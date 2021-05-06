package com.team.choix.service;

import java.util.List;
import java.util.Random;


public class ChoixService {
	
	Random rand = new Random();
	
	public String hasard (List<String> candidats) {	
		return candidats.get(rand.nextInt(candidats.size()));
	}
	
	public String suppleant(List<String> candidats, String nom) {
		candidats.remove(new String(nom));
		
		return candidats.get(rand.nextInt(candidats.size()));
	}

}
