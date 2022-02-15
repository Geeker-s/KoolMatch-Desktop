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
import java.util.List;
import java.util.Scanner;
import utils.MyDB;

/**
 *
 * @author Asus
 */
public class ServiceInvitation implements IService<invitation> {
    

     private Connection cnx;

    public ServiceInvitation() {
        cnx = MyDB.getInstance().getCnx();

    
}

    @Override
    public void ajouter(invitation p) {
        try {
             String querry="INSERT INTO `invitation`( `id_invitation`, `id_event`, `id_user`) VALUES ('"+p.getId_invitation()+"','"+p.getId_event()+"','"+p.getId_user()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<invitation> afficher() {
         List<invitation> invitations = new ArrayList<>();
        try {
            String req = "SELECT * FROM invitation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
            invitations.add(new invitation(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return invitations;
    }

    @Override
    public boolean modifer(invitation p) {
           Scanner sc = new Scanner(System.in);
        System.out.println("id event : ");
        String id_event = sc.nextLine();
          try {
           String req = " UPDATE `invitation` SET `id_event` = '" + id_event+ "' WHERE `id_invitation` = '" + p.getId_invitation() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(invitation p) {
         try {
            String querry = "DELETE FROM invitation WHERE id_invitation = '" + p.getId_invitation() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
