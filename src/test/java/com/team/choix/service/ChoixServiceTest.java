package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.choix.model.Pair;

@SpringBootTest
public class ChoixServiceTest {

	ChoixService choixService = new ChoixService();
	Pair pompier = new Pair();

	private List<String> inputList() {
		List<String> inputList = List.of("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara", " ", "l", "f   ", "");
		return inputList;
	}


	@Test
	public void shouldReturnRandomlyAnItemFromAList() {
		List<String> inputList = inputList();
		
		String pompier = choixService.chooseRandomItem(inputList);
		
		assertTrue(inputList.contains(pompier));
		assertNotNull(pompier);
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
	public void shouldReturnAListWithoutTheGivenPair() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		pompier.setDeputy("Camille");
		pompier.setHolder("Thomas");
		
		List<String> updateList = choixService.removeNames(inputList, pompier);
		
//		assertFalse(updateList.isEmpty());
		assertFalse(updateList.contains(pompier.getDeputy()));
		assertFalse(updateList.contains(pompier.getHolder()));
	}
	
	@Test
	public void ShouldReturnAListWithoutThe2GivenPair() {
		List<String> inputList = List.of("Arthur", "Thomas", "Frederic", "Elisabeth", "Christelle");
		pompier.setDeputy("Camille");
		pompier.setHolder("Thomas");
		Pair reviewer = new Pair("Toto", "Christelle");
		
		List<String> updateList = choixService.removeNames(inputList, pompier, reviewer);
		
//		assertFalse(updateList.isEmpty());
		assertFalse(updateList.contains(reviewer.getDeputy()));
		assertFalse(updateList.contains(reviewer.getHolder()));
		assertFalse(updateList.contains(pompier.getDeputy()));
		assertFalse(updateList.contains(pompier.getHolder()));
		assertFalse(updateList.equals(inputList));
	}
	
	
//	@Test
//	// ???????????
//	void shouldReturnAListOf2ItemsFromEachInputList() {
//		List<String> inputList = inputList();
//		List<String> inputList2 = List.of("Camille", "Maxime", "Claude", "Dominique");
//		
//		Pair result = choixService.select2Items(inputList, inputList2);
//		
////		assertTrue(inputList.contains(result.getDeputy()));
////		assertTrue(inputList2.contains(result.getHolder()));
//		assertTrue(inputList.contains(result.getHolder()));
//		assertTrue(inputList2.contains(result.getDeputy()));
//	}
	
	@Test
	void shouldReturnPairHolderDeputyStrictlyDifferentFromOneAnother() {
		for(int i = 0; i < 100; i++) {
			List<String> inputList = inputList();
			List<String> inputList2 = inputList();

			Pair result = choixService.selectAPair(inputList, inputList2);

			assertNotNull(result.getDeputy());
			assertNotNull(result.getHolder());
			assertNotEquals(result.getHolder(), result.getDeputy());
		}
	}
	
	@Test
	void shouldReturnPairHolderDeputyStrictlyDifferentFromTheGivenPair() {
		for(int i = 0; i < 100; i++) {
			List<String> inputList = inputList();
			List<String> inputList2 = List.of("Camille", "Maxime", "Claude", "Dominique");
			pompier.setDeputy("Maxime");
			pompier.setHolder("Arthur");;

			Pair result = choixService.selectAPair(inputList, inputList2, pompier);

			assertNotNull(result.getDeputy());
			assertNotNull(result.getHolder());
			assertNotEquals(result.getHolder(), result.getDeputy());
			assertNotEquals(pompier.getHolder(), result.getDeputy());
			assertNotEquals(pompier.getDeputy(), result.getDeputy());
			assertNotEquals(pompier.getHolder(), result.getHolder());
			assertNotEquals(pompier.getDeputy(), result.getHolder());
		}
	}
		
		@Test
		void shouldReturnPairHolderDeputyStrictlyDifferentFromTheGivenPairs() {
			for(int i = 0; i < 100; i++) {
				List<String> inputList = inputList();
				List<String> inputList2 = List.of("Camille", "Maxime", "Claude", "Dominique");
				pompier.setDeputy("Maxime");
				pompier.setHolder("Arthur");;
				Pair reviewer = new Pair("Dominique", "Christelle");
				Pair autre = new Pair("Claude", "Frederic");
				
				Pair result = choixService.selectAPair(inputList, inputList2, pompier, reviewer, autre);
				
				assertNotNull(result.getDeputy());
				assertNotNull(result.getHolder());
				assertNotEquals(result.getHolder(), result.getDeputy());
				assertNotEquals(pompier.getHolder(), result.getDeputy());
				assertNotEquals(pompier.getDeputy(), result.getDeputy());
				assertNotEquals(pompier.getHolder(), result.getHolder());
				assertNotEquals(pompier.getDeputy(), result.getHolder());
				assertNotEquals(reviewer.getHolder(), result.getDeputy());
				assertNotEquals(reviewer.getDeputy(), result.getDeputy());
				assertNotEquals(reviewer.getHolder(), result.getHolder());
				assertNotEquals(reviewer.getDeputy(), result.getHolder());
				assertNotEquals(autre.getHolder(), result.getDeputy());
				assertNotEquals(autre.getDeputy(), result.getDeputy());
				assertNotEquals(autre.getHolder(), result.getHolder());
				assertNotEquals(autre.getDeputy(), result.getHolder());
			}
	}
}
