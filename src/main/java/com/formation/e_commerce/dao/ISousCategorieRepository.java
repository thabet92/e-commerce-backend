package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.SousCategorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISousCategorieRepository extends JpaRepository<SousCategorie,Long> {
    
}