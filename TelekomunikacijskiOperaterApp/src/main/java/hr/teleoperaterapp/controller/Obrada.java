/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.util.HibernateUtil;
import hr.teleoperaterapp.util.OperaterException;
import org.hibernate.Session;

/**
 *
 * @author Andrija
 */
public abstract class Obrada<X> {
    
    protected X entitet;
    protected Session session;
    protected abstract void kontrolaCreate() throws OperaterException;
    protected abstract void kontrolaUpdate() throws OperaterException;
    protected abstract void kontrolaSave () throws OperaterException;
    
    
    public Obrada (X entitet){
        this.entitet=entitet;
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public X create() throws OperaterException{
        kontrolaCreate();
         return save();
    }
    
    public X update() throws OperaterException{
       kontrolaUpdate();
        return save ();
    }
    
    public boolean Delete() throws OperaterException{
        
        kontrolaCreate();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
      
        return true;
        
    }
    
    private X save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        return entitet;
    }

   
}
