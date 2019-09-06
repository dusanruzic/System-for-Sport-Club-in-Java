/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Igrac;
import domen.StatistikaIgracaSaUtakmice;
import domen.Tim;
import domen.Utakmica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import logika.Controler;
import modeli.ModelTabeleIgraci;
import modeli.ModelTabeleStatistika;
import sesija.Session;
import domen.IGeneralEntity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duler
 */
public class EvidentirajStatistikuTrenerForma extends javax.swing.JDialog {

    /**
     * Creates new form EvidentirajStatistikuTrenerForma
     */
    public EvidentirajStatistikuTrenerForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        btnSacuvajStatistikuSvihIgraca.setEnabled(false);
        popuniKomboTimova();
        popuniKomboUtakmica();

        popuniTabeluIgraca();
        srediTabeluStatistika();
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
        cmbTim = new javax.swing.JComboBox();
        cmbUtakmica = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIgrac = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBrojSuteva = new javax.swing.JTextField();
        txtBrojGolova = new javax.swing.JTextField();
        txtBrojZutihKartona = new javax.swing.JTextField();
        txtOcena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStatistika = new javax.swing.JTable();
        btnIzbrisi = new javax.swing.JButton();
        btnSacuvajStatistikuSvihIgraca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Evidentiraj statistiku"));

