package com.ids.examen2.model;

import javax.persistence.*;

@Entity
@Table(name= "languaje")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLanguage;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public long getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(long idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

