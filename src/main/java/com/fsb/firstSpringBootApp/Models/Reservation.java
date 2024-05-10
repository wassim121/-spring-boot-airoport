package com.fsb.firstSpringBootApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
 
	@Column(name="idvol")
	long idvol;
	@Column(name="username")
	String username;
	@Column(name="nbp")
	int nbp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdvol() {
		return idvol;
	}
	public void setIdvol(long idvol) {
		this.idvol = idvol;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNbp() {
		return nbp;
	}
	public void setNbp(int nbp) {
		this.nbp = nbp;
	}
	

}
