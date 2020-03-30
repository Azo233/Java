package hr.teleoperaterapp.model;

import java.math.BigDecimal;

import javax.persistence.Entity;




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
public class Tv extends Entitet{

    
    private String naziv;    
    private Boolean sportskiKanali;
    private Boolean filmskiKanali;
    private BigDecimal cijena;
    
  
    
    

    public boolean getSportskiKanali() {
        return sportskiKanali;
    }

    public void setSportskiKanali(Boolean sportskiKanali) {
        this.sportskiKanali = sportskiKanali;
    }

    public boolean getFilmskiKanali() {
        return filmskiKanali;
    }

    public void setFilmskiKanali(Boolean filmskiKanali) {
        this.filmskiKanali = filmskiKanali;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
