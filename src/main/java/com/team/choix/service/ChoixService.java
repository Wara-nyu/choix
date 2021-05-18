package com.team.choix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	Random rand = new Random();
	
	public String selectHasard (List<String> prenoms) {	
//		List<String> candidats = new ArrayList<>(Arrays.asList(prenoms));
 		return prenoms.get(rand.nextInt(prenoms.size()));
	}
	
	public String suppleant(String prenoms, String nom) {
		List<String> candidats = new ArrayList<>(Arrays.asList(prenoms.split("\n")));
		candidats.remove(new String(nom));
		
		return candidats.get(rand.nextInt(candidats.size()));
	}

}
