/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.Tv;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;


/**
 *
 * @author Andrija
 */
public class ObradaTv extends Obrada<Tv> {

    public ObradaTv(Tv entitet) {
        super(entitet);
    }

    public ObradaTv() {
    }
    
    @Override
    public List<Tv> getPodaci() {
         return session.createQuery("from Tv").list();
    }
    
    
    

    @Override
    protected void kontrolaCreate() throws OperaterException {
        kontrolaCijena();
        kontrolaSportskiKanali();
        kontrolaFilmskiKanali();
        kontrolaIstiNaziv();
        
    }
    
 
    @Override
    protected void kontrolaUpdate() throws OperaterException {
        kontrolaDuzinaNaziv();
    }

    private void kontrolaCijena() throws OperaterException{
         if(entitet.getCijena()==null){
            throw new OperaterException("Cijena obavezna");
        }
    }

    private void kontrolaSportskiKanali() throws OperaterException {
         if(entitet.getSportskiKanali()!=true && entitet.getSportskiKanali()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    private void kontrolaFilmskiKanali() throws OperaterException{
        
         if(entitet.getFilmskiKanali()!=true && entitet.getFilmskiKanali()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    private void kontrolaDuzinaNaziv()throws OperaterException {
        
        if(entitet.getNaziv().length()>50){
          throw new OperaterException("Naziv mora biti manji od 50 znakova");
      }  
        
        
    }

    private void kontrolaIstiNaziv() throws OperaterException {
        
        Long ukupno = (Long)session
            .createQuery(" select count(t) from Tv t "
                    + " where t.naziv=:naziv")
              .setParameter("naziv", entitet.getNaziv())
              .uniqueResult();
      if(ukupno>0){
          throw  new OperaterException("Naziv postoji u bazi, odaberite drugi");
      }  
    }
    
     @Override
    protected void nakonSpremanja() throws OperaterException {
       
    }
     @Override
    protected void kontrolaDelete() throws OperaterException {
       
      
    }

    
}
