/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp1;


import hr.teleoperaterapp.controller.ObradaMobilnaTarifa;
import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.util.HibernateUtil;
import hr.teleoperaterapp.util.OperaterException;
import hr.teleoperaterapp.util.Pomocno;
import hr.teleoperaterapp.view.SplashScreen;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class Start {
    
    public Start(){
        
        //HibernateUtil.getSessionFactory().openSession();
       Pomocno.pocetniInsert();
        new SplashScreen().setVisible(true);
     
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
    
}
