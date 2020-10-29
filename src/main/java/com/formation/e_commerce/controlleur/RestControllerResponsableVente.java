package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.IResponsableVenteRepository;
import com.formation.e_commerce.model.ResponsableVente;

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
@RequestMapping(value = "/responsablesVente")
public class RestControllerResponsableVente {
    @Autowired
    public IResponsableVenteRepository iResponsableVenteRepository;

    @GetMapping("/all")
    public List<ResponsableVente> gResponsableVentes() {
        return iResponsableVenteRepository.findAll();
    }
    
    @PostMapping("/save")
    public ResponsableVente sResponsableVente(@RequestBody ResponsableVente responsableVente){
        return iResponsableVenteRepository.save(responsableVente);
    }

    @PutMapping("/modif/{id}")
    public ResponsableVente mResponsableVente(@RequestBody ResponsableVente responsableVente, @PathVariable long id){
        responsableVente.setIdPersonne(id);
        return iResponsableVenteRepository.saveAndFlush(responsableVente);

    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete (@PathVariable long id){
        HashMap hashMap = new HashMap<>();
        try{
            iResponsableVenteRepository.deleteById(id);
            hashMap.put("etat", "responsable de vente supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "responsable de vente non suprimé");
            return hashMap;

        }
    }
    
}