/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author dedpy
 */
public class ServiceUser implements IService<user> {

    private Connection cnx;
    private static final String SQL_FIND = "select * from user where id_user = :id";

    public ServiceUser() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(user p) {
        try {
            String querry = "INSERT INTO `user`( `email_user`, `login_user`, `password_user`, `nom_user`, `prenom_user`,`dateNaissance_user`,`sexe_user`,`telephone_user`,`photo_user`,`description_user`,`maxDistance_user`,`preferredMinAge_user`,`preferredMaxAge_user`,`adresse_user`,`latitude`,`longitude`,`Interet_user`,`archive`) VALUES ('" + p.getEmail_user() + "' ,'" + p.getLogin_user() + "','" + p.getPassword_user() + "','" + p.getNom_user() + "','" + p.getPrenom_user() + "','" + p.getDateNaissance_user() + "','" + p.getSexe_user() + "','" + p.getTelephone_user() + "','" + p.getPhoto_user() + "','" + p.getDescription_user() + "','" + p.getMaxDistance_user() + "','" + p.getPreferredMinAge_user() + "','" + p.getPreferredMaxAge_user() + "','" + p.getAdresse_user() + "','" + p.getLatitude_user() + "','" + p.getLongitude_user() + "','" + p.getInteret_user() + "','" + p.getArchive() + "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<user> afficher() {
        List<user> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user where archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                users.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getDouble(16), rs.getDouble(17), rs.getInt(18)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return users;
    }

    @Override
    public boolean modifer(user p) {
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
    public boolean supprimer(user p) {
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

    public boolean login(String login_user, String password_user) {
        boolean success = false;
        try {
            Statement stm = cnx.createStatement();
            String req = "SELECT password_user FROM user WHERE login_user='" + login_user + "'";
            ResultSet rs = stm.executeQuery(req);
            rs = stm.executeQuery(req);
            while (rs.next()) {
                if (password_user.equals(rs.getString(1))) {
                    System.out.println("Bienvenue");
                } else {
                    System.out.println("Vérifier mot de passe");
                }
            return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    @Override
    public List<user> rechercher(user p) {
        List<user> u = afficher();
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
