package com.afs.nats.stdapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.afs.nats.stdapp.model.Company;
import com.afs.nats.stdapp.repository.CompanyRepository;

@Controller
@RequestMapping("/company")
public class CompanyController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private CompanyRepository companyRepository;

	@Autowired
	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	// create a company
	@PostMapping("/form")
	private String createCompany(@Valid Company company, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", true);
			model.addAttribute("company", company);
			return "company/form";
		}
		log.info("Create a company");
		companyRepository.save(company);
		log.info(String.format("company added: %s ", company.toString()));
		return "redirect:/company";
	}

	// delete a company
	@GetMapping("/delete/{id}")
	private String deleteCompany(@PathVariable long id) {
		log.info(String.format("Delete company with id = %d", id));
		companyRepository.delete(id);
		return "redirect:/company";
	}

	// edit a company
	@PostMapping("/{id}")
	private String editCompany(@PathVariable Long id, @Valid Company company, BindingResult result, Model model) {	
		log.info(String.format("Edit company with id = %d", company.getId()));
		if (result.hasErrors()) {
			model.addAttribute("status", false);
			model.addAttribute("company", company);
			return "company/form";
		}
		companyRepository.save(company);
		return "redirect:/company";
	}

	// list of companies
	@GetMapping
	private String showCompanies(Model model) {
		log.info("List of companies");
		List<Company> companies = companyRepository.findAll();
		model.addAttribute("companyList", companies);
		log.info(String.format("Total of companies %d", companies.size()));
		return "company/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("company", new Company());
		model.addAttribute("status", true);
		log.info("Show Form");
		return "company/form";
	}

	// view a company
	@GetMapping("/{id}")
	private String viewCompany(@PathVariable long id, Model model) {
		log.info(String.format("View company with id = %d", id));
		model.addAttribute("company", companyRepository.findOne(id));
		model.addAttribute("status", false);
		return "company/form";
	}
}
