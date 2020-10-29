package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.ICategorieRepository;
import com.formation.e_commerce.model.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categories")
public class RestControllerCategorie {

    @Autowired
    public ICategorieRepository iCategorieRepository;


    @GetMapping("/all")
    public List<Categorie> getCategorie(){
        return iCategorieRepository.findAll();
    }

    @PostMapping("/save")
    public Categorie saveCategorie(@RequestBody Categorie c){
        return iCategorieRepository.save(c);
    }

    @PutMapping("/modif/{id}")
    public Categorie modif(@RequestBody Categorie c,@PathVariable Long id){
        c.setIdCategorie(id);
        return iCategorieRepository.saveAndFlush(c); 
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete (@PathVariable Long id){
        HashMap hashMap=new HashMap<>();
        try{
            iCategorieRepository.deleteById(id);
            hashMap.put("etat", "Categorie supprimée");
            return hashMap;

        }
        catch(Exception e){
            hashMap.put("etat", "Categorie non supprimée");
            return hashMap;

        }
    }
    
}