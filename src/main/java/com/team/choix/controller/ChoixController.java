package com.team.choix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.choix.model.Choix;
import com.team.choix.model.Participant;
import com.team.choix.service.ChoixService;
import com.team.choix.service.ParticipantService;

@Controller
public class ChoixController {
	@Value("${separator.default}")
	private String separator;
	
	@Autowired
	ChoixService choixService;
	
	@Autowired
	ParticipantService participantService;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model, @ModelAttribute("participant") Participant participant) {
		String participants = String.join(separator, participantService.getListFirstnames());
		model.addAttribute("participants", participants);
		model.addAttribute("choix", new Choix(participants));
		return "index";
	}

	@PostMapping(value = { "/", "/index" })
	public String choixSubmit(Model model, @ModelAttribute("choix") Choix choix, BindingResult errors) {
		try {
			List<String> candidats = new ArrayList<>(List.of(choix.getPrenoms().split(separator)));
			String firstPerson = choixService.setFirstPerson(candidats);
			String secondPerson = choixService.setSecondPerson(candidats, firstPerson);
			model.addAttribute("nouveauPompier", firstPerson);
			model.addAttribute("nouveauSuppleantPompier", secondPerson);
			return "index";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}

}
