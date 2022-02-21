/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mysql.cj.Messages;
import entities.Restaurant;
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
            String querry = "INSERT INTO `restaurant` (`id_restaurant`,`nom_restaurant`,`adresse_restaurant`,`telephone_restaurant`,`siteweb_restaurant`,`specialite_restaurant`,`id_gerant`,`image`,`statut_supprime`,`nb_placeResto`) VALUES('" + p.getId_restaurant()+ "','" + p.getNom_restaurant() + "','" + p.getAdresse_restaurant()+ "','" + p.getTelephone_restaurant()+ "','" + p.getSiteweb_restaurant()+ "','" + p.getSpecialite_restaurant()+ "','" + p.getId_gerant() + "','" + p.getImage()+ "','" + p.getStatut_supprime() + "','" +p.getNb_placeResto()+"')";
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
            String req = "SELECT * FROM restaurant WHERE `statut_supprime` = 1";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Restaurant.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10)));
               
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
            String req = " UPDATE `restaurant` SET `statut_supprime` = 0  WHERE `id_restaurant` = '" + p.getId_restaurant()+ "'";
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
    
     
       
        
     try { 
         System.out.println("nombre de place = " +P.getNb_placeResto());
          System.out.println("nombre de place = " +P.getId_restaurant());
            String req = " UPDATE `restaurant` SET `nb_placeResto`  = '" + P.getNb_placeResto()+ "' - '"+nbPlace_reservation+"'  WHERE `id_restaurant` = '" + P.getId_restaurant()+ "' ";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
       
        
     } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true; 
    }

  

    
  
    
    
}
