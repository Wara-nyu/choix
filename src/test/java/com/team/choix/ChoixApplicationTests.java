package com.team.choix;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.choix.service.ChoixService;

@SpringBootTest
class ChoixApplicationTests {

	@Test
	public void test() {
		List<String> prenoms = Arrays.asList("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara");
		ChoixService choisi = new ChoixService();
		String nom = choisi.selectHasard(prenoms);

		assertTrue(prenoms.contains(nom));

	}
	
	@Test
	public void testSuppleant() throws Exception {
		List<String> prenoms = new ArrayList<>(Arrays.asList("Arthur", "Christelle", "Elisabeth", "Federic", "Thomas", "Wara"));
		ChoixService choisi = new ChoixService();
		String nom = choisi.selectHasard(prenoms);
			
		String suppleant = choisi.suppleant(prenoms, nom);
			
		assertTrue(prenoms.contains(suppleant));
		assertNotEquals(nom, suppleant);
		}
		
}
