package com.formation.e_commerce.model;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Personne{


   

    public Administrateur(String username, String password, String firstName, String lastName, String adresse,
            String mail, Long phone, Long cin) {
        super(username, password, firstName, lastName, adresse, mail, phone, cin);
    }

    public Administrateur() {
    }
    
}