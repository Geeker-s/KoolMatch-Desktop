/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Conversations;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author Guedo
 */
public class ServiceConversation implements IService<Conversations>{

    private Connection cnx;

    public ServiceConversation() {
        cnx = MyDB.getInstance().getCnx();
    }
    @Override
    public void ajouter(Conversations p) {
        try {
            
            Statement stm =cnx.createStatement();
           
            String querry="INSERT INTO `conversation`( `titre_conversation`, `id_user1`, `id_user2`) VALUES ('"+p.getTitre_conversation()+"' ,'"+p.getId_user1()+"','"+p.getId_user2()+"')";
              stm.executeUpdate(querry);
         
             
     
             String querry1="INSERT INTO `message`( id_conversation ) select max(id_conversation) from conversation";
              stm.executeUpdate(querry1);
     
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<Conversations> afficher() {
       List<Conversations> conversation = new ArrayList<>();
        try {
            String req = "SELECT * FROM conversation WHERE archive = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                conversation.add(new Conversations(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return conversation;
    }

    @Override
    public boolean modifer(Conversations p) {
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
    public boolean supprimer(Conversations p) {
         try {
            String querry = "UPDATE `conversation` set archive = 1 WHERE `id_conversation` = '" + p.getId_conversation()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
        public boolean signal(Conversations p) {
         try {
            
             Statement stm = cnx.createStatement();

            String querry = "UPDATE `conversation` set archive = 1 WHERE `id_conversation` = '" + p.getId_conversation()+ "'";
            stm.executeUpdate(querry);
            
            String querry1 = "UPDATE `message` set archive = 1 WHERE `id_conversation` = '" + p.getId_conversation()+ "'";
            stm.executeUpdate(querry1);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public List<Conversations> rechercher(Conversations r) {
       List<Conversations> conver = afficher();
       
        return conver.stream().filter(b -> b.getTitre_conversation().equals(r.getTitre_conversation())).collect(Collectors.toList());
    }
    

    public List<Conversations> Tri() {
        Comparator<Conversations> comparator = Comparator.comparing((conversations) -> conversations.getId_conversation());
        List<Conversations> conv = afficher();
        return conv.stream().sorted(comparator).collect(Collectors.toList());
    }
    
    
    




         
}
             