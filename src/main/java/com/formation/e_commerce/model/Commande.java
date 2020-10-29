package com.formation.e_commerce.model;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCommande;
    private Date dateCommande;
    private String descCommande;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;
    
    @ManyToMany(mappedBy = "commandes")
    private List<Article>articles;

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDescCommande() {
        return descCommande;
    }

    public void setDescCommande(String descCommande) {
        this.descCommande = descCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Commande() {
    }

    public Commande(long idCommande, Date dateCommande, String descCommande, Client client, List<Article> articles) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.descCommande = descCommande;
        this.client = client;
        this.articles = articles;
    }

    public Commande(Date dateCommande, String descCommande, Client client, List<Article> articles) {
        this.dateCommande = dateCommande;
        this.descCommande = descCommande;
        this.client = client;
        this.articles = articles;
    }

    
    

}