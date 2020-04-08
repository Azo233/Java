/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.controller;

import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.util.OperaterException;
import java.util.List;


/**
 *
 * @author Andrija
 */
public class ObradaMobilniUredaj extends Obrada<MobilniUredaj> {

    public ObradaMobilniUredaj(MobilniUredaj entitet) {
        super(entitet);
    }

    public ObradaMobilniUredaj() {
        
    }
    
  

    @Override
    protected void kontrolaCreate() throws OperaterException {
        kontrolaNaziv();
        kontrolaCijena();
        kontrolaOs();
        kontrolaIstiNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws OperaterException {
      kontrolaDuzinaNaziv();
    }

  

    private void kontrolaCijena() throws OperaterException{
        if(entitet.getCijena()==null){
            throw new OperaterException("Cijena obavezna");
        }
        
       
    }

    

    private void kontrolaOs() throws OperaterException {
        if(entitet.getOs().length()>20){
            throw new OperaterException("Ime mora imati manje od 20 znakova");
        }
    }

    private void kontrolaNaziv() throws OperaterException{
        
       if(entitet.getNaziv().length()>20){
            throw new OperaterException("Ime mora imati manje od 20 znakova");
        }
        
    }

    @Override
    public List<MobilniUredaj> getPodaci() {
        return session.createQuery("from MobilniUredaj").list();
    }

    @Override
    protected void kontrolaDelete() throws OperaterException {
        
    }

    @Override
    protected void nakonSpremanja() throws OperaterException {
        
    }

    private void kontrolaIstiNaziv() throws OperaterException {
       Long ukupno = (Long)session
            .createQuery(" select count(m) from MobilniUredaj m "
                    + " where m.naziv=:naziv")
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

   
    

