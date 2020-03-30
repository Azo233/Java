/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.util;

import hr.teleoperaterapp.controller.ObradaFiksniTelefon;
import hr.teleoperaterapp.controller.ObradaInternet;
import hr.teleoperaterapp.controller.ObradaKorisnik;
import hr.teleoperaterapp.controller.ObradaMobilnaTarifa;
import hr.teleoperaterapp.controller.ObradaMobilniUredaj;
import hr.teleoperaterapp.controller.ObradaOperater;
import hr.teleoperaterapp.controller.ObradaTv;
import hr.teleoperaterapp.model.FiksniTelefon;
import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.model.Operater;
import hr.teleoperaterapp.model.Tv;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Andrija
 */
public class Pomocno {
    
    public static Operater LOGIRAN;
    
       private final static DecimalFormat df = df();
    
    
    
     public static String getNazivAplikacije(){
        return "Telekomunikacijski Operater App";
        
    }
     
   
     
        public static void pocetniInsert(){
            
            
        
      Operater o = new Operater();
        o.setEmail("azinic@gmail.com");
        o.setIme("Andrija");
        o.setPrezime("Azinić");
        o.setLozinka(BCrypt.hashpw("a", BCrypt.gensalt()));
        
        
        ObradaOperater obradaOperater = new ObradaOperater(o);
        try {
            obradaOperater.create();
        } catch (OperaterException eo) {
            System.out.println(eo.getPoruka());
        }
        }
        
        
        
        
           
        
        public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
     
    public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
     public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df.format(b);
    }
    
     public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
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

    private static DecimalFormat df() {
       NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    }
    
}
