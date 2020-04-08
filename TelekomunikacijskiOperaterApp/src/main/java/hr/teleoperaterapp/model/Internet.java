/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Andrija
 */

@Entity(name = "Internet")
public class Internet extends Entitet
{
    
   
    private String naziv;
    private Boolean FlatInterent;
    private Boolean PokucniInternet;
    private BigDecimal cijena;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getFlatInterent() {
        return FlatInterent;
    }

    public void setFlatInterent(Boolean FlatInterent) {
        this.FlatInterent = FlatInterent;
    }

    public Boolean getPokucniInternet() {
        return PokucniInternet;
    }

    public void setPokucniInternet(Boolean PokucniInternet) {
        this.PokucniInternet = PokucniInternet;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

  

   
@Override
    public String toString() {
        // nešto što ne morate raditi
        if(naziv==null){
            return "";
        }
        if(naziv.length()>20){
            return naziv.substring(0,17) + "...";
        }
        return naziv;
    }
    
    
        
    
}
