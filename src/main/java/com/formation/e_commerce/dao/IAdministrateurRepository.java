package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Administrateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministrateurRepository extends JpaRepository<Administrateur,Long> {
    
}