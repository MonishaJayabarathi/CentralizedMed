package com.centrailized_medi_application;
import java.util.*;

//Class for patient registration

public class PatientRegistration {
    static Register register = new Register();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.print("Hello there Welcome to the Registration Centralized Medi Application ");
            System.out.println();
            System.out.println();
            System.out.println("Please enter the below details in order to get registered success as a patient");

            //User Details
            System.out.print(" Enter firstName: ");
            String firstName = scanner.nextLine();
            register.setFirstName(firstName);

            System.out.print(" Enter lastName: ");
            String lastName = scanner.nextLine();
            register.setLastName(lastName);

            System.out.print(" Enter gender: ");
            String gender = scanner.nextLine();
            register.setGender(gender);

            System.out.print(" Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            register.setDob(dateOfBirth);

            System.out.print(" Enter contactNo: ");
            long contactNo = scanner.nextLong();
            register.setContactNo(contactNo);

            System.out.print(" Enter address: ");
            String address = scanner.nextLine();
            register.setAddress(address);

            //login Details
            System.out.print(" Enter emailId: ");
            String emailId = scanner.nextLine();
            register.setEmailId(emailId);

            System.out.print(" Enter password: ");
            String password = scanner.nextLine();

            System.out.print(" Enter confirm password: ");
            String confirmPassword = scanner.nextLine();
            if (password.equals(confirmPassword)) {
                register.setPassword(password);
            }
            else{
                System.out.println("Password dont match");
            }

            System.out.println("Now please enter your answer for security questions");
            System.out.println("Enter name of your first school");
            String firstAnswer = scanner.nextLine();
            register.setFirstAnswer(firstAnswer);

            System.out.println("Enter your Hobby");
            String secondAnswer = scanner.nextLine();
            register.setSecondAnswer(secondAnswer);

            System.out.println("Enter name of your first bike");
            String thirdAnswer = scanner.nextLine();
            register.setThirdAnswer(thirdAnswer);



            System.out.println(register.toString());
        }
    }
}

class Register {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String password;
    private String emailId;
    private String address;
    private long contactNo;
    private  String firstAnswer;
    private  String secondAnswer;
    private  String thirdAnswer;

    public String getFirstName() {
        return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName; }

    public String getLastName() {
        return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName; }

    public String getGender() {
        return firstName; }

    public void setGender(String gender) {
        this.gender = gender; }

    public void setDob(String Dob) {
        this.dateOfBirth = Dob; }

    public String getDob(String Dob) {
        return dateOfBirth; }

    public long getContactNo() {
        return contactNo; }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo; }

    public String getAddress(String address) {
        return address; }

    public String setAddress(String address) {
        return this.address = address; }

    public String getEmailId() {
        return emailId; }

    public void setEmailId(String emailId) {
        this.emailId = emailId; }

    public String getPassword() {
        return password; }

    public void setPassword(String password) {
        this.password = password; }

    public String getFirstAnswer(String firstAnswer)
    {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer){
        this.firstAnswer = firstAnswer;
    }
    public String getSecondAnswer(String secondAnswer)
    {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer){
        this.secondAnswer = secondAnswer;
    }
    public String getThirdAnswer(String thirdAnswer)
    {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer){
        this.thirdAnswer = thirdAnswer;
    }



    @Override
    public String toString() {
        return "Register [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" +
                dateOfBirth + ",contactNo" + contactNo +",address="+address+",password"+password+",firstanswer"
                +firstAnswer+"second answer"+secondAnswer+"third answer"+thirdAnswer+"]";
    }

}
