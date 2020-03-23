/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.util.HibernateUtil;
import hr.teleoperaterapp.util.OperaterException;
import org.hibernate.Session;
import java.util.List;


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
    public abstract List<X> getPodatci();

    public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    
    
    public Obrada (X entitet){
        this();
        this.entitet=entitet;
        
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
