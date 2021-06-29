package com.team.choix.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
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

		assertEquals("erreur", result);
	}

	@Test
	public void pompierShouldBeDiffrentFromReviewerAndVersionner() {
		for(int i = 0; i <100; i++) {
			List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
			List<String> alreadySelectedPeople = List.of("Arthur", "Thomas");

			String result = choixService.selectAnotherPerson(inputList, alreadySelectedPeople);

			assertTrue(inputList.contains(result));
			assertFalse(alreadySelectedPeople.contains(result));
		}
	}

	@Test
	void testSelectAnotherPersonForListOfAlreadySelectedPeopleEmpty() {
		for(int i = 0; i <100; i++) {
			List<String> inputList = inputList();
			List<String> alreadySelectedPeople = Collections.emptyList();

			String result = choixService.selectAnotherPerson(inputList, alreadySelectedPeople);

			System.out.println(result);
			assertTrue(inputList.contains(result));
			assertFalse(alreadySelectedPeople.contains(result));
		}
	}

}




