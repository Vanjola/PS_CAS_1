/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vanja
 */
public class Konekcija {
    private static Konekcija instance;
    private Connection connection;

    public Konekcija() {
        try {
            String url="jdbc:mysql://localhost:3306/ps_sql_1";
            String user="root";
            String password="";
            connection=DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public Connection getConnection() {
        return connection;
    }

    public static Konekcija getInstance(){
        if(instance==null){
            instance=new Konekcija();
        }
        return instance;
}
}
