/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;


/**
 *
 * @author Andrija
 */
public class ObradaInternet extends Obrada<Internet> {

    public ObradaInternet(Internet entitet) {
        super(entitet);
    }

    public ObradaInternet() {
    }
    
    

    
    @Override
    protected void kontrolaCreate() throws OperaterException {
      kontolaFlatInternet();
      kontrolaPokucniInternet();
      kontrolaCijena();
      kontrolaIstiNaziv();
        
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        
        kontrolaDuzinaNaziv();
        
    }


    private void kontolaFlatInternet() throws OperaterException{
        if(entitet.getFlatInterent()!=true && entitet.getFlatInterent()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
        
    }

    private void kontrolaPokucniInternet() throws OperaterException {
        if(entitet.getPokucniInternet()!=true && entitet.getPokucniInternet()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    private void kontrolaCijena() throws OperaterException{
        if (entitet.getCijena()==null){
            throw new OperaterException("Cijena obavezna");
        }
    }

    @Override
    public List<Internet> getPodaci() {
         return session.createQuery("from Internet").list();
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
            .createQuery(" select count(i) from Internet i "
                    + " where i.naziv=:naziv")
              .setParameter("naziv", entitet.getNaziv())
              .uniqueResult();
      if(ukupno>0){
          throw  new OperaterException("Naziv postoji u bazi, odaberite drugi");
      }  
        
    }
    
}
