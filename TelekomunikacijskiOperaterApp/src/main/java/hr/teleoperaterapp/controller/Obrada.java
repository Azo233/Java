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
    protected abstract void kontrolaDelete() throws OperaterException;
    public abstract List<X> getPodaci();
    protected abstract void nakonSpremanja() throws OperaterException;
    
    public X getEntitet() {
        return entitet;
    }
    
     public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void setEntitet(X entitet) {
        this.entitet = entitet;
    }

    
    
    public Obrada (X entitet){
        this();
        this.entitet=entitet;
        
    }
   
    
    public X create() throws OperaterException{
        System.out.println(entitet);
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    
    
     public void createAll(List<X> lista) throws OperaterException{
    
        session.beginTransaction();
        for(X sl : lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
        
        
    }
    
    public X update() throws OperaterException{
       kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public boolean delete() throws OperaterException{
        
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        return true;
        
    }
    
    private void  save(){
         session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
        
    }

   
}
