/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;


import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.util.OperaterException;
import hr.teleoperaterapp.util.Pomocno;
import java.util.List;




public class ObradaKorisnik extends Obrada<Korisnik> {

    
    public ObradaKorisnik(Korisnik korisnik){
        super(korisnik);
    }

    public ObradaKorisnik() {
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

    @Override
    public List<Korisnik> getPodaci() {
         return session.createQuery("from Korisnik").list();
    }
    
    public List<Korisnik> getPodaci(String uvjet){
        return session.createQuery("from Korisnik k "
                + " where concat(k.ime, ' ', k.prezime) like :uvjet "
                + " or concat(k.prezime, ' ', k.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(50).list();
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
        
    }

    @Override
    protected void nakonSpremanja() throws OperaterException {
       
    }

   
        
    }

   
    

   

   

   
    

   

    
    
    
    

