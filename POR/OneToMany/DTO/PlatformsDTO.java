package com.apssindia.hibernateframeworkclass.OneToMany.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;

import com.apssindia.javaproject.Singleton.SessionFactorySingleton;

@Entity
@Table(name="platform_table")
public class PlatformsDTO  
{
	@Id
	@GenericGenerator(name="gen4",strategy ="increment")
	@GeneratedValue(generator = "gen4")
	@Column(name="platform_no")
private int platformNo;
	@Column(name="platform_noofstalls")
private int noOfStalls;
	@Column(name="platform_trainname")
private String trainName;
	
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="Rail_noofplat")
	
	private RailwayStationDTO railway;
	
	
	public RailwayStationDTO getRailway() {
		return railway;
	}
	public void setRailway(RailwayStationDTO railway) {
		this.railway = railway;
	}
	
	RailwayStationDTO railway2 = new RailwayStationDTO();
	
	
	
	
	public int getPlatformNo() {
		return platformNo;
	}
	public void setPlatformNo(int platformNo) {
		this.platformNo = platformNo;
	}
	public int getNoOfStalls() {
		return noOfStalls;
	}
	public void setNoOfStalls(int noOfStalls) {
		this.noOfStalls = noOfStalls;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
    
	
}
