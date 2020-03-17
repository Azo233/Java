/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.util.OperaterException;


/**
 *
 * @author Andrija
 */
public class ObradaInternet extends Obrada<Internet> {

    public ObradaInternet(Internet entitet) {
        super(entitet);
    }

    
    @Override
    protected void kontrolaCreate() throws OperaterException {
      kontolaFlatInternet();
      kontrolaPokucniInternet();
      kontrolaCijena();
        
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        
    }

    @Override
    protected void kontrolaSave() throws OperaterException {
        
    }

    private void kontolaFlatInternet() throws OperaterException{
        if(entitet.isFlatInterent()!=true && entitet.isFlatInterent()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
        
    }

    private void kontrolaPokucniInternet() throws OperaterException {
        if(entitet.isPokucniInternet()!=true && entitet.isPokucniInternet()!=false){
            throw new OperaterException("Obavezno true ili false");
        }
    }

    private void kontrolaCijena() throws OperaterException{
        if (entitet.getCijena()==0){
            throw new OperaterException("Cijena obavezna");
        }
    }
    
}
