package com.hamdi.motos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Moto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMoto;
	private String nomMoto;
	private Double prixMoto;
	private Date dateCreation;
	@ManyToOne
	private Categorie categorie;
	
	
	
	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Moto(String nomMoto, Double prixMoto, Date dateCreation) {
		super();
		this.nomMoto = nomMoto;
		this.prixMoto = prixMoto;
		this.dateCreation = dateCreation;
	}


	public Long getIdMoto() {
		return idMoto;
	}
	public void setIdMoto(Long idMoto) {
		this.idMoto = idMoto;
	}
	public String getNomMoto() {
		return nomMoto;
	}
	public void setNomMoto(String nomMoto) {
		this.nomMoto = nomMoto;
	}
	public Double getPrixMoto() {
		return prixMoto;
	}
	public void setPrixMoto(Double prixMoto) {
		this.prixMoto = prixMoto;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Moto [idMoto=" + idMoto + ", nomMoto=" + nomMoto + ", prixMoto=" + prixMoto + ", dateCreation="
				+ dateCreation + "]";
	}
	
	
}
