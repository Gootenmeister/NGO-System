package ngo.system;

/**
 * Hej, här fipplade jag på några lösningar på dåliga ints, doubles och strings!
 * För att kunna implementera dessa korrekt i koden senare (Call'a valideringsmetoderna korrekt),
 * behöver man kolla om värde som ska kollas =! null - EXEMPEL PÅ goodInt(), implementering:
 * 
 * String error = Validering.goodInt(userInt); 
 * if (error != null) { showError(error); //Visa error! =)
 * return; //exita
 * } 
 * // PROCEED AS USUAL
 * 
 * @author Gustav Alvesvärd
 */
public class Validering {
    
    //KONSTANTER
    private static final int OUT_OF_BOUNDS = 16000;     //OutOfBounds-tak
    private static final int MAX_STRLEN = 255;          //MaxStringLen-tak
    public static String goodInt(int num) {
    if (num < 0) {
        return "NUMBER IS NEGATIVE";
    }
    if (num > OUT_OF_BOUNDS) {
        return "VALUE OUT OF BOUNDS!";
    }
    return null; // NULL är pass!
    }
    
    public static String goodDbl(double num) {
    if (num < 0) {
        return "NUMBER IS NEGATIVE";
    }
    if (num > OUT_OF_BOUNDS) {
        return "VALUE OUT OF BOUNDS!";
    }
    return null;
}
    
    public static String goodStr(String s) {
    if (s == null || s.isEmpty()) {
        return "STRING IS EMPTY!";
    }
    if (s.length() > MAX_STRLEN) {
        return "STRING TOO LONG (>255)";
    }
    return null; //här med är NULL är valid
    }
}