        cmbTim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTimItemStateChanged(evt);
            }
        });

        cmbUtakmica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tim:");

        jLabel2.setText("Utakmica:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Kreiraj statistiku igraca"));

        tblIgrac.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblIgrac);

        jLabel4.setText("Broj golova:");

        jLabel3.setText("Broj suteva:");

        jLabel6.setText("Ocena:");

        jLabel5.setText("Broj zutih kartona:");

        btnDodaj.setText("Dodaj statistiku igraca");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBrojZutihKartona)
                            .addComponent(txtOcena)
                            .addComponent(txtBrojGolova)
                            .addComponent(txtBrojSuteva, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrojSuteva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBrojGolova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBrojZutihKartona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Spisak napravljenih statistika"));

        tblStatistika.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblStatistika);

        btnIzbrisi.setText("Izbrisi statistiku");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnSacuvajStatistikuSvihIgraca.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSacuvajStatistikuSvihIgraca.setText("Sacuvaj statistiku svih igraca");
        btnSacuvajStatistikuSvihIgraca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajStatistikuSvihIgracaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzbrisi))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnSacuvajStatistikuSvihIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvajStatistikuSvihIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmbUtakmica, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbTim, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(942, 942, 942))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUtakmica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTimItemStateChanged
        popuniKomboUtakmica();
        popuniTabeluIgraca();
    }//GEN-LAST:event_cmbTimItemStateChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        ModelTabeleIgraci mti = (ModelTabeleIgraci) tblIgrac.getModel();
        ModelTabeleStatistika mts = (ModelTabeleStatistika) tblStatistika.getModel();
        int rowIndex = tblIgrac.getSelectedRow();
        try {
            if (rowIndex >= 0) {

                if (Integer.parseInt(txtBrojGolova.getText()) > 0 && Integer.parseInt(txtBrojSuteva.getText()) > 0 && Integer.parseInt(txtBrojZutihKartona.getText()) > 0 && Integer.parseInt(txtOcena.getText()) > 0) {
                    if(Integer.parseInt(txtOcena.getText()) <5 || Integer.parseInt(txtOcena.getText()) >10 ){
                        JOptionPane.showMessageDialog(this, "Ocena mora biti u opsegu [5,10]", "Greska", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(Integer.parseInt(txtBrojZutihKartona.getText()) > 2){
                        JOptionPane.showMessageDialog(this, "Igrac najvise moze da dobije 2 zuta kartona na utakmici!","Greska", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    
                    Tim tim = (Tim) cmbTim.getSelectedItem();
                    Utakmica utakmica = (Utakmica) cmbUtakmica.getSelectedItem();
                    Igrac igrac = mti.getIgrac(rowIndex);
                    int brojSuteva = Integer.parseInt(txtBrojSuteva.getText());
                    int brojGolova = Integer.parseInt(txtBrojGolova.getText());
                    int brojZutihKartona = Integer.parseInt(txtBrojZutihKartona.getText());
                    int ocena = Integer.parseInt(txtOcena.getText());

                    StatistikaIgracaSaUtakmice statistikaIgraca = new StatistikaIgracaSaUtakmice(utakmica, igrac, brojSuteva, brojGolova, brojZutihKartona, ocena);

                    for (StatistikaIgracaSaUtakmice stat : mts.vratiStatistikaIgracaSaUtakmices()) {

                        if (stat.getIgrac().getSifraIgraca() == igrac.getSifraIgraca()) {
                            JOptionPane.showMessageDialog(this, "Malopre ste kreirali statistiku za datog igraca!", "Greska", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    mts.dodajStatistiku(statistikaIgraca);
                    if (mts.vratiStatistikaIgracaSaUtakmices().size() > 0) {
                        btnSacuvajStatistikuSvihIgraca.setEnabled(true);
                    }

                    txtBrojGolova.setText("");
                    txtBrojSuteva.setText("");
                    txtBrojZutihKartona.setText("");
                    txtOcena.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(this, "Unesi lepo statistiku za izabranog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Igrac nije selektovan!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unesi lepo statistiku za izabranog igraca", "Greska", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        ModelTabeleStatistika mts = (ModelTabeleStatistika) tblStatistika.getModel();
        int red = tblStatistika.getSelectedRow();
        if (red > -1) {
            mts.izbrisiStatistiku(red);
            if (mts.vratiStatistikaIgracaSaUtakmices().size() == 0) {
                btnSacuvajStatistikuSvihIgraca.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Morate selektovati nekog igraca", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnSacuvajStatistikuSvihIgracaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajStatistikuSvihIgracaActionPerformed
        ModelTabeleStatistika mts = (ModelTabeleStatistika) tblStatistika.getModel();
        ArrayList<StatistikaIgracaSaUtakmice> listaStatistika = mts.vratiStatistikaIgracaSaUtakmices();
        boolean sacuvano = false;
        try {
            if (listaStatistika.size() > 0) {
                sacuvano = Controler.getInstanca().zapamtiStatistike(listaStatistika);

            }

        } catch (Exception ex) {
            Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (sacuvano) {
            JOptionPane.showMessageDialog(this, "Statistike sa utakmice je evidentirana");
            mts.isprazniModelStatistika();

        } else {
            JOptionPane.showMessageDialog(this, "Statistika sa utakmice nije evidentirana!");
        }

    }//GEN-LAST:event_btnSacuvajStatistikuSvihIgracaActionPerformed

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
            java.util.logging.Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EvidentirajStatistikuTrenerForma dialog = new EvidentirajStatistikuTrenerForma(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnSacuvajStatistikuSvihIgraca;
    private javax.swing.JComboBox cmbTim;
    private javax.swing.JComboBox cmbUtakmica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblIgrac;
    private javax.swing.JTable tblStatistika;
    private javax.swing.JTextField txtBrojGolova;
    private javax.swing.JTextField txtBrojSuteva;
    private javax.swing.JTextField txtBrojZutihKartona;
    private javax.swing.JTextField txtOcena;
    // End of variables declaration//GEN-END:variables

    private void popuniKomboTimova() {
        ArrayList<Tim> listaTimova = new ArrayList<>();
        cmbTim.removeAllItems();

        try {
            listaTimova = Controler.getInstanca().vratiTimoveTrenera(Session.getInstance().getTrener());
        } catch (Exception ex) {
            Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (IGeneralEntity ekipa : listaTimova) {
            cmbTim.addItem(ekipa);
        }
    }

    private void popuniKomboUtakmica() {
        Tim tim = (Tim) cmbTim.getSelectedItem();
        if (tim != null) {
            ArrayList<Utakmica> listaUtakmica = new ArrayList<>();
            cmbUtakmica.removeAllItems();
            Utakmica utakmica = new Utakmica();
            utakmica.setTim((Tim) cmbTim.getSelectedItem());
            System.out.println(utakmica);
            try {
                listaUtakmica = Controler.getInstanca().vratiUtakmiceTima(tim);
            } catch (Exception ex) {
                Logger.getLogger(EvidentirajStatistikuTrenerForma.class.getName()).log(Level.SEVERE, null, ex);
            }

            //System.out.println(listaUtakmica.size());
            for (IGeneralEntity ut : listaUtakmica) {
                cmbUtakmica.addItem(ut);
                //System.out.println(ut);

            }
        }
    }

    private void popuniTabeluIgraca() {
        Tim tim = (Tim) cmbTim.getSelectedItem();
        if (tim != null) {
            try {
                Igrac igrac = new Igrac();
                igrac.setTim((Tim) cmbTim.getSelectedItem());
                ArrayList<Igrac> igraci = Controler.getInstanca().pronadjiIgrace(igrac);
                System.out.println(igraci.size());
                ModelTabeleIgraci model = new ModelTabeleIgraci((ArrayList<Igrac>) igraci);
                tblIgrac.setModel(model);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void srediTabeluStatistika() {
        ModelTabeleStatistika mts = new ModelTabeleStatistika();
        tblStatistika.setModel(mts);
    }
}