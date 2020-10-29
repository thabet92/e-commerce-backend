package com.formation.e_commerce.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Fournisseur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFournisseur;
    private String namaFourisseur;
    private String adresseFournisseur;
    private String mailFournisseur;
    private String descFourniseur;

    @ManyToMany(mappedBy = "fournisseurs")
    private List<Article>articles;

    public long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNamaFourisseur() {
        return namaFourisseur;
    }

    public void setNamaFourisseur(String namaFourisseur) {
        this.namaFourisseur = namaFourisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public String getMailFournisseur() {
        return mailFournisseur;
    }

    public void setMailFournisseur(String mailFournisseur) {
        this.mailFournisseur = mailFournisseur;
    }

    public String getDescFourniseur() {
        return descFourniseur;
    }

    public void setDescFourniseur(String descFourniseur) {
        this.descFourniseur = descFourniseur;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Fournisseur() {
    }

   

    public Fournisseur(String namaFourisseur, String adresseFournisseur, String mailFournisseur, String descFourniseur,
            List<Article> articles) {
        this.namaFourisseur = namaFourisseur;
        this.adresseFournisseur = adresseFournisseur;
        this.mailFournisseur = mailFournisseur;
        this.descFourniseur = descFourniseur;
        this.articles = articles;
    }
    
    

    



    
}