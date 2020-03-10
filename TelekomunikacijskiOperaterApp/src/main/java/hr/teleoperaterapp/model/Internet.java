/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.model;

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
    
   
    public boolean FlatInterent;
    public boolean PokucniInternet;
    private int cijena;

    public boolean isFlatInterent() {
        return FlatInterent;
    }

    public void setFlatInterent(boolean FlatInterent) {
        this.FlatInterent = FlatInterent;
    }

    public boolean isPokucniInternet() {
        return PokucniInternet;
    }

    public void setPokucniInternet(boolean PokucniInternet) {
        this.PokucniInternet = PokucniInternet;
    }

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    
    
        
    
}
