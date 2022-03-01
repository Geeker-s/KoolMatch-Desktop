/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.event;
import entities.invitation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author Asus
 */
public class ServiceEvent implements IService<event> {
    
    private Connection cnx;
    

    public ServiceEvent() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter( event p) {
 try {
             String querry="INSERT INTO `evenement`( `nom_event`, `dd_event`, `df_event`, `theme_event`, `adresse_event`, `telephone`) VALUES ('"+p.getNom_event()+"','"+p.getDd_event()+"','"+p.getDf_event()+"','"+p.getTheme_event()+"','"+p.getAdresse_event()+"','"+p.getTelephone()+"' )";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    
    @Override
    public List<event> afficher() {
        List<event> events = new ArrayList<>();
        try {
            String req = "SELECT * FROM evenement  WHERE archive = 0 " ;
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
            events.add(new event(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8) ) )  ; 
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return events ;
    }
     
   

    @Override
    public boolean modifer(event p) {
        
           Scanner sc = new Scanner(System.in);
        System.out.println("nom event : ");
        String nom_event = sc.nextLine();
          try {
           String req = " UPDATE `evenement` SET `nom_event` = '" + nom_event+ "' WHERE `id_event` = '" + p.getId_event() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
             
    

    @Override
    public boolean supprimer(event p) {
         try {
              
            String querry = "update evenement set archive = 1  WHERE id_event = '" + p.getId_event() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
   public List<event> Recherche(event p) {
        List<event> events = afficher();
         return events.stream().filter(b -> b.getNom_event().equals( p.getNom_event())).collect(Collectors.toList());
    }
    
    
     public List<event> Tri() {
        Comparator<event> comparator = Comparator.comparing(event::getDd_event);
        List<event> events = afficher();
        return events.stream().sorted(comparator).collect(Collectors.toList());
    }

   

   

   
}
