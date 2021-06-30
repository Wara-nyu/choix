package com.team.choix.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class ChoixService {
	
//	>>> Stray with Stream till manipulating the list
	public Stream<String> returnStreamOfPlaussibleNames(List<String> inputList){
		Stream<String> cleanList = inputList.stream().map(String::strip).filter(prenom -> !(prenom.length()<=1));
		return cleanList;
	}

	
	public Stream<String> returnStreamWithoutPeopleAlreadySelected(Stream<String> cleanList, String...string) {
		Stream<String> updateList = cleanList.filter(person -> !Arrays.asList(string).contains(person));
		return updateList;
	}
//	>>>
	
	public String chooseItemRandomlyInList(List<String> listOfNames, String...string) {
		List<String> list = returnStreamWithoutPeopleAlreadySelected(returnStreamOfPlaussibleNames(listOfNames), string).collect(Collectors.toList());
		Random rand = new Random();
//		if (listOfNames.empty()) {
//			return "erreur";
//		}
		String item = list.get(rand.nextInt(list.size()));
		return item;
	}
}
