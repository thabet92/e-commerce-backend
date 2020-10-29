package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Reclamation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReclamationRepository extends JpaRepository<Reclamation,Long> {
    
}