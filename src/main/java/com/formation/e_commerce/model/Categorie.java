package com.formation.e_commerce.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Categorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategorie;
    private String nameCategorie;
    private String descCategorie;
    
    @OneToMany(mappedBy = "categorie")
    private List<SousCategorie> sousCategories;
    @OneToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Article> articles;

    public long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }

    public String getDescCategorie() {
        return descCategorie;
    }

    public void setDescCategorie(String descCategorie) {
        this.descCategorie = descCategorie;
    }

    public List<SousCategorie> getSousCategories() {
        return sousCategories;
    }

    public void setSousCategories(List<SousCategorie> sousCategories) {
        this.sousCategories = sousCategories;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Categorie() {
    }

    public Categorie(long idCategorie, String nameCategorie, String descCategorie, List<SousCategorie> sousCategories,
            List<Article> articles) {
        this.idCategorie = idCategorie;
        this.nameCategorie = nameCategorie;
        this.descCategorie = descCategorie;
        this.sousCategories = sousCategories;
        this.articles = articles;
    }

    public Categorie(String nameCategorie, String descCategorie, List<SousCategorie> sousCategories,
            List<Article> articles) {
        this.nameCategorie = nameCategorie;
        this.descCategorie = descCategorie;
        this.sousCategories = sousCategories;
        this.articles = articles;
    }

    
    

    

    
}