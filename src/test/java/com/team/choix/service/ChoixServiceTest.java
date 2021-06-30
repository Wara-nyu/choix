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

		List<String> result = choixService.returnStreamOfPlaussibleNames(inputList).collect(Collectors.toList());

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
	public void shouldReturnTheStream() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");

		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList.stream()).collect(Collectors.toList());
		
		assertTrue(inputList.equals(updateList));
	}
	
	@Test
	public void shouldReturnAStreamWithoutOneSelectedPerson() {
		Stream<String> inputList = Stream.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		
		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList, pompier).collect(Collectors.toList());
		
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void ShouldReturnAStreamWithoutTwoSelectedPeople() {
		Stream<String> inputList = Stream.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";
		
		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList, pompier, reviewer).collect(Collectors.toList());
		
		assertFalse(updateList.contains(reviewer));
		assertFalse(updateList.contains(pompier));
	}
	

}
