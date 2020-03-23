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
import hr.teleoperaterapp.controller.ObradaOperater;
import hr.teleoperaterapp.model.FiksniTelefon;
import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.model.Operater;
import hr.teleoperaterapp.model.Tv;
import java.math.BigDecimal;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Andrija
 */
public class Pomocno {
    
     public static String getNazivAplikacije(){
        return "Telekomunikacijski Operater App";
    }
     
    public static void pocetniInsert(){
        
        
        Operater o = new Operater();
        o.setEmail("azinic@gmail.com");
        o.setLozinka(BCrypt.hashpw("a", BCrypt.gensalt()));
        
        
        ObradaOperater obradaOperater = new ObradaOperater(o);
        try {
            obradaOperater.create();
        } catch (OperaterException op) {
            System.out.println(op.getPoruka());
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
