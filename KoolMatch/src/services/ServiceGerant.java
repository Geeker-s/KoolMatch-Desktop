/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.gerant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.MyDB;

/**
 *
 * @author MED ZOUARI
 */
public class ServiceGerant implements IService<gerant> {
 private Connection cnx;

    public ServiceGerant() {
        cnx = MyDB.getInstance().getCnx();
    }
    @Override
    public void ajouter(gerant p) {
        try {
             String querry="INSERT INTO `gerant`( `nom_gerant`, `prenom_gerant`, `telephone_gerant`, `dd_abonnement`, `df_abonnement`,`archive`) VALUES ('"+p.getNom_gerant()+"' ,'"+p.getPrenom_gerant()+"','"+p.getTelephone_gerant()+"','"+p.getDd_abonnement()+"','"+p.getDf_abonnement()+"','"+p.getArchive()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<gerant> afficher() {
        List<gerant> gerants = new ArrayList<>();
        try {
            String req = "SELECT * FROM gerant where archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                gerants.add(new gerant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDate(6)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return gerants;
    }

    @Override
    public boolean modifer(gerant p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numéro téléphone gérant : ");
        String telephone_gerant = sc.nextLine();
          try {
           String req = " UPDATE `gerant` SET `telephone_gerant` = '" + telephone_gerant+ "' WHERE `id_gerant` = '" + p.getId_gerant() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(gerant p) {
 String req = " update gerant set archive = 1 where id_gerant='" + p.getId_gerant() + "'";
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("Gérant supprimée");

        return true;
    }

    @Override
    public List<gerant> rechercher(gerant p) {
        List<gerant> g = afficher();
        return  g.stream().filter(b -> b.getId_gerant() == p.getId_gerant()).collect(Collectors.toList());  
    }

    




}
