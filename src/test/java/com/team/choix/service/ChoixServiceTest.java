package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public void ShouldReturnAListOfPlaussibleName() {
		List<String> inputList = inputList();

		List<String> result = choixService.keepValidStrings(inputList);

		assertFalse(result.contains(" "));
		assertFalse(result.contains(""));
		assertFalse(result.contains("l"));
		assertFalse(result.contains("f   "));
	}

	//a retravailler redéfinir la spec
//	@Test
//	public void testIfInputIsEmptyListShouldReturnStringErreur() {
//		List<String> input = Collections.emptyList();
//
//		String result = choixService.setFirstPerson(input);
//
//		assertEquals("erreur", result);
//	}

	@Test
	public void shouldReturnTheSameList() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");

		List<String> updateList = choixService.removeNames(inputList);
		
		assertTrue(inputList.equals(updateList));
	}
	
	@Test
	public void shouldReturnAStreamWithoutOneSelectedPerson() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		
		List<String> updateList = choixService.removeNames(inputList, pompier);
		
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void ShouldReturnAStreamWithoutTwoSelectedPeople() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";
		
		List<String> updateList = choixService.removeNames(inputList, pompier, reviewer);
		
		assertFalse(updateList.contains(reviewer));
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void shouldReturnRandomlyAnItemOfProperList() {
		List<String> inputList = inputList();

		String pompier = choixService.chooseRandomItem(inputList);
		
		assertFalse(pompier.equals(" "));
		assertFalse(pompier.equals(""));
		assertFalse(pompier.equals("l"));
		assertFalse(pompier.equals("f   "));
		assertTrue(inputList.contains(pompier));
		assertNotNull(pompier);
	}
	
	@Test
	public void shouldReturnRandomlyAnItemOfProperListAndBeDifferentFromTheGivenString() {
		List<String> inputList = inputList();
		String reviewer = "Arthur";
		
		String pompier = choixService.chooseRandomItem(inputList,reviewer);
		
		assertFalse(pompier.equals(" "));
		assertFalse(pompier.equals(""));
		assertFalse(pompier.equals("l"));
		assertFalse(pompier.equals("f   "));
		assertTrue(inputList.contains(pompier));
		assertFalse(pompier.equals(reviewer));
		assertNotNull(pompier);
	}
	
	@Test
	public void shouldReturnRandomlyAnItemOfProperListAndBeDifferentFromThe2GivenStrings() {
		List<String> inputList = inputList();
		String reviewer = "Arthur";
		String versionner = "Frederic";
		
		String pompier = choixService.chooseRandomItem(inputList, reviewer, versionner);
		
		assertFalse(pompier.equals(" "));
		assertFalse(pompier.equals(""));
		assertFalse(pompier.equals("l"));
		assertFalse(pompier.equals("f   "));
		assertTrue(inputList.contains(pompier));
		assertFalse(pompier.equals(reviewer));
		assertFalse(pompier.equals(versionner));
		assertNotNull(pompier);
	}
}
