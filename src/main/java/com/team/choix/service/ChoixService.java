package com.team.choix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ChoixService {
	
	Random rand = new Random();
	
	public String hasard (String prenoms) {	
		List<String> candidats = new ArrayList<>(Arrays.asList(prenoms.split("\n")));
 		return candidats.get(rand.nextInt(candidats.size()));
	}
	
	public String suppleant(String prenoms, String nom) {
		List<String> candidats = new ArrayList<>(Arrays.asList(prenoms.split("\n")));
		candidats.remove(new String(nom));
		
		return candidats.get(rand.nextInt(candidats.size()));
	}

}
