package com.apssindia.hibernateframeworkclass.POI.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logo_table")
//@DiscriminatorValue("logo")
public class LogoDTO extends DesignDTO  implements Serializable
{  
   
   @Column(name="logo_shape")
   private String shape; 
   @Column(name="logo_client_name")
   private String clientName;
public String getShape() {
	return shape;
}
public void setShape(String shape) {
	this.shape = shape;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
   
	
}
