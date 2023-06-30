/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author brahim
 */
public class DBConnexion {
      private String url="jdbc:mysql://127.0.0.1:3306/db_campi";
    private String userName="root";
    private String password="";
    
    private Connection cnx;
    private static DBConnexion instance;
    
    private DBConnexion(){
        
        try {
            cnx= (Connection) DriverManager.getConnection(url,userName,password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
    }
    
    public static DBConnexion getInstance(){
        if (instance == null)
            instance = new DBConnexion();
        return (instance);
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
}
