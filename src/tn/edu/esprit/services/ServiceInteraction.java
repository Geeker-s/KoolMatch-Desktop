/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.interfaces.IService;
import tn.edu.esprit.model.Interaction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author wassimromdhane
 */
public class ServiceInteraction implements IService<Interaction> {

    private final Connection cnx;

    public ServiceInteraction() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Interaction p) {
        Interaction x = afficher()
                .stream()
                .filter(m -> m.getId_interaction() == p.getId_interaction())
                .findAny()
                .orElse(null);
        if (x == null) {
            try {
                String querry = "INSERT INTO `interaction` (`type_interaction`,`date_interaction`,`id_user1`,`id_user2`) VALUES('" + p.getType_interaction() + "','" + p.getDate_interaction() + "','" + p.getId_user1() + "','" + p.getId_user2() + "')";
                Statement stm = cnx.createStatement();
                stm.executeUpdate(querry);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Interaction existe deja!");
        }
    }

    @Override
    public List<Interaction> afficher() {
        List<Interaction> interactions = new ArrayList<>();
        try {
            String req = "SELECT * FROM interaction WHERE archive=0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                interactions.add(new Interaction(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return interactions;
    }

    @Override
    public boolean modifer(Interaction p) {
        Interaction x = afficher()
                .stream()
                .filter(m -> m.getId_interaction() == p.getId_interaction())
                .filter(m -> m.getArchive() == 0)
                .findAny()
                .orElse(null);
        if (x != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nouveau Date : ");
            String date = sc.nextLine();
            Date newDate = Date.valueOf(date);
            try {
                String req = " UPDATE `interaction` SET `date_interaction` = '" + newDate + "' WHERE `id_interaction` = '" + p.getId_interaction() + "'";
                Statement stm = cnx.createStatement();
                stm.executeUpdate(req);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Erreur de modification.");
                return false;
            }
        } else {
            System.out.println("Interaction not found!");
            return false;
        }
        System.out.println("Date modifié avec succes.");
        return true;
    }

    @Override
    public boolean supprimer(Interaction p) {
        Interaction x = afficher()
                .stream()
                .filter(m -> m.getId_interaction() == p.getId_interaction())
                .filter(m -> m.getArchive() == 0)
                .findAny()
                .orElse(null);
        if (x != null) {
            try {
                String querry = "UPDATE `interaction` SET archive=1 WHERE `id_interaction` = '" + p.getId_interaction() + "'";
                Statement stm = cnx.createStatement();
                stm.executeUpdate(querry);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        } else {
            System.out.println("Interaction not found!");
            return false;
        }
        return true;
    }

    public boolean userLIKE(Interaction p) {
        List<Interaction> likes = afficher()
                .stream()
                .filter(l -> l.getArchive() == 0)
                .filter(l -> "o".equals(l.getType_interaction()))
                .filter(l -> l.getId_user1() == p.getId_user1() || l.getId_user2() == p.getId_user1())
                .filter(l -> l.getId_user1() == p.getId_user2() || l.getId_user2() == p.getId_user2())
                .collect(Collectors.toList());
        if ( likes != null){
            likes.stream()
                 .forEach(l->supprimer(l));
        }
        else {
            return false;
        }
        return true;
    }
}
