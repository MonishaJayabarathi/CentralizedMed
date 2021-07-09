package com.centrailized_medi_application;
import java.io.IOException;
import java.sql.*;
import java.util.*;

//Class for patient registration

public class PatientRegistration {
    private static BasicDetails patientBasicDetails;
    // Mentioned all the variables names which will be used for
    //Storing values
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
    private String em;


    //Creating Get and Set methods for all the entities required for registration

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer){ this.firstAnswer = firstAnswer; }

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
            patientBasicDetails = new BasicDetails();
            System.out.print("Hello there Welcome to the Registration for patient in Centralized Medi Application ");
            System.out.println();
            System.out.println();
            System.out.println("Please enter the below details in order to get registered as a patient successfully");

//            boolean checker = false;
//            do {
//
//            }while(checker) {
//                //User Details
//                System.out.print(" Enter firstName: ");
//                patientBasicDetails.setFirstName(scanner.nextLine());
//                if(!) {
//                    checker = true;
//                }
//                else {
//                    checker = false;
//                }
//            }

            System.out.print(" Enter FirstName: ");
            patientBasicDetails.setFirstName(scanner.nextLine());

            System.out.print(" Enter lastName: ");
            patientBasicDetails.setLastName(scanner.nextLine());

            System.out.print(" Enter gender: ");
            String gender = scanner.nextLine();
            patientBasicDetails.setGender(gender);

            System.out.print(" Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            patientBasicDetails.setDob(dateOfBirth);

            System.out.print(" Enter contactNo: ");
            String contactNo = scanner.nextLine();
            patientBasicDetails.setContactNo(contactNo);

            System.out.print(" Enter address: ");
            String address = scanner.nextLine();
            patientBasicDetails.setAddress(address);

            //login Details
            System.out.print(" Enter emailId: ");
            patientBasicDetails.setEmailId(scanner.nextLine());

            System.out.print(" Enter password: ");
            String password = scanner.nextLine();

            System.out.print(" Enter confirm password: ");
            String confirmPassword = scanner.nextLine();
            if (confirmPassword.equals(password)) {

                    patientBasicDetails.setPassword(confirmPassword);

            }
            else {
                System.out.println("Password dont match");

            }

            // Taking input for security questions

            System.out.println("Now please enter your answer for security questions");
            System.out.println(" Enter name of your first school:");
            String firstAnswer = scanner.nextLine();
            setFirstAnswer(firstAnswer);

            System.out.println(" Enter your Hobby:");
            String secondAnswer = scanner.nextLine();
            setSecondAnswer(secondAnswer);

            System.out.println(" Enter name of your first bike:");
            String thirdAnswer = scanner.nextLine();
            setThirdAnswer(thirdAnswer);

            //Additonal Personal medical Details
            System.out.print(" Enter your Blood Group:");
            String bloodGroup = scanner.nextLine();
            setBloodGroup(bloodGroup);

            System.out.print(" Enter information for Allergies(if there are otherwise enter Null):");
            String allergy = scanner.nextLine();
            setAllergy(allergy);

            System.out.println(" Enter Chronic disease if any(otherwise enter null):");
            String chronicDisease = scanner.nextLine();
            setChronicDisease(chronicDisease);

            System.out.println(" Enter your insurance number:");
            String insuranceNo = scanner.nextLine();
            setInsuranceNo(insuranceNo);

            System.out.println(" Enter your donar card number (if you have):");
            String donorCardNo = scanner.nextLine();
            setDonorCardNo(donorCardNo);

            System.out.println(" Enter your family members identity code: ");
            String familyMemberCode = scanner.nextLine();
            setFamilyMemberCode(familyMemberCode);

            System.out.println("If would you like to be a volunteer please enter yes otherwise no");
            String volunteer = scanner.nextLine();
            setVolunteer(volunteer);


            System.out.println("Please check the details and if you are sure then press 1");

            // Showing user its entered values in order to confirm it

            System.out.println("[firstName:" + patientBasicDetails.getFirstName() + ", lastName:" +
                    patientBasicDetails.getLastName() + ", gender:" + patientBasicDetails.getGender() + ", dateOfBirth:" +
                    patientBasicDetails.getDob()+ ", contactNo:" + patientBasicDetails.getContactNo() +", address:" +patientBasicDetails.getAddress()+", password:"
                    +patientBasicDetails.getPassword()+" ,emailId:"+patientBasicDetails.getEmailId()+ ", " +
                    "firstAnswer:" +firstAnswer+", secondAnswer:"+secondAnswer+", thirdAnswer:"+
                    thirdAnswer+", bloodGroup:"+bloodGroup+", allergies:"+allergy+", chronicDisease:"+
                    chronicDisease+", insuranceNo:"+insuranceNo+ ", donarCardNo:"+donorCardNo+
                    ", familyMemberCode:"+familyMemberCode+", volunteer:"+volunteer+"]");

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// update method to insert values in the database after user's choice is entered

    public void update() throws ClassNotFoundException, SQLException, IOException
    {
            System.out.println("Inserting values in the database");
                   //Setting up the connection with the database
//                    String driver = "com.mysql.cj.jdbc.Driver";
//                    String url = "jdbc:mysql://localhost:3306/trytest";
//                    String uname = "root";
//                    String pass = "";
//                    Class.forName(driver);

//                    Connection c = DriverManager.getConnection(url, uname, pass);
                    DbConnection one = new DB_Connection("src/main/resources/config_test.properties");
                    Connection c = one.createConnection();
                    //prepare statment to insert values in the database
                    PreparedStatement test = c.prepareStatement("INSERT INTO `userinfo`(firstname,lastname," +
                            "dateofbirth,gender,password,emailId,address,contactNo,firstAnswer,secondAnswer,thirdAnswer," +
                            "bloodGroup,allergy,chronicDisease,insuranceNo,donorCardNo,familyMemberCode,volunteer)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    //inserting values one by one for each entities

                    test.setString(1, patientBasicDetails.getFirstName());
                    test.setString(2, patientBasicDetails.getLastName());
                    test.setString(3, patientBasicDetails.getDob());
                    test.setString(4, patientBasicDetails.getGender());
                    test.setString(5, patientBasicDetails.getPassword());
                    test.setString(6, patientBasicDetails.getEmailId());
                    test.setString(7, patientBasicDetails.getAddress());
                    test.setString(8, patientBasicDetails.getContactNo());
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
                    System.out.println(patientBasicDetails.getFirstName()+"  has successfully Registered");
                    System.out.println("Now you would be able to login main menu");
                    WelcomePage init = new WelcomePage();
                    init.display();
    }

    public void get(String Email) throws SQLException, ClassNotFoundException, IOException {
//                String driver = "com.mysql.cj.jdbc.Driver";
//                String url = "jdbc:mysql://localhost:3306/trytest";
//                String uname = "root";
//                String pass = "";
//                Class.forName(driver);
                DbConnection two = new DB_Connection("src/main/resources/config_test.properties");
                Connection c = two.createConnection();
                this.em = Email;
                System.out.println("Fetching value for the user whose EmailId:"+em);
                String sqlStmt = "SELECT * FROM userinfo where emailId =?";
                PreparedStatement prepStmt = c.prepareStatement(sqlStmt);
                prepStmt.toString();
                prepStmt.setString(1,em);
                ResultSet rs = prepStmt.executeQuery();
                while(rs.next()){
                    //Display values
                    System.out.println("Firstname: " + rs.getString("firstname"));
                    System.out.println("Lastname: " + rs.getString("lastname"));
                    System.out.println("Date of birth: " + rs.getString("dateofbirth"));
                    System.out.println("Gender: " + rs.getString("gender"));
                    System.out.println("EmailId: " + rs.getString("emailId"));
                    System.out.println("Address: " + rs.getString("address"));
                    System.out.println("BloodGroup: " + rs.getString("bloodGroup"));
                    System.out.println("Allergy: " + rs.getString("allergy"));
                    System.out.println("ChronicDisease: " + rs.getString("chronicDisease"));
                    System.out.println("InsuranceNo: " + rs.getString("insuranceNo"));
                    System.out.println("DonorCardNo: " + rs.getString("insuranceNo"));
                    System.out.println("FamilyMemberCode: " + rs.getString("familyMemberCode"));
                    System.out.println("Volunteer: " + rs.getString("volunteer"));
                }

    }

}





