/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.interfaces.IService;
import tn.edu.esprit.gps.Mapa;
import tn.edu.esprit.model.Matching;
import tn.edu.esprit.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.utils.Mail;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author wassimromdhane
 */
public class ServiceMatching implements IService<Matching> {

    private final Connection cnx;

    public ServiceMatching() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Matching p) {
        User u1 = getEmailUser(new User(p.getId_user1()));
        User u2 = getEmailUser(new User(p.getId_user2()));
 

        try {
            String querry = "INSERT INTO `matching` (`id_user1`,`id_user2`,`date_match`) VALUES('" + p.getId_user1() + "','" + p.getId_user2() + "','" + p.getDate_match() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Mail.sendMail(u1.getEmail_user());
            Mail.sendMail(u2.getEmail_user());

        } catch (Exception ex) {
            Logger.getLogger(ServiceMatching.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Matching> afficher() {
        List<Matching> matches = new ArrayList<>();
        try {
            String req = "SELECT * FROM matching";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                matches.add(new Matching(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return matches;

    }

    @Override
    public boolean modifer(Matching p) {
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
    public boolean supprimer(Matching p) {
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

    public List<User> algorithme(User u) {
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user WHERE id_user NOT LIKE '" + u.getId_user() + "' ORDER BY (ABS( Interet_user - '" + u.getInteret_user() + "'))";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getFloat(16), rs.getFloat(17), rs.getString(18)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return users;
    }

    public static int calculateAge(User u) {

        int year;
        year = u.getDateNaissance_user().getYear();

        return Date.valueOf(LocalDate.now()).getYear() - year;
    }

    public User updateUser(User u) {

        User x = new User();
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

    public User getUser(User u) {

        User x = new User();
        try {
            String req = "SELECT `latitude`, `longitude` FROM user WHERE id_user = '" + u.getId_user() + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                x.setId_user(u.getId_user());
                x.setLatitude_user(rs.getDouble(1));
                x.setLongitude_user(rs.getDouble(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

        public User getEmailUser(User u) {

        User x = new User();
        try {
            String req = "SELECT `email_user` FROM user WHERE id_user = '" + u.getId_user() + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                x.setId_user(u.getId_user());
                x.setEmail_user(rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }
    public void filter(User u) {

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

    public void mapGPS(User u) {

        final Mapa example = new Mapa("test", u.getLatitude_user(), u.getLongitude_user());
        example.generateMarker(Mapa.map.getCenter());
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    //  This function converts decimal degrees to radians
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
