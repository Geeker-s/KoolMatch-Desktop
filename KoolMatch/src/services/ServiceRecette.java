/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Recette;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.MyDB;

/**
 *
 * @author dedpy
 */
public class ServiceRecette implements IService<Recette> {

    private Connection cnx;

    public ServiceRecette() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Recette r) {
        try {
             String querry="INSERT INTO `recette`(`nom_recette`, `photo_recette`,`description_recette`,`categorie_recette`,`duree_recette`) VALUES ('"+r.getNom_recette()+"','"+r.getPhoto_recette()+"','"+r.getDescription_recette()+"','"+r.getCategorie_recette()+"','"+r.getDuree_recette()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<Recette> afficher() {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = "SELECT * FROM recette";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Recette.add(new Recette(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }

    @Override
    public boolean modifer(Recette r) {
        Scanner sc = new Scanner(System.in);
        System.out.println("description recette : ");
        String description_recette = sc.nextLine();
          try {
           String req = " UPDATE recette SET description_recette = '" + description_recette+ "' WHERE id_recette = '" + r.getId_recette()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Recette r) {
         try {
            String querry = "DELETE FROM recette WHERE id_recette = '" + r.getId_recette()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    
    }

}
