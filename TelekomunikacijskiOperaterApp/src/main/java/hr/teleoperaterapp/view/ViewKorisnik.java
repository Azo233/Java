/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.view;

import hr.teleoperaterapp.controller.ObradaKorisnik;
import hr.teleoperaterapp.controller.ObradaMobilniUredaj;
import hr.teleoperaterapp.controller.ObradaTv;
import hr.teleoperaterapp.controller.ObradaInternet;
import hr.teleoperaterapp.controller.ObradaFiksniTelefon;
import hr.teleoperaterapp.controller.ObradaMobilnaTarifa;
import hr.teleoperaterapp.model.FiksniTelefon;
import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.MobilnaTarifa;
import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.model.Tv;
import hr.teleoperaterapp.model.Internet;
import hr.teleoperaterapp.util.OperaterException;
import hr.teleoperaterapp.util.Pomocno;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrija
 */
public class ViewKorisnik extends javax.swing.JFrame {

    private final ObradaKorisnik obrada;
    
    /**
     * Creates new form ViewKorisnik
     */
    public ViewKorisnik() {
        initComponents();
        obrada=new ObradaKorisnik();
        ucitajMobilneTarife();
        ucitajMobilneUredaje();
        ucitajFiksniTelefon();
        ucitajTv();
        ucitajInternet();
        postInitComponents();
    }
    
    
    private void postInitComponents() {
        setTitle("Korisnik - " + Pomocno.LOGIRAN.getPrezime());
        ucitaj();
       
    }
    
     private void ucitaj() {
        DefaultListModel<Korisnik> k = new DefaultListModel<>();
        obrada.getPodaci(txtUvjet.getText().trim()).forEach(s -> k.addElement(s));
        lstPodaci.setModel(k);
    }
    
    
     
     private void ucitajMobilneUredaje() {
         
        DefaultComboBoxModel<MobilniUredaj> m = new DefaultComboBoxModel<>();
        new ObradaMobilniUredaj().getPodaci().forEach(p->m.addElement(p));
        cmbMobilniUredaj.setModel(m);
        
    }
     
     
     private void ucitajMobilneTarife() {
        DefaultComboBoxModel<MobilnaTarifa> m = new DefaultComboBoxModel<>();
        new ObradaMobilnaTarifa().getPodaci().forEach(p->m.addElement(p));
        cmbMobilnaTarifa.setModel(m);
          
    }
     
    private void ucitajFiksniTelefon() {
        
        DefaultComboBoxModel<FiksniTelefon> m = new DefaultComboBoxModel<>();
        new ObradaFiksniTelefon().getPodaci().forEach(p->m.addElement(p));
        cmbFiksniTelefon.setModel(m);
       
    }

    private void ucitajTv() {
        
        DefaultComboBoxModel<Tv> m = new DefaultComboBoxModel<>();
        new ObradaTv().getPodaci().forEach(p->m.addElement(p));
        cmbTv.setModel(m);
 
    }

    private void ucitajInternet() {

        DefaultComboBoxModel<Internet> m = new DefaultComboBoxModel<>();
        new ObradaInternet().getPodaci().forEach(p->m.addElement(p));
        cmbInternet.setModel(m);
        
    }
     
     
      
        private void ucitajVrijednosti(){
          
          obrada.getEntitet().setIme(txtIme.getText());
          obrada.getEntitet().setPrezime(txtPrezime.getText());
          obrada.getEntitet().setOib(txtOib.getText());
          obrada.getEntitet().setMobilniuredaj(cmbMobilniUredaj.getModel()
          .getElementAt(cmbMobilniUredaj.getSelectedIndex()));
          obrada.getEntitet().setMobilnatarifa(cmbMobilnaTarifa.getModel()
          .getElementAt(cmbMobilnaTarifa.getSelectedIndex()));
          obrada.getEntitet().setFiksnitelefon(cmbFiksniTelefon.getModel()
          .getElementAt(cmbFiksniTelefon.getSelectedIndex()));
          obrada.getEntitet().setTv(cmbTv.getModel()
          .getElementAt(cmbTv.getSelectedIndex()));
          obrada.getEntitet().setInternet(cmbInternet.getModel()
          .getElementAt(cmbInternet.getSelectedIndex()));
          
          obrada.getEntitet().setTroskovi(Pomocno.getDecimalniBrojIzStringa(txtTroskovi.getText()));
          
         
      }
       
       private void postaviVrijednosti (){
           
           txtIme.setText(obrada.getEntitet().getIme());
           txtPrezime.setText(obrada.getEntitet().getPrezime());
           txtOib.setText(obrada.getEntitet().getOib());
           postaviMobilniUredaj();
           postaviMobilnuTarifu();
           postaviFiksniTelefon();
           postaviTv();
           PostaviInternet();
           IzracunajTrosak();
           
       }

           
       
       
       private void IzracunajTrosak() {
           
           List<BigDecimal> bigDecimalList= new ArrayList<>();
           
           bigDecimalList.add(((FiksniTelefon)cmbFiksniTelefon.getSelectedItem()).getCijena());
           bigDecimalList.add(((MobilnaTarifa)cmbMobilnaTarifa.getSelectedItem()).getCijena());
           bigDecimalList.add(((Tv)cmbTv.getSelectedItem()).getCijena());
           bigDecimalList.add(((Internet)cmbInternet.getSelectedItem()).getCijena());
           
           
           BigDecimal dodaj= new BigDecimal(0);
           for (BigDecimal value : bigDecimalList){
              dodaj= dodaj.add(new BigDecimal(value.floatValue()));
           }
           System.out.printf("%.2f",dodaj);
       txtTroskovi.setText(Pomocno.getFormatDecimalniBroj(dodaj));
       

    }
       
       
       
