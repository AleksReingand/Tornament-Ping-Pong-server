package com.airdr.pingpong.repository;

import com.airdr.pingpong.api.ResponseServer;
import com.airdr.pingpong.entities.Participant;

public interface IParticipant {

	Iterable<Participant> getAll();
	ResponseServer addParticipant(Participant participant);
	ResponseServer updateInfo(int id);
	ResponseServer removeParticipant(int id);
}
