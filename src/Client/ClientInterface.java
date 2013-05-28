/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;
import HESServer.RmiServerInterface;
import HesClient.Dispatcher;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sk
 */
public class ClientInterface extends javax.swing.JFrame {

    private Dispatcher dispatcher;
    private RmiServerInterface onlineServer;

    /**
     * Creates new form ClientInterface
     */
    public ClientInterface() {
        initComponents();
        this.dispatcher = new Dispatcher(LabelAlpha, LabelBeta);
        this.dispatcher.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelKunden = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblKunde = new javax.swing.JTable();
        EdtSucheKDNR = new javax.swing.JTextField();
        BtnSucheKunde = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EdtSucheVorname = new javax.swing.JTextField();
        EdtSucheNachname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EdtSucheTelNr = new javax.swing.JTextField();
        BtnErstelleKunde = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        EdtSucheVorwahl = new javax.swing.JTextField();
        jPanelProdukte = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        EdtSucheProduktName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProdukt = new javax.swing.JTable();
        BtnSucheProdukt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        EdtSucheProduktNr = new javax.swing.JTextField();
        BtnErstelleProdukt = new javax.swing.JButton();
        jPanelMonitor = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelAlpha = new javax.swing.JLabel();
        LabelBeta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblKunde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "KundenNr", "Vorname", "Nachname", "Adresse", "TelefonNr"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblKunde.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TblKunde);

