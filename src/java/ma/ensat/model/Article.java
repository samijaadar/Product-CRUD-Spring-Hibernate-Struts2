/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.ensat.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByCode", query = "SELECT a FROM Article a WHERE a.code = :code"),
    @NamedQuery(name = "Article.findByDesignation", query = "SELECT a FROM Article a WHERE a.designation = :designation"),
    @NamedQuery(name = "Article.findByPrix", query = "SELECT a FROM Article a WHERE a.prix = :prix")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "code")
    private Integer code;
    
    @Column(name = "Designation")
    private String designation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prix")
    private Float prix;

    public Article() {
    }

    public Article(Integer code) {
        this.code = code;
    }

    public Article(Integer code, String designation, Float prix) {
        this.code = code;
        this.designation = designation;
        this.prix = prix;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ma.ensat.model.Article[ code=" + code + " ]";
    }
    
}
