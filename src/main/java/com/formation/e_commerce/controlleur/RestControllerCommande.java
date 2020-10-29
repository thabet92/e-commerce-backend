package com.formation.e_commerce.controlleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.formation.e_commerce.dao.IArticleRepository;
import com.formation.e_commerce.dao.IClientRepository;
import com.formation.e_commerce.dao.ICommandeRepository;
import com.formation.e_commerce.model.Article;
import com.formation.e_commerce.model.Client;
import com.formation.e_commerce.model.Commande;

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
@RequestMapping(value = "/commandes")
public class RestControllerCommande {

    @Autowired
    private ICommandeRepository iCommandeRepository;
    @Autowired
    private IClientRepository icClientRepository;
    @Autowired
    private IArticleRepository iarticle;
    @GetMapping("/all")
    public List<Commande> gCommandes(){
        return iCommandeRepository.findAll();
    }
    @PostMapping("/save/{idClient}")
    public Commande saveCommande(@RequestBody Commande commande, @PathVariable long idClient ){
        Client client=icClientRepository.getOne(idClient);
        commande.setClient(client);
        return iCommandeRepository.save(commande);
    }

    @PostMapping("/saveCA/{idA}")
    public Commande saveCommandeArticle(@RequestBody Commande commande, @PathVariable long idA){
        Article article=iarticle.getOne(idA);
        List<Article> articles=new ArrayList<>();
        articles.add(article);
        commande.setArticles(articles);
        return iCommandeRepository.save(commande);
    }

    @PostMapping("/affectarticle/{idA}/{idC}")
    public Commande affectCommandeArticle(@PathVariable long idC, @PathVariable long idA){
      Article article=iarticle.getOne(idA);
      Commande commande=iCommandeRepository.getOne(idC);
      List<Article> articles=commande.getArticles();
      articles.add(articles.size(), article);;
      commande.setArticles(articles);
      return iCommandeRepository.save(commande);

    }

    
    @PutMapping("/modif/{idCommande}")
    public Commande modifCommande(@RequestBody Commande commande, @PathVariable long idCommande){
        commande.setIdCommande(idCommande);
        return iCommandeRepository.saveAndFlush(commande);

    }
    @DeleteMapping("/delete/{idCommande}")
    public HashMap<String,String> delete(@PathVariable long idCommande){
        HashMap  hashMap= new HashMap<>();
        try{
            iCommandeRepository.deleteById(idCommande);
            hashMap.put("etat", "commande supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "commande non suprimé");
            return hashMap;
        }
    }
    
}