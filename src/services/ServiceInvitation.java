/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.event;
import entities.invitation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
            String querry = " UPDATE `invitation` SET archive = 1  WHERE id_invitation = '" + p.getId_invitation() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    
     @Override
    public List<invitation> Recherche(invitation r) {
        List<invitation> inv = afficher();
         return inv.stream().filter(b -> b.getId_invitation() == r.getId_invitation()).collect(Collectors.toList());
    }
    
    
    


    public List<invitation> Tri() {
       
        Comparator<invitation> comparator = Comparator.comparing((event)->event.getId_event());
        List<invitation> inv = afficher();
        return inv.stream().sorted(comparator).collect(Collectors.toList());
    }

    
    
    
}
