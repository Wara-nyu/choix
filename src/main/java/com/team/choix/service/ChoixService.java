package com.team.choix.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
	public String chooseItemRandomlyInList(Stream<String> listOfNames) {
		List<String> cleanList = setOnlyNames(listOfNames); 
		Random rand = new Random();
//		if (listOfNames.empty()) {
//			return "erreur";
//		}
		String item = cleanList.get(rand.nextInt(cleanList.size()));
		return item;
	}
	
	public List<String> setOnlyNames(Stream<String> inputList){
		List<String> cleanList = inputList.map(String::strip).filter(prenom -> !(prenom.length()<=1)).collect(Collectors.toList());
		return cleanList;
	}
	
//	public String setFirstPerson (List<String> list) {
//		return chooseItemRandomlyInList(list);
//	}
//	
//	public String setSecondPerson(List<String> list, String name) {
//		list.remove(new String(name));
//		return chooseItemRandomlyInList(list);
//	}
	
	public Stream<String> returnListWithoutAlreadySelectedPerson(List<String> input, String...string) {
		Stream<String> updateList = input.stream().filter(person -> !Arrays.asList(string).contains(person));
		
		return updateList;
	}
	
}
