package com.team.choix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.catalina.Contained;
import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	Random rand = new Random();
	
	public String setFirstPerson (List<String> listOfNames) {
		List<String> cleanList = onlyNames(listOfNames); 
		return cleanList.get(rand.nextInt(cleanList.size()));
	}
	
	public String setSecondPerson(List<String> listOfNames, String name) {
		listOfNames.remove(new String(name));
		
		return listOfNames.get(rand.nextInt(listOfNames.size()));
	}
	
	public List<String> onlyNames(List<String> inputList){
		List<String> cleanList = inputList.stream().map(String::strip).filter(prenom -> !(prenom.length()<=1)).collect(Collectors.toList());
		return cleanList;
	}
}
