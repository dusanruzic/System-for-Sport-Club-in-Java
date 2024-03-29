/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Tim;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logika.Controler;
import modeli.ModelTabeleIgraci;
import modeli.ModelTabeleTimovi;
import domen.IGeneralEntity;
import domen.Sport;
import domen.Trener;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duler
 */
public class PretraziTimoveMenadzerForma extends javax.swing.JDialog {

    /**
     * Creates new form PretraziTimoveMenadzerForma
     */
    public PretraziTimoveMenadzerForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        
        
        popuniKomboTreneri();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimovi = new javax.swing.JTable();
        btnDetalji = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbTreneri = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Spisak timova"));

        tblTimovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTimovi);

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetalji)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Trener:");

        cmbTreneri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTreneri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTreneriItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addComponent(cmbTreneri, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTreneri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int row = tblTimovi.getSelectedRow();
        if(row>-1){
            ModelTabeleTimovi mtt = (ModelTabeleTimovi) tblTimovi.getModel();
            Tim tim = mtt.getTim(row);
            JDialog atmf = new AzurirajTimMenadzerForma(null, true, tim);
            JOptionPane.showMessageDialog(this, "Odabrani tim ima ID " + tim.getSifraTima());
            if (tim.getSifraTima() < 0){
                JOptionPane.showMessageDialog(this, "Tim nije pronadjen");
                dispose();
            }
            else {
                atmf.setVisible(true);
            }
            
            
        }
        else {
            JOptionPane.showMessageDialog(this, "Morate izabrati neki tim da biste ga azurirali!");
        }
    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void cmbTreneriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTreneriItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED ) {
            System.out.println(evt.getSource());
            popuniTabeluPodUslovom();
        }
        
        
    }//GEN-LAST:event_cmbTreneriItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PretraziTimoveMenadzerForma dialog = new PretraziTimoveMenadzerForma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JComboBox cmbTreneri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTimovi;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        ArrayList<Tim> listaTimova = new ArrayList<>();
        try {
            listaTimova = Controler.getInstanca().vratiSveTimove();
        } catch (Exception ex) {
            Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ModelTabeleTimovi mtt = new ModelTabeleTimovi(listaTimova);
        tblTimovi.setModel(mtt);
    }
    
    private void popuniTabeluPodUslovom() {
        ArrayList<Tim> listaTimova = new ArrayList<>();
        try {
            listaTimova = Controler.getInstanca().vratiTimoveTrenera((Trener) cmbTreneri.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(PretraziTimoveMenadzerForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ModelTabeleTimovi mtt = new ModelTabeleTimovi(listaTimova);
        tblTimovi.setModel(mtt);
        if(listaTimova.size() == 0) {
            JOptionPane.showMessageDialog(this, "Sistem nije pronasao timove po zadatoj vrednosti  ");
        }
        else {
            JOptionPane.showMessageDialog(this, "Sistem je pronasao timove po zadatoj vrednosti  ");
        }
    }

    private void popuniKomboTreneri() {
        
            ArrayList<Trener> listaTrenera = new ArrayList<>();
            cmbTreneri.removeAllItems();
            
            try {
                listaTrenera = Controler.getInstanca().vratiSveTrenere();
            } catch (Exception ex) {
                Logger.getLogger(KreirajNoviTimMenadzerForma.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Trener trener : listaTrenera) {
                cmbTreneri.addItem(trener);
                
            }
        

    }
}
