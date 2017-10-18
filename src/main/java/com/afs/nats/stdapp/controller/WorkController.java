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

import com.afs.nats.stdapp.model.Work;
import com.afs.nats.stdapp.repository.CompanyRepository;
import com.afs.nats.stdapp.repository.TupaRepository;
import com.afs.nats.stdapp.repository.WorkRepository;

@Controller
@RequestMapping("/work")
public class WorkController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private WorkRepository workRepository;
	private TupaRepository tupaRepository;
	private CompanyRepository companyRepository;
	
	@Autowired
	public WorkController(WorkRepository workRepository, TupaRepository tupaRepository, CompanyRepository companyRepository) {
		this.workRepository = workRepository;
		this.tupaRepository = tupaRepository;
		this.companyRepository = companyRepository;
	}

	// create a work
	@PostMapping("/form")
	private String createWork(@Valid Work work, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("companyList", companyRepository.findAll());
			model.addAttribute("tupaList", tupaRepository.findAll());
			model.addAttribute("status", true);
			model.addAttribute("work", work);
			return "work/form";
		}
		log.info("Create a work");
		workRepository.save(work);
		log.info(String.format("work added: %s ", work.toString()));
		return "redirect:/work";
	}

	// delete a work
	@GetMapping("/delete/{id}")
	private String deletetupa(@PathVariable long id) {
		log.info(String.format("Delete work with id = %d", id));
		workRepository.delete(id);
		return "redirect:/work";
	}

	// edit a work
	@PostMapping("/{id}")
	private String editWork(@PathVariable Long id, @Valid Work work, BindingResult result, Model model) {	
		log.info(String.format("Edit work with id = %d", work.getId()));
		if (result.hasErrors()) {
			model.addAttribute("status", false);
			model.addAttribute("work", work);
			return "work/form";
		}
		workRepository.save(work);
		return "redirect:/work";
	}

	// list of works
	@GetMapping
	private String showWorks(Model model) {
		log.info("List of Works");
		List<Work> works = workRepository.findAll();
		model.addAttribute("workList", works);
		log.info(String.format("Total of tupas %d", works.size()));
		return "work/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("companyList", companyRepository.findAll());
		model.addAttribute("tupaList", tupaRepository.findAll());
		model.addAttribute("work", new Work());
		model.addAttribute("status", true);
		log.info("Show Form");
		return "work/form";
	}

	// view a work
	@GetMapping("/{id}")
	private String viewWork(@PathVariable long id, Model model) {
		log.info(String.format("View work with id = %d", id));
		model.addAttribute("companyList", companyRepository.findAll());
		model.addAttribute("tupaList", tupaRepository.findAll());
		model.addAttribute("work", workRepository.findOne(id));
		model.addAttribute("status", false);
		return "work/form";
	}
}
