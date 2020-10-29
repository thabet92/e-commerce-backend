package com.formation.e_commerce.dao;

import com.formation.e_commerce.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends JpaRepository<Article,Long>{
    
}