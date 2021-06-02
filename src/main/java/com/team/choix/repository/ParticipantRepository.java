package com.team.choix.repository;

import java.util.List;

import com.team.choix.model.Participant;

public interface ParticipantRepository {
	List<Participant> list();
	Participant get(Long id);
	Participant create(Participant participant);
}
  