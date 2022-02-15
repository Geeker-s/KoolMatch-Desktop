/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.conversations;
import entities.messages;
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
public class ServiceMessage implements IService<messages>{
     private Connection cnx;

    public ServiceMessage() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(messages p) {
        try {
             String querry="INSERT INTO `message`( `msg_message`, `date_message`) VALUES ('"+p.getMsg_message()+"' ,'"+p.getDate_message()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<messages> afficher() {
        
         List<messages> message = new ArrayList<>();
        try {
            String req = "SELECT * FROM conversation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                message.add(new messages(rs.getInt(1),rs.getString(2),rs.getDate(3)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return message;
    }

    @Override
    public boolean modifer(messages p) {
                Scanner sc = new Scanner(System.in);
        System.out.println("le message : ");
        String message = sc.nextLine();
          try {
           String req = " UPDATE `message` SET `msg_message` = '" + message + "' WHERE `id_conversation` = '" + p.getId_message()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(messages p) {
              try {
            String querry = "DELETE FROM `message` WHERE `id_message` = '" + p.getId_message()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
   
    
}
