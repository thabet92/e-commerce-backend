package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande,Long> {
    
}