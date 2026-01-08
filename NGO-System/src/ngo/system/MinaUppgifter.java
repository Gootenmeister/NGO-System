/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo.system;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author calle
 */
public class MinaUppgifter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MinaUppgifter.class.getName());
    
    private final InfDB idb;
    private final String aid;
    
    public MinaUppgifter(InfDB idb, String aid) 
    {
        this.aid = aid;
        this.idb = idb;
        initComponents();
        hamtaMinaUppgifter();
        txtAnstallningsdatum.setEditable(false);
        txtAvdelning.setEditable(false);
    }
    // kör sql frågan och hämtar "kolumnnamnen" som nycklar i en hashmap (rader) och datan som värde.
    // visar den hämtade infon i Jtable.
    private void hamtaMinaUppgifter()
    {
        try {
            String sql = "SELECT aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning FROM anstalld "
                    + "WHERE aid = " + aid;
            
            HashMap<String, String> rader = idb.fetchRow(sql);
            
            txtNamn.setText(rader.get("fornamn"));
            txtENamn.setText(rader.get("efternamn"));
            txtAdress.setText(rader.get("adress"));
            txtEpost.setText(rader.get("epost"));
            txtTelefon.setText(rader.get("telefon"));
            txtAnstallningsdatum.setText(rader.get("anstallningsdatum"));
            txtLosenord.setText(rader.get("losenord"));
            txtAvdelning.setText(rader.get("avdelning"));
            
            } catch (InfException e)
            { 
                JOptionPane.showMessageDialog(this, "Kunde ej hämta uppgifter", "Fel", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNamn = new javax.swing.JTextField();
        txtENamn = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtLosenord = new javax.swing.JTextField();
        txtAvdelning = new javax.swing.JTextField();
        lblFornamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        lblAvdelning = new javax.swing.JLabel();
        lblAnstallningsdatum = new javax.swing.JLabel();
        btnSpara = new javax.swing.JButton();
        txtEpost = new javax.swing.JTextField();
        txtAnstallningsdatum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFornamn.setText("Förnamn:");

        lblEfternamn.setText("Efternamn:");

        lblEpost.setText("Epost:");

        lblTelefon.setText("Telefon:");

        lblAdress.setText("Adress:");

        lblLosenord.setText("Lösenord:");

        lblAvdelning.setText("Avdelning:");

        lblAnstallningsdatum.setText("Anställningsdatum:");

        btnSpara.setText("Spara Ändringar");
        btnSpara.addActionListener(this::btnSparaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFornamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEfternamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEpost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAvdelning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnstallningsdatum, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAvdelning, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtLosenord)
                            .addComponent(txtTelefon)
                            .addComponent(txtAdress)
                            .addComponent(txtENamn)
                            .addComponent(txtNamn)))
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(671, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFornamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtENamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEfternamn))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEpost)
                        .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLosenord))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvdelning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnstallningsdatum)
                    .addComponent(txtAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSpara)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //körs när man sparar ändringar.
    //skapar en array av JTextField object. txtnamn, txtEnamn osv.
    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        javax.swing.JTextField[] textfält = {
            txtNamn, txtENamn, txtEpost, txtAdress, txtLosenord };
        
        // kontrollerar att man inte lämnar något tomt.
        for (JTextField textfält1 : textfält) {
            if (textfält1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " Fyll i alla fält");
                return;
            }
        }
        // SQl frågan uppdaterar en rad ur anstalld.
        // via set. ex "fornamn" till txtNamn.getText(), alltså den inskrivda texten.
        // hämtar alltså värdena om skrivs in  GUI 
        String sql = "UPDATE anstalld SET " 
                + "fornamn = '" + txtNamn.getText() + "', "
                + "efternamn = '" + txtENamn.getText() + "', "
                + "epost = '" + txtEpost.getText() + "', "
                + "adress = '" + txtAdress.getText() + "', "
                + "losenord = '" + txtLosenord.getText() + "' "
                + "WHERE aid = " + aid;
              
               try { 
                   idb.update(sql);
                   JOptionPane.showMessageDialog(this, "Uppgifterna har ändrats");
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(this, "Ett fel har inträffat");
               }
    
            
    }//GEN-LAST:event_btnSparaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAnstallningsdatum;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtAnstallningsdatum;
    private javax.swing.JTextField txtAvdelning;
    private javax.swing.JTextField txtENamn;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtLosenord;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
