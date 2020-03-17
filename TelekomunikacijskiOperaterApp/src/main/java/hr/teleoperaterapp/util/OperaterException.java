/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.util;

/**
 *
 * @author Andrija
 */
public class OperaterException extends Exception {
    
    private String poruka;

    public OperaterException(String poruka) {
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    
    
    
    
    
    
}
