package com.centrailized_medi_application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
//    public static void main(String[] args) throws Exception{
    public boolean validateEmail(String email)  {
        //Constraint is that is should contain @ in between
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if (email == null) {
            return false;
        }

        //Matching between given Email and regular expression
        Matcher m = p.matcher(email);

        // Return true the name matched the ReGex

        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validateName(String name)
    {
        //Constraints for Name is that there should not be any . or space in first charactor
        //Regex to check valid name.
        String regex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the name is empty
        // return false
        if (name == null) {
            return false;
        }

        //Matching between given name and regular expression

        Matcher m = p.matcher(name);

        // Return if the name
        // matched the ReGex


        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validateDob(String dob){
        //Date format is DD/MM/YYYY or DD.MM.YYYY or DD-MM-YYYY
        String dateRegEx="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
                "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]" +
                "|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])" +
                "|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        // Compile the ReGex
        Pattern p = Pattern.compile(dateRegEx);

        if (dob == null) {
            return false;
        }

        // Matching given dob and regular expression.
        Matcher m = p.matcher(dob);

        // Return true if the dob matched the ReGex


        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean validateContactNo(String contactno){
        //Contact No Contraints:
        //Can be of length 10 or 11
        String ContactRegEx="^\\d{10,11}$";
        // Compile the ReGex
        Pattern p = Pattern.compile(ContactRegEx);

        if (contactno == null) {
            return false;
        }

        // Matching between given contactno and regular expression.
        Matcher m = p.matcher(contactno);

        // Return true if the contactno matched the ReGex

        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean validateGender(String gender)
    {
        //List of the approved options if matched then return true
        if(gender.equals("f") || gender.equals("F") || gender.equals("female") || gender.equals("Female") || gender.equals("FEMALE")  ||
                gender.equals("m")  || gender.equals("M") || gender.equals("male") || gender.equals("Male") || gender.equals("MALE"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validateBloodGroup(String bloodgroup)
    {
        ////List of the approved options if matched then return true
        if(bloodgroup.equals("A+")|| bloodgroup.equals("A+ve")|| bloodgroup.equals("A-ve") || bloodgroup.equals("A-")
                || bloodgroup.equals("a+") || bloodgroup.equals("a+ve") || bloodgroup.equals("a-ve")
                || bloodgroup.equals("a-") ||bloodgroup.equals("A+VE") ||bloodgroup.equals("A-VE")
                ||bloodgroup.equals("a+VE") ||bloodgroup.equals("a-VE") || bloodgroup.equals("B+")
                || bloodgroup.equals("B+ve") || bloodgroup.equals("B-ve") || bloodgroup.equals("B-")
                || bloodgroup.equals("b+") || bloodgroup.equals("b+ve") || bloodgroup.equals("b-ve")
                || bloodgroup.equals("b-")||bloodgroup.equals("B+VE")  ||bloodgroup.equals("B-VE")
                ||bloodgroup.equals("b+VE") ||bloodgroup.equals("b-VE") ||bloodgroup.equals("O+")
                || bloodgroup.equals("O+ve") || bloodgroup.equals("O-ve") || bloodgroup.equals("O-")
                || bloodgroup.equals("o+") || bloodgroup.equals("o+ve")  || bloodgroup.equals("o-ve")
                || bloodgroup.equals("o-")||bloodgroup.equals("O+VE") ||bloodgroup.equals("O-VE")
                ||bloodgroup.equals("o+VE") ||bloodgroup.equals("o-VE") || bloodgroup.equals("AB+")
                || bloodgroup.equals("AB+ve") || bloodgroup.equals("AB-ve") || bloodgroup.equals("AB-")
                || bloodgroup.equals("ab+") || bloodgroup.equals("ab+ve")  || bloodgroup.equals("ab-ve")
                || bloodgroup.equals("ab-")||bloodgroup.equals("AB+VE") ||bloodgroup.equals("AB-VE")
                ||bloodgroup.equals("ab+VE") ||bloodgroup.equals("ab-VE") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean validateVolunteer(String volunteer)
    {
        //List of the approved options if matched then return true
        if(volunteer.equals("yes") || volunteer.equals("YES") || volunteer.equals("NO") ||volunteer.equals("Yes")
                || volunteer.equals("no") || volunteer.equals("Y") ||volunteer.equals("No")
                || volunteer.equals("N")  || volunteer.equals("y")  || volunteer.equals("n"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean validateAlphanumeric(String data)
    {
        //Constraints are that String can only contain alphabets and number along
        // and also comma is allows
        String AlphanumericRegEx="^[a-zA-Z0-9,]+$";


        // Compile the ReGex
        Pattern p = Pattern.compile(AlphanumericRegEx);

        if (data == null) {
            return false;
        }

        // Matching given Alphanurmic String and regular expression.
        Matcher m = p.matcher(data);

        // Return true if the Alphanurmic matched the ReGex
;
        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean validatePassword(String password)
    {

        //Password Constraints :
        // a digit must occur at least once.
        //a lower case alphabet must occur at least once.
        //an upper case alphabet that must occur at least once.
        //a special character that must occur at least once.
        //white spaces don’t allowed in the entire string.
        //At least 8 characters and at most 20 characters.

        String PasswordRegEx="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(PasswordRegEx);

        if (password == null) {
            return false;
        }

        // Matching between given Password and regular expression.
        Matcher m = p.matcher(password);

        // Return true if the Password matched the ReGex

        if (m.matches() == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
