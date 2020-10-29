package com.formation.e_commerce.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SousCategorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSousCat;
    private String nameSousCat;
    private String descSousCat;
    
    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    private Categorie categorie;

    public long getIdSousCat() {
        return idSousCat;
    }

    public void setIdSousCat(long idSousCat) {
        this.idSousCat = idSousCat;
    }

    public String getNameSousCat() {
        return nameSousCat;
    }

    public void setNameSousCat(String nameSousCat) {
        this.nameSousCat = nameSousCat;
    }

    public String getDescSousCat() {
        return descSousCat;
    }

    public void setDescSousCat(String descSousCat) {
        this.descSousCat = descSousCat;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public SousCategorie() {
    }

    public SousCategorie(long idSousCat, String nameSousCat, String descSousCat, Categorie categorie) {
        this.idSousCat = idSousCat;
        this.nameSousCat = nameSousCat;
        this.descSousCat = descSousCat;
        this.categorie = categorie;
    }

    public SousCategorie(String nameSousCat, String descSousCat, Categorie categorie) {
        this.nameSousCat = nameSousCat;
        this.descSousCat = descSousCat;
        this.categorie = categorie;
    }
    
}