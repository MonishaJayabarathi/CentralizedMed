package com.centrailized_medi_application;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Properties;

/**
 * author:Ridampreet Singh
 * DbConnection interface implemented by the classes.
 * Constructors take parameters as config file to get database details.
 * getDetails()-method will return boolean array containing the validity status of the entered credentials.
 * createConnection()-returns a connection so that the interaction with the database can begin.
 */
public class DB_Connection implements DbConnection {

    private String url;
    private String username;
    private String password;
    private Connection connection=null;
    private  boolean res_id=false;
    private  boolean res_pass=false;
    private String configFile;
    private String u_name;
    private String u_pass;
    //private  FileInputStream f1 = null;
    Properties pr = null;
    private String name;
    private String pass;
    private boolean[] cred_validity=new boolean[2];

    public DB_Connection(String configFile,String u_name,String u_pass) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //f1 = new FileInputStream(configFile);
        String[] fullFileName = configFile.split("/", 0);
        String fileName = fullFileName[3];

        InputStream f1 = getClass().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(f1, StandardCharsets.UTF_8));

        pr = new Properties();
        pr.load(f1);  //load the details from the properties file
        url = pr.getProperty("database");
        username = pr.getProperty("user");
        password = pr.getProperty("password");
        this.configFile = configFile;
        this.u_name = u_name;
        this.u_pass = u_pass;
        connection = DriverManager.getConnection(url, username, password);
    }
    public DB_Connection(String configFile) throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //f1 = new FileInputStream(configFile);
        String[] fullFileName = configFile.split("/", 0);
        String fileName = fullFileName[3];
        InputStream f1 = getClass().getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(f1, StandardCharsets.UTF_8));

        pr = new Properties();
        pr.load(f1); //load the details from the properties file
        url = pr.getProperty("database");
        username = pr.getProperty("user");
        password = pr.getProperty("password");
        connection = DriverManager.getConnection(url, username, password);

    }

    //return the connection created in the constructor of this class.
    @Override
    public Connection createConnection()
    {

        return connection;
    }

    //return credential array containing info if the username and password are valid.
    @Override
    public boolean[] getDetails() throws SQLException, IOException, ClassNotFoundException {
        DB_Layer db=new DB_Layer();
        return db.getCredStatus(u_name,u_pass);

    }


}
