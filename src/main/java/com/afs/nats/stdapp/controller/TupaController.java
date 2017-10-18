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

import com.afs.nats.stdapp.model.Tupa;
import com.afs.nats.stdapp.repository.TupaRepository;

@Controller
@RequestMapping("/tupa")
public class TupaController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private TupaRepository tupaRepository;

	@Autowired
	public TupaController(TupaRepository tupaRepository) {
		this.tupaRepository = tupaRepository;
	}

	// create a tupa
	@PostMapping("/form")
	private String createTupa(@Valid Tupa tupa, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", true);
			model.addAttribute("tupa", tupa);
			return "tupa/form";
		}
		log.info("Create a tupa");
		tupaRepository.save(tupa);
		log.info(String.format("tupa added: %s ", tupa.toString()));
		return "redirect:/tupa";
	}

	// delete a tupa
	@GetMapping("/delete/{id}")
	private String deleteTupa(@PathVariable long id) {
		log.info(String.format("Delete tupa with id = %d", id));
		tupaRepository.delete(id);
		return "redirect:/tupa";
	}

	// edit a tupa
	@PostMapping("/{id}")
	private String editTupa(@PathVariable Long id, @Valid Tupa tupa, BindingResult result, Model model) {	
		log.info(String.format("Edit tupa with id = %d", tupa.getId()));
		if (result.hasErrors()) {
			model.addAttribute("status", false);
			model.addAttribute("tupa", tupa);
			return "tupa/form";
		}
		tupaRepository.save(tupa);
		return "redirect:/tupa";
	}

	// list of companies
	@GetMapping
	private String showTupas(Model model) {
		log.info("List of companies");
		List<Tupa> companies = tupaRepository.findAll();
		model.addAttribute("tupaList", companies);
		log.info(String.format("Total of tupas %d", companies.size()));
		return "tupa/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("tupa", new Tupa());
		model.addAttribute("status", true);
		log.info("Show Form");
		return "tupa/form";
	}

	// view a tupa
	@GetMapping("/{id}")
	private String viewTupa(@PathVariable long id, Model model) {
		log.info(String.format("View tupa with id = %d", id));
		model.addAttribute("tupa", tupaRepository.findOne(id));
		model.addAttribute("status", false);
		return "tupa/form";
	}
}
