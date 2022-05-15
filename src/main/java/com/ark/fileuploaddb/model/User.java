package com.ark.fileuploaddb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user")
    private Long id;



    @Column(name="nom")
    private String nom;


    @Column(name="prenom")
    private String prenom;

    @Column(name="role")
    private String role;
    @Column(name="email")
    private String email;


    @Column(name="password")
    private String password;




    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_projet",joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<projet> projet =  new HashSet<>();

    public User(String username, String name, String email, String encode, Date creationDateTime, boolean b) {

        this.prenom = username ;
        this.nom = name;
                this.email = email ;
        this.password = encode ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<com.ark.fileuploaddb.model.projet> getProjet() {
        return projet;
    }

    public void setProjet(Set<com.ark.fileuploaddb.model.projet> projet) {
        this.projet = projet;
    }

    public User() {
    }

    public User(Long id, String nom, String prenom, String role, String email, String password, Set<com.ark.fileuploaddb.model.projet> projet) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.password = password;
        this.projet = projet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", projet=" + projet +
                '}';
    }
}
