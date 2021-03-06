/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.teleoperaterapp.view;


import hr.teleoperaterapp.controller.ObradaKorisnik;
import hr.teleoperaterapp.controller.ObradaMobilniUredaj;
import hr.teleoperaterapp.model.Korisnik;
import hr.teleoperaterapp.model.MobilniUredaj;
import hr.teleoperaterapp.util.HibernateUtil;
import hr.teleoperaterapp.util.Pomocno;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Andrija
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    
    
    
    
    public Izbornik() {
        initComponents();
         setTitle(Pomocno.getNazivAplikacije());
        jmAplikacija.setText(Pomocno.getNazivAplikacije());
        
        Vrijeme v = new Vrijeme();
        v.start();
        
      nacrtajGraf();
    }

   
    
    private class Vrijeme extends Thread{

        SimpleDateFormat df = new SimpleDateFormat("dd. MM. yyyy. HH:mm:ss");
        
        @Override
        public void run() {
            try {
                lblVrijeme.setText(df.format(new Date()));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            run();
        }
        
    }
    
     private void nacrtajGraf(){
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for(MobilniUredaj m: new ObradaMobilniUredaj().getPodaci()){
            pieDataset.setValue(m.getNaziv(), m.getKorisnici().size());
        }
        JFreeChart chart = ChartFactory.createPieChart
                     ("Broj korisnika koji koriste uređaje",   
                      pieDataset,          
                      true,                   
                      true,                 
                      new Locale("hr","HR") 
                     );
        
        BufferedImage image = chart.createBufferedImage(
                (int)lblGraf.getSize().getWidth(),
                (int)lblGraf.getSize().getHeight());
        lblGraf.setIcon(new ImageIcon(image));
         }
    
   
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        lblGraf = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAplikacija = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jToolBar2.setBackground(new java.awt.Color(51, 153, 255));
        jToolBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar2.setForeground(new java.awt.Color(51, 153, 255));
        jToolBar2.setRollover(true);

        lblVrijeme.setBackground(new java.awt.Color(51, 153, 255));
        lblVrijeme.setText("Vrijeme");
        jToolBar2.add(lblVrijeme);

        jMenuBar1.setBackground(new java.awt.Color(51, 153, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jmAplikacija.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jmAplikacija.setText("Aplikacija");

        jMenuItem7.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem7.setText("Izlaz");
        jMenuItem7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmAplikacija.add(jMenuItem7);

        jMenuItem8.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem8.setText("Natrag");
        jMenuItem8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmAplikacija.add(jMenuItem8);

        jMenuBar1.add(jmAplikacija);

        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jMenu2.setText("Programi");

        jMenuItem1.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem1.setText("Korisnik");
        jMenuItem1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem2.setText("Mobilni uredaj");
        jMenuItem2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem3.setText("Mobilna tarifa");
        jMenuItem3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem4.setText("Fiksni telefon");
        jMenuItem4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem5.setText("Internet");
        jMenuItem5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setBackground(new java.awt.Color(51, 153, 255));
        jMenuItem6.setText("Tv");
        jMenuItem6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGraf, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 230, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 24, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       HibernateUtil.getSessionFactory().close();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         new ViewKorisnik().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ViewMobilniUredaj().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ViewMobilnaTarifa().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new ViewFiksniTelefon().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ViewInternet().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        new ViewTv().setVisible(true);   
 
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       
        dispose();
        new Autorizacija().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
  
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenu jmAplikacija;
    private javax.swing.JLabel lblGraf;
    private javax.swing.JLabel lblVrijeme;
    // End of variables declaration//GEN-END:variables
}
