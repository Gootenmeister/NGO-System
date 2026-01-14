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
import java.util.HashMap;

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
    private String avdid;
    private ArrayList<String> aidLista;


    /**
     * Creates new form Projekt
     */
    public Projekt(InfDB idb, int accessLevel) {
        this.idb = idb;
        this.accessLevel = accessLevel;
        epost = "";
        avdid = "";
        ArrayList<String> projektNamn = new ArrayList<>();
        ArrayList<String> aidLista = new ArrayList<>();
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
            
        projektListaAllaProjekt();
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

        //sql-sats om man är handläggare
        String sqlHandläggare =
        "select p.projektnamn " +
        "from sdgsweden.projekt p " +
        "join sdgsweden.ans_proj ap on p.pid = ap.pid " +
        "join sdgsweden.anstalld a on ap.aid = a.aid " +
        "where ap.aid = " + Meny.getAID();
        
        //sql-sats om man är projektchef
        String sqlProjektChef = 
        "select projektnamn from sdgsweden.projekt  where projekt.projektchef = " + Meny.getAID();


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
    
    private void projektListaAllaProjekt(){
        
        try {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            
            System.out.println(avdid);
            setAvdid();
            System.out.println(avdid);
            String sqlQ = "select projektnamn from projekt where projektchef in (select aid from anstalld where avdelning = " + avdid + ")";
            System.out.println(sqlQ);
            projektNamn = idb.fetchColumn(sqlQ);
            
            for (String namn : projektNamn) {
                listModel.addElement(namn);
            }
            
            lstAllaProjekt.setModel(listModel);
        } catch (InfException ex) {
            System.getLogger(Projekt.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProjektMedarbetare = new javax.swing.JList<>();
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

        lstProjektMedarbetare.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Välj ett projekt" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProjektMedarbetare);

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
                .addGap(60, 60, 60)
                .addComponent(lblAvdelning)
                .addGap(0, 638, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(splProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
    
    private void setAvdid()
    {
        String sqlQ = "select avdelning from anstalld where aid = " + Meny.getAID();
        try
        {
            avdid = idb.fetchSingle(sqlQ);
        }
        
        catch(InfException exception)
        {
            System.out.println("Error: " + exception);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JList<String> lstProjekt;
    private javax.swing.JList<String> lstProjektMedarbetare;
    private javax.swing.JList<String> lstProjektPartner;
    private javax.swing.JScrollPane splProjekt;
    // End of variables declaration//GEN-END:variables
}

