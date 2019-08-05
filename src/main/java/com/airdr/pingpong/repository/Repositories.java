package com.airdr.pingpong.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.airdr.pingpong.api.ResponseServer;
import com.airdr.pingpong.entities.Participant;


@Repository
public class Repositories implements IParticipant{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Participant> getAllParticipant() {
		Query query = em.createQuery("SELECT p FROM Participant AS p");		
		return query.getResultList();
	}

	@Transactional
	public ResponseServer addParticipant(Participant participant) {
		if(em.find(Participant.class, participant.getId()) != null)
		{
			return ResponseServer.EXIST;
		}
		em.persist(participant);
		return ResponseServer.OK;
	}

	public Participant getParticipantById(Integer id) {
		return em.find(Participant.class, id);
	}

	@Transactional
	public ResponseServer updateInfo(Integer id, Participant newParticipant) {
		Participant participantOld = em.find(Participant.class, id);
		if(participantOld == null)
		{
			return ResponseServer.NOT_FOUND;
		}
		participantOld.setName(newParticipant.getName());
		participantOld.setPhoto(newParticipant.getPhoto());
		
		return ResponseServer.OK;
	}

	@Transactional
	public ResponseServer removeParticipant(Integer id) {
		Participant participant = em.find(Participant.class, id);
		if(participant == null)
		{
			return ResponseServer.NOT_FOUND;
		}
		em.remove(participant);
		return ResponseServer.OK;
	}

}
