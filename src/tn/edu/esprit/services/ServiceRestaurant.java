/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.mysql.cj.Messages;
import tn.edu.esprit.entities.Restaurant;
import tn.edu.esprit.entities.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author BAZINFO
 */
public class ServiceRestaurant implements IService<Restaurant>{

    private final Connection cnx;

    public ServiceRestaurant() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Restaurant p) {
        try {
            String querry = "INSERT INTO `restaurant` (`id_restaurant`,`nom_restaurant`,`adresse_restaurant`,`telephone_restaurant`,`siteweb_restaurant`,`specialite_restaurant`,`id_gerant`,`image`,`archive`,`nb_placeResto`,`image_structure_resturant`,`description`,`lien`) VALUES('" + p.getId_restaurant()+ "','" + p.getNom_restaurant() + "','" + p.getAdresse_restaurant()+ "','" + p.getTelephone_restaurant()+ "','" + p.getSiteweb_restaurant()+ "','" + p.getSpecialite_restaurant()+ "','" + p.getId_gerant() + "','" + p.getImage()+ "','" + p.getArchive()+ "','" +p.getNb_placeResto()+"','" +p.getImage_structure_resturant()+"','" +p.getDescription() +"','" +p.getLien()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

     @Override
    public List<Restaurant> afficher() {
        List<Restaurant> Restaurant = new ArrayList<>();
        try {
            String req = "SELECT * FROM restaurant WHERE `archive` = 1";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Restaurant.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13)));
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Restaurant;
    }


    @Override
    public boolean modifer(Restaurant p ) {
        
           Scanner sc = new Scanner(System.in);
             System.out.println("Nouveau Nom : ");
           String newNom = sc.nextLine();
     
       
        
     try { 
       
            String req = " UPDATE `restaurant` SET `nom_restaurant` = '" + newNom+ "' WHERE `id_restaurant` = '" + p.getId_restaurant()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
       
        
     } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Restaurant p) {
     /*   try {
            String querry = "DELETE FROM `restaurant` WHERE `id_restaurant` = '" + p.getId_restaurant()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
        }*/
       try {
            String req = " UPDATE `restaurant` SET `archive` = 0  WHERE `id_restaurant` = '" + p.getId_restaurant()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
        
        
    }
    
@Override
    public boolean updateNbrPlace(Restaurant P, int nbPlace_reservation) {
    
    /* if(P.getNb_placeResto()< nbPlace_reservation)
     {*/
     
     
     
       
        
     try { 
        /* System.out.println("nombre de place = " +P.getNb_placeResto());
          System.out.println("nombre de place = " +P.getId_restaurant());*/
            String req = " UPDATE `restaurant` SET `nb_placeResto`  = '" + P.getNb_placeResto()+ "' - '"+nbPlace_reservation+"'  WHERE `id_restaurant` = '" + P.getId_restaurant()+ "' ";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
       
         
     } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
     
             }
        return true; 
       
    }
    

     public List<Restaurant> rechercher(Restaurant p) {
        List<Restaurant> a = afficher();
        return  a.stream().filter(b -> ( b.getAdresse_restaurant().equals(p.getAdresse_restaurant()))).collect(Collectors.toList());  
    }
       public List<Restaurant> rechercherSpecialite(Restaurant p) {
        List<Restaurant> a = afficher();
        return  a.stream().filter(b -> ( b.getSpecialite_restaurant().equals(p.getSpecialite_restaurant()))).collect(Collectors.toList());  
    }

    @Override
    public void search(Restaurant p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<Restaurant> RechercheEvenementParNom(String recherche) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
  
       
   

        
        
    


   
  
    

    
    

  

    
  
    
    

