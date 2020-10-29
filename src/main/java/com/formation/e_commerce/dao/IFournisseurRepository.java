package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
    
}