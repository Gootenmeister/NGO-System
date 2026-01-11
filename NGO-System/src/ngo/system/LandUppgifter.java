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
public class LandUppgifter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LandUppgifter.class.getName());
    
    private final InfDB idb;
    private ArrayList<String> landLista;
    
    
    public LandUppgifter(InfDB idb) 
    {
        this.idb = idb;
        landLista = new ArrayList<>();
        initComponents();
        fyllcBoxLander();
        
    }
    
    // kör sql frågan och hämtar "kolumnnamnen" som nycklar i en hashmap (rader) och datan som värde.
    // alltså rader = nyckel: namn && värde: ex Sverige.
    // txtNamn, txtSprak osv är variabelnamn för JTextfield. 
    // fetchrow returnerar värdet i kolumnerna som strängar. spelar alltså ingen roll här, att valuta är en decimal i databasen.
    private void hamtaLandUppgifter(String namn)
    {
        try {
              HashMap<String, String> rader = idb.fetchRow("SELECT * FROM land WHERE namn = '" + namn + "'");
              txtLandID.setText(rader.get("lid"));
              txtNamn.setText(rader.get("namn"));
              txtSprak.setText(rader.get("sprak"));
              txtValuta.setText(rader.get("valuta"));
              txtTidszon.setText(rader.get("tidszon"));
              txtPolitiskStruktur.setText(rader.get("politisk_struktur"));
              txtEkonomi.setText(rader.get("ekonomi"));
              
              txtLandID.setEditable(false);
            } catch (InfException e) 
            {
                JOptionPane.showMessageDialog(this, "kunde ej hämta uppgifter", "Fel", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    private void fyllcBoxLander()
    {
        try {
             landLista = idb.fetchColumn("SELECT namn FROM land");
             if (landLista != null)
             {
                 cBoxLander.setModel(new javax.swing.DefaultComboBoxModel(landLista.toArray()));
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

        txtSprak = new javax.swing.JTextField();
        txtValuta = new javax.swing.JTextField();
        txtTidszon = new javax.swing.JTextField();
        txtPolitiskStruktur = new javax.swing.JTextField();
        txtEkonomi = new javax.swing.JTextField();
        sparaÄndringar = new javax.swing.JButton();
        lblNamn = new javax.swing.JLabel();
        lblSpråk = new javax.swing.JLabel();
        lblValuta = new javax.swing.JLabel();
        lblTidszon = new javax.swing.JLabel();
        lblPolitiskStruktur = new javax.swing.JLabel();
        lblEkonomi = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        nyttLand = new javax.swing.JButton();
        btnSparaNyttLand = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLandID = new javax.swing.JTextField();
        cBoxLander = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sparaÄndringar.setText("Spara ändringar");
        sparaÄndringar.addActionListener(this::sparaÄndringarActionPerformed);

        lblNamn.setText("Namn");

        lblSpråk.setText("Språk");

        lblValuta.setText("Valuta");

        lblTidszon.setText("Tidszon");

        lblPolitiskStruktur.setText("Politisk struktur");

        lblEkonomi.setText("Ekonomi");

        nyttLand.setText("Lägg till land");
        nyttLand.addActionListener(this::nyttLandActionPerformed);

        btnSparaNyttLand.setText("Spara Nytt Land");
        btnSparaNyttLand.addActionListener(this::btnSparaNyttLandActionPerformed);

        jLabel1.setText("Land ID:");

        cBoxLander.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxLander.addActionListener(this::cBoxLanderActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSpråk, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValuta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPolitiskStruktur, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEkonomi, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnSparaNyttLand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nyttLand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sparaÄndringar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPolitiskStruktur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtTidszon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtValuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtSprak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLandID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(cBoxLander, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(576, 576, 576))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cBoxLander, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLandID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpråk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTidszon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolitiskStruktur)
                    .addComponent(txtPolitiskStruktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEkonomi)
                    .addComponent(txtEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(sparaÄndringar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nyttLand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSparaNyttLand)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void sparaÄndringarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaÄndringarActionPerformed
        //här skapas en array med alla täxtfält som användaren ska fylla i.
        JTextField[] textfält = {
            txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi};
        
        //for each loopen har som syfe att gå igneom alla "täxtfält" i arrayen täxtfält och se om något lämnats tomt. 
        //om något lämnats tomt returneras ett felmeddelane "fyll i alla fält" 
         for (JTextField textfält1 : textfält) {
            if (textfält1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " Fyll i alla fält");
                return;
            }
        }
         //Sgl frågan uppdaterar all info som användaren har skrivit in i täxtfälten genom getText().
         // texten använderen skrev in blir det nya texten.
         String sqlFråga = "UPDATE land SET "
                 + "namn = '" + txtNamn.getText() + "', "
                 + "sprak = '" + txtSprak.getText() + "', "
                 + "valuta = " + txtValuta.getText() + ", "
                 + "tidszon = '" + txtTidszon.getText() + "', "
                 + "politisk_struktur = '" + txtPolitiskStruktur.getText() + "', "
                 + "ekonomi = '" + txtEkonomi.getText() + "' "
                 + "WHERE lid = " + txtLandID.getText();
         
                try { 
                    // uppdateringen körs 
                   idb.update(sqlFråga);
                   //funkar det returneras "uppgifterna har ändrats"
                   JOptionPane.showMessageDialog(this, "Uppgifterna har ändrats");
               } catch (InfException e) {
                   //funkar det ej returneras "ett fel har inträffat"
                   JOptionPane.showMessageDialog(this, "Ett fel har inträffat");
               }
                
                
                
                
                
                
                
                
    }//GEN-LAST:event_sparaÄndringarActionPerformed
     //Koden är näst intill identisk till när man sparar ändringar, med skillnaden att täxtfältena lämnas tomma 
    // och att sql frågan använder sig av en INSERT istället för UPDATE 
    //man uppdaterar alltså inte databasen utan man skapar ett nytt land till databasen.
    private void nyttLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nyttLandActionPerformed
        JTextField[] textfält = {
            txtLandID, txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi  };
        
        for (JTextField fält : textfält)
        {
            fält.setText("");
        }
        
        txtLandID.setEditable(true);
    }//GEN-LAST:event_nyttLandActionPerformed

    private void btnSparaNyttLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaNyttLandActionPerformed
        
        JTextField[] textfält = {
            txtLandID, txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi  };
        
        for (JTextField fält : textfält) {
            if (fält.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " Fyll i alla fält");
                return;
            }
        }    
        
        String fråga = "INSERT INTO land(lid, namn, sprak, valuta, tidszon, politisk_struktur, ekonomi) VALUES ('"
                 + txtLandID.getText() + "', '"
                 + txtNamn.getText() + "', '"
                 + txtSprak.getText() + "', '"
                 + txtValuta.getText() + "', '"
                 + txtTidszon.getText() + "', '"
                 + txtPolitiskStruktur.getText() + "', '"
                 + txtEkonomi.getText() + "')";
            
        
        
        try 
        {
            System.out.println();
            idb.insert(fråga);
            JOptionPane.showMessageDialog(this, "Lyckat");
            fyllcBoxLander();
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "misslyckat " + e.getMessage());
        }
      
    }//GEN-LAST:event_btnSparaNyttLandActionPerformed

    private void cBoxLanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxLanderActionPerformed
        String namnPaLand = (String) cBoxLander.getSelectedItem();
        if (namnPaLand != null) 
        {
            hamtaLandUppgifter(namnPaLand);
        }
    }//GEN-LAST:event_cBoxLanderActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSparaNyttLand;
    private javax.swing.JComboBox<String> cBoxLander;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEkonomi;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPolitiskStruktur;
    private javax.swing.JLabel lblSpråk;
    private javax.swing.JLabel lblTidszon;
    private javax.swing.JLabel lblValuta;
    private javax.swing.JButton nyttLand;
    private javax.swing.JButton sparaÄndringar;
    private javax.swing.JTextField txtEkonomi;
    private javax.swing.JTextField txtLandID;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtPolitiskStruktur;
    private javax.swing.JTextField txtSprak;
    private javax.swing.JTextField txtTidszon;
    private javax.swing.JTextField txtValuta;
    // End of variables declaration//GEN-END:variables
}
