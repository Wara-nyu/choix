package com.team.choix.repository.impl;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team.choix.model.Participant;
import com.team.choix.repository.ParticipantRepository;

@Repository
public class ParticipantRepositoryJdbcImpl implements ParticipantRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Participant> list() {
		return jdbcTemplate.query("SELECT * FROM PARTICIPANT",
                (rs, rowNum) ->
        new Participant(
                rs.getLong("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("selectionCount"),
                rs.getDate("lastSelectionDate") != null ? 
                rs.getDate("lastSelectionDate").toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate() : null));
	}

	@Override
	public Participant get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participant create(Participant participant) {
		
		return null;
	}

}
