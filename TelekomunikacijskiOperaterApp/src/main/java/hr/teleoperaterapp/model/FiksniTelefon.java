package hr.teleoperaterapp.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrija
 */
@Entity
public class FiksniTelefon extends Entitet {

  
    private String naziv;
    private int min;
    private int minInozemstvo;
    private BigDecimal cijena;
    

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMinInozemstvo() {
        return minInozemstvo;
    }

    public void setMinInozemstvo(int minInozemstvo) {
        this.minInozemstvo = minInozemstvo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
     
   @Override
    public String toString() {
       
        if(naziv==null){
            return "";
        }
        if(naziv.length()>20){
            return naziv.substring(0,17) + "...";
        }
        return naziv;
    }
    
    
   
    
    
    
}
