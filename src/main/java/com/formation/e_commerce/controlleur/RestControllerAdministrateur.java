package com.formation.e_commerce.controlleur;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.IAdministrateurRepository;
import com.formation.e_commerce.dao.IPersonneRepository;
import com.formation.e_commerce.model.Administrateur;
import com.formation.e_commerce.model.Personne;
import com.formation.e_commerce.service.AccountService;

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
@RequestMapping(value = "/administrateurs")
public class RestControllerAdministrateur {
    @Autowired
    public IAdministrateurRepository iAdministrateurRepository;
    @Autowired
    private AccountService accountservice;
    @Autowired
    public IPersonneRepository ipersonnerepository;

    @GetMapping("/all")
    public List<Administrateur> gAdministrateurs() {
        return iAdministrateurRepository.findAll();
    }
    
    @PostMapping("/save")
    public Administrateur sAdministrateur(@RequestBody Administrateur administrateur){
        return accountservice.saveAdmin(administrateur);
    }

    @PutMapping("/modif/{id}")
    public Administrateur modifAdministrateur(@RequestBody Administrateur administrateur, @PathVariable long id){
        administrateur.setIdPersonne(id);
        return iAdministrateurRepository.saveAndFlush(administrateur);

    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete (@PathVariable long id){
        HashMap hashMap = new HashMap<>();
        try{
            iAdministrateurRepository.deleteById(id);
            hashMap.put("etat", "admin supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "admin non suprimé");
            return hashMap;

        }
    }
    @GetMapping("/byiduser")
    public Personne  getUser(Principal principal){
    Personne appUser = ipersonnerepository.findByUsername(principal.getName());
    return appUser ;
}
}