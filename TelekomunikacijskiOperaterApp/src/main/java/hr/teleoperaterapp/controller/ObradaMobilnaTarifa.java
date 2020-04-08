/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;


/**
 *
 * @author Andrija
 */
public class ObradaMobilnaTarifa extends Obrada<MobilnaTarifa> {

    public ObradaMobilnaTarifa(MobilnaTarifa entitet) {
        super(entitet);
    }

    public ObradaMobilnaTarifa() {
    }
    
    

   
    @Override
    protected void kontrolaCreate() throws OperaterException {
         kontrolaCijena();
        kontrolaNaziv();
        kontrolaPodatkovniPromet();
        kontrolaSms_min();
        kontrolaIstiNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        kontrolaDuzinaNaziv();
    }

  

    private void kontrolaCijena() throws OperaterException {
        if(entitet.getCijena()==null){
            throw new OperaterException("Cijena obavezna");
        }
        
    }

    private void kontrolaNaziv() throws OperaterException {
       if(entitet.getNaziv().length()>20){
           throw new OperaterException("Naziv mora biti manji od 20 znakova");
       }
    }

    private void kontrolaPodatkovniPromet() throws OperaterException {
        
        if(entitet.getPodatkovi_promet()==0){
            throw new OperaterException("Obavezno Podatkovni promet");
                    
            
        }
        
    }

    private void kontrolaSms_min() throws OperaterException{
        
        if(entitet.getSms_min()==0){
            throw new OperaterException("Sms_min obavezno");
        }
     
    }

    @Override
    public List<MobilnaTarifa> getPodaci() {
         return session.createQuery("from MobilnaTarifa").list();
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
       
    }

    @Override
    protected void nakonSpremanja() throws OperaterException {
      
    }

    private void kontrolaDuzinaNaziv() throws OperaterException {
        
        if(entitet.getNaziv().length()>50){
          throw new OperaterException("Naziv mora biti manji od 50 znakova");
      }  
        
    }

    private void kontrolaIstiNaziv() throws OperaterException {
         Long ukupno = (Long)session
            .createQuery(" select count(m) from MobilnaTarifa m"
                    + " where m.naziv=:naziv")
              .setParameter("naziv", entitet.getNaziv())
              .uniqueResult();
      if(ukupno>0){
          throw  new OperaterException("Naziv postoji u bazi, odaberite drugi");
      }  
    
        
    }

    

  

   

    
}
