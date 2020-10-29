package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Personne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPersonneRepository extends JpaRepository<Personne,Long>{
    public Personne findByUsername(String username);
    
}