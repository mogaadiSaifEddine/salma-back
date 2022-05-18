package com.ark.fileuploaddb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="isp_default_names")
public class IspDefultNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;




    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "ispname_projet",joinColumns = @JoinColumn(name = "ispame_id") , inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<projet> projet =  new HashSet<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public IspDefultNames() {
    }

    public Set<com.ark.fileuploaddb.model.projet> getProjet() {
        return projet;
    }

    public void setProjet(Set<com.ark.fileuploaddb.model.projet> projet) {
        this.projet = projet;
    }

    public IspDefultNames(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IspDefultNames{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
