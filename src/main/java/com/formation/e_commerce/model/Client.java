package com.formation.e_commerce.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends Personne{
    
    @OneToMany(mappedBy = "client")
    private Collection<Commande> commandes;

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

   

    public Client(String username, String password, String firstName, String lastName, String adresse, String mail,
            Long phone, Long cin, Collection<Commande> commandes) {
        super(username, password, firstName, lastName, adresse, mail, phone, cin);
        this.commandes = commandes;
    }

    public Client(Collection<Commande> commandes) {
        this.commandes = commandes;
    }

    public Client() {
    }
    
}