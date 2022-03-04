/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.ensat.actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import ma.ensat.model.Article;
import ma.ensat.service.*;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

@Component
public class ArticleAction {
    private Integer code;
    private String designation;
    private Float prix;
    private List<Article> articleList = new ArrayList<Article>();
    
    ArticleService articleService =new ArticleServiceImp();
             
    public String index(){
        articleList = articleService.getAll();
        return SUCCESS;
    }
    
    public String saveOrUpdateArticle(){
        Article art= new Article(code, designation,prix);
        articleService.create(art);
        return SUCCESS;
    }
    
    public String editArticle(){
        HttpServletRequest request;
        request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	Article	ArticleService = articleService.getArticle(Integer.parseInt(request.getParameter("code")));
	return SUCCESS;
    }
    public String deleteArticle(){
        HttpServletRequest request ;
        request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	articleService.deleteArticle(Integer.parseInt(request.getParameter("code")));
	return SUCCESS;
    }	
    
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
            
    
}
