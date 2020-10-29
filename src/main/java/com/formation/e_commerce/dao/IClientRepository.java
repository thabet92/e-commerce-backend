package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {
    
}