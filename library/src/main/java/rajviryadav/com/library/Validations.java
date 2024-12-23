package rajviryadav.com.library;

import android.util.Patterns;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations
{
    public static boolean validateEmail(String email)
    {
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if (email.isEmpty())
        {
            return false;
        }
        else if (!email.matches(checkEmail))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean validatePassword(String password)
    {
        String checkPassword = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (password.isEmpty())
        {
            return false;
        }
        else if (!password.matches(checkPassword))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean validateAge(int userAge)
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int isAgeValid = currentYear - userAge;
        if (isAgeValid < 17)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        String checkspaces = "Aw{1,20}z";
        if (phoneNumber.isEmpty()) {
            return false;
        } else if (!phoneNumber.matches(checkspaces)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateUrl(String url)
    {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url.toLowerCase());
        return m.matches();
    }
}
