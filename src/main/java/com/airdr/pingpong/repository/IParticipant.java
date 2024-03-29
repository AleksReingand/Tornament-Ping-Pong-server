package com.airdr.pingpong.repository;

import com.airdr.pingpong.api.ResponseServer;
import com.airdr.pingpong.entities.Participant;

public interface IParticipant {

	Participant getParticipantById(Integer id);
	Iterable<Participant> getAllParticipant();
	ResponseServer addParticipant(Participant participant);
	ResponseServer updateInfo(Integer id, Participant participant);
	ResponseServer removeParticipant(Integer id);
}
