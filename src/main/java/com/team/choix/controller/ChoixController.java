package com.team.choix.controller;

import com.team.choix.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChoixController {

    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
    	model.addAttribute("choix", new Choix());
    	return "index";
    }
    @PostMapping(value={"/", "/index"})
    public String choixSubmit(@ModelAttribute Choix choix, Model model) {
	  model.addAttribute("choix", choix);
	  return "resultChoix";
	}
}
