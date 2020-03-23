/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Andrija
 */
@Entity
@Table(name=" operater ")
public class Operater extends Entitet{
    
    private String email;
    private String lozinka;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

   
    
    
    
    
    
    
    
}
