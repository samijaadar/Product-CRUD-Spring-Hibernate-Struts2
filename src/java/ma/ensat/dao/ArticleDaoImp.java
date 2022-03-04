package ma.ensat.dao;
import java.util.ArrayList;
import java.util.List;
import ma.ensat.model.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImp implements ArticleDao
{
    Transaction Tx=null;
    
    @Override
    public  void create(Article art)
    { 
        try   
        {   
            Session S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            S.saveOrUpdate(art);
            Tx.commit();
        }
        catch (Exception e) 
        {
            Tx.rollback();
            e.printStackTrace();
        }
    }

    public  List<Article> getAll(){   
        List<Article> articles = new ArrayList<Article>();
        try {
            Session S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            articles = S.createQuery("from Article").list();
        } 
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return articles;
    }

    public  Article getArticle(int idArticle) {

        Article art = null;
        try {
            Session    S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            art = (Article) S.get(Article.class, idArticle);
        } 
        catch (Exception e)
        {   
            e.printStackTrace();
        }		
        return art;
    }

    public  void updateArticle(Article art) {
      try{
            Session S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            S.saveOrUpdate(art);
            Tx.commit();
        }
        catch (Exception e){
            Tx.rollback();
            e.printStackTrace();
        }
    }

    public  void deleteArticle(Article article) 
    {  
        try
        {
            Session S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            Article art = (Article) S.get(Article.class, article.getCode());
            S.delete(art);
            Tx.commit();
            Tx.rollback();
        }
        catch (Exception e) 
        {
            Tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int id) {
      try
        {
            Session S= HibernateUtil.getSessionFactory().openSession();
            Tx =S.beginTransaction(); 
            Article art = (Article) S.get(Article.class, id);
            S.delete(art);
            Tx.commit();
             
        }
        catch (Exception e) 
        {
            Tx.rollback();
            e.printStackTrace();
        }
    }
    
    
}
