package com.formation.e_commerce.controlleur;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import com.formation.e_commerce.File.StorageService;
import com.formation.e_commerce.dao.IArticleRepository;
import com.formation.e_commerce.dao.ICategorieRepository;
import com.formation.e_commerce.dao.IFournisseurRepository;
import com.formation.e_commerce.model.Article;
import com.formation.e_commerce.model.Categorie;
import com.formation.e_commerce.model.Fournisseur;

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
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/articles")
public class RestControllerArticle {

    @Autowired
    private IArticleRepository iArticleRepository;

    @Autowired
   private IFournisseurRepository ifFournisseurRepository;

   @Autowired
   private ICategorieRepository iCategorieRepository;
   @Autowired
   private StorageService storageService;



    @GetMapping("/all")
    public List<Article> gArticles(){
        return iArticleRepository.findAll();
    }

    @PostMapping("/save")
    public Article saveArticle( Article article, @PathParam("file") MultipartFile file){
        storageService.store(file);
        article.setPhoto(file.getOriginalFilename());
        return iArticleRepository.save(article);
    }

    @PostMapping("/save/{idCategorie}")
    public Article sArticleCat(Article article, @PathVariable long idCategorie, @PathParam("file") MultipartFile file){
        Categorie categorie=iCategorieRepository.getOne(idCategorie);
        article.setCategories(categorie);
        storageService.store(file);
        article.setPhoto(file.getOriginalFilename());
        return iArticleRepository.save(article);
    }

    @PutMapping("/modif/{idArticle}")
    public Article setArticle(@RequestBody Article article, @PathVariable long idArticle){
        article.setIdArticle(idArticle);
        return iArticleRepository.saveAndFlush(article);
    }
    @PutMapping("/modif/{idArticle}/{idCategorie}")
    public Article setArticle( Article article, @PathVariable long idArticle, @PathVariable long idCategorie , @PathParam("file") MultipartFile file){
        Categorie categorie=iCategorieRepository.getOne(idCategorie);
        article.setCategories(categorie);
        storageService.store(file);
        article.setPhoto(file.getOriginalFilename());
        article.setIdArticle(idArticle);
        return iArticleRepository.saveAndFlush(article);
    }

    @DeleteMapping("/delete/{idArticle}")
    public HashMap<String, String> delete(@PathVariable long idArticle){
        HashMap hashMap= new HashMap<>();
        try{
            iArticleRepository.deleteById(idArticle);
            hashMap.put("etat", "Article supprimé");
            return hashMap;
        }
        catch(Exception e){
            hashMap.put("etat", "Article non supprimé");
            return hashMap;

        }
    }

    /*@PostMapping("/save/{idFournissuer}")
    public Article sArticle(@RequestBody Article a, @PathVariable Long idFournisseur){
        Fournisseur fournisseur=ifFournisseurRepository.getOne(idFournisseur);
        a.setFournisseurs(fournisseur);
        return iArticleRepository.save(a);
    }*/
}