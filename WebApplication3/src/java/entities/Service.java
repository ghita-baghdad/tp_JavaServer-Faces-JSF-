/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */
@Entity
public class Service implements Serializable {
    
    
    @Id 
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id ;
    private String code;
    private String libelle;
     
    @OneToMany (mappedBy = "services",fetch = FetchType.EAGER)
    private List<Employe> employe;
    
    
    public Service() {
    }

    public Service(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(List<Employe> employe) {
        this.employe = employe;
    }
     

    @Override
    public String toString() {
        return "Service{" + "code=" + code + ", libelle=" + libelle + '}';
    }
    
    
    
}
