/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp1;


import hr.teleoperaterapp.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class Start {
    
    public Start(){
        HibernateUtil.getSessionFactory().openSession();
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
    
}
