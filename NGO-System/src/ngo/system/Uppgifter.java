/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo.system;

import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author calle
 */
public class Uppgifter extends javax.swing.JFrame 
{
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Uppgifter.class.getName());
    
    private final InfDB idb;
    private final String aid;
    
    
    
    
    // hämtar databasen och aid till inloggad i konstruktorn
    public Uppgifter(InfDB idb, String aid) 
    {
        this.idb = idb;
        this.aid = Meny.getAID();
        initComponents();
        hamtaMinaProjekt();
    } 
        
        
    

    private void hamtaMinaProjekt()
    {
        try{
            String sqlFraga = "SELECT projektnamn, beskrivning, kostnad, prioritet, land, projektchef, startdatum, slutdatum, status FROM projekt WHERE pid IN"
                    + "(SELECT pid FROM ans_proj WHERE aid =  " + aid + ")";
            
            //skapar en Arraylist av hashmaps, kolumnerna ovan efter SELECT är nycklar och "infon" är värdena.
            ArrayList<HashMap<String, String>> projektLista = idb.fetchRows(sqlFraga);
            
            //TableModel lagrar datan
            //kolumner, eller ordningen på arrayen är det som visas i jTable... "designen".
            String[] kolumner = {"Projektnamn", "beskrivning", "kostnad", "prioritet", "land", "projektchef", "Startdatum", "Slutdatum", "Status"};
            DefaultTableModel model = new DefaultTableModel(kolumner, 0);
            
            // loopar igenom alla projekt i projektlistan. ex "projektnamn" är nyckel och "infon" är värdet.
            // Object[] rad skapar en array av rader. rad och kolumner matchar så att ordningen blir rätt.
            // Object klassen används för att kunna hantera "alla typer" av data till tabellen. 
            // ex kan "beskrivning" vara en String och "kostnad" en int. Object kan hantera båda.
            for (HashMap<String, String> projekt : projektLista )
            {
                Object[] rad = {
                                projekt.get("projektnamn"),
                                projekt.get("beskrivning"),
                                projekt.get("kostnad"),
                                projekt.get("prioritet"),
                                projekt.get("land"),
                                projekt.get("projektchef"),
                                projekt.get("startdatum"),
                                projekt.get("slutdatum"),
                                projekt.get("status")
                               };
                model.addRow(rad);
                
            }
                
               projektTable.setModel(model);
        } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Kunde inte hämta projekten: " + e.getMessage());
            }
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneProjekt = new javax.swing.JScrollPane();
        projektTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        projektTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPaneProjekt.setViewportView(projektTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneProjekt, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneProjekt, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        //java.awt.EventQueue.invokeLater(() -> new Uppgifter().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable projektTable;
    private javax.swing.JScrollPane scrollPaneProjekt;
    // End of variables declaration//GEN-END:variables
}
