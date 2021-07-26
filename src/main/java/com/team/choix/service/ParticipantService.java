package com.team.choix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.choix.model.Participant;

@Service
public interface ParticipantService {
	List<Participant> getAll();

	List<String> getListFirstnames();
	List<String> getSeniors();
	List<String> getJuniors();
	
}
