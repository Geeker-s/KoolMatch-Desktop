/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.Invitation;
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
import tn.edu.esprit.model.User;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author Asus
 */
public class ServiceInvitation implements IService<Invitation> {

    private Connection cnx;

    public ServiceInvitation() {
        cnx = MyDB.getInstance().getCnx();

    }

    @Override
    public void ajouter(Invitation p) {
        try {
            String querry = "INSERT INTO `invitation`( `id_invitation`, `nom_event`, `id_user`) VALUES ('" + p.getId_invitation() + "','" + p.getNom_event() + "','" + p.getId_user() + "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Invitation> afficher() {
        List<Invitation> invitations = new ArrayList<>();
        try {
            String req = "SELECT * FROM invitation  WHERE archive = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                invitations.add(new Invitation(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return invitations;

    }

    @Override
    public boolean modifer(Invitation p) {
        
        try {
            String req = " UPDATE `invitation` SET `nom_event`= '" + p.getNom_event()+ "' , "
                    + "`id_user` ='" + p.getId_user()+ "' WHERE `id_invitation` = '" + p.getId_invitation() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Invitation p) {
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
    public List<Invitation> rechercher(Invitation r) {
        List<Invitation> inv = afficher();
        return inv.stream().filter(b -> b.getId_invitation() == r.getId_invitation()).collect(Collectors.toList());
    }

    public List<Invitation> Tri() {

        Comparator<Invitation> comparator = Comparator.comparing((event) -> event.getNom_event());
        List<Invitation> inv = afficher();
        return inv.stream().sorted(comparator).collect(Collectors.toList());
    }
    
    public List<Integer> afficherid() {
        List<Integer> ids = new ArrayList<>();
        try {
            String req = "SELECT id_user FROM user   ";

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                ids.add(rs.getInt(1));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return ids ;
       
    }

}