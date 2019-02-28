package com.apssindia.hibernateframeworkclass.MAnyToMany.DTO;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="Competetion_table")
public class CompetetionDTO implements Serializable
{   @Id
	@GenericGenerator(name="gen7",strategy="increment")
	@GeneratedValue(generator="gen7")
	@Column(name="Competetion_fee")
	private int fee;
	@Column(name="Competetion_noOfParticipants")
	private int noOfParticipants;
	@Column(name="Competetion_eventName")
	private String eventName;
	@Column(name="Competetion_location")
    private String location;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="paticipents_table")
    private Collection<ParticipantsDTO> participants;
    
    public Collection<ParticipantsDTO> getParticipants() {
		return participants;
	}
	public void setParticipants(Collection<ParticipantsDTO> participants) {
		this.participants = participants;
	}

public int getNoOfParticipants() {
	return noOfParticipants;
}
public void setNoOfParticipants(int noOfParticipants) {
	this.noOfParticipants = noOfParticipants;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
   
}
