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
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlHandler {
    
    // Driver ja database url
    private String driver;
    private String db_url;
    
    // Kirjautumisinfot
    private String user;
    private String pass;
    
    // Connection, statement ja query
    private Connection conn;
    private Statement stmt;
    private String query;
    private String result;
    private String searchcolumn;
    
    // Results
    ResultSet rs;
    
    public MysqlHandler() {
        driver = "com.mysql.jdbc.Driver";
        db_url = "jdbc:mysql://mysql.labranet.jamk.fi/H8543";
        user = "H8543";
        pass = "7qZZ6Iex5Ni84fuRl0IhbsMPyiY7f4ED";
        conn = null;
        stmt = null;
        rs = null;
        query = "";
        result = "";
    }
    
    // Connect
    private void connect() {
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
    private void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Insert
    public void insert(String insertvalue) {
        
    }
    // Read
    public ResultSet read(String readvalue) {
        try {
            connect();
            conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            disconnect();
        }
        return this.rs;
    }
    
    // Translate
    // Parametrit: Käännettävä ohjelma/prosessi ja suunta käännökselle
    // Palauttaa käännöksen
    public String translate(String translate, String direction) {
        switch (direction) {
            case "software":
                query = "select ohjelma from tbl_translation where prosessi = \"" + translate + "\"";
                searchcolumn = "ohjelma";
                break;
            case "process":
                query = "select prosessi from tbl_translation where ohjelma = \"" + translate + "\"";
                searchcolumn = "prosessi";
                break;
        }
        
       try {
                    connect();
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        result = rs.getString(searchcolumn);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    disconnect();
                }
       
        return this.result;
    }
}
