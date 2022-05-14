package com.ark.fileuploaddb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name="Chantier")
	public class Chantier implements Serializable {
	
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="chantier_ID")
	private Long C_Id;
	@Column(name="nom_chantier")
	private String nom;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Chantier")
	private List<projet> projet;
	
	
	public Long getC_Id() {
		return C_Id;
	}

	public void setC_Id(Long c_Id) {
		C_Id = c_Id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<projet> getProjet() {
		return projet;
	}
	public void setProjet(List<projet> projet) {
		this.projet = projet;
	}
	
	public Chantier(Long c_Id, String nom, List<com.ark.fileuploaddb.model.projet> projet) {
		super();
		C_Id = c_Id;
		this.nom = nom;
		this.projet = projet;
	}
	public Chantier(Long c_Id, String nom) {
		super();
		C_Id = c_Id;
		this.nom = nom;
		
	}

	@Override
	public String toString() {
		return "Chantier [C_Id=" + C_Id + ", nom=" + nom + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Chantier() {
		// TODO Auto-generated constructor stub
	}
}
