/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.mysql.cj.Messages;
import com.teamdev.jxmaps.a;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author BAZINFO
 */
public class ServiceRestaurant implements IService<Restaurant> {

    private final Connection cnx;
    Alert b = new Alert(AlertType.NONE);

    public ServiceRestaurant() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Restaurant p) {
        try {
            String querry = "INSERT INTO `restaurant` (`id_restaurant`,`nom_restaurant`,`adresse_restaurant`,`telephone_restaurant`,`siteweb_restaurant`,`specialite_restaurant`,`id_gerant`,`image`,`archive`,`nb_placeResto`,`image_structure_resturant`,`description`,`lien`) VALUES('" + p.getId_restaurant() + "','" + p.getNom_restaurant() + "','" + p.getAdresse_restaurant() + "','" + p.getTelephone_restaurant() + "','" + p.getSiteweb_restaurant() + "','" + p.getSpecialite_restaurant() + "','" + p.getId_gerant() + "','" + p.getImage() + "','" + p.getArchive() + "','" + p.getNb_placeResto() + "','" + p.getImage_structure_resturant() + "','" + p.getDescription() + "','" + p.getLien() + "')";
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
            String req = "SELECT * FROM restaurant WHERE `archive` = 0";

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Restaurant.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Restaurant;
    }

     public List<Restaurant> MesResto() {
        List<Restaurant> Restaurant = new ArrayList<>();
        try {
            String req = "SELECT * FROM restaurant WHERE `archive` = 1 AND id_gerant="+CurrentUser.getId_user();
                    //+ CurrentUser.getId_user();

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Restaurant.add(new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Restaurant;
    }

    

    public Restaurant GetRestobyid(int b) throws SQLException {

        //-------------------- Update ----------//
        Restaurant pr = new Restaurant();

        String query = "select * from restaurant where id_restaurant = ? ";
        PreparedStatement ps;
        try {
            ps = MyDB.getInstance().getCnx().prepareCall(query);
            ps.setInt(1, b);
            ResultSet rest = ps.executeQuery();

            while (rest.next()) {
                pr.setId_restaurant(rest.getInt("id_restaurant"));
                pr.setNom_restaurant(rest.getString("nom_restaurant"));
                pr.setAdresse_restaurant(rest.getString("adresse_restaurant"));
                pr.setTelephone_restaurant(rest.getInt("telephone_restaurant"));
                pr.setSiteweb_restaurant(rest.getString("siteweb_restaurant"));
                pr.setSpecialite_restaurant(rest.getString("specialite_restaurant"));
                pr.setId_gerant(rest.getInt("id_gerant"));
                pr.setImage(rest.getString("image"));
                pr.setArchive(rest.getInt("archive"));
                pr.setNb_placeResto(rest.getInt("nb_placeResto"));
                pr.setImage_structure_resturant(rest.getString("image_structure_resturant"));

                pr.setDescription(rest.getString("description"));
                pr.setLien(rest.getString("lien")
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;

    }

    /*
    public boolean modifer(Restaurant p) {

       

        try {

            String req = " UPDATE `restaurant` SET `nom_restaurant` = '" + p.getNom_restaurant() + "' WHERE `id_restaurant` = '" + p.getId_restaurant() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }*/
    public void UpdateResto(Restaurant b) throws SQLException {
        //-------------------- Update ----------//

        String reqUp = " UPDATE`restaurant` SET `nom_restaurant` =? ,`adresse_restaurant` =?,`telephone_restaurant` =?,`siteweb_restaurant` =?,`specialite_restaurant` =?,`image` =?,`nb_placeResto` =?, `description` =? WHERE`id_restaurant`=? ";

        PreparedStatement pss = MyDB.getInstance().getCnx().prepareStatement(reqUp);

        pss.setString(1, b.getNom_restaurant());
        pss.setString(2, b.getAdresse_restaurant());
        pss.setInt(3, b.getTelephone_restaurant());
        pss.setString(4, b.getSiteweb_restaurant());
        pss.setString(5, b.getSpecialite_restaurant());
        pss.setString(6, b.getImage());
        pss.setInt(7, b.getNb_placeResto());
        pss.setString(8, b.getDescription());
        pss.setInt(9, b.getId_restaurant());

        pss.executeUpdate();

    }

    @Override
    public boolean supprimer(Restaurant p) {

        try {
            String req = " UPDATE `restaurant` SET `archive` = 1  WHERE `id_restaurant` = '" + p.getId_restaurant() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateNbrPlace(Restaurant P, int nbPlace_reservation) {
        /* if(P.getNb_placeResto()< nbPlace_reservation)
     {*/
        try {
            /* System.out.println("nombre de place = " +P.getNb_placeResto());
          System.out.println("nombre de place = " +P.getId_restaurant());*/
            String req = " UPDATE `restaurant` SET `nb_placeResto`  = '" + P.getNb_placeResto() + "' - '" + nbPlace_reservation + "'  WHERE `id_restaurant` = '" + P.getId_restaurant() + "' ";
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
        return a.stream().filter(b -> (b.getAdresse_restaurant().equals(p.getAdresse_restaurant()))).collect(Collectors.toList());

    }

    public List<Restaurant> rechercherSpecialite(Restaurant p) {
        List<Restaurant> a = afficher();
        return a.stream().filter(b -> (b.getSpecialite_restaurant().equals(p.getSpecialite_restaurant()))).collect(Collectors.toList());
    }

    public Iterable<Restaurant> RechercheRestaurantsParNom(String recherche) {
        List ALLproducts = new ArrayList();
        try {
            String query = "select * from restaurant WHERE  archive =0 and  nom_restaurant LIKE '%" + recherche + "%';";
            Statement st = MyDB.getInstance().getCnx().createStatement();
            ResultSet rest = st.executeQuery(query);
            while (rest.next()) {
                Restaurant pr = new Restaurant();

                pr.setId_restaurant(rest.getInt("id_restaurant"));
                pr.setNom_restaurant(rest.getString("nom_restaurant"));
                pr.setAdresse_restaurant(rest.getString("adresse_restaurant"));
                pr.setTelephone_restaurant(rest.getInt("telephone_restaurant"));
                pr.setSiteweb_restaurant(rest.getString("siteweb_restaurant"));
                pr.setSpecialite_restaurant(rest.getString("specialite_restaurant"));
                pr.setLien(rest.getString("lien"));
                pr.setImage(rest.getString("image"));

                ALLproducts.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ALLproducts;

    }

    @Override
    public boolean modifer(Restaurant p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
