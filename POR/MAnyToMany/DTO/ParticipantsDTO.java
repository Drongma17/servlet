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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="participent_table")
public class ParticipantsDTO implements Serializable
{   @Id
	@GenericGenerator(name ="gen6",strategy="increment")
	@GeneratedValue(generator="gen6")
	@Column(name="participants_id")
	private int id;
	@Column(name="participants_name")
	private String name;
	@Column(name="participants_noOfEvents")
    private int noOfEvents;
	@Column(name="participants_rating")
	private int rating;

	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="competetion_table")
private Collection<CompetetionDTO> comp;


public Collection<CompetetionDTO> getComp() {
	return comp;
}
public void setComp(Collection<CompetetionDTO> comp) {
	this.comp = comp;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNoOfEvents() {
	return noOfEvents;
}
public void setNoOfEvents(int noOfEvents) {
	this.noOfEvents = noOfEvents;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}



}
