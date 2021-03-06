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
public class MobilnaTarifa extends Entitet {
    
    private String naziv;
    private BigDecimal cijena;
    private int podatkovi_promet;
    private int sms_min;

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

    public int getPodatkovi_promet() {
        return podatkovi_promet;
    }

    public void setPodatkovi_promet(int podatkovi_promet) {
        this.podatkovi_promet = podatkovi_promet;
    }

    public int getSms_min() {
        return sms_min;
    }

    public void setSms_min(int sms_min) {
        this.sms_min = sms_min;
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