        BtnSucheKunde.setText("suchen");
        BtnSucheKunde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSucheKundeMouseClicked(evt);
            }
        });

        jLabel1.setText("KundenNr.:");

        jLabel2.setText("Vorname:");

        jLabel3.setText("Nachname:");

        jLabel4.setText("TelefonNr.:");

        BtnErstelleKunde.setText("erstelle Kunde");
        BtnErstelleKunde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnErstelleKundeMouseClicked(evt);
            }
        });

        jLabel5.setText("Vorwahl:");

        javax.swing.GroupLayout jPanelKundenLayout = new javax.swing.GroupLayout(jPanelKunden);
        jPanelKunden.setLayout(jPanelKundenLayout);
        jPanelKundenLayout.setHorizontalGroup(
            jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKundenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanelKundenLayout.createSequentialGroup()
                        .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelKundenLayout.createSequentialGroup()
                                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKundenLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanelKundenLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(19, 19, 19)))
                                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EdtSucheKDNR, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(EdtSucheVorname)))
                            .addGroup(jPanelKundenLayout.createSequentialGroup()
                                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelKundenLayout.createSequentialGroup()
                                        .addComponent(EdtSucheVorwahl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EdtSucheTelNr, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(EdtSucheNachname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnSucheKunde)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKundenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnErstelleKunde)))
                .addContainerGap())
        );
        jPanelKundenLayout.setVerticalGroup(
            jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKundenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EdtSucheKDNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15)
                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EdtSucheVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EdtSucheNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKundenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelKundenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(EdtSucheTelNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnSucheKunde)
                            .addComponent(EdtSucheVorwahl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelKundenLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnErstelleKunde)
                        .addGap(43, 43, 43))))
        );

        jTabbedPane1.addTab("Kunden", jPanelKunden);

        jLabel6.setText("Name:");

        TblProdukt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ProduktNr.:", "Name", "Preis", "reserviert?", "LagerBestand"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblProdukt);
        TblProdukt.getColumnModel().getColumn(0).setResizable(false);
        TblProdukt.getColumnModel().getColumn(1).setResizable(false);
        TblProdukt.getColumnModel().getColumn(2).setResizable(false);
        TblProdukt.getColumnModel().getColumn(3).setResizable(false);
        TblProdukt.getColumnModel().getColumn(4).setResizable(false);

        BtnSucheProdukt.setText("suchen");
        BtnSucheProdukt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSucheProduktMouseClicked(evt);
            }
        });

        jLabel7.setText("ProduktNr.:");

        BtnErstelleProdukt.setText("erstelle Produkt");

        javax.swing.GroupLayout jPanelProdukteLayout = new javax.swing.GroupLayout(jPanelProdukte);
        jPanelProdukte.setLayout(jPanelProdukteLayout);
        jPanelProdukteLayout.setHorizontalGroup(
            jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdukteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanelProdukteLayout.createSequentialGroup()
                        .addGroup(jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EdtSucheProduktNr, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(EdtSucheProduktName))
                        .addGap(18, 18, 18)
                        .addComponent(BtnSucheProdukt)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdukteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnErstelleProdukt)))
                .addContainerGap())
        );
        jPanelProdukteLayout.setVerticalGroup(
            jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdukteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(EdtSucheProduktNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelProdukteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(EdtSucheProduktName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSucheProdukt))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnErstelleProdukt)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produkte", jPanelProdukte);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Server Alpha:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Server Beta:");

        LabelAlpha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelAlpha.setForeground(new java.awt.Color(255, 0, 0));
        LabelAlpha.setText("Offline");
        LabelAlpha.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LabelAlpha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LabelAlphaPropertyChange(evt);
            }
        });

        LabelBeta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelBeta.setForeground(new java.awt.Color(255, 0, 0));
        LabelBeta.setText("Offline");
        LabelBeta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelMonitorLayout = new javax.swing.GroupLayout(jPanelMonitor);
        jPanelMonitor.setLayout(jPanelMonitorLayout);
        jPanelMonitorLayout.setHorizontalGroup(
            jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonitorLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(29, 29, 29)
                .addGroup(jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelBeta)
                    .addComponent(LabelAlpha))
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPanelMonitorLayout.setVerticalGroup(
            jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMonitorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(LabelAlpha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(LabelBeta))
                .addContainerGap(330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monitor", jPanelMonitor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSucheKundeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSucheKundeMouseClicked
        onlineServer = dispatcher.liefereServer();
        if (onlineServer == null) {
            JOptionPane.showMessageDialog(rootPane, "Keine Server Online!", "Error !", JOptionPane.ERROR_MESSAGE);

        } else {

            TblKunde.removeAll();
            String kdnr = EdtSucheKDNR.getText();
            String vorname = EdtSucheVorname.getText();
            String nachname = EdtSucheNachname.getText();
            String vorwahl = EdtSucheVorwahl.getText();
            String tel = EdtSucheTelNr.getText();
            try {
                int telNr = Integer.valueOf(tel);
                TelefonNrTyp telefonNR = new TelefonNrTyp(vorwahl, telNr);
                KundenTyp kunde = onlineServer.getKunde(telefonNR);

                TblKunde.getModel().setValueAt(kunde.getKundenNr(), 0, 0);
                TblKunde.getModel().setValueAt(kunde.getvorName(), 0, 1);
                TblKunde.getModel().setValueAt(kunde.getnachName(), 0, 2);
                TblKunde.getModel().setValueAt(kunde.getAdresse(), 0, 3);
                TblKunde.getModel().setValueAt(kunde.getTelNr(), 0, 4);


            } catch (RemoteException ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);

            } catch (KundeException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Kunde nicht gefunden", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Telefonnummer darf nicht leer sein!", "Telefonnummer", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(rootPane, "Kunde existiert nicht!", "Kunde", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BtnSucheKundeMouseClicked

    private void BtnErstelleKundeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnErstelleKundeMouseClicked
        KundeView kundenGUI = new KundeView(dispatcher);
        kundenGUI.setVisible(true);
        onlineServer = dispatcher.liefereServer();
    }//GEN-LAST:event_BtnErstelleKundeMouseClicked

    private void BtnSucheProduktMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSucheProduktMouseClicked

        TblProdukt.removeAll();
        String produktNr = EdtSucheProduktNr.getText();
        String produktName = EdtSucheProduktName.getText();

        //ProduktTyp produkt = verkaufFassade.ge(produktNr);


    }//GEN-LAST:event_BtnSucheProduktMouseClicked

    private void LabelAlphaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LabelAlphaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelAlphaPropertyChange

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
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnErstelleKunde;
    private javax.swing.JButton BtnErstelleProdukt;
    private javax.swing.JButton BtnSucheKunde;
    private javax.swing.JButton BtnSucheProdukt;
    private javax.swing.JTextField EdtSucheKDNR;
    private javax.swing.JTextField EdtSucheNachname;
    private javax.swing.JTextField EdtSucheProduktName;
    private javax.swing.JTextField EdtSucheProduktNr;
    private javax.swing.JTextField EdtSucheTelNr;
    private javax.swing.JTextField EdtSucheVorname;
    private javax.swing.JTextField EdtSucheVorwahl;
    public javax.swing.JLabel LabelAlpha;
    public javax.swing.JLabel LabelBeta;
    private javax.swing.JTable TblKunde;
    private javax.swing.JTable TblProdukt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelKunden;
    private javax.swing.JPanel jPanelMonitor;
    private javax.swing.JPanel jPanelProdukte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
