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
import java.util.ArrayList;
/**
 *
 * @author cl
 */
public class UppgifterOmPartner extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UppgifterOmPartner.class.getName());

    private final InfDB idb;
    private ArrayList<String> partnerlista;
    
    public UppgifterOmPartner(InfDB idb) {
        this.idb = idb;
        partnerlista = new ArrayList<>();
        initComponents();
        fyllcBoxPartner();
                
        
        
        
    }
    //en Hashmap skapas där alla är nycklar och deras info är värden. metoden tar en parameter namn
    // eftersom metoden kallas senare i koden. behövs för det.
    // PID sätts till falskt - alltså går ej att ändra
    private void hamtaUppgifterOmPartner(String namn)
    {
        try {
            HashMap<String, String> rader = idb.fetchRow("SELECT * FROM partner WHERE namn = '" + namn + "'");
            
            txtpID.setText(rader.get("pid"));
            txtNamn.setText(rader.get("namn"));
            txtKontaktperson.setText(rader.get("kontaktperson"));
            txtKontaktepost.setText(rader.get("kontaktepost"));
            txtTelefon.setText(rader.get("telefon"));
            txtAdress.setText(rader.get("adress"));
            txtBransch.setText(rader.get("branch"));
            txtStad.setText(rader.get("stad"));
            
            txtpID.setEditable(false);
            
        } catch (InfException e)
        {
            JOptionPane.showMessageDialog(this, "kunde ej hämta uppgifter", "Fel", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Metoden hämtar namn på alla partners som lagras i partnerlista. om partnerlistan inte är null 
    //skapas en combobox där alla namn radas upp.
    //omvandlar arraylist till en array då combobox kräver det.
    private void fyllcBoxPartner()
    {
        try {
            partnerlista = idb.fetchColumn("SELECT namn FROM partner");
            if (partnerlista != null)
                {
                cboxPartner.setModel(new javax.swing.DefaultComboBoxModel(partnerlista.toArray()));
                }
            }
            catch (InfException e)
                    {
                    System.out.println("Error: " + e);
                    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNamn = new javax.swing.JLabel();
        lblKontaktperson = new javax.swing.JLabel();
        lblKontaktepost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblBransch = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        txtKontaktperson = new javax.swing.JTextField();
        txtKontaktepost = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtBransch = new javax.swing.JTextField();
        txtStad = new javax.swing.JTextField();
        btnSparaÄndringar = new javax.swing.JButton();
        btnLäggTillNyPartner = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpID = new javax.swing.JTextField();
        btnSparaNyPartner = new javax.swing.JButton();
        btnTaBortPartner = new javax.swing.JButton();
        cboxPartner = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNamn.setText("Namn");

        lblKontaktperson.setText("Kontaktperson");

        lblKontaktepost.setText("KontaktEpost");

        lblTelefon.setText("Telefon");

        lblAdress.setText("Adress");

        lblBransch.setText("Bransch");

        lblStad.setText("Stad");

        btnSparaÄndringar.setText("Spara ändringar");
        btnSparaÄndringar.addActionListener(this::btnSparaÄndringarActionPerformed);

        btnLäggTillNyPartner.setText("Lägg till ny Partner");
        btnLäggTillNyPartner.addActionListener(this::btnLäggTillNyPartnerActionPerformed);

        jLabel1.setText("Partner ID");

        btnSparaNyPartner.setText("Spara ny Partner");
        btnSparaNyPartner.addActionListener(this::btnSparaNyPartnerActionPerformed);

        btnTaBortPartner.setText("Ta bort Partner");
        btnTaBortPartner.addActionListener(this::btnTaBortPartnerActionPerformed);

        cboxPartner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxPartner.addActionListener(this::cboxPartnerActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBransch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKontaktepost, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTaBortPartner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSparaNyPartner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLäggTillNyPartner, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnSparaÄndringar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStad))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKontaktepost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBransch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 432, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKontaktperson, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKontaktperson, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKontaktepost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKontaktepost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBransch)
                    .addComponent(txtBransch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStad)
                    .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(btnSparaÄndringar)
                .addGap(18, 18, 18)
                .addComponent(btnLäggTillNyPartner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSparaNyPartner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaBortPartner)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //metoden sparar ändringar som görs i textfälten.
    //kolumner är en array av JTextfields. loopar igenom alla textfält i kolumner och kollar ifall uppgifter har fyllts i korrekt
    // SQL frågan "frågar" databasen. namn blir = namnet som skrevs in i textrutan.
    //try satsen testar att uppdatera databasen 
    private void btnSparaÄndringarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaÄndringarActionPerformed
       
        JTextField[] kolumner = {
            txtNamn, txtKontaktperson, txtKontaktepost, txtTelefon, txtAdress, txtBransch, txtStad };
        
        for (JTextField textfält1 : kolumner) {
            if (textfält1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " Fyll i alla fält");
                return;
            }
        }
        
        String sqlFråga = "UPDATE partner SET "
                 + "namn = '" + txtNamn.getText() + "', "
                 + "kontaktperson = '" + txtKontaktperson.getText() + "', "
                 + "kontaktepost = '" + txtKontaktepost.getText() + "', "
                 + "telefon = '" + txtTelefon.getText() + "', "
                 + "adress = '" + txtAdress.getText() + "', "
                 + "branch = '" + txtBransch.getText() + "', "
                 + "stad = '" + txtStad.getText() + "' "
                 + "WHERE pid = " + txtpID.getText() + "'";
        
        try { 
                    
                   idb.update(sqlFråga);
                   
                   JOptionPane.showMessageDialog(this, "Uppgifterna har ändrats");
               } catch (InfException e) {
                   
                   JOptionPane.showMessageDialog(this, "Ett fel har inträffat");
               }
    }//GEN-LAST:event_btnSparaÄndringarActionPerformed

    //metoden har som uppgift att rensa textrutorna när man klickar på lägg till ny partner 
    // först skapar en array av alla textfält döpt till kolumner
    // loopar sedan igenom alla fält i listan kolumner och säger "ta bort all text".
    // pid sätts här till redigerbart.
    
    private void btnLäggTillNyPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLäggTillNyPartnerActionPerformed
        JTextField[] kolumner = {
            txtNamn, txtKontaktperson, txtKontaktepost, txtTelefon, txtAdress, txtBransch, txtStad  };
        
        for (JTextField fält : kolumner)
        {
            fält.setText("");
        }
        
        txtpID.setEditable(true);
        
    }//GEN-LAST:event_btnLäggTillNyPartnerActionPerformed

    //samma princip som tidigare metoder. skapar en array, går igenom alla textfält i arrayen.
    // sql frågan skickar till databasen "testa uppdatera dom här fälten, till det användaren skriver in i textfälten.
    // try satsen testar att uppdatera databasen och sedan fyller comboboxen med en till partner
    private void btnSparaNyPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaNyPartnerActionPerformed
       JTextField[] kolumner = {
            txtpID, txtNamn, txtKontaktperson, txtKontaktepost, txtTelefon, txtAdress, txtBransch, txtStad  };
        
        for (JTextField fält : kolumner) {
            if (fält.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " Fyll i alla fält");
                return;
            }
        }    
        
        String fråga = "INSERT INTO partner(pid, namn, kontaktperson, kontaktepost, telefon, adress, branch, stad) VALUES ('"
                 + txtpID.getText() + "', '"
                 + txtNamn.getText() + "', '"
                 + txtKontaktperson.getText() + "', '"
                 + txtKontaktepost.getText() + "', '"
                 + txtTelefon.getText() + "', '"
                 + txtAdress.getText() + "', '"
                 + txtBransch.getText() + "','"
                 + txtStad.getText() + "')";
        
        try 
        {
            
            idb.insert(fråga);
            JOptionPane.showMessageDialog(this, "Lyckat");
            fyllcBoxPartner();
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "misslyckat " + e.getMessage());
        }
    
    
   
    

    }//GEN-LAST:event_btnSparaNyPartnerActionPerformed

    // namnPaPartner = det selected item man hämtar från comboboxen.
    // det man hämtar kläs i en sträng eftersom, det hämtas som ett objekt.
    // funkar inte. felmeddelande.
    //kallar på metoden hamtaUppgifterOmPartner med samma partner som man klickr på i comboboxen.
    private void cboxPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPartnerActionPerformed
        String namnPaPartner = (String) cboxPartner.getSelectedItem();
         if(namnPaPartner != null){ 
             hamtaUppgifterOmPartner(namnPaPartner);
         }
    }//GEN-LAST:event_cboxPartnerActionPerformed

    //samma som ovan det hämtade objektet blir en sträng för att vara kompatibelt 
    //tar bort det valda namnet från databasen.
    private void btnTaBortPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortPartnerActionPerformed
        try
        {
            String namnPaPartner = (String) cboxPartner.getSelectedItem();
            idb.delete("DELETE FROM partner WHERE namn = '" + namnPaPartner + "'");
        }
        catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Användaren kunde inte tas bort" + e.getMessage());
        }
    }//GEN-LAST:event_btnTaBortPartnerActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLäggTillNyPartner;
    private javax.swing.JButton btnSparaNyPartner;
    private javax.swing.JButton btnSparaÄndringar;
    private javax.swing.JButton btnTaBortPartner;
    private javax.swing.JComboBox<String> cboxPartner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBransch;
    private javax.swing.JLabel lblKontaktepost;
    private javax.swing.JLabel lblKontaktperson;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBransch;
    private javax.swing.JTextField txtKontaktepost;
    private javax.swing.JTextField txtKontaktperson;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtStad;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtpID;
    // End of variables declaration//GEN-END:variables
}
