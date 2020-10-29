package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.ResponsableVente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResponsableVenteRepository extends JpaRepository<ResponsableVente,Long> {
    
}