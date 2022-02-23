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
        try {
            String querry = "INSERT INTO `interaction` (`type_interaction`,`date_interaction`,`id_user1`,`id_user2`) VALUES('" + p.getType_interaction() + "','" + p.getDate_interaction() + "','" + p.getId_user1() + "','" + p.getId_user2() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Interaction> afficher() {
        List<Interaction> interactions = new ArrayList<>();
        try {
            String req = "SELECT * FROM interaction";
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
            return false;
        }
        return true;

    }

    @Override
    public boolean supprimer(Interaction p) {
        try {
            String querry = "DELETE FROM `interaction` WHERE `id_interaction` = '" + p.getId_interaction() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public Interaction userLIKE(Interaction p) {
        List<Interaction> likes = new ArrayList<>();
        try {
            String req = "SELECT `id_interaction`,`id_user1`,`id_user2` FROM `interaction` WHERE (`type_interaction` = 'o') AND (`id_user1`='" + p.getId_user1() + "' or `id_user2` ='" + p.getId_user1() + "')";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                likes.add(new Interaction(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Interaction X = new Interaction(0, 0, 0);
        for (int i = 0; i < likes.size(); i++) {
            X.setId_interaction(likes.get(i).getId_interaction());
            X.setId_user1(likes.get(i).getId_user2());
            X.setId_user2(likes.get(i).getId_user1());
            if (likes.get(i).equals(X)) {  //nthabet mel equals
                try {
                    //usr1 = id1 et usr2 =id2 ou l3aks
                    String querry = "DELETE FROM `interaction` WHERE `id_interaction` = '" + X.getId_interaction() + "'";
                    Statement stm = cnx.createStatement();
                    stm.executeUpdate(querry);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return X; //new Interaction(foulen.getId_user(), foulena.getId_user())
    }

    public boolean userMATCH(List<Interaction> listLike) {

        return true;
    }
}