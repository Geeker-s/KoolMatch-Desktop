/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Reservation;
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
 * @author BAZINFO
 */
public class ServiceReservation implements IService<Reservation>{
    private final Connection cnx;

    public ServiceReservation() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reservation p1) {
        try {
            String querry = "INSERT INTO `reservation` (`id_reservation`,`date_reservation`,`nbPlace_reservation`,`id_restaurant`,`id_user`,`status_supprimer1`) VALUES('" + p1.getId_reservation()+ "','" + p1.getDate_reservation() + "','" + p1.getNbPlace_reservation()+ "','" + p1.getId_restaurant()+ "','" + p1.getId_user()+ "','" + p1.getStatus_supprimer1()+ "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

     @Override
    public List<Reservation> afficher() {
        List<Reservation> Reservation = new ArrayList<>();
        try {
            String req = "SELECT * FROM reservation WHERE `status_supprimer1` = 1 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation.add(new Reservation(rs.getInt(1), rs.getDate(2), rs.getInt(3),rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Reservation;
    }


    @Override
    public boolean modifer(Reservation p1) {
           Scanner sc = new Scanner(System.in);
             System.out.println("Nouveau place : ");
              String newPlace = sc.nextLine();
           /*       Scanner sc1 = new Scanner(System.in);
             System.out.println("Nouveau place : ");
           String newDate =sc1.nextLine();
            Scanner sc2 = new Scanner(System.in);
             System.out.println("Nouveau place : ");
           String newRestaurant =sc2.nextLine();
              Scanner sc3 = new Scanner(System.in);
             System.out.println("Nouveau place : ");
           String newSta =sc3.nextLine();*/
      
        
    //    UPDATE `reservation` SET `id_reservation` = '2', `date_reservation` = '2022-02-13', `id_restaurant` = '5', `id_user` = '2', `status_supprimer1` = '2' WHERE `reservation`.`id_reservation` = 1 AND `reservation`.`date_reservation` = '2022-02-14' AND `reservation`.`id_user` = 1; 
        
        try {
            String req = " UPDATE `reservation` SET `nbPlace_reservation` = '" + newPlace + "' WHERE `id_reservation` = '" + p1.getId_reservation()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Reservation p1) {
     /*   try {
            String querry = "DELETE FROM `restaurant` WHERE `id_restaurant` = '" + p.getId_restaurant()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
        }*/
       try {
            String req = " UPDATE `reservation` SET `status_supprimer1` = 0  WHERE `id_reservation` = '" + p1.getId_reservation()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

   

    @Override
    public boolean updateNbrPlace(Reservation P, int nbPlace_reservation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }

 



        
    

