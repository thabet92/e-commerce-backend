package com.formation.e_commerce.model;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idPersonne;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String adresse;
    private String mail;
    private Long phone;
    private Long cin;

    @OneToMany(mappedBy = "personne")
    private Collection<Reclamation> reclamations;

    @ManyToOne
    private Role role;
    



    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

  
    public Personne(String username, String password, String firstName, String lastName, String adresse, String mail,
            Long phone, Long cin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.mail = mail;
        this.phone = phone;
        this.cin = cin;
    }

    public Personne() {
    }

    public Collection<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(Collection<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    

    



}