package com.afs.nats.stdapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.afs.nats.stdapp.model.Claimant;
import com.afs.nats.stdapp.model.TipoDocumento;
import com.afs.nats.stdapp.repository.ClaimantRepository;

@Controller
@RequestMapping("/claimants")
public class ClaimantController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private ClaimantRepository claimantRepository;

	@Autowired
	public ClaimantController(ClaimantRepository claimantRepository) {
		this.claimantRepository = claimantRepository;
	}

	// create a claimant
	@PostMapping("/form")
	private String createClaimant(@Valid Claimant claimant, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", true);
			model.addAttribute("tipoDocs", TipoDocumento.getValues());
			model.addAttribute("claimant", claimant);
			return "claimant/form";
		}
		log.info("Create a claimant");
		claimantRepository.save(claimant);
		log.info(String.format("Claimant added: %s ", claimant.toString()));
		return "redirect:/claimants";
	}

	// delete a claimant
	@GetMapping("/delete/{id}")
	private String deleteClaimant(@PathVariable long id) {
		log.info(String.format("Delete claimant with id = %d", id));
		claimantRepository.delete(id);
		return "redirect:/claimants";
	}

	// edit a claimant
	@PostMapping("/{id}")
	private String editClaimant(@PathVariable long id, @Valid Claimant claimant, BindingResult result, Model model) {
		log.info(String.format("Edit claimant with id = %d", claimant.getId()));
		if (result.hasErrors()) {
			model.addAttribute("status", false);
			model.addAttribute("tipoDocs", TipoDocumento.getValues());
			model.addAttribute("claimant", claimant);
			return "claimant/form";
		}
		claimantRepository.save(claimant);
		return "redirect:/claimants";
	}

	@GetMapping
	private String showClaimantsByPage(Model model, @PageableDefault Pageable pageable) {
		log.info("List of claimants");

		Page<Claimant> claimants = claimantRepository.findAll(pageable);
		model.addAttribute("claimantsPage", claimants);
		model.addAttribute("pageNumber", claimants.getNumber());
		model.addAttribute("pageSize", claimants.getSize());
		log.info(String.format("Total of claimants in page %d: %d", claimants.getNumber(),
				claimants.getContent().size()));
		return "claimant/list";
		// return "claimant/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("claimant", new Claimant());
		model.addAttribute("status", true);
		model.addAttribute("tipoDocs", TipoDocumento.getValues());
		log.info("Show Form");
		return "claimant/form";
	}

	// view a claimant
	@GetMapping("/{id}")
	private String viewClaimant(@PathVariable long id, Model model) {
		log.info(String.format("View claimant with id = %d", id));
		model.addAttribute("claimant", claimantRepository.findOne(id));
		model.addAttribute("status", false);
		model.addAttribute("tipoDocs", TipoDocumento.getValues());

		return "claimant/form";
	}
}