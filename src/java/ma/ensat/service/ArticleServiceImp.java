/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.ensat.service;


import ma.ensat.dao.ArticleDaoImp;
import java.util.List;
import ma.ensat.dao.ArticleDao;
import ma.ensat.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImp implements ArticleService{

//    ArticleDaoImp dao = new ArticleDaoImp() ;
    
    ArticleDao dao = new ArticleDaoImp() ;

    
    public void setDao(ArticleDaoImp dao) {
        this.dao = dao;
    }

    public ArticleDao getDao() {
        return dao;
    }
     
    public void create(Article art) {
        dao.create(art);
    }

    public List<Article> getAll() {
            return dao.getAll();
    }

    public Article getArticle(int idArticle) {
    return dao.getArticle(idArticle);
    }


    public void updateArticle(Article art) {
    dao.create(art);
    }

    public void deleteArticle(Article article) {
    dao.deleteArticle(article);
    }

    @Override
    public void deleteArticle(int id) { 
    dao.deleteArticle(id);
    }
    
}
