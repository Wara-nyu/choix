package com.team.choix;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.choix.service.ChoixService;

@SpringBootTest
class ChoixApplicationTests {

	@Test
	public void testSetFirstPersonGetANameFromTheList() {
		List<String> listOfNames = List.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara");
		ChoixService choixService = new ChoixService();
		String name = choixService.setFirstPerson(listOfNames);

		assertTrue(listOfNames.contains(name));
	}
	
	@Test
	public void testSetSecondPersonGetANamefromTheListDifferentFromTheFirst() throws Exception {
		List<String> listOfNames = new ArrayList<>(List.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara"));
		ChoixService choixService = new ChoixService();
		String name = "Thomas";
			
		String secondName = choixService.setSecondPerson(listOfNames, name);
			
		assertTrue(listOfNames.contains(secondName));
		assertNotEquals(name, secondName);
		}
		
	@Test
	public void testOnlyNamesCanBeChosen() {
		List<String> inputList = List.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara", " ", "l", "f   ", "");
		ChoixService choixService = new ChoixService();
		
		List<String> result = choixService.onlyNames(inputList);
		
		assertFalse(result.contains(" "));
		assertFalse(result.contains(""));
		assertFalse(result.contains("l"));
		assertFalse(result.contains("f   "));
	}
}
