package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

	// bientôt inutile
//	@Test
//	public void testSetFirstPersonGetANameFromTheList() {
//		List<String> inputList = inputList();
//
//		String name = choixService.setFirstPerson(inputList);
//
//		assertTrue(inputList.contains(name));
//		assertFalse(name.equals(" "));
//		assertFalse(name.equals(""));
//		assertFalse(name.equals("l"));
//		assertFalse(name.equals("f   "));
//	}

	// bientôt inutile
//	@Test
//	public void testSetSecondPersonGetANamefromTheListDifferentFromTheFirst() {
//		List<String> inputList = new ArrayList<>(inputList());
//		String name = "Thomas";
//
//		String secondName = choixService.setSecondPerson(inputList, name);
//
//		assertTrue(inputList.contains(secondName));
//		assertNotEquals(name, secondName);
//		assertFalse(secondName.equals(" "));
//		assertFalse(secondName.equals(""));
//		assertFalse(secondName.equals("l"));
//		assertFalse(secondName.equals("f   "));
//	}

	@Test
	public void testSetOnlyNamesCanBeChosen() {
		Stream<String> inputList = inputList();

		List<String> result = choixService.setOnlyNames(inputList);

		assertFalse(result.contains(" "));
		assertFalse(result.contains(""));
		assertFalse(result.contains("l"));
		assertFalse(result.contains("f   "));
	}

//	@Test
//	public void testIfInputIsEmptyListShouldReturnStringErreur() {
//		List<String> input = Collections.emptyList();
//
//		String result = choixService.setFirstPerson(input);
//
//		assertEquals("erreur", result);
//	}

	@Test
	public void pompierShouldBeDiffrentFromReviewerAndVersionner() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";

		Stream<String> updateList = choixService.returnListWithoutAlreadySelectedPerson(inputList, pompier, reviewer);
		String result = choixService.chooseItemRandomlyInList(updateList);
		
		System.out.println(result);
		assertTrue(inputList.contains(result));
		assertNotEquals(pompier, result);
		assertNotEquals(reviewer, result);
	}

//	@Test
//	void testSelectAnotherPersonForNobodyElseSelectedYet() {
//		List<String> inputList = inputList();
//
//		List<String>  result = choixService.selectAnotherPerson(inputList, alreadySelectedPeople);
//
//		assertTrue(inputList.contains(result));
//		assertFalse(alreadySelectedPeople.contains(result));
//	}
//
////	@Test
//	void testIfSelectAnotherPersonAddTheSelectedOneToAlreadySelectPeopleList() {
//		List<String> inputList = inputList();
//
//		List<String>  result = choixService.selectAnotherPerson(inputList, alreadySelectedPeople);
//
//		assertTrue(alreadySelectedPeople.contains(result));
//	}

}
