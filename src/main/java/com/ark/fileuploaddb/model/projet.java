package com.ark.fileuploaddb.model;


import java.io.Serializable;
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

	@ManyToMany
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

	@Override
	public String toString() {
		return "projet{" +
				"P_Id=" + P_Id +
				", nom='" + nom + '\'' +
				", Chantier=" + Chantier +
				", users=" + users +
				'}';
	}
}
