package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChoixServiceTest {

	ChoixService choixService = new ChoixService();
	
	private List<String> inputList() {
		List<String> inputList = List.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara", " ", "l", "f   ", "");
		return inputList;
	}

	@Test
	public void testSetFirstPersonGetANameFromTheList() {
		List<String> inputList = inputList();
		
		String name = choixService.setFirstPerson(inputList);

		assertTrue(inputList.contains(name));
		assertFalse(name.equals(" "));
		assertFalse(name.equals(""));
		assertFalse(name.equals("l"));
		assertFalse(name.equals("f   "));
	}
	
	@Test
	public void testSetSecondPersonGetANamefromTheListDifferentFromTheFirst() {
		List<String> inputList = new ArrayList<>(inputList());
		String name = "Thomas";
			
		String secondName = choixService.setSecondPerson(inputList, name);
			
		assertTrue(inputList.contains(secondName));
		assertNotEquals(name, secondName);
		assertFalse(secondName.equals(" "));
		assertFalse(secondName.equals(""));
		assertFalse(secondName.equals("l"));
		assertFalse(secondName.equals("f   "));
		}
		
	@Test
	public void testSetOnlyNamesCanBeChosen() {
		List<String> inputList = inputList();
		
		List<String> result = choixService.setOnlyNames(inputList);
		
		assertFalse(result.contains(" "));
		assertFalse(result.contains(""));
		assertFalse(result.contains("l"));
		assertFalse(result.contains("f   "));
	}
	
	@Test
	public void testIfInputIsEmptyListShouldReturnNull() {
		//test liste vide; que veut-on dans ce cas là ?
		List<String> input = Collections.emptyList();
		
		String result = choixService.setFirstPerson(input);
		
		assertEquals("Veuillez entrer plusieurs noms", result);
	}

}




