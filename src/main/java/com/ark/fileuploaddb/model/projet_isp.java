package com.ark.fileuploaddb.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="projet_isp")
	public class projet_isp implements Serializable {
	
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="projet_isp_ID")
	private Long PI_Id;
	@Column(name="nom_proje_ispt")
	private String nom;

	
	public projet_isp(Long pI_Id, String nom) {
		super();
		PI_Id = pI_Id;
		this.nom = nom;
	}

	public Long getPI_Id() {
		return PI_Id;
	}

	public void setPI_Id(Long pI_Id) {
		PI_Id = pI_Id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public projet_isp() {
		// TODO Auto-generated constructor stub
	}
}
