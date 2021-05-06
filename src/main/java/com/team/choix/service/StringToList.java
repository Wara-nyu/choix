package com.team.choix.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToList {
	
	public static List<String> stringToList(String input){
		if(input.equals("")) {
			return null;
		}
		List<String> candidats = new ArrayList<String>(Arrays.asList(input.split(" ")));
		return candidats;
	}
}
