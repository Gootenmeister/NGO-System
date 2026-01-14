/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo.system;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author drakm
 */
public class Projekt extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Projekt.class.getName());
    private InfDB idb;
    private String avdelning;
    private String avdelningNummer;
    private String epost;
    private Date startDatum;
    private Date slutDatum;
    private ArrayList<String> projektNamn;
    private String epostChef;
    private LocalDate startDatumLocal;
    private LocalDate slutDatumLocal;
    private String statusFilter = null;
    private int accessLevel;


    /**
     * Creates new form Projekt
     */
    public Projekt(InfDB idb, int accessLevel) {
        this.idb = idb;
        this.accessLevel = accessLevel;
        epost = "";
        ArrayList<String> projektNamn = new ArrayList<>();
        epostChef = "";
        initComponents();
        printAvdelning();
        projektLista();
        lstProjekt.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { 
                String selectedProjekt = lstProjekt.getSelectedValue();
            if (selectedProjekt != null) {
                visaProjektMedarbetare(selectedProjekt);
                visaProjektParner(selectedProjekt);
            }
    }
});

    }
    
    //Ändrar lblAvdelning till att visa avdelningens namn som användaren jobbar på
    private void printAvdelning()
    {
        setAvdelningNummer();
        setAvdelning();
        lblAvdelning.setText(avdelning);
    }
    
    //Ger fältet avdelningNummer värdet för avdelningen som användaren tillhör med hjälp av AID
    private void setAvdelningNummer()
    {
        try {
            String sqlQ = "select avdelning from anstalld where aid = ";
            avdelningNummer = idb.fetchSingle(sqlQ + Meny.getAID());
        }
        
        catch(InfException exception) {
            System.out.println("Error: " + exception);
        }
    }
    
    //Ger fältet avdelning namnet för avdelningen som användaren tillhör med hjälp av avdid
    private void setAvdelning()
    {
        try {
            String sqlQ = "select namn from avdelning where avdid = ";
            avdelning = idb.fetchSingle(sqlQ + avdelningNummer);
        }
        
        catch(InfException exception) {
            System.out.println("Error: " + exception);
        }
    }
    
    //Skapar en lista för alla projekt som finns i avdelningen som användaren jobbar på och som är aktiva samt ingår i det datumet användaren skrivit in om de har det. Söker även efter projekt utifrån vilken projektchef som projektet har om användaren har sökt på en Epost-adress. 
    private void projektLista() {
    try {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        String statusCondition = "";
        if (statusFilter != null) {
            statusCondition = " and p.status = '" + statusFilter + "'";
        }

        
        String dateCondition = "";
        if (startDatumLocal != null && slutDatumLocal != null) {
            dateCondition = " and CAST(p.startdatum AS DATE) >= DATE '" + startDatumLocal.toString() + "'" +
                            " and CAST(p.slutdatum AS DATE) <= DATE '" + slutDatumLocal.toString() + "'";
        } else if (startDatumLocal != null) {
            dateCondition = " and CAST(p.startdatum AS DATE) >= DATE '" + startDatumLocal.toString() + "'";
        } else if (slutDatumLocal != null) {
            dateCondition = " and CAST(p.slutdatum AS DATE) <= DATE '" + slutDatumLocal.toString() + "'";
        }

        String emailCondition = "";
        if (epost != null && !epost.isEmpty()) {
            emailCondition = " and lower(a.epost) like '%" + epost.toLowerCase() + "%'";
        }

        //sql-sats om man är handläggare
        String sqlHandläggare =
        "select p.projektnamn " +
        "from sdgsweden.projekt p " +
        "join sdgsweden.ans_proj ap on p.pid = ap.pid " +
        "join sdgsweden.anstalld a on ap.aid = a.aid " +
        "where ap.aid = " + Meny.getAID() +
        statusCondition +
        dateCondition +
        emailCondition;
        
        //sql-sats om man är projektchef
        String sqlProjektChef = 
        "select projektnamn from sdgsweden.projekt  where projekt.projektchef = " + Meny.getAID() +
        statusCondition +
        dateCondition +
        emailCondition;


        if (accessLevel == 0){
        projektNamn = idb.fetchColumn(sqlHandläggare);
        }
        System.out.println(accessLevel);
        
        if (accessLevel == 1){
        projektNamn = idb.fetchColumn(sqlProjektChef);
        }

        for (String namn : projektNamn) {
            listModel.addElement(namn);
        }

        lstProjekt.setModel(listModel);

    } catch (InfException exception) {
        System.out.println("Error: " + exception);
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

        lblAvdelning = new javax.swing.JLabel();
        splProjekt = new javax.swing.JScrollPane();
        lstProjekt = new javax.swing.JList<>();
        btnDatum = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEpost = new javax.swing.JTextField();
        lblEpost = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statusCbox = new javax.swing.JComboBox<>();
        txtStartDatum = new javax.swing.JTextField();
        txtSlutDatum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProjektMedarbetare = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProjektPartner = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAvdelning.setText("jLabel1");

        lstProjekt.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        splProjekt.setViewportView(lstProjekt);

        btnDatum.setText("Sök");
        btnDatum.addActionListener(this::btnDatumActionPerformed);

        jLabel1.setText("Sök inom ett datum eller på en användares E-post");

        txtEpost.addActionListener(this::txtEpostActionPerformed);

        lblEpost.setText("E-post");

        jLabel2.setText("Filtrera på status:");

        statusCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Ingen Filtrering-", "Pågående", "Avslutat", "Planerat" }));
        statusCbox.addActionListener(this::statusCboxActionPerformed);

        txtSlutDatum.addActionListener(this::txtSlutDatumActionPerformed);

        lstProjektMedarbetare.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Välj ett projekt" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProjektMedarbetare);

        jLabel3.setText("Startdatum [åååå-mm-dd]");

        jLabel4.setText("Slutdatum [åååå-mm-dd]");

        lstProjektPartner.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Välj ett projekt" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstProjektPartner);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblAvdelning))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnDatum)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(statusCbox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel4)))
                        .addGap(0, 371, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(splProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEpost))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblAvdelning)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEpost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDatum)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //När användaren klickar på knappen så hämtas det som användaren har sökt på för Epost och de datum som användaren har knappat in. Datumen görs om från Date till LocalDate så att vi kan gemföra datum i vår SQL query
    private void btnDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatumActionPerformed
        epost = txtEpost.getText().trim();

    try {
        String error = Validering.datumValid(txtStartDatum.getText());
        if (error != null) {
            showError("Lösenord: " + error);
            return;
        }
        
        error = Validering.datumValid(txtSlutDatum.getText());
        if (error != null) {
            showError("Lösenord: " + error);
            return;
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        startDatumLocal = txtStartDatum.getText().isBlank()
                ? null
                : startDatumLocal.parse(txtStartDatum.getText(), formatter);
        
        slutDatumLocal = txtSlutDatum.getText().isBlank()
                ? null
                : slutDatumLocal.parse(txtSlutDatum.getText(), formatter);


    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Felaktigt datumformat! Använd yyyy-MM-dd");
        startDatumLocal = null;
        slutDatumLocal = null;
    }

    projektLista();
    }//GEN-LAST:event_btnDatumActionPerformed

    
    private void visaProjektMedarbetare(String projektnamn) {
    try {
        String pid = idb.fetchSingle(
            "SELECT pid FROM projekt WHERE projektnamn = '" + projektnamn + "'"
        );

        DefaultListModel<String> listModel = new DefaultListModel<>();

        if (pid != null) {
            String query = "SELECT CONCAT(a.fornamn, ' ', a.efternamn) AS namn " +
                           "FROM ans_proj ap " +
                           "JOIN anstalld a ON ap.aid = a.aid " +
                           "WHERE ap.pid = " + pid;
            System.out.println("DEBUG: Medarbetare query = " + query);

            ArrayList<String> medarbetare = idb.fetchColumn(query);

            if (medarbetare != null) {
                for (String namn : medarbetare) {
                    listModel.addElement(namn);
                }
            }
        }

        lstProjektMedarbetare.setModel(listModel);

    } catch (InfException ex) {
        System.out.println("Error: " + ex);
    }
}
    
    
    private void visaProjektParner(String projektnamn){
    
        try {
            String pid = idb.fetchSingle(
                    "SELECT pid FROM projekt WHERE projektnamn = '" + projektnamn + "'"
            );
            
            DefaultListModel<String> listModel = new DefaultListModel<>();
            
            if (pid != null) {
                String query = "SELECT namn from partner join projekt_partner on projekt_partner.partner_pid = partner.pid where projekt_partner.pid = " + pid;
                System.out.println("DEBUG: Medarbetare query = " + query);
                
                ArrayList<String> partner = idb.fetchColumn(query);
                
                if (partner != null) {
                    for (String namn : partner) {
                        listModel.addElement(namn);
                    }
                }
            }
            
            lstProjektPartner.setModel(listModel);
        } catch (InfException ex) {
            System.getLogger(Projekt.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    
    }
    //Visar ett medellande om vad som gick fel om en validering misslyckades
    private void showError(String message) 
    {
        JOptionPane.showMessageDialog(this, message, "Valideringsfel", JOptionPane.ERROR_MESSAGE);
    }



    private void txtEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEpostActionPerformed

    private void statusCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusCboxActionPerformed
        statusFilter = statusCbox.getSelectedIndex() == 0 ? null
                    : (String) statusCbox.getSelectedItem();
    projektLista();
    }//GEN-LAST:event_statusCboxActionPerformed

    private void txtSlutDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlutDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlutDatumActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> new Projekt().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JList<String> lstProjekt;
    private javax.swing.JList<String> lstProjektMedarbetare;
    private javax.swing.JList<String> lstProjektPartner;
    private javax.swing.JScrollPane splProjekt;
    private javax.swing.JComboBox<String> statusCbox;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtSlutDatum;
    private javax.swing.JTextField txtStartDatum;
    // End of variables declaration//GEN-END:variables
}

