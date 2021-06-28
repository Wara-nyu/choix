package com.team.choix.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.choix.model.Participant;
import com.team.choix.repository.ParticipantRepository;
import com.team.choix.service.ParticipantService;


@Service
public class ParticipantServiceImpl implements ParticipantService{
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@Override
	public List<Participant> getAll() {
		return participantRepository.list();
	}

	@Override
	public List<String> getListFirstnames() {
		List<Participant> participants = getAll();
		List<String> firstNames = participants.stream().map(participant -> participant.getFirstName()).collect(Collectors.toList());
		return firstNames;
	}
}
