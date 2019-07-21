package com.airdr.pingpong.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airdr.pingpong.api.Api;
import com.airdr.pingpong.entities.Participant;
import com.airdr.pingpong.repository.IParticipant;

@RestController
public class Controller {
	
	@Autowired
	IParticipant participant;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Controller.class);

	@GetMapping(Api.PARTICIPANT)
	public Iterable<Participant> createParticipant()
	{
		return participant.getAllParticipant();
	}
}
