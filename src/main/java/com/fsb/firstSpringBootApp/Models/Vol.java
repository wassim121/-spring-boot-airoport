package com.fsb.firstSpringBootApp.Models;

 
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vol")
public class Vol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nb_p")
	private int nbP;

	@Column(name = "dateAller")
	private LocalDate dateAller;

	@Column(name = "dateArriver")
	private LocalDate dateArriver;



	@Column(name = "lieuDepart")
	private String lieuDepart;

	@Column(name = "lieuArriver")
	private String lieuArriver;

	@Column(name = "prix")
	private double prix;

	// constructeurs, getters et setters
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbP() {
		return nbP;
	}

	public void setNbP(int nbP) {
		this.nbP = nbP;
	}

	public LocalDate getDateAller() {
		return dateAller;
	}

	public void setDateAller(LocalDate dateAller) {
		this.dateAller = dateAller;
	}

	public LocalDate getDateArriver() {
		return dateArriver;
	}

	public void setDateArriver(LocalDate dateArriver) {
		this.dateArriver = dateArriver;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArriver() {
		return lieuArriver;
	}

	public void setLieuArriver(String lieuArriver) {
		this.lieuArriver = lieuArriver;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
