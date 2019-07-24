package com.airdr.pingpong.repository;

import com.airdr.pingpong.api.ResponseServer;
import com.airdr.pingpong.entities.Participant;

public interface IParticipant {

	Participant getParticipantById(int id);
	Iterable<Participant> getAllParticipant();
	ResponseServer addParticipant(Participant participant);
	ResponseServer updateInfo(int id, Participant participant);
	ResponseServer removeParticipant(int id);
}
