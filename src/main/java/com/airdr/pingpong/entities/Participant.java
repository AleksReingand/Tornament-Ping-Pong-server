package com.airdr.pingpong.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

	@Id
	private String id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	@OneToOne
	Photo photo;		
}
