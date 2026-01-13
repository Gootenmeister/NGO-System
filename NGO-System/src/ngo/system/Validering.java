package ngo.system;

/**
 * Hej, här fipplade jag på några lösningar på dåliga ints, doubles och strings!
 * För att kunna implementera dessa korrekt i koden senare (Call'a valideringsmetoderna korrekt),
 * behöver man kolla om värde som ska kollas =! null - EXEMPEL PÅ goodInt(), implementering:
 * 
 * String error = Validering.goodInt(userInt); 
 * if (error != null) { 
 *    showError(error); //Visa error! =)
 *    return; //exita
 *} 
 * // PROCEED AS USUAL
 * 
 * @author Gustav Alvesvärd
 */
public class Validering {
    
    //KONSTANTER
    private static final int OUT_OF_BOUNDS = 16000;     //OutOfBounds-tak
    private static final int MAX_STRLEN = 255;          //MaxStringLen-tak
    
    //METODER
    public static String goodInt(int num) {
    if (num < 0) {
        return "Ogiltigt värde!";
    }
    if (num > OUT_OF_BOUNDS) {
        return "Värde out of bounds!";
    }
    return null; // NULL är pass!
    }
    
    public static String goodDbl(double num) {
    if (num < 0) {
        return "Ogiltigt värde!";
    }
    if (num > OUT_OF_BOUNDS) {
        return "Värde out of bounds!";
    }
    return null;
    }
    
    public static String tfnValid(String tfn)
    {
        //Kollar längden på telefnonummret
        if(tfn.length() < 10)
        {
            return "För litet! 10 siffror behövs.";
        }
        else if(tfn.length() > 10)
        {
            return "För stort! Endast 10 siffror behövs.";
        }
        else
        {
            //Kollar om alla tecken är siffror
            for(int i = 0; i < tfn.length(); i++)
            {
                if (!Character.isDigit(tfn.charAt(i)))
                {
                    return "Alla tecken behöver vara siffor.";
                }
            }
        }
        
        return null;
    }
    
    public static String mailValid(String mail)
    {
        //Kollar om adressen innehåller @ och . och vart dem är
        if(!mail.contains("@"))
        {
            return "Email-adressen saknar ett \"@\".";
        }
        else if(!mail.contains("."))
        {
            return "Email-adressen saknar ett \".\".";
        }
        else if(mail.startsWith("@"))
        {
            return "Email-adressen kan inte börja med ett \"@\".";
        }
        else if(mail.endsWith("@"))
        {
            return "Email-adressen kan inte sluta med ett \"@\".";
        }
        else if(mail.startsWith("."))
        {
            return "Email-adressen kan inte börja med ett \".\".";
        }
        else if(mail.endsWith("."))
        {
            return "Email-adressen kan inte börja med ett \".\".";
        }

        return null;
    }
    
    public static String datumValid(String datum)
    {
        if(!datum.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            return "Datumet behöver använda formatet (yyyy-mm-dd) bindestreck inkluderat.";
        }
        
        return null;
    }
    
    public static String goodStr(String s) {
    if (s == null || s.isEmpty()) {
        return "Inputsträng tom!";
    }
    if (s.length() > MAX_STRLEN) {
        return "Inputsträng för lång! (>255)";
    }
    //if (!s.contains("@")) {
    //    return "E-postadresser måste innehålla '@'";
    //}

    return null; //här med är NULL är valid
    }
}
