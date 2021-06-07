package com.team.choix.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void testGetAll() {
		List<Participant> result = service.getAll();
		assertEquals(10, result.size());
		assertEquals("Arthur", result.get(1).getFirstName());
		assertEquals("Leothaud", result.get(1).getLastName());

	}

	@Test
	public void testGetListFirstnames() throws Exception {
		//given
		List <String> expected = Arrays.asList("Abdelaziz", "Arthur", "Christelle", "Elisabeth", "Frederic", "Jonathan", "Laurent", "Mathieu", "Thomas", "Wara");
		//when
		List<String> result = service.getListFirstnames();
		//then
		assertNotNull(result);
		assertEquals(10, result.size());
		assertEquals(expected, result);
	}
	
}
