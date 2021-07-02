package com.centrailized_medi_application;
import java.sql.*;
import java.util.*;

//Class for patient registration

public class PatientRegistration {
    // Mentioned all the variables names which will be used for
    //Storing values
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String password;
    private String emailId;
    private String address;
    private String contactNo;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String bloodGroup;
    private String allergy;
    private String chronicDisease;
    private String insuranceNo;
    private String donorCardNo;
    private String familyMemberCode;
    private String volunteer;


    //Creating Get and Set methods for all the entities required for registration

    //Get and set methods for basic user details
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGender() { return firstName; }

    public void setGender(String gender) { this.gender = gender; }

    public void setDob(String Dob) { this.dateOfBirth = Dob; }

    public String getDob() { return dateOfBirth; }

    public String getContactNo() { return contactNo; }

    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getAddress() { return address; }

    public String setAddress(String address) { return this.address = address; }

    public String getEmailId() { return emailId; }

    //Get and Set methods for login credentials of patients along with security questions

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer){
        this.firstAnswer = firstAnswer; }

    public String getSecondAnswer() {
        return secondAnswer;
    }

   public void setSecondAnswer(String secondAnswer)
   {
       this.secondAnswer = secondAnswer;
   }

    public String getThirdAnswer()
    {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer){
        this.thirdAnswer = thirdAnswer;
    }

    //Get and Set method for users personal medical information

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getChonicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(String chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getInsuranceNo()
    {
        return  insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo){
        this.insuranceNo = insuranceNo;
    }

    public String getDonorCardNo()
    {
        return donorCardNo;
    }

    public void setDonorCardNo(String donorCardNo){
        this.donorCardNo = donorCardNo;
    }

    public String getFamilyMemberCode(){
        return familyMemberCode;
    }

    public void setFamilyMemberCode(String familyMemberCode){
        this.familyMemberCode = familyMemberCode;
    }

    public String getVolunteer()
    {
        return volunteer;
    }

    public void setVolunteer(String volunteer){
        this.volunteer = volunteer;
    }

    //Method for providing interface to interact with the user in order to get values

    public void beginRegistration(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Hello there Welcome to the Registration for patient in Centralized Medi Application ");
            System.out.println();
            System.out.println();
            System.out.println("Please enter the below details in order to get registered as a patient successfully");

            //User Details
            System.out.print(" Enter firstName: ");
            String firstName = scanner.nextLine();
            setFirstName(firstName);

            System.out.print(" Enter lastName: ");
            String lastName = scanner.nextLine();
            setLastName(lastName);

            System.out.print(" Enter gender: ");
            String gender = scanner.nextLine();
            setGender(gender);

            System.out.print(" Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            setDob(dateOfBirth);

            System.out.print(" Enter contactNo: ");
            String contactNo = scanner.nextLine();
            setContactNo(contactNo);

            System.out.print(" Enter address: ");
            String address = scanner.nextLine();
            setAddress(address);

            //login Details
            System.out.print(" Enter emailId: ");
            String emailId = scanner.nextLine();
            setEmailId(emailId);

            System.out.print(" Enter password: ");
            String password = scanner.nextLine();

            System.out.print(" Enter confirm password: ");
            String confirmPassword = scanner.nextLine();
            if (password.equals(confirmPassword)) {
                setPassword(password);
            } else {
                System.out.println("Password dont match");
            }

            // Taking input for security questions
            System.out.println("Now please enter your answer for security questions");
            System.out.println("Enter name of your first school");
            String firstAnswer = scanner.nextLine();
            setFirstAnswer(firstAnswer);

            System.out.println("Enter your Hobby");
            String secondAnswer = scanner.nextLine();
            setSecondAnswer(secondAnswer);

            System.out.println("Enter name of your first bike");
            String thirdAnswer = scanner.nextLine();
            setThirdAnswer(thirdAnswer);

            //Additonal Personal medical Details
            System.out.print("Enter your Blood Group: ");
            String bloodGroup = scanner.nextLine();
            setBloodGroup(bloodGroup);

            System.out.print(" Enter information for Allergies(if there are otherwise enter Null): ");
            String allergy = scanner.nextLine();
            setAllergy(allergy);

            System.out.println("Enter Chronic disease if any(otherwise enter null): ");
            String chronicDisease = scanner.nextLine();
            setChronicDisease(chronicDisease);

            System.out.println("Enter your insurance number:) ");
            String insuranceNo = scanner.nextLine();
            setInsuranceNo(insuranceNo);

            System.out.println("Enter your donar card number (if you have):");
            String donorCardNo = scanner.nextLine();
            setDonorCardNo(donorCardNo);

            System.out.println("Enter your family members identity code:");
            String familyMemberCode = scanner.nextLine();
            setFamilyMemberCode(familyMemberCode);

            System.out.println("If would you like to be a volunteer please enter yes otherwise no");
            String volunteer = scanner.nextLine();
            setVolunteer(volunteer);


            System.out.println("Please check the details and if you are sure then press 1");

            // Showing user its entered values in order to confirm it

            System.out.println("[firstName:" + firstName + ", lastName:" + lastName + ", gender:" + gender + ", dateOfBirth:" +
                    dateOfBirth + ", contactNo:" + contactNo +", address:" +address+", password:" +password+", firstAnswer:"
                    +firstAnswer+", secondAnswer:"+secondAnswer+", thirdAnswer:"+thirdAnswer+", bloodGroup:"+bloodGroup+
                    ", allergies:"+allergy+", chronicDisease:"+chronicDisease+", insuranceNo:"+insuranceNo+
                    ", donarCardNo:"+donorCardNo+", familyMemberCode:"+familyMemberCode+", volunteer:"+volunteer+"]");

            //taking user input for choice to insert value in the database
            int submit = scanner.nextInt();

            // Inserting values in the database if user finalize the information entered
            if(submit == 1){
                update();
            }
            else
            {
                System.out.println("You have decided not to submit your details so now you have to fill the form again");
                //Asking user to enter details again if they wish to change any information
                beginRegistration();

            }
        }
        //catch in order to handle any exceptions related to sql occurs
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
// update method to insert values in the database after user's choice is entered
    public void update() throws ClassNotFoundException, SQLException {
            System.out.println("Inserting values in the database");
                   //Setting up the connection with the database
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/trytest";
                    String uname = "root";
                    String pass = "";
                    Class.forName(driver);
                    Connection c = (Connection) DriverManager.getConnection(url, uname, pass);
                    //prepare statment to insert values in the database
                    PreparedStatement test = c.prepareStatement("INSERT INTO `userinfo`(firstname,lastname,dateofbirth,gender,password,emailId,address,contactNo,firstAnswer,secondAnswer,thirdAnswer,bloodGroup,allergy,chronicDisease,insuranceNo,donorCardNo,familyMemberCode,volunteer)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    //inserting values one by one for each entities

                    test.setString(1, firstName);
                    test.setString(2, lastName);
                    test.setString(3, dateOfBirth);
                    test.setString(4, gender);
                    test.setString(5, password);
                    test.setString(6, emailId);
                    test.setString(7, address);
                    test.setString(8, contactNo);
                    test.setString(9, firstAnswer);
                    test.setString(10, secondAnswer);
                    test.setString(11, thirdAnswer);
                    test.setString(12, bloodGroup);
                    test.setString(13, allergy);
                    test.setString(14, chronicDisease);
                    test.setString(15, insuranceNo);
                    test.setString(16, donorCardNo);
                    test.setString(17, familyMemberCode);
                    test.setString(18, volunteer);

                    //executing update
                    test.executeUpdate();
            }

}




