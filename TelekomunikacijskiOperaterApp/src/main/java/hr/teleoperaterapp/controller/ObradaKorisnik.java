/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;


import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.util.OperaterException;
import hr.teleoperaterapp.util.Pomocno;




public class ObradaKorisnik<X extends Korisnik>extends Obrada<X> {

    
    public ObradaKorisnik(X entitet) {
        super(entitet);
    }
    
     @Override
    protected void kontrolaCreate() throws OperaterException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
       
    }

    @Override
    protected void kontrolaSave() throws OperaterException {
       
    }

    private void kontrolaIme() throws OperaterException {
        if(entitet.getIme().length()>20){
            throw new OperaterException("Ime mora imati manje od 20 znakova");
        }
       
    }

    private void kontrolaPrezime() throws OperaterException {
       if(entitet.getPrezime().length()>20){
           throw new OperaterException("Prezime mora imati manje od 20 znakova");
       }
    }

    private void kontrolaOib()throws OperaterException {
     if(!Pomocno.isOibValjan(entitet.getOib())){
            throw new  OperaterException("OIB nije valjan");
        }
    }

   
    

   

   

   
    }

   

    
    
    
    

