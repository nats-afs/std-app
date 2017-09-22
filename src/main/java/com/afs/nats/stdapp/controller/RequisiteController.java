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
import org.springframework.web.bind.annotation.RequestMethod;

import com.afs.nats.stdapp.model.Requisite;
import com.afs.nats.stdapp.model.TipoDocumento;
import com.afs.nats.stdapp.repository.RequisiteRepository;

@Controller
@RequestMapping("/requisites")
public class RequisiteController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private RequisiteRepository requisiteRepository;

	@Autowired
	public RequisiteController(RequisiteRepository requisiteRepository) {
		this.requisiteRepository = requisiteRepository;
	}

	// create a requisite
	@PostMapping("/form")
	private String createRequisite(@Valid Requisite requisite, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", true);
			model.addAttribute("requisite", requisite);
			return "requisite/form";
		}
		log.info("Create a requisite");
		requisiteRepository.save(requisite);
		log.info(String.format("Requisite added: %s ", requisite.toString()));
		return "redirect:/requisites";
	}

	// delete a requisite
	@GetMapping("/delete/{id}")
	private String deleteRequisite(@PathVariable long id) {
		log.info(String.format("Delete requisite with id = %d", id));
		requisiteRepository.delete(id);
		return "redirect:/requisites";
	}

	// edit a requisite
	@PostMapping("/{id}")
	private String editRequisite(@PathVariable long id, Requisite requisite) {
		log.info(String.format("Edit requisite with id = %d", requisite.getId()));
		requisiteRepository.save(requisite);
		return "redirect:/requisites";
	}

	// list of requisites
	@GetMapping
	private String showRequisites(Model model) {
		log.info("List of requisites");
		List<Requisite> requisites = requisiteRepository.findAll();
		model.addAttribute("requisiteList", requisites);
		log.info(String.format("Total of requisites %d", requisites.size()));
		return "requisite/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("requisite", new Requisite());
		model.addAttribute("status", true);
		log.info("Show Form");
		return "requisite/form";
	}

	// view a requisite
	@GetMapping("/{id}")
	private String viewRequisite(@PathVariable long id, Model model) {
		log.info(String.format("View requisite with id = %d", id));
		model.addAttribute("requisite", requisiteRepository.findOne(id));
		model.addAttribute("status", false);

		return "requisite/form";
	}
}
