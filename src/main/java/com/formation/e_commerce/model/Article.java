package com.formation.e_commerce.model;


import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    private float prixArticle;
    private double qteArticle;
    private String descArticle;
    private String photo;

    @ManyToMany
    @JoinTable(name = "ART_CMD", joinColumns = @JoinColumn(name= "ART_ID"),inverseJoinColumns = @JoinColumn(name="CMD_ID"))
    private List<Commande> commandes;

    @ManyToMany
    @JoinTable(name = "ART_FOUR",joinColumns = @JoinColumn(name= "ART_ID"),inverseJoinColumns = @JoinColumn(name= "FOUR_ID"))
    private List<Fournisseur> fournisseurs;

    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    private Categorie categories;

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public float getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(float prixArticle) {
        this.prixArticle = prixArticle;
    }

    public double getQteArticle() {
        return qteArticle;
    }

    public void setQteArticle(double qteArticle) {
        this.qteArticle = qteArticle;
    }

    public String getDescArticle() {
        return descArticle;
    }

    public void setDescArticle(String descArticle) {
        this.descArticle = descArticle;
    }
    

    public Article() {
    }

    public Article(Long idArticle, float prixArticle, double qteArticle, String descArticle, List<Commande> commandes,
            List<Fournisseur> fournisseurs, Categorie categories) {
        this.idArticle = idArticle;
        this.prixArticle = prixArticle;
        this.qteArticle = qteArticle;
        this.descArticle = descArticle;
        this.commandes = commandes;
        this.fournisseurs = fournisseurs;
        this.categories = categories;
    }

    public Article(float prixArticle, double qteArticle, String descArticle, List<Commande> commandes,
            List<Fournisseur> fournisseurs, Categorie categories) {
        this.prixArticle = prixArticle;
        this.qteArticle = qteArticle;
        this.descArticle = descArticle;
        this.commandes = commandes;
        this.fournisseurs = fournisseurs;
        this.categories = categories;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public Categorie getCategories() {
        return categories;
    }

    public void setCategories(Categorie categories) {
        this.categories = categories;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    

    
    


    
}