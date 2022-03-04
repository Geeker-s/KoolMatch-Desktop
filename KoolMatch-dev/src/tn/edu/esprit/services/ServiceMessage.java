/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Conversations;
import tn.edu.esprit.model.Messages;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author Guedo
 */
public class ServiceMessage implements IService<Messages>{
     private Connection cnx;

    public ServiceMessage() {
        cnx = MyDB.getInstance().getCnx();
    }
    
@Override
    public void ajouter(Messages p) {
        
        try {
             String querry="UPDATE `message` SET `msg_message`='"+p.getMsg_message()+"',`date_message`='"+p.getDate_message()+"' WHERE `id_message`='"+p.getId_message()+"'";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<Messages> afficher() {
        
         List<Messages> message = new ArrayList<>();
        try {
            String req = " SELECT * FROM `message` WHERE `archive` = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                message.add(new Messages(rs.getInt(1),rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return message;
    }

    @Override
    public boolean modifer(Messages p) {
                Scanner sc = new Scanner(System.in);
        System.out.println("le message : ");
        String message = sc.nextLine();
          try {
           String req = "UPDATE `message` SET `msg_message`='"+message+"',`date_message`='"+p.getDate_message()+"' WHERE `id_message`='"+p.getId_message()+"'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Messages p) {
              try {
            String querry = "UPDATE `message` set archive = 1 WHERE `id_message` = '" + p.getId_message()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

     @Override
    public List<Messages> rechercher(Messages r) {
       List<Messages> conver = afficher();
       
        return conver.stream().filter(b -> b.getMsg_message().equals(r.getMsg_message())).collect(Collectors.toList());
    }




   
    
}
