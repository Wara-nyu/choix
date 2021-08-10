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
//		pairsOfNames est un array de l'objet pair
		List<String> updateList = cleanList.stream().filter(person -> !Stream.of(pairsOfNames).flatMap(pair -> Stream.of(pair.toString().split(","))).collect(Collectors.toList()).contains(person)).collect(Collectors.toList());
		return updateList;
	}
	List<String> removeName(List<String> cleanList, String...name) {
		List<String> updateList = cleanList.stream().filter(person -> !Arrays.asList(name).contains(person)).collect(Collectors.toList());
		return updateList;
	}
	
	public String chooseRandomItem(List<String> list) {
		Random rand = new Random();
		String item = list.get(rand.nextInt(list.size()));
		return item;
		
	}
	
	Pair select2Items(List<String> list1, List<String> list2) {
		String holder = chooseRandomItem(list1);
		String deputy = chooseRandomItem(removeName(list2, holder));
		return new Pair(holder, deputy);
	}
	
	public Pair selectAPair(List<String> list1, List<String> list2, Pair...names) {
		int rand = (int) (Math.random() * 2);
		Pair team;
		List<String> updateList1 = removeNames(keepValidStrings(list1), names);
		List<String> updateList2 = removeNames(keepValidStrings(list2), names);
		if (rand == 0) {
			return team = select2Items(updateList1, updateList2);
		}
		return team = select2Items(updateList2, updateList1);
	}
}
