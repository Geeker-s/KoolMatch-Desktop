/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author dedpy
 */
public class ServiceUser implements IService<User> {
    
    private Connection cnx;
    private static final String SQL_FIND = "select * from user where id_user = :id";
    
    public ServiceUser() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(User p) {
        try {
            String querry = "INSERT INTO `user`( `email_user`, `password_user`, `nom_user`, `prenom_user`,`dateNaissance_user`,`sexe_user`,`telephone_user`,`photo_user`,`description_user`,`maxDistance_user`,`preferredMinAge_user`,`preferredMaxAge_user`,`adresse_user`,`latitude`,`longitude`,`Interet_user`,`archive`) VALUES ('" + p.getEmail_user() + "','" + p.getPassword_user() + "','" + p.getNom_user() + "','" + p.getPrenom_user() + "','" + p.getDateNaissance_user() + "','" + p.getSexe_user() + "','" + p.getTelephone_user() + "','" + p.getPhoto_user() + "','" + p.getDescription_user() + "','" + p.getMaxDistance_user() + "','" + p.getPreferredMinAge_user() + "','" + p.getPreferredMaxAge_user() + "','" + p.getAdresse_user() + "','" + p.getLatitude_user() + "','" + p.getLongitude_user() + "','" + p.getInteret_user() + "','" + p.getArchive() + "')";
            Statement stm = cnx.createStatement();
            
            stm.executeUpdate(querry);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<User> afficher() {
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user where archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getDouble(15), rs.getDouble(16), rs.getInt(17)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return users;
    }
    
    @Override
    public boolean modifer(User p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Description : ");
        String description_user = sc.nextLine();
        try {
            String req = " UPDATE `user` SET `description_user` = '" + description_user + "' WHERE `id_user` = '" + p.getId_user() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public boolean supprimer(User p) {
        String req = "update user set archive = 1 where id_user='" + p.getId_user() + "'";
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("user supprimée");
        
        return true;
    }


    public Boolean login(String u, String p) throws SQLException {
        String req = "SELECT * FROM `user` WHERE email_user =\'" + u + "\' and password_user=\'" + p + "\'";
        User user = new User();
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            System.out.println(rs);
            if (rs != null) {
                while (rs.next()) {
                    
                    user.setId_user(rs.getInt("id_user"));
                    user.setNom_user(rs.getString("nom_user"));
                    user.setPrenom_user(rs.getString("prenom_user"));
                    user.setEmail_user(rs.getString("email_user"));
                    user.setPassword_user(rs.getString("password_user"));
                    user.setDateNaissance_user(rs.getDate("dateNaissance_user"));
                    user.setSexe_user(rs.getString("sexe_user"));
                    user.setAdresse_user(rs.getString("adresse_user"));
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }
    
    public User AssignCurrentUser(String u, String p) throws SQLException {
        User user = new User();
        String req = "SELECT * FROM `user` WHERE email_user =\'" + u + "\' and password_user=\'" + p + "\'";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            if (rs != null) {
                while (rs.next()) {
                    user.setId_user(rs.getInt("id_user"));
                    user.setTelephone_user(rs.getInt("telephone_user"));
                    user.setPhoto_user(rs.getString("photo_user"));
                    user.setNom_user(rs.getString("nom_user"));
                    user.setPrenom_user(rs.getString("prenom_user"));
                    user.setEmail_user(rs.getString("email_user"));
                    user.setPassword_user(rs.getString("password_user"));
                    user.setDateNaissance_user(rs.getDate("dateNaissance_user"));
                    user.setSexe_user(rs.getString("sexe_user"));
                    user.setAdresse_user(rs.getString("adresse_user"));
                    user.setDescription_user(rs.getString("description_user"));
                    user.setMaxDistance_user(rs.getInt("maxDistance_user"));
                    user.setPreferredMinAge_user(rs.getInt("preferredMinAge_user"));
                    user.setPreferredMaxAge_user(rs.getInt("preferredMaxAge_user"));
                    user.setLatitude_user(rs.getDouble("latitude_user"));
                    user.setLongitude_user(rs.getDouble("longitude_user"));
                    user.setInteret_user(rs.getInt("interet_user"));

                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return user;
    }
    
    @Override
    public List<User> rechercher(User p) {
        List<User> u = afficher();
        return u.stream().filter(b -> b.getId_user() == p.getId_user()).collect(Collectors.toList());
    }
    
    public boolean checkEmail(String email_user) {
        boolean success = false;
        try {
            Statement stm = cnx.createStatement();
            
            String req = "SELECT email_user FROM user where archive = 0 ";
            ResultSet rs = stm.executeQuery(req);
            rs = stm.executeQuery(req);
            
            while (rs.next()) {
                if (email_user.equals(rs.getString(1))) {
                    System.out.println("Adresse utilisé");
                } else {
                    System.out.println("Vous pouvez utilisé cette adresse");
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
        
    }
}
