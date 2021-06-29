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

	private Stream<String> inputList() {
		Stream<String> inputList = Stream.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara", " ", "l",
				"f   ", "");
		return inputList;
	}


	@Test
	public void ShouldReturnAListOfPlosibleName() {
		Stream<String> inputList = inputList();

		List<String> result = choixService.returnListOfPlosibleNames(inputList);

		assertFalse(result.contains(" "));
		assertFalse(result.contains(""));
		assertFalse(result.contains("l"));
		assertFalse(result.contains("f   "));
	}

	//a retravailler
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

		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList).collect(Collectors.toList());
		
		assertEquals(inputList, updateList);
	}
	
	@Test
	public void shouldReturnAStreamWithoutOneSelectedPerson() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		
		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList, pompier).collect(Collectors.toList());
		
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void ShouldReturnAStreamWithoutTwoSelectedPeople() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";
		
		List<String> updateList = choixService.returnStreamWithoutPeopleAlreadySelected(inputList, pompier, reviewer).collect(Collectors.toList());
		
		assertFalse(updateList.contains(reviewer));
		assertFalse(updateList.contains(pompier));
	}

}
