package com.ark.fileuploaddb.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
	@Table(name="projet")
	public class projet implements Serializable {
	
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="projet_ID")
	private Long P_Id;
	@Column(name="nom_projet")
	private String nom;
	@Column(name="etat",columnDefinition = "boolean default true")
	private Boolean state;



	private ZonedDateTime date = ZonedDateTime.now();

	public ZonedDateTime getDate() {
		return date;
	}

	public Long getP_Id() {
		return P_Id;
	}
	
	public projet(Long p_Id, String nom, Chantier chantier) {
		super();
		P_Id = p_Id;
		this.nom = nom;
		this.Chantier = chantier;

	}
	public projet(Long p_Id, String nom) {
		super();
		P_Id = p_Id;
		this.nom = nom;
		
	}
	
	public void setP_Id(Long p_Id) {
		P_Id = p_Id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Chantier getChantier() {
		return Chantier;
	}
	public void setChantiers(Chantier chantier) {
		this.Chantier = chantier;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@ManyToOne
	@JoinColumn(name = "chantier_ID")
	Chantier Chantier;



	@JsonIgnoreProperties(value = "projet")
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.MERGE
			},
			mappedBy = "projet")
	Set<User> users;
	public projet() {
		// TODO Auto-generated constructor stub
	}



	public void setChantier(com.ark.fileuploaddb.model.Chantier chantier) {
		Chantier = chantier;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "projet{" +
				"P_Id=" + P_Id +
				", nom='" + nom + '\'' +
				", state=" + state +
				", Chantier=" + Chantier +
				", users=" + users +
				'}';
	}
}
