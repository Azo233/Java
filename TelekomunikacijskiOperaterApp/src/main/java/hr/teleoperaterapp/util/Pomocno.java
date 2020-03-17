/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.util;

import hr.teleoperaterapp.controller.ObradaMobilnaTarifa;
import hr.teleoperaterapp.controller.ObradaMobilniUredaj;
import hr.teleoperaterapp.controller.ObradaFiksniTelefon;
import hr.teleoperaterapp.controller.ObradaInternet;
import hr.teleoperaterapp.controller.ObradaTv;
import hr.teleoperaterapp.controller.ObradaKorisnik;
import hr.teleoperaterapp.model.FiksniTelefon;
import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.model.Tv;
import java.math.BigDecimal;

/**
 *
 * @author Andrija
 */
public class Pomocno {
    
    
    public static void pocetniInstert(){
       MobilnaTarifa Mt =new MobilnaTarifa();
            Mt.setNaziv("Svima svega");
            Mt.setPodatkovi_promet(20500 );
            Mt.setSms_min(2000);
            Mt.setCijena(150);
           ObradaMobilnaTarifa obradaMobilnaTarifa=new ObradaMobilnaTarifa(Mt);
             try {
            obradaMobilnaTarifa.create();
        } catch (OperaterException Oe) {
                 System.out.println(Oe.getPoruka());
        }
             
             
         
             MobilniUredaj Mu= new MobilniUredaj();
             Mu.setBrand("Samsung");
             Mu.setCijena(5000);
             Mu.setOs("Android 10");
             Mu.setMobilnatarifa(Mt); 
            ObradaMobilniUredaj obradaMobilniUredaj=new ObradaMobilniUredaj(Mu);
            try {
            obradaMobilniUredaj.create();
        } catch (OperaterException Oe) {
                System.out.println(Oe.getPoruka());
        }
            
            
      
         FiksniTelefon Ft=new FiksniTelefon();
         Ft.setCijena(80);
         Ft.setMin(2000);
         ObradaFiksniTelefon obradaFiksniTelefon=new ObradaFiksniTelefon(Ft);
         try {
            obradaFiksniTelefon.create();
        } catch (OperaterException Oe) {
             System.out.println(Oe.getPoruka());
        }
         
         
         
        Internet I=new Internet();
        I.setFlatInterent(true);
        I.setPokucniInternet(false);
        I.setCijena(150);
        ObradaInternet obradaInternet=new ObradaInternet(I);
         try {
          obradaInternet.create();
        } catch (OperaterException Oe) {
             System.out.println(Oe.getPoruka());
        }
         
         
         
        Tv tv=new Tv();
        tv.setFilmskiKanali(true);
        tv.setSportskiKanali(true);
        tv.setCijena(120);
        ObradaTv obradaTv=new ObradaTv(tv);
        try {
            obradaTv.create();
            
        } catch (OperaterException Oe) {
            System.out.println(Oe.getPoruka());
        }
        
        
        
        Korisnik K=new Korisnik();
        K.setIme("Petar");
        K.setPrezime("Marković");
        K.setOib("56460803073");
        K.setMobilnatarifa(Mt);
        K.setMobilniuredaj(Mu);
        K.setFiksnitelefon(Ft);
        K.setInternet(I);
        K.setTv(tv);
        ObradaKorisnik obradaKorisnik=new ObradaKorisnik(K);
        try {
            obradaKorisnik.create();
        } catch (OperaterException Oe) {
            System.out.println(Oe.getPoruka());
        }
        
        
        
          
          
         
    }
    public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }
    
}
