/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.controller.Obrada;
import hr.teleoperaterapp.model.Operater;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Andrija
 */
public class ObradaOperater extends Obrada<Operater> {


 
   public ObradaOperater(Operater entitet) {
        super(entitet);
   }

    public ObradaOperater() {
        super();
    }

  
    
    public Operater autoriziraj(String email, String lozinka){
        
        List<Operater> lista= session.createQuery(" from Operater o "
        + " where o.email=:email ")
              .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Operater o = lista.get(0);
        if(o==null){
            return null;
        }
        
        return BCrypt.checkpw(lozinka, o.getLozinka()) ? o : null;
    }


    protected void kontrolaCreate() throws OperaterException {
        kontrolaEmail();
       kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        
    }

    @Override
    protected void kontrolaSave() throws OperaterException {
       
    }

    @Override
    public List<Operater> getPodatci() {
        return session.createQuery("from Operater").list();
    }

    private void kontrolaEmail() throws OperaterException {
        if (entitet.getEmail()==null|| entitet.getLozinka().trim().length()==0){
            throw new OperaterException("email obavezan");
        }
    }

    private void kontrolaLozinka() throws OperaterException {
         if(entitet.getLozinka()==null || entitet.getLozinka().trim().length()==0){
            throw new OperaterException("Obavezno lozinka");
    }

    }
}
  
   

   
    
    
    
    

   
    
    
    
    
    

