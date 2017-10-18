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
import com.afs.nats.stdapp.model.Process;
import com.afs.nats.stdapp.model.TipoDocumento;
import com.afs.nats.stdapp.repository.ProcessRepository;

@Controller
@RequestMapping("/processes")
public class ProcessController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private ProcessRepository processRepository;

	@Autowired
	public ProcessController(ProcessRepository processRepository) {
		this.processRepository = processRepository;
	}

	// create a process
	@PostMapping("/form")
	private String createProcess(@Valid Process process, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", true);
			model.addAttribute("tipoDocs", TipoDocumento.getValues());
			model.addAttribute("process", process);
			return "process/form";
		}
		log.info("Create a process");
		processRepository.save(process);
		log.info(String.format("process added: %s ", process.toString()));
		return "redirect:/process";
	}

	// delete a process
	@GetMapping("/delete/{id}")
	private String deleteProcess(@PathVariable long id) {
		log.info(String.format("Delete process with id = %d", id));
		processRepository.delete(id);
		return "redirect:/process";
	}

	// edit a process
	@PostMapping("/{id}")
	private String editProcess(@PathVariable long id, Process process) {
		log.info(String.format("Edit process with id = %d", process.getId()));
		processRepository.save(process);
		return "redirect:/process";
	}

	// list of process
	@GetMapping
	private String showProcesses(Model model) {
		log.info("List of process");
		List<Process> process = processRepository.findAll();
		model.addAttribute("processList", process);
		log.info(String.format("Total of process %d", process.size()));
		return "process/list";
	}

	// show form
	@GetMapping("/form")
	private String showForm(Model model) {
		model.addAttribute("process", new Process());
		model.addAttribute("status", true);
		model.addAttribute("tipoDocs", TipoDocumento.getValues());
		log.info("Show Form");
		return "process/form";
	}

	// view a process
	@GetMapping("/{id}")
	private String viewProcess(@PathVariable long id, Model model) {
		log.info(String.format("View process with id = %d", id));
		model.addAttribute("process", processRepository.findOne(id));
		model.addAttribute("status", false);
		model.addAttribute("tipoDocs", TipoDocumento.getValues());

		return "process/form";
	}
}
