/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author dedpy
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB {

    public final String url = "jdbc:mysql://127.0.0.1:3306/koolmatch";
    public final String login = "root";
    public final String pwd = "";

    Connection connexion;
    public static MyDB instance;

    private MyDB() {
        try {
            connexion = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie avec succes.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur de connexion.");

        }
    }

    public static MyDB getInstance() {
        if (instance == null) {
            instance = new MyDB();
        }

        return instance;
    }

    public Connection getCnx() {
        return connexion;
    }

}
