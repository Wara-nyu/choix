package com.team.choix.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	Random rand = new Random();
	
	public String selectHasard (List<String> prenoms) {	
 		return prenoms.get(rand.nextInt(prenoms.size()));
	}
	
	public String suppleant(List<String> prenoms, String nom) {
		prenoms.remove(new String(nom));
		
		return prenoms.get(rand.nextInt(prenoms.size()));
	}

}
