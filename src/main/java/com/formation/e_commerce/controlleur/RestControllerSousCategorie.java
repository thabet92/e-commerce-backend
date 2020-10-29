package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.ICategorieRepository;
import com.formation.e_commerce.dao.ISousCategorieRepository;
import com.formation.e_commerce.model.Categorie;
import com.formation.e_commerce.model.SousCategorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/souscategories")
public class RestControllerSousCategorie {
    @Autowired
    private ISousCategorieRepository iSousCategorieRepository;

    @Autowired
    private ICategorieRepository iCategorieRespository;

    @GetMapping("/all")
    public List<SousCategorie> gSousCategories(){
        return iSousCategorieRepository.findAll();
    }
    @PostMapping("/save/{idcategorie}")
    public SousCategorie saveSousCategorie(@RequestBody SousCategorie sCategorie, @PathVariable Long idcategorie){
        Categorie categorie = iCategorieRespository.getOne(idcategorie);
        sCategorie.setCategorie(categorie);
        return iSousCategorieRepository.save(sCategorie);

    }
    @PutMapping("/modif/{id}")
    public SousCategorie mSousCategorie(@RequestBody SousCategorie sousCategorie, @PathVariable long id){
        sousCategorie.setIdSousCat(id);
        return iSousCategorieRepository.saveAndFlush(sousCategorie);
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete(@PathVariable long id){
        HashMap hashMap=new HashMap<>();
        try{
            iSousCategorieRepository.deleteById(id);
            hashMap.put("etat", "sous categorie supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "sous categorie non supprimé");
            return hashMap;
        }
    }

    
    
}