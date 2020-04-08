package hr.teleoperaterapp.model;

import java.math.BigDecimal;
import javax.persistence.Entity;

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
     
    
    private String naziv;
    private BigDecimal cijena;
    private String os;
    @OneToOne
    private  MobilnaTarifa mobilnatarifa;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

   
    
    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
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