    private void postaviMobilniUredaj() {
        
         ComboBoxModel<MobilniUredaj> m = cmbMobilniUredaj.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getMobilniuredaj().getSifra())){
               cmbMobilniUredaj.setSelectedIndex(i);
                break;
            }
        }
      
    }

    private void postaviMobilnuTarifu() {
        ComboBoxModel<MobilnaTarifa> m = cmbMobilnaTarifa.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getMobilnatarifa().getSifra())){
               cmbMobilnaTarifa.setSelectedIndex(i);
                break;
            }
        }
    }

    private void postaviFiksniTelefon() {
        ComboBoxModel<FiksniTelefon> m = cmbFiksniTelefon.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getFiksnitelefon().getSifra())){
               cmbFiksniTelefon.setSelectedIndex(i);
                break;
            }
        } 
    }

    private void postaviTv() {
      ComboBoxModel<Tv> m = cmbTv.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getTv().getSifra())){
               cmbTv.setSelectedIndex(i);
                break;
            }
        }   
    }

    private void PostaviInternet() {
         ComboBoxModel<Internet> m = cmbInternet.getModel();
        for(int i=0;i<m.getSize();i++){
            if(m.getElementAt(i).getSifra().equals(
                    obrada.getEntitet().getInternet().getSifra())){
              cmbInternet.setSelectedIndex(i);
                break;
            }
        }
    }
       
       
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOib = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMobilnaTarifa = new javax.swing.JComboBox<>();
        cmbFiksniTelefon = new javax.swing.JComboBox<>();
        cmbTv = new javax.swing.JComboBox<>();
        cmbInternet = new javax.swing.JComboBox<>();
        btnTrazi = new javax.swing.JButton();
        txtUvjet = new javax.swing.JTextField();
        Troškovi = new javax.swing.JLabel();
        txtTroskovi = new javax.swing.JTextField();
        cmbMobilniUredaj = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtOib.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("OIB");

        jLabel4.setText("Mobilni Uređaj");

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel5.setText("Mobilna tarifa");

        jLabel6.setText("Fiksni telefon");

        jLabel7.setText("Tv");

        jLabel8.setText("Internet");

        cmbMobilnaTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMobilnaTarifaActionPerformed(evt);
            }
        });

        cmbFiksniTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiksniTelefonActionPerformed(evt);
            }
        });

        cmbTv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTvActionPerformed(evt);
            }
        });

        cmbInternet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInternetActionPerformed(evt);
            }
        });

        btnTrazi.setText("Traži");
        btnTrazi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        Troškovi.setText("Troškovi");

        txtTroskovi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTroskovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTroskoviActionPerformed(evt);
            }
        });

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnDodaj.setText("Dodaj");
        btnDodaj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(Troškovi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtOib, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbMobilniUredaj, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMobilnaTarifa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbFiksniTelefon, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbTv, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbInternet, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTroskovi, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPromjeni)
                            .addGap(18, 18, 18)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTrazi)
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbMobilniUredaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMobilnaTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbFiksniTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmbTv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbInternet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Troškovi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTroskovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPromjeni)
                                .addComponent(btnDodaj))))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed

         ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void txtTroskoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTroskoviActionPerformed
       
    }//GEN-LAST:event_txtTroskoviActionPerformed

    private void cmbMobilnaTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMobilnaTarifaActionPerformed
        IzracunajTrosak();
    }//GEN-LAST:event_cmbMobilnaTarifaActionPerformed

    private void cmbFiksniTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiksniTelefonActionPerformed
        IzracunajTrosak();
    }//GEN-LAST:event_cmbFiksniTelefonActionPerformed

    private void cmbTvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTvActionPerformed
        IzracunajTrosak();
    }//GEN-LAST:event_cmbTvActionPerformed

    private void cmbInternetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInternetActionPerformed
       IzracunajTrosak();
    }//GEN-LAST:event_cmbInternetActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());
        if (obrada.getEntitet() == null) {
            return;
        }
        postaviVrijednosti();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            obrada.setEntitet(new Korisnik());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (OperaterException op) {
            JOptionPane.showMessageDialog(null, op.getPoruka());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (OperaterException op) {
            JOptionPane.showMessageDialog(null, op.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (OperaterException op) {
            JOptionPane.showMessageDialog(null, op.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

  
    
    private String ocistiSuskavce(String s){
        return s.replace("š","s")
                .replace("đ", "d")
                .replace("ž", "z")
                .replace("ć", "c")
                .replace("č", "c");
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Troškovi;
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<FiksniTelefon> cmbFiksniTelefon;
    private javax.swing.JComboBox<Internet> cmbInternet;
    private javax.swing.JComboBox<MobilnaTarifa> cmbMobilnaTarifa;
    private javax.swing.JComboBox<MobilniUredaj> cmbMobilniUredaj;
    private javax.swing.JComboBox<Tv> cmbTv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Korisnik> lstPodaci;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTroskovi;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    



    

    

    
}
