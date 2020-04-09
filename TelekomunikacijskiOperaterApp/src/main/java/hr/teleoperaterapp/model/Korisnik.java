package hr.teleoperaterapp.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrija
 */
@Entity(name = "Korisnik")
public class Korisnik extends Entitet {
    
    private String ime;
    private String prezime;
    private String oib;
    private BigDecimal troskovi;
    
    @ManyToOne
    private  MobilnaTarifa mobilnatarifa;
    @ManyToOne
    private  MobilniUredaj mobilniuredaj;
    @ManyToOne
    private FiksniTelefon fiksnitelefon;
    @ManyToOne
    private  Tv tv;
    @ManyToOne
    private  Internet internet;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

      public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }


    public MobilnaTarifa getMobilnatarifa() {
        return mobilnatarifa;
    }

    public void setMobilnatarifa(MobilnaTarifa mobilnatarifa) {
        this.mobilnatarifa = mobilnatarifa;
    }

    public MobilniUredaj getMobilniuredaj() {
        return mobilniuredaj;
    }

    public void setMobilniuredaj(MobilniUredaj mobilniuredaj) {
        this.mobilniuredaj = mobilniuredaj;
    }

    public FiksniTelefon getFiksnitelefon() {
        return fiksnitelefon;
    }

    public void setFiksnitelefon(FiksniTelefon fiksnitelefon) {
        this.fiksnitelefon = fiksnitelefon;
    }

    public Tv getTv() {
        return tv;
    }

    public void setTv(Tv tv) {
        this.tv = tv;
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    public BigDecimal getTroskovi() {
        return troskovi;
    }

    public void setTroskovi(BigDecimal Troskovi) {
        this.troskovi = Troskovi;
    }

  

    

    
    
    

   
    

    @Override
    public String toString() {
        return prezime + " " + ime;
    }
   

    
}