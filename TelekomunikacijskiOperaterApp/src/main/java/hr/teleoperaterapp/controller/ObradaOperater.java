/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;


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


  

   
    
    @Override
    public List<Operater> getPodaci() {
         return session.createQuery("from Operater").list();
    }

    @Override
    protected void kontrolaCreate() throws OperaterException {
      
       kontrolaEmail();
       kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
        
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
       
    }


    @Override
    protected void nakonSpremanja() throws OperaterException {
        
    }
    
     private void kontrolaEmail() throws OperaterException{
         if(entitet.getEmail()==null||entitet.getEmail().trim().length()==0){
           throw new OperaterException("Email obavezno");
       }
    }

    private void kontrolaLozinka() throws OperaterException{
        if(entitet.getLozinka()==null || BCrypt.checkpw("", entitet.getLozinka())){
            throw new OperaterException("Obavezno lozinka");  
           }
    }
}
  
   

   
    
    
    
    

   
    
    
    
    
    

