package com.team.choix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringToListTest {
	
	@Test
	public void testChaineVide() throws Exception {
		assertEquals(null, StringToList.stringToList(""));
	}
	
	@Test
	public void testDeuxNom() throws Exception {
		List<String> candidats = new ArrayList<String>(Arrays.asList("Noël", "Sylvestre"));
		assertEquals(candidats, StringToList.stringToList("Noël\nSylvestre"));
	}
}
