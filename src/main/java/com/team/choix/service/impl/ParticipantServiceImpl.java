package com.team.choix.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	@Override
	public List<String> getSeniors(){
		List<Participant> participants = getAll();
		List<String> seniors = participants.stream().filter(participant -> participant.getExp().equals("senior")).map(participant -> participant.getFirstName()).collect(Collectors.toList());
		return seniors;
	}
	
	@Override
	public List<String> getJuniors(){
		List<Participant> participants = getAll();
		List<String> juniors = participants.stream().filter(participant -> participant.getExp().equals("junior")).map(participant -> participant.getFirstName()).collect(Collectors.toList());
		return juniors;
	}
}
