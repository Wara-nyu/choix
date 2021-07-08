package com.team.choix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	String chooseRandomItem(List<String> list) {
		Random rand = new Random();
//		if (listOfNames.empty()) {
//			return "erreur";
//		}
		String item = list.get(rand.nextInt(list.size()));
		return item;
		
	}
	
	List<String> select2Items(List<String> list1, List<String> list2) {
		List<String> outputList = new ArrayList<String>();
		outputList.add(chooseRandomItem(list1));
		outputList.add(chooseRandomItem(list2));
		return outputList;
	}
	
//	public Pair randomizeTheHolder(List<String> list1, List<String> list2, String...names) {
//		List<String> updateList1 = removeNames(keepValidStrings(list1), names);
//		List<String> updateList2 = removeNames(keepValidStrings(list2), names);
//		
//		
//		
//		return null;
//	}
}
