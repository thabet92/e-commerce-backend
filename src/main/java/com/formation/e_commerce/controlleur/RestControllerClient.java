package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.IClientRepository;
import com.formation.e_commerce.model.Client;

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
@RequestMapping(value = "/clients")
public class RestControllerClient {
    @Autowired
    public IClientRepository iClientRepository;

    @GetMapping("/all")
    public List<Client> gClients() {
        return iClientRepository.findAll();
    }
    
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client c){
        return iClientRepository.save(c);
    }

    @PutMapping("/modif/{id}")
    public Client modifClient(@RequestBody Client c, @PathVariable long id){
        c.setIdPersonne(id);
        return iClientRepository.saveAndFlush(c);

    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> delete (@PathVariable long id){
        HashMap hashMap = new HashMap<>();
        try{
            iClientRepository.deleteById(id);
            hashMap.put("etat", "client supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "client non suprimé");
            return hashMap;

        }
    }


}