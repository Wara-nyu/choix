package com.team.choix.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	private String chooseItemRandomlyInList(List<String> listOfNames) {
		List<String> cleanList = setOnlyNames(listOfNames); 
		Random rand = new Random();
		if (listOfNames.isEmpty()) {
			return "erreur";
		}
		String item = cleanList.get(rand.nextInt(cleanList.size()));
		return item;
		
	}
	
	public String setFirstPerson (List<String> list) {
		return chooseItemRandomlyInList(list);
	}
	
	public String setSecondPerson(List<String> list, String name) {
		list.remove(new String(name));
		return chooseItemRandomlyInList(list);
	}
	
	public List<String> setOnlyNames(List<String> inputList){
		List<String> cleanList = inputList.stream().map(String::strip).filter(prenom -> !(prenom.length()<=1)).collect(Collectors.toList());
		return cleanList;
	}
}
