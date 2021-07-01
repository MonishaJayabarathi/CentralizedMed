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


    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return firstName; }

    public void setGender(String gender) { this.gender = gender; }

    public void setDob(String Dob) { this.dateOfBirth = Dob; }

    public String getDob(String Dob) { return dateOfBirth; }

    public long getContactNo() { return contactNo; }

    public void setContactNo(long contactNo) { this.contactNo = contactNo; }

    public String getAddress(String address) { return address; }

    public String setAddress(String address) { return this.address = address; }


    @Override
    public String toString() {
        return "Register [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" +
                dateOfBirth + ",contactNo" + contactNo +"]";
    }

}
