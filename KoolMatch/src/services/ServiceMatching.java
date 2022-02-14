/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.matching;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.MyDB;

/**
 *
 * @author wassimromdhane
 */
public class ServiceMatching implements IService<matching> {

    private final Connection cnx;

    public ServiceMatching() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(matching p) {

        try {
            String querry = "INSERT INTO `matching` (`id_user1`,`id_user2`,`date_match`) VALUES('" + p.getId_user1() + "','" + p.getId_user2() + "','" + p.getDate_match() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<matching> afficher() {
        List<matching> matches = new ArrayList<>();
        try {
            String req = "SELECT * FROM matching";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                matches.add(new matching(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return matches;

    }

    @Override
    public boolean modifer(matching p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nouveau Date : ");
        String date = sc.nextLine();
        Date newDate = Date.valueOf(date);
        try {
            String req = " UPDATE `matching` SET `date_match` = '" + newDate + "' WHERE `id_match` = '" + p.getId_match() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(matching p) {
        try {
            String querry = "DELETE FROM `matching` WHERE `id_match` = '" + p.getId_match() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
