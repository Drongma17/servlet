package com.apssindia.hibernateframeworkclass.POI.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="greetings_table")
//@DiscriminatorValue("greetings")
public class GreetingsDTO extends DesignDTO implements Serializable
{
	 
	   @Column(name="greetings_shape")
private int size;
	 @Column(name="greetings_size")
private String color;
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}

}
