package com.apssindia.hibernateframeworkclass.OneToMany.DTO;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Railway_table")
public class RailwayStationDTO 
{
@Id
@GenericGenerator(name="gen5",strategy="increment")
@GeneratedValue(generator="gen5")
@Column(name="RailwayST_noOfPlaform")
private int noOfPaltforms;
@Column(name="RailwayST_stationName")
private String stationName;
@Column(name="RailwayST_noOfCounters")
private int noOfCounters;
@Column(name="RailwatST_location")
private String Location;


/*@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="platform_column")

private Collection<PlatformsDTO> platforms;



public Collection<PlatformsDTO> getPlatforms() {
	return platforms;
}
public void setPlatforms(Collection<PlatformsDTO> platforms) {
	this.platforms = platforms;
}*/
public int getNoOfPaltforms() {
	return noOfPaltforms;
}
public void setNoOfPaltforms(int noOfPaltforms) {
	this.noOfPaltforms = noOfPaltforms;
}
public String getStationName() {
	return stationName;
}
public void setStationName(String stationName) {
	this.stationName = stationName;
}
public int getNoOfCounters() {
	return noOfCounters;
}
public void setNoOfCounters(int noOfCounters) {
	this.noOfCounters = noOfCounters;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
}
