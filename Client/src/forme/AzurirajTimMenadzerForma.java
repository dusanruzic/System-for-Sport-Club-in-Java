/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Tim;
import domen.Trener;
import java.util.ArrayList;
import logika.Controler;
import domen.IGeneralEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class AzurirajTimMenadzerForma extends javax.swing.JDialog {
    
    Tim tim;
    
    /**
     * Creates new form AzurirajTimMenadzerForma
     */
    public AzurirajTimMenadzerForma(java.awt.Frame parent, boolean modal, Tim tim) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.tim = tim;
        popuniKomboTrenera();
        srediFormu();
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
        jLabel1 = new javax.swing.JLabel();
        txtImeTima = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chkAktivan = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cmbTrener = new javax.swing.JComboBox();
        btnAzurirajTim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Azuriraj tim"));

        jLabel1.setText("Ime tima:");

        jLabel2.setText("Aktivan:");

        jLabel3.setText("Trener:");

        cmbTrener.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAzurirajTim.setText("Azuriraj tim");
        btnAzurirajTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtImeTima)
                    .addComponent(chkAktivan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTrener, 0, 187, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(btnAzurirajTim)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtImeTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chkAktivan))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTrener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnAzurirajTim)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAzurirajTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajTimActionPerformed
        boolean izmenjeno = false;
        if(!txtImeTima.getText().isEmpty()){
            try {
            tim.setNazivTima(txtImeTima.getText());
            tim.setDaLiJeAktivanTim(chkAktivan.isSelected());
            tim.setTrener((Trener) cmbTrener.getSelectedItem());
            izmenjeno = Controler.getInstanca().azurirajTim(tim);
            JOptionPane.showMessageDialog(this, "Tim je uspesno izmenjen!");
        } catch (Exception ex) {
            Logger.getLogger(AzurirajTimMenadzerForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Tim nije uspesno izmenjen!");
        }
        }
        
        else {
            JOptionPane.showMessageDialog(this, "Unesi naziv tima");
        }
        
    }//GEN-LAST:event_btnAzurirajTimActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzurirajTim;
    private javax.swing.JCheckBox chkAktivan;
    private javax.swing.JComboBox cmbTrener;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtImeTima;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        
        txtImeTima.setText(tim.getNazivTima());
        if(tim.getDaLiJeAktivanTim()){
            chkAktivan.setSelected(true);
        }
        else {
            chkAktivan.setSelected(false);
        }
        cmbTrener.setSelectedItem(tim.getTrener());
    }

    private void popuniKomboTrenera() {
        ArrayList<Trener> listaTrenera = new ArrayList<Trener>();
        cmbTrener.removeAllItems();
        try {
            listaTrenera = Controler.getInstanca().vratiTrenereSporta(tim.getTrener().getSport());
        } catch (Exception ex) {
            Logger.getLogger(AzurirajTimMenadzerForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Trener t : listaTrenera){
            cmbTrener.addItem(t);
            System.out.println(t);
        }
    }
}
