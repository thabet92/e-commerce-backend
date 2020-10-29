package com.formation.e_commerce.controlleur;

import java.util.ArrayList;
import java.util.List;

import com.formation.e_commerce.dao.IArticleRepository;
import com.formation.e_commerce.dao.IFournisseurRepository;
import com.formation.e_commerce.model.Article;
import com.formation.e_commerce.model.Fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fournisseur")
public class RestControllerFournisseur {
    @Autowired
    public IFournisseurRepository iFournisseurRepository;
    @Autowired
    public IArticleRepository iarticle;
    @GetMapping("/all")
    public List<Fournisseur> gFournisseurs(){
        return iFournisseurRepository.findAll();
    }

    @PostMapping("/save")
    public Fournisseur saveFournisseur(@RequestBody Fournisseur f){
        return iFournisseurRepository.save(f);

    }
    @PostMapping("/saveFA/{idA}")
    public Fournisseur saveFournisseurArticle(@RequestBody Fournisseur fournisseur, @PathVariable long idA){
      Article article=iarticle.getOne(idA);
      List<Article> articles=new ArrayList<>();
      articles.add(article);
      fournisseur.setArticles(articles);
      return iFournisseurRepository.save(fournisseur);

    }
    @PostMapping("/affectarticle/{idA}/{idF}")
    public Fournisseur affectarticle(@PathVariable long idF, @PathVariable long idA){
      Article article=iarticle.getOne(idA);
      System.out.println(" article"+article);
      Fournisseur fournisseur=iFournisseurRepository.getOne(idF);
      List<Article> articles=fournisseur.getArticles();
      
      System.out.println("list articles avant add"+articles);
      articles.add(articles.size(), article);;
      System.out.println("list articles apres add"+articles);
      fournisseur.setArticles(articles);
      return iFournisseurRepository.save(fournisseur);

    }
}