package com.team.choix.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
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
		String seniors = String.join(separator, participantService.getSeniors());
		String juniors = String.join(separator, participantService.getJuniors());
		model.addAttribute("choix", new Choix(seniors, juniors));
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
			
		} catch (IllegalArgumentException iAE) {
				iAE.printStackTrace();
				model.addAttribute("err", "Veuillez rentrer au moins 3 noms dans chaque colonne");
				return "index";
		
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
	}
	
	@GetMapping(value = { "/pair1" })
	public String pair(Model model, @ModelAttribute("participant") Participant participant) {
		String list = "";
		model.addAttribute("choix", new Choix(list));
		return "pair1";
	}
	
	@PostMapping(value = {"/pair1" })
	public String pairSubmit(Model model, @ModelAttribute("choix") Choix choix, BindingResult errors) {
		try {
			List<String> list = new ArrayList<>(List.of(choix.getList().split(separator)));
			Pair pair = new Pair();
			System.out.println(pair);
			pair.setHolder(choixService.chooseRandomItem(list).strip());
			System.out.println(pair.getHolder());
			pair.setDeputy(choixService.chooseRandomItem(list).strip());
			System.out.println(pair.getDeputy());
			model.addAttribute("pompier", pair.getHolder());
			model.addAttribute("suppleantPompier", pair.getDeputy());
			
			return "pair1";
		} catch(Exception ex){
			ex.printStackTrace();
			return "error";
			}
		}
	
	
//	Pair pompier = new Pair();
//	pompier.setHolder("Wara");
//	pompier.setDeputy(choixService.chooseRandomItem(candidatsSeniors).strip());
//	model.addAttribute("pompier", pompier.getHolder());
//	model.addAttribute("suppleantPompier", pompier.getDeputy());
}
