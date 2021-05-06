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
		List<String> candidats = new ArrayList<>(Arrays.asList("Abdelazziz", "Arthur", "Christelle", "Elisabeth", "Frederic", "Jonathan", "Laurent","Mathieu", "Thomas", "Wara"));
		ChoixService choisi = new ChoixService();
		
		String nom = choisi.hasard(candidats);

		assertTrue(candidats.contains(nom));

	}
	
	@Test
	public void testSuppleant() throws Exception {
			
			List<String> candidats = new ArrayList<>(Arrays.asList("Arthur", "Christelle", "Elisabeth", "Frederic", "Thomas", "Wara"));
			ChoixService choisi = new ChoixService();
			String nom = choisi.hasard(candidats);
			
			String suppleant = choisi.suppleant(candidats, nom);
			
			assertTrue(candidats.contains(suppleant));
			assertNotEquals(nom, suppleant);
		}
		
}
