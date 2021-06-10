package com.team.choix.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.team.choix.model.Participant;

@Profile("test")
@SpringBootTest
public class ParticipantRepositoryTest {
	@Autowired
	ParticipantRepository repository;
	
	@Test @Disabled
	public void testCreate() throws Exception {
		Participant participant = new Participant();
		participant.setFirstName("firstName");
		participant.setLastName("lastName");
		Participant result = repository.create(participant);
		assertNotNull(result.getId());
	}

	@Test @Disabled
	public void testList() throws Exception {
		List<Participant> result = repository.list();
		assertEquals(1, result.size());
	}

	@Test @Disabled
	public void testGet() throws Exception {
		Participant result = repository.get(1L);
		assertNotNull(result);
	}

}
