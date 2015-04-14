/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.jamk;

/**
 *
 * @author Sami
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MysqlHandler {
    
    // Driver ja database url
    private String driver;
    private String db_url;
    
    // Kirjautumisinfot
    private String user;
    private String pass;
    
    // Connection ja statement
    Connection conn;
    Statement stmt;
    
    // Results
    String result;
    
    public MysqlHandler() {
        driver = "com.mysql.jdbc.Driver";
        db_url = "jdbc:mysql://student.labranet.jamk.fi";
        user = "H8543";
        pass = "7qZZ6Iex5Ni84fuRl0IhbsMPyiY7f4ED"; // TODO: lisää passu
        conn = null;
        stmt = null;
        result = "";
    }
    
    // Connect
    public void connect() {
        try {
            // JDBC driverin rekisteröinti
            Class.forName("com.mysql.jdbc.Driver");
            // Avataan connection
            conn = DriverManager.getConnection(db_url, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Disconnect
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Insert
    public void insert(String insertvalue) {
        
    }
    // Read
    public String read(String readvalue) {
        
        return this.result;
    }
}
