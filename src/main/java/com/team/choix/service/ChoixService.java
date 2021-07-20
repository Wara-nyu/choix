package com.team.choix.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.team.choix.model.Pair;

@Service
public class ChoixService {
	
	List<String> keepValidStrings(List<String> inputList){
		List<String> cleanList = inputList.stream().map(String::strip).filter(prenom -> prenom.length()>1).collect(Collectors.toList());
		return cleanList;
	}
	
	List<String> removeNames(List<String> cleanList, Pair...pairsOfNames) {
//		pairsOfNames[0].getDeputy()
		List<String> updateList = cleanList.stream().filter(person -> !Stream.of(pairsOfNames).flatMap(pair -> Stream.of(pair.toString().split(","))).collect(Collectors.toList()).contains(person)).collect(Collectors.toList());
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
	
	Pair select2Items(List<String> list1, List<String> list2) {
		return new Pair(chooseRandomItem(list1), chooseRandomItem(list2));
	}
	
	public Pair selectTheHolder(List<String> list1, List<String> list2, Pair...names) {
		List<String> updateList1 = removeNames(keepValidStrings(list1), names);
		List<String> updateList2 = removeNames(keepValidStrings(list2), names);
		Pair team = select2Items(updateList1, updateList2);

		
		return team;
	}
}
