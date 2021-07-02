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

    public DB_Connection(String configFile,String u_name,String u_pass) {
    this.configFile=configFile;
    this.u_name=u_name;
    this.u_pass=u_pass;


    }

    public boolean[] getDetails() throws ClassNotFoundException, IOException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");



        f1 = new FileInputStream(configFile);


        pr = new Properties();
        pr.load(f1);

        url = pr.getProperty("database");

        username = pr.getProperty("user");
        password = pr.getProperty("password");

        connection = DriverManager.getConnection(url, username, password);

        PreparedStatement p1 = connection.prepareStatement("select * from trial where name=? and id=?");
        p1.setString(1, u_name);
        p1.setString(2, u_pass);
        System.out.println("Connection established successfully");
        ResultSet b = p1.executeQuery();

        while (b.next())
        {
            name=b.getString("name");
            System.out.println(b.getString("name"));
            pass=b.getString("id");
            if(name.equals(u_name))
            {
            res_id = true;
            if(pass.equals(u_pass))
            {
                res_pass=true;
            }
            }
            cred_validity[0]=res_id;
            cred_validity[1]=res_pass;
        }
        return cred_validity;
    }


}
