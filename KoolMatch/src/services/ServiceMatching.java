/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.matching;
import entities.user;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
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

    public int hex(String s) {
        int i = 0;
        String res = "";
        while (i <= s.length() - 3) {
            res += String.valueOf(Integer.parseInt(s.substring(i, i + 3), 2));
            i += 3;
        }
        return Integer.parseInt(res);
    }

    public List<user> algorithme(user u) {
        List<user> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user WHERE id_user NOT LIKE '" + u.getId_user() + "' ORDER BY (ABS( Interet_user - '" + u.getInteret_user() + "'))";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                users.add(new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getFloat(16), rs.getFloat(17), rs.getString(18)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return users;
    }

    public static int calculateAge(user u) {

        int year;
        year = u.getDateNaissance_user().getYear();

        return Date.valueOf(LocalDate.now()).getYear() - year;
    }

    public user updateUser(user u) {

        user x = new user();
        try {
            String req = "SELECT `id_user`, `dateNaissance_user` FROM user WHERE id_user = '" + u.getId_user() + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                x.setId_user(rs.getInt(1));
                x.setDateNaissance_user(rs.getDate(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

    public void filter(user u) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Age minimum Preferre : ");
        String preferredMinAge = sc.nextLine();
        System.out.println("Age maximum Preferre : ");
        String preferredMaxAge = sc.nextLine();
        System.out.println("Distance maximum Preferre : ");
        String maxDistance = sc.nextLine();
        int ageMin = Integer.parseInt(preferredMinAge);
        int ageMax = Integer.parseInt(preferredMaxAge);
        int distance = Integer.parseInt(maxDistance);

        try {
            String req = " UPDATE `user` SET `preferredMinAge_user` = '" + ageMin + "', `preferredMaxAge_user` = '" + ageMax + "', `maxDistance_user` = '" + distance + "' WHERE `id_user` = '" + u.getId_user() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        algorithme(u)
                .stream()
                .filter(x -> ageMin <= calculateAge(x))
                .filter(x -> calculateAge(x) <= ageMax)
                
                //Manque la partie distance
                .forEach(x -> System.out.println(x));
    }
}
