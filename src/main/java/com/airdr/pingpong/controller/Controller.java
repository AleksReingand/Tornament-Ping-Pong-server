package com.airdr.pingpong.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airdr.pingpong.api.Api;
import com.airdr.pingpong.api.ResponseServer;
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
	
	@PostMapping(Api.PARTICIPANT)
	public ResponseServer newParticipant(@RequestBody Participant entity)
	{
		return participant.addParticipant(entity);
	}
	
	@PutMapping(Api.PARTICIPANT)
	public ResponseServer updateParticipant(@RequestParam(name = Api.DATA) int id, @RequestParam Participant entity)
	{
		return participant.updateInfo(id, entity);
	}
	
	@DeleteMapping(Api.PARTICIPANT)
	public ResponseServer deleteParticipant(@RequestParam(name = Api.DATA) int id)
	{
		return participant.removeParticipant(id);
	}
}
