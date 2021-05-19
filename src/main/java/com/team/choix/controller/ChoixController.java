package com.team.choix.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.team.choix.service.ChoixService;

@Controller
public class ChoixController {
	@Autowired
	ChoixService choixService;
	
	@Value("${prenoms.parDefaut}")
	private String prenoms;
	
//	public String saveStudent(@ModelAttribute Student student, , Model model) {

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
    	model.addAttribute("choix", new Choix(prenoms));
    	return "index";
    }
    
    @PostMapping(value={"/", "/index"})
    public String choixSubmit(Model model,
    		@ModelAttribute("choix") Choix choix
//    		BindingResult errors
    		) {
    	try {
    		List<String> candidats = new ArrayList<>(Arrays.asList(choix.getPrenoms().split("\n")));
    	String nouveauPompier = choixService.selectHasard(candidats);
    	String nouveauSuppleant = choixService.suppleant(candidats, nouveauPompier);
    	model.addAttribute("nouveauPompier", nouveauPompier);
    	model.addAttribute("nouveauSuppleant", nouveauSuppleant);
    	return "index";
    	}
     catch (Exception ex) {
    	 ex.printStackTrace();
    	 return "error";
     }
	}
}
