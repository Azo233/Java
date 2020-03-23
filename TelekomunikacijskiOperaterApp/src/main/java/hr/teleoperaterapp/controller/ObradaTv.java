/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

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
    
    

    @Override
    protected void kontrolaCreate() throws OperaterException {
        kontrolaCijena();
        kontrolaSportskiKanali();
        kontrolaFilmskiKanali();
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

    private void kontrolaSportskiKanali() throws OperaterException {
         if(entitet.isSportskiKanali()!=true && entitet.isSportskiKanali()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    private void kontrolaFilmskiKanali() throws OperaterException{
        
         if(entitet.isFilmskiKanali()!=true && entitet.isFilmskiKanali()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    @Override
    public List<Tv> getPodatci() {
         return session.createQuery("from Tv").list();
    }
  

    

   
    
}
