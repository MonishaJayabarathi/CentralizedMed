package com.centrailized_medi_application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;



public class DB_Connection {

    private String url;
    private String username;
    private String password;
    private Connection connection=null;
    private  boolean res_id=false;
    private  boolean res_pass=false;
    private String configFile;
    private String u_name;
    private String u_pass;
    private  FileInputStream f1 = null;
    Properties pr = null;
    private String name;
    private String pass;
    private boolean[] cred_validity=new boolean[2];

    public DB_Connection(String configFile,String u_name,String u_pass) throws IOException, ClassNotFoundException, SQLException {
    this.configFile=configFile;
    this.u_name=u_name;
    this.u_pass=u_pass;
    connection = DriverManager.getConnection(url, username, password);
    }
    public DB_Connection(String configFile) throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        f1 = new FileInputStream(configFile);


        pr = new Properties();
        pr.load(f1);

        url = pr.getProperty("database");
        username = pr.getProperty("user");
        password = pr.getProperty("password");
        connection = DriverManager.getConnection(url, username, password);

    }
    public Connection createConnection()
    {

        return connection;
    }


    public boolean[] getDetails() throws ClassNotFoundException, IOException, SQLException {





        PreparedStatement p1 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=?");
        p1.setString(1, u_name);
        ResultSet login_name = p1.executeQuery();
        // and pass=?
        // p1.setString(2, u_pass);
        while (login_name.next())
        {
            name=login_name.getString("user_name");
            //System.out.println(b.getString("user_name"));
            if(name.equals((this.u_name)))
            {
                res_id = true;
            }

            PreparedStatement p2 = connection.prepareStatement("select * from CSCI5308_5_TEST.login_details where user_name=? and pass=?");
            p2.setString(1, this.u_name);
            p2.setString(2, this.u_pass);
            ResultSet login_pass  = p2.executeQuery();
            while (login_pass.next()) {

                pass = login_pass.getString("pass");
                if (pass.equals(this.u_pass)) {
                    res_pass = true;
                }
            }
            cred_validity[0]=res_id;
            cred_validity[1]=res_pass;
        }
        return cred_validity;
    }


}
