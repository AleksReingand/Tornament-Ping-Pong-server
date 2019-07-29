package com.airdr.pingpong.controller;

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
public class ControllerApp {
	
	@Autowired
	IParticipant participant;
	
	//private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ControllerApp.class);
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}

	@GetMapping(Api.PROFILE)
	public Participant getParticipantById(@RequestParam(name = Api.DATA) Integer id)
	{
		return participant.getParticipantById(id);
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
