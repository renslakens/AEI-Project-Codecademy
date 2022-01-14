package programma.logic;

//import domain;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Validatie {

    public static boolean validatieUrl(String Url){
        boolean valid;
        valid = Url.matches("https://(.*)");
        return valid;
    }

    public static boolean validatieEmail(String Email){
        boolean valid;
        valid = Email.matches("(.*)@(.*)");
        return valid;
    }

    public static boolean validatieDatum(Date datum){
        if (datum != null && datum.before(new Date())) {
            return true;
        }
        return false;
    }

    public static boolean validatieGeslacht(String gender){
        if (gender.equals("Man") || gender.equals("Vrouw")) {
            return true;
        }else{
            return false;
        }
    }

    //check op cijfers en nummers
    public static boolean validatiePostcode(String postcode){
        if (postcode.equals(null)) {
            return false;
        } else if (postcode.length() <= 5 || postcode.length() >= 7) {
            return false;
        } else if (postcode.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}")) {

            return true;
        } else {
            return false;
        }
    }

}
