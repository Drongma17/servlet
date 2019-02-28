package com.apssindia.hibernateframeworkclass.POI.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="design_table")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy=InheritanceType.JOINED)

@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="DesignType")
public class DesignDTO implements Serializable
{
	@Id
	@GenericGenerator(name = "gen" ,strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="design_id")
	private int id;
	@Column(name="design_price")
	private String price;
	@Column(name="design_type")
	private String designType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDesignType() {
		return designType;
	}
	public void setDesignType(String designType) {
		this.designType = designType;
	}
	
	
	
	
	
	

}
