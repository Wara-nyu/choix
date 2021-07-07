package com.team.choix.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	List<String> keepValidStrings(List<String> inputList){
		List<String> cleanList = inputList.stream().map(String::strip).filter(prenom -> prenom.length()>1).collect(Collectors.toList());
		return cleanList;
	}
	
	List<String> removeNames(List<String> cleanList, String...names) {
		List<String> updateList = cleanList.stream().filter(person -> !Arrays.asList(names).contains(person)).collect(Collectors.toList());
		return updateList;
	}
	
	public String chooseRandomItem(List<String> listOfNames, String...names) {
		List<String> list = removeNames(keepValidStrings(listOfNames), names);
		Random rand = new Random();
//		if (listOfNames.empty()) {
//			return "erreur";
//		}
		String item = list.get(rand.nextInt(list.size()));
		return item;
	}
}
