package hr.teleoperaterapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class MobilniUredaj extends Entitet {
     
    
    private String brand;
    private int cijena;
    private String os;
    @OneToOne
    private  MobilnaTarifa mobilnatarifa;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

   

    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public MobilnaTarifa getMobilnatarifa() {
        return mobilnatarifa;
    }

    public void setMobilnatarifa(MobilnaTarifa mobilnatarifa) {
        this.mobilnatarifa = mobilnatarifa;
    }

   
    
    
    
}
