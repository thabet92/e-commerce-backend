package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieRepository extends JpaRepository<Categorie,Long> {
    
}