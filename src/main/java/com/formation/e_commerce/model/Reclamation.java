package com.formation.e_commerce.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idReclamation;
    private String titre;
    private String sujet;

    @ManyToOne
    @JoinColumn(name="PER_ID")
    private Personne personne;

    public Long getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Reclamation() {
    }

    public Reclamation(Long idReclamation, String titre, String sujet, Personne personne) {
        this.idReclamation = idReclamation;
        this.titre = titre;
        this.sujet = sujet;
        this.personne = personne;
    }

    public Reclamation(String titre, String sujet, Personne personne) {
        this.titre = titre;
        this.sujet = sujet;
        this.personne = personne;
    }
    
    

    
}