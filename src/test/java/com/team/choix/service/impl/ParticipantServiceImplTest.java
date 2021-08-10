package com.team.choix.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.team.choix.model.Participant;
import com.team.choix.service.ParticipantService;

@Profile("test")
@SpringBootTest
public class ParticipantServiceImplTest {

	@Autowired
	ParticipantService service;
	
//	@Test
//	public void testGetAll() {
//		//mock ?
//		List<Participant> result = service.getAll();
//		assertEquals(10, result.size());
//		assertEquals("Arthur", result.get(1).getFirstName());
//		assertEquals("Leothaud", result.get(1).getLastName());
//
//	}
//
//	@Test
//	public void getFirstnames() throws Exception {
//		//given
//		List <String> expected = Arrays.asList("Abdelaziz", "Arthur", "Christelle", "Elisabeth", "Frederic", "Jonathan", "Laurent", "Mathieu", "Thomas", "Wara");
//		//when
//		List<String> result = service.getListFirstnames();
//		//then
//		assertNotNull(result);
//		assertEquals(10, result.size());
//		assertEquals(expected, result);
//	}
	
	@Test
	@Disabled
	void ShouldReturnListOfAllSenior(){
		List <String> expected = Arrays.asList("Arthur", "Thomas");
		
		List<String> result = service.getSeniors();
		
		assertTrue(result.equals(expected));
	}
	
	@Test
	@Disabled
	void ShouldReturnListOfAllJunior(){
		List <String> expected = Arrays.asList("Wara");
		
		List<String> result = service.getJuniors();
		
		assertTrue(result.equals(expected));
	}
	
}
