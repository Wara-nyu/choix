package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.choix.model.Pair;

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
	public void shouldReturnAListWithoutTheGivenItem() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		
		List<String> updateList = choixService.removeNames(inputList, pompier);
		
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void ShouldReturnAListWithoutThe2GivenItems() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";
		
		List<String> updateList = choixService.removeNames(inputList, pompier, reviewer);
		
		assertFalse(updateList.contains(reviewer));
		assertFalse(updateList.contains(pompier));
	}
	
	@Test
	public void ShouldReturnAListWithoutThe3GivenItemsWith1NotInTheList() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		String pompier = "Thomas";
		String reviewer = "Arthur";
		String other = "Anon";
		
		List<String> updateList = choixService.removeNames(inputList, pompier, reviewer, other);
		
		assertFalse(updateList.contains(reviewer));
		assertFalse(updateList.contains(pompier));
		assertFalse(updateList.contains(other));
	}
	
	@Test
	public void shouldReturnRandomlyAnItemFromAList() {
		List<String> inputList = inputList();

		String pompier = choixService.chooseRandomItem(inputList);
		
		assertTrue(inputList.contains(pompier));
		assertNotNull(pompier);
	}
	
	@Test
	void shouldReturnAListOf2ItemsFromEachInputList() {
		List<String> inputList = inputList();
		List<String> inputList2 = List.of("Camille", "Maxime", "Claude", "Dominique");
		
		List<String> result = choixService.select2Items(inputList, inputList2);
		
		assertTrue(inputList.contains(result.get(0)));
		assertTrue(inputList2.contains(result.get(1)));
	}
	

	
	
//	@Test
//	void shouldReturnPairHolderDeputy() {
//		Pair pompier = new Pair();
//		
//		
//	}
}
