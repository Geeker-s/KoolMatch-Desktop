/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.conversations;
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
 * @author Guedo
 */
public class ServiceConversation implements IService<conversations>{

    private Connection cnx;

    public ServiceConversation() {
        cnx = MyDB.getInstance().getCnx();
    }
    @Override
    public void ajouter(conversations p) {
        try {
             String querry="INSERT INTO `conversation`( `titre_conversation`, `id_user1`, `id_user2`) VALUES ('"+p.getTitre_conversation()+"' ,'"+p.getId_user1()+"','"+p.getId_user2()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<conversations> afficher() {
       List<conversations> conversation = new ArrayList<>();
        try {
            String req = "SELECT * FROM conversation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                conversation.add(new conversations(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return conversation;
    }

    @Override
    public boolean modifer(conversations p) {
         Scanner sc = new Scanner(System.in);
        System.out.println("titre conversation : ");
        String titre_conversation = sc.nextLine();
          try {
           String req = " UPDATE `conversation` SET `titre_conversation` = '" + titre_conversation + "' WHERE `id_conversation` = '" + p.getId_conversation()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
          
    }

    @Override
    public boolean supprimer(conversations p) {
         try {
            String querry = "DELETE FROM `conversation` WHERE `id_conversation` = '" + p.getId_conversation()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    
}
