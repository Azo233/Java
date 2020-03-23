/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;


/**
 *
 * @author Andrija
 */
public class ObradaMobilniUredaj extends Obrada<MobilniUredaj> {

    public ObradaMobilniUredaj(MobilniUredaj entitet) {
        super(entitet);
    }

    
    
    @Override
    protected void kontrolaCreate() throws OperaterException {
        kontrolaCijena();
        kontrolaBrand();
        kontrolaOs();
       
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
      
    }

    @Override
    protected void kontrolaSave() throws OperaterException {
        
    }

    private void kontrolaCijena() throws OperaterException{
        if(entitet.getCijena()==0){
            throw new OperaterException("Cijena obavezna");
        }
        
       
    }

    

    private void kontrolaOs() throws OperaterException {
        if(entitet.getOs().length()>20){
            throw new OperaterException("Ime mora imati manje od 20 znakova");
        }
    }

    private void kontrolaBrand() throws OperaterException{
        
       if(entitet.getBrand().length()>20){
            throw new OperaterException("Ime mora imati manje od 20 znakova");
        }
        
    }

    @Override
    public List<MobilniUredaj> getPodatci() {
        return session.createQuery("from MobilniUredaj").list();
    }
    
}
