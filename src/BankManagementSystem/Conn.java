package BankManagementSystem;

import java.sql.*;

public class Conn {
    Connection c;
    public Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///Bankmanagementsystem", "root", "admin");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}