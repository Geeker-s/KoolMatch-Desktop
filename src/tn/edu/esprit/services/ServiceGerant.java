/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Gerant;
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
public class ServiceGerant implements IService<Gerant> {

    private Connection cnx;

    public ServiceGerant() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Gerant p) {
        try {
            String querry = "INSERT INTO `gerant`( `nom_gerant`, `prenom_gerant`,`email_gerant`,`password_gerant`, `telephone_gerant`, `dd_abonnement`, `df_abonnement`,`archive`) VALUES ('" + p.getNom_gerant() + "' ,'" + p.getPrenom_gerant() + "','" + p.getEmail_gerant() + "','" + p.getPassword_gerant() + "','" + p.getTelephone_gerant() + "','" + p.getDd_abonnement() + "','" + p.getDf_abonnement() + "','" + p.getArchive() + "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Gerant> afficher() {
        List<Gerant> gerants = new ArrayList<>();
        try {
            String req = "SELECT * FROM gerant where archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                gerants.add(new Gerant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getDate(8)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return gerants;
    }

    @Override
    public boolean modifer(Gerant p) {

        try {
            String req = " UPDATE `gerant` SET `nom_gerant`= '" + p.getNom_gerant() + "' , "
                    + "`prenom_gerant`='" + p.getPrenom_gerant() + "' ,"
                    + "`email_gerant`='" + p.getEmail_gerant() + "',"
                    + "`password_gerant`='" + p.getPassword_gerant() + "',"
                    + "`telephone_gerant`='" + p.getTelephone_gerant() + "',"
                    + "`dd_abonnement`='" + p.getDd_abonnement() + "',"
                    + "`df_abonnement` = '" + p.getDf_abonnement() + "' WHERE `id_gerant` = '" + p.getId_gerant() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Gerant p) {
        String req = "update gerant set archive = 1 where id_gerant='" + p.getId_gerant() + "'";
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("gerant supprimée");

        return true;
    }

    public Boolean login(String u, String p) throws SQLException {
        String req = "SELECT * FROM `gerant` WHERE email_gerant =\'" + u + "\' and password_gerant=\'" + p + "\'";
        Gerant a = new Gerant();
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            System.out.println(rs);
            if (rs != null) {
                while (rs.next()) {

                    a.setId_gerant(rs.getInt("id_gerant"));
                    a.setEmail_gerant(rs.getString("email_gerant"));
                    a.setPassword_gerant(rs.getString("password_gerant"));
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return false;
    }

    public Gerant AssignCurrentGerant(String u, String p) throws SQLException {
        Gerant g = new Gerant();
        String req = "SELECT * FROM `gerant` WHERE email_gerant =\'" + u + "\' and password_gerant=\'" + p + "\'";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            if (rs != null) {
                while (rs.next()) {
                    g.setId_gerant(rs.getInt("id_gerant"));
                    g.setNom_gerant(rs.getString("nom_gerant"));
                    g.setPrenom_gerant(rs.getString("prenom_gerant"));
                    g.setEmail_gerant(rs.getString("email_gerant"));
                    g.setPassword_gerant(rs.getString("password_gerant"));
                    g.setTelephone_gerant(rs.getInt("telephone_gerant"));
                    g.setDd_abonnement(rs.getDate("dd_abonnement"));
                    g.setDf_abonnement(rs.getDate("df_abonnement"));

                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return g;
    }

    @Override
    public List<Gerant> rechercher(Gerant p) {
        List<Gerant> g = afficher();
        return g.stream().filter(b -> b.getId_gerant() == p.getId_gerant()).collect(Collectors.toList());
    }

}
