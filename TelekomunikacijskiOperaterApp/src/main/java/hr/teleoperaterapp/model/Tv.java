package hr.teleoperaterapp.model;

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
public class Tv extends Entitet{
    
    
    private boolean sportskiKanali;
    private boolean filmskiKanali;
    private int cijena;

    public boolean isSportskiKanali() {
        return sportskiKanali;
    }

    public void setSportskiKanali(boolean sportskiKanali) {
        this.sportskiKanali = sportskiKanali;
    }

    public boolean isFilmskiKanali() {
        return filmskiKanali;
    }

    public void setFilmskiKanali(boolean filmskiKanali) {
        this.filmskiKanali = filmskiKanali;
    }

    
  
    public int getCijena() {
        return cijena;
    }

    public void setCijena(int cijena) {
        this.cijena = cijena;
    }
    
    
}
