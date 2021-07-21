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
import com.team.choix.model.Pair;
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
		model.addAttribute("choix", new Choix(participants));
		return "index";
	}

	@PostMapping(value = { "/", "/index" })
	public String choixSubmit(Model model, @ModelAttribute("choix") Choix choix, BindingResult errors) {
		try {
			List<String> candidatsSeniors = new ArrayList<>(List.of(choix.getSeniors().split(separator)));
			List<String> candidatsJuniors = new ArrayList<>(List.of(choix.getJuniors().split(separator)));
			
			Pair pompier = choixService.selectAPair(candidatsSeniors, candidatsJuniors);
			model.addAttribute("pompier", pompier.getHolder());
			model.addAttribute("suppleantPompier", pompier.getDeputy());
			
			Pair revieweur = choixService.selectAPair(candidatsSeniors, candidatsJuniors, pompier);
			model.addAttribute("revieweur", revieweur.getHolder());
			model.addAttribute("suppleantRevieweur", revieweur.getDeputy());
			
			Pair versionneur = choixService.selectAPair(candidatsSeniors, candidatsJuniors, pompier, revieweur);
			model.addAttribute("versionneur", versionneur.getHolder());
			model.addAttribute("suppleantVersionneur", versionneur.getDeputy());
			
			return "index";
			//construire une exception "maison" (service pour le géré throw...)
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}

}
