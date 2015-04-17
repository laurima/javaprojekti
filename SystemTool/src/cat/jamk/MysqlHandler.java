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
    private boolean isConnection;
    private boolean isUserInDB;
    private Connection conn;
    private Statement stmt;
    private String query;  
    private String searchcolumn;
    
    // Results
    private ResultSet rs;
    private String result;
    
    // Konstruktori
    public MysqlHandler() {
        
        isConnection = false;
        driver = "com.mysql.jdbc.Driver";
        db_url = "jdbc:mysql://mysql.labranet.jamk.fi/H8543";
        user = "H8543";
        pass = "7qZZ6Iex5Ni84fuRl0IhbsMPyiY7f4ED";
        conn = null;
        stmt = null;
        rs = null;
        query = "";
        result = "";
        searchcolumn = "";
        isUserInDB = false;

    }
    
    // Connectionin tsekkaaminen
    public boolean isConnection() {
        connect();
        disconnect();
        return isConnection;
    }

    // Connect
    private void connect() {
        try {
            // JDBC driverin rekisteröinti
            Class.forName("com.mysql.jdbc.Driver");
            // Avataan connection
            conn = DriverManager.getConnection(db_url, user, pass);
            isConnection = true;
        } catch (Exception e) {
            isConnection = false;
            //System.out.println(e);
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
    
    // Käyttäjän lisääminen tietokantaan
    public void insertNewUser(String mac, String computername, String username, String country, String language) {
        query = "insert into tbl_users (mac, computername, user, country, lang) values ('" + mac + "', '" + computername + "', '" + username + "',' " + country + "', '" + language + "');";
        executeQuery(query);
    }
    
    // Käyttäjän tsekkaaminen tietokannasta
    public boolean isUserInDB (String mac) {
        query = "select user from tbl_users where mac = '" + mac + "';";
        
        if (searchDB(query, "user") != null) {
            isUserInDB = true;
        } else {
            isUserInDB = false;  
        }
        return isUserInDB;
    }
    
    // Kyselyn toteuttaminen
    private void executeQuery(String query) {
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            disconnect();
        }
    }
    
    // Tietokannasta etsiminen
    private String searchDB(String query, String searchcolumn) {
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = rs.getString(searchcolumn);
            }
        } catch (Exception e) {
            result = null;
            System.out.println(e);
        } finally {
            disconnect();
        }
        
        return this.result;
    }
    
    // Translate
    // Parametrit: Käännettävän ohjelman/prosessin nimi ja suunta käännökselle
    // Palauttaa käännöksen
    // esimerkki kutsumisesta: translate("chrome.exe", "software");
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
        
        this.result = searchDB(query, searchcolumn);

        return this.result;
    }
}
