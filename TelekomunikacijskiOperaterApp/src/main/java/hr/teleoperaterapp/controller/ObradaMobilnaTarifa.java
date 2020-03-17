/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.util.OperaterException;


/**
 *
 * @author Andrija
 */
public class ObradaMobilnaTarifa extends Obrada<MobilnaTarifa> {

    public ObradaMobilnaTarifa(MobilnaTarifa entitet) {
        super(entitet);
    }

   
    @Override
    protected void kontrolaCreate() throws OperaterException {
         kontrolaCijena();
        kontrolaNaziv();
        kontrolaPodatkovniPromet();
        kontrolaSms_min();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        
    }

    @Override
    protected void kontrolaSave() throws OperaterException {
      
    }

    private void kontrolaCijena() throws OperaterException {
        if(entitet.getCijena()==0){
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

    

  

   

    
}
