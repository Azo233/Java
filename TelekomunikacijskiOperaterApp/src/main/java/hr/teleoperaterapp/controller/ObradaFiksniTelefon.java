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

    public ObradaFiksniTelefon() {
    }
    


    @Override
    protected void kontrolaCreate() throws OperaterException {
       kontrolaCijena();
       kontrolaMin();
       kontrolaIstiNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException{
      kontrolaDuzinaNaziv();
    }

   

    private void kontrolaCijena()  throws OperaterException{
        if(entitet.getCijena()==null){
            throw new OperaterException("Cijena obavezna");
        }
        
        
    }

    private void kontrolaMin() throws OperaterException{
        if (entitet.getMin()==0){
            throw new OperaterException("Min obavezno");
        }
    }

    @Override
    public List<FiksniTelefon> getPodaci() {
         return session.createQuery("from FiksniTelefon").list();
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
        
    }

    @Override
    protected void nakonSpremanja() throws OperaterException {
      
    }

    private void kontrolaIstiNaziv() throws OperaterException {
       
         Long ukupno = (Long)session
            .createQuery(" select count(f) from FiksniTelefon f "
                    + " where f.naziv=:naziv")
              .setParameter("naziv", entitet.getNaziv())
              .uniqueResult();
      if(ukupno>0){
          throw  new OperaterException("Naziv postoji u bazi, odaberite drugi");
      }  
        
    }

    private void kontrolaDuzinaNaziv() throws OperaterException {
        
        if(entitet.getNaziv().length()>50){
          throw new OperaterException("Naziv mora biti manji od 50 znakova");
      }  
       
    }

    
    }

   
    
    
    
    
    
    

