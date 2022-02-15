/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch_pi;

import Services.ServiceRestaurant;
import entities.Restaurant;
import java.util.Arrays;

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
    
       Restaurant resto3 = new  Restaurant(6, "kfc", "ariana ", 22022555, "www.kfc.com", "FastfOOD", 8);
      //Restaurant resto2 = new  Restaurant(4, "hafood", "nabeul ", 55550222, "www.hafood.com", "FastfOOD", 0);
       //service_resto.ajouter(resto);
     


/*service_resto.ajouter(resto3);
      System.out.println(service_resto.afficher());*/
    
     
     
      if (service_resto.modifer(new Restaurant(4))) {
           System.out.println("restaurant modifié avec succes.");
        } else {
           System.out.println("Erreur de modification.");}
      
      

      /*  if (service_resto.supprimer(new Restaurant(2))) {
           System.out.println("retaurant supprimé.");
        } else {
            System.out.println("Erreur de suppression Interaction");
        }
            */

        
        
    }
    
}
