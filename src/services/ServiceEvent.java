/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
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
             String querry="INSERT INTO `evenement`( `nom_event`, `dd_event`, `df_event`, `theme_event`, `adresse_event`, `telephone`) VALUES ('"+p.getNom_event()+"','"+p.getDd_event()+"','"+p.getDf_event()+"','"+p.getTheme_event()+"','"+p.getAdresse_event()+"','"+p.getTelephone()+"')";
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
            String req = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
            events.add(new event(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return events;
    }

    @Override
    public boolean modifer(event p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(event p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
