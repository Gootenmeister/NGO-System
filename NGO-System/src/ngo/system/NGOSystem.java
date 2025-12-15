/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ngo.system;

//Dessa två klasser ska alltid importeras när vi ska hantera vår databas
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author alve
 */
public class NGOSystem {

    private static InfDB idb;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //provar etablera connection - params är "DBnamn", "port", "user", "pwd"
            //i sql scriptet ska dbAdmin2024 skapas med ett dbAdmin2024PW så vi provar, annars får vi köra root :(
            idb = new InfDB("sdgsweden", "3306", "dbAdmin2024", "dbAdmin2024PW");
            //idb = new InfDB("sdgsweden", "3306", "root", "masterkey");
            
            new Login(idb).setVisible(true);
        } catch (InfException ex) {
            System.out.println("Error: "+ ex.getMessage());
            
        }
           
    }         
    
}
