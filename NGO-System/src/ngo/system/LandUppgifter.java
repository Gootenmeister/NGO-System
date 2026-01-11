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
 * @author cl
 */
public class LandUppgifter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LandUppgifter.class.getName());
    
    private final InfDB idb;
    private final String landID;
    
    
    public LandUppgifter(InfDB idb, String landID) 
    {
        this.idb = idb;
        this.landID = landID;
        initComponents();
        hamtaLandUppgifter();
        
        txtLandID.setText(landID);
        txtLandID.setEditable(false);
    }
    // kör sql frågan och hämtar "kolumnnamnen" som nycklar i en hashmap (rader) och datan som värde.
    // alltså rader = nyckel: namn && värde: ex Sverige.
    // txtNamn, txtSprak osv är variabelnamn för JTextfield. 
    // alltså variabler, vars hämtade värden visas i GUI.
    // fetchrow returnerar värdet i kolumnerna som strängar. spelar alltså ingen roll här, att valuta är en decimal i databasen.
    private void hamtaLandUppgifter()
    {
        try {
              String sqlFråga = "SELECT lid, namn, sprak, valuta, tidszon, politisk_struktur, ekonomi FROM land "
                                + "WHERE lid = " + landID;
              
              HashMap<String, String> rader = idb.fetchRow(sqlFråga);
              
              txtNamn.setText(rader.get("namn"));
              txtSprak.setText(rader.get("sprak"));
              txtValuta.setText(rader.get("valuta"));
              txtTidszon.setText(rader.get("tidszon"));
              txtPolitiskStruktur.setText(rader.get("politisk_struktur"));
              txtEkonomi.setText(rader.get("ekonomi"));
              
            } catch (InfException e) 
            {
                JOptionPane.showMessageDialog(this, "kunde ej hämta uppgifter", "Fel", JOptionPane.ERROR_MESSAGE);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSpråk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTidszon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPolitiskStruktur, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addComponent(lblEkonomi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSparaNyttLand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nyttLand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSprak)
                    .addComponent(txtValuta)
                    .addComponent(txtTidszon)
                    .addComponent(txtPolitiskStruktur)
                    .addComponent(txtEkonomi)
                    .addComponent(sparaÄndringar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamn)
                    .addComponent(txtLandID))
                .addContainerGap(537, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLandID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamn)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpråk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValuta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTidszon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPolitiskStruktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPolitiskStruktur))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEkonomi))
                .addGap(18, 18, 18)
                .addComponent(sparaÄndringar)
                .addGap(29, 29, 29)
                .addComponent(nyttLand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSparaNyttLand)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void sparaÄndringarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaÄndringarActionPerformed
        //här skapas en array med alla täxtfält som användaren ska fylla i.
        javax.swing.JTextField[] textfält = {
            txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi  };
        
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
                 + "WHERE lid = " + landID;
         
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
        javax.swing.JTextField[] textfält2 = {
            txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi  };
        
        for (JTextField fält : textfält2)
        {
            fält.setText("");
        }
        
        txtLandID.setEditable(true);
    }//GEN-LAST:event_nyttLandActionPerformed

    private void btnSparaNyttLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaNyttLandActionPerformed
        
        javax.swing.JTextField[] textfält3 = {
            txtLandID, txtNamn, txtSprak, txtValuta, txtTidszon, txtPolitiskStruktur, txtEkonomi  };
        
        for (JTextField fält : textfält3) {
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
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "misslyckat " + e.getMessage());
        }
        

    }//GEN-LAST:event_btnSparaNyttLandActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSparaNyttLand;
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
