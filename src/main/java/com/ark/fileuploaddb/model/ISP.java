package com.ark.fileuploaddb.model;


import javax.persistence.*;

@Entity
@Table(name="ISP")
public class ISP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String filename ;

    public ISP() {
    }

    public ISP(Long id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public ISP(String filename) {
        this.filename = filename;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "ISP{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                '}';
    }
}
