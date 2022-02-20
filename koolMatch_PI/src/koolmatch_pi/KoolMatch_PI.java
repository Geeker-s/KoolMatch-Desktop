/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch_pi;

import Services.ServiceReservation;
import Services.ServiceRestaurant;
import entities.Reservation;
import entities.Restaurant;
import entities.user;
import java.sql.Date;


/**
 *
 * @author BAZINFO
 */
public class KoolMatch_PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ServiceRestaurant service_resto = new ServiceRestaurant();
        ServiceReservation service_reseservation = new ServiceReservation();
    
      Restaurant resto3 = new  Restaurant(6, "kfc", "ariana ", 22022555, "www.kfc.com", "FastfOOD", 8);
      //Restaurant resto2 = new  Restaurant(4, "hafood", "nabeul ", 55550222, "www.hafood.com", "FastfOOD", 0);
      //service_resto.ajouter(resto);
        
       
       //service_resto.ajouter(resto3);
       
      //System.out.println(service_resto.afficher());
    
     
     
     /* if (service_resto.modifer(new Restaurant(4))) {
           System.out.println("restaurant modifié avec succes.");
        } else {
           System.out.println("Erreur de modification.");}*/
      
      

   /*  if (service_resto.supprimer(new Restaurant(1))) {
           System.out.println("retaurant supprimé.");
        } else {
            System.out.println("Erreur de suppression Interaction");
        }*/
            

        
        //Creation des utilisateurs
        user foulen = new user(1);
        user foulena = new user(2);

       // Reservation resev =new Reservation(1 ,Date.valueOf("2022-03-14"),4,resto3.getId_restaurant(),foulen.getId_user(),1);
       // service_reseservation.ajouter(resev);
        
       System.out.println(service_reseservation.afficher());
      
     /* if (service_reseservation.modifer(new Reservation(2),Date.valueOf("2022-02-14"),foulen.getId_user())) {
           System.out.println("reservation modifié avec succes.");
        } else {
           System.out.println("Erreur de modification.");}*/
     
     
        
   /*   if (service_reseservation.supprimer(new Reservation(1))) {
           System.out.println("reservation supprimé.");
        } else {
            System.out.println("Erreur de suppression Interaction");
        } 
      
    }*/
    }
}
