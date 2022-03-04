/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Admin;
import tn.edu.esprit.model.User;
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
 * @author MED ZOUARI
 */
public class ServiceAdmin implements IService<Admin> {

    private Connection cnx;

    public ServiceAdmin() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Admin p) {
        try {
            String querry = "INSERT INTO `admin`( `login_admin`, `password_admin`, `archive`) VALUES ('" + p.getLogin_admin() + "' ,'" + p.getPassword_admin() + "','"+p.getArchive()+"')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Admin> afficher() {
        List<Admin> admins = new ArrayList<>();
        try {
            String req = "SELECT * FROM admin where archive = 0";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                admins.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return admins;
    }

    @Override
    public boolean modifer(Admin p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mot de passe : ");
        String password_admin = sc.nextLine();
        try {
            String req = " UPDATE `admin` SET `password_admin` = '" + password_admin + "' WHERE `id_admin` = '" + p.getId_admin() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Admin p) {
        String req = "update admin set archive = 1 where id_admin='" + p.getId_admin() + "'";
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("admin supprimée");

        return true;

    }

    public boolean login(String login_admin, String password_admin) {
        boolean success = false;
        try {
            Statement stm = cnx.createStatement();

            String req = "SELECT password_admin FROM admin WHERE login_admin='" + login_admin + "'";
            ResultSet rs = stm.executeQuery(req);
            rs = stm.executeQuery(req);

            while (rs.next()) {
                if (password_admin.equals(rs.getString(1)))
                    System.out.println("Bienvenue");
                else
                    System.out.println("Vérifier mot de passe");
                return false;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    @Override
    public List<Admin> rechercher(Admin p) {
        List<Admin> a = afficher();
        return  a.stream().filter(b -> b.getId_admin() == p.getId_admin()).collect(Collectors.toList());  
    }

    

}
