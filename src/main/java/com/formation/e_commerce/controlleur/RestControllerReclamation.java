package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.IPersonneRepository;
import com.formation.e_commerce.dao.IReclamationRepository;
import com.formation.e_commerce.model.Personne;
import com.formation.e_commerce.model.Reclamation;

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
@RequestMapping(value  = "/reclamations")
public class RestControllerReclamation {
    @Autowired
    private IReclamationRepository iReclamationRepository;
    @Autowired
    private IPersonneRepository iPersonneRepository;

    @GetMapping("/all")
    public List<Reclamation> getReclamations() {
        return iReclamationRepository.findAll();
        
    }

    @PostMapping("/save/{idPersonne}")
    public Reclamation saveReclamation(@RequestBody Reclamation r, @PathVariable Long idPersonne){
        Personne personne =iPersonneRepository.getOne(idPersonne);
        r.setPersonne(personne);
        return iReclamationRepository.save(r);
    }

    @PutMapping("/modif/{id}")
    public Reclamation modifReclamation(@RequestBody Reclamation reclamation, @PathVariable long id){
        reclamation.setIdReclamation(id);
        return iReclamationRepository.saveAndFlush(reclamation);
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> delete(@PathVariable long id){
        HashMap hashMap= new HashMap<>();
        try{
            iReclamationRepository.deleteById(id);
            hashMap.put("etat", "reclamation supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "reclamation non supprimé");
            return hashMap;
        }
    }


}