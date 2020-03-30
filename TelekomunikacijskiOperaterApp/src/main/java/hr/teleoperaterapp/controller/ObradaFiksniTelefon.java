/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.FiksniTelefon;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;



/**
 *
 * @author Andrija
 */
public class ObradaFiksniTelefon extends Obrada<FiksniTelefon>{

    public ObradaFiksniTelefon(FiksniTelefon entitet) {
        super(entitet);
    }
    
   
    
    

    @Override
    protected void kontrolaCreate() throws OperaterException {
       kontrolaCijena();
       kontrolaMin();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException{
      
    }

   

    private void kontrolaCijena()  throws OperaterException{
        if(entitet.getCijena()==0){
            throw new OperaterException("Cijena obavezna");
        }
        
        
    }

    private void kontrolaMin() throws OperaterException{
        if (entitet.getMin()==0){
            throw new OperaterException("Min obavezno");
        }
    }

    @Override
    public List<FiksniTelefon> getPodatci() {
         return session.createQuery("from FiksniTelefon").list();
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
        
    }

    @Override
    protected void nakonSpremanja() throws OperaterException {
      
    }

    
    }

   
    
    
    
    
    
    

