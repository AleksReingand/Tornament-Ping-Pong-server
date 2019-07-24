package com.airdr.pingpong.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airdr.pingpong.api.ResponseServer;
import com.airdr.pingpong.entities.Participant;


@Repository
public class Repositories implements IParticipant{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public Iterable<Participant> getAllParticipant() {
		Query query = em.createQuery("SELECT * FROM partisipant");		
		return query.getResultList();
	}

	public ResponseServer addParticipant(Participant participant) {
		if(em.find(Participant.class, participant.getId()) != null)
		{
			return ResponseServer.EXIST;
		}
		em.persist(participant);
		return ResponseServer.OK;
	}

	public ResponseServer updateInfo(int id, Participant participant) {
		Participant participantOld = em.find(Participant.class, id);
		if(participantOld == null)
		{
			return ResponseServer.NOT_FOUND;
		}
		participantOld.setName(participant.getName());
		participantOld.setPhoto(participant.getPhoto());
		return ResponseServer.OK;
	}

	public ResponseServer removeParticipant(int id) {
		Participant participant = em.find(Participant.class, id);
		if(participant == null)
		{
			return ResponseServer.NOT_FOUND;
		}
		em.remove(participant);
		return ResponseServer.OK;
	}
	
	public Participant getParticipantById(int id)
	{
		Participant participant = em.find(Participant.class, id);
		return participant;
	}

}
