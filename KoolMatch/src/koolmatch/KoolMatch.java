/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;

import entities.interaction;
import entities.matching;
import entities.user;
import java.sql.Date;
import services.ServiceInteraction;
import services.ServiceMatching;
import services.ServiceUser;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creation des utilisateurs
        user foulen = new user(1);
        user foulena = new user(2);

        //Controllers
        ServiceUser user = new ServiceUser();
        ServiceInteraction react = new ServiceInteraction();
        ServiceMatching match = new ServiceMatching();

        
        
        
//       react.ajouter(new interaction("o", Date.valueOf("2022-02-14"), foulen.getId_user(), foulena.getId_user()));
//       react.ajouter(new interaction("o", Date.valueOf("2022-02-15"), foulena.getId_user(), foulen.getId_user()));
       

//        match.ajouter(new matching(foulen.getId_user(), foulena.getId_user(), Date.valueOf("2022-02-14")));









        /*supprimer un match*/
//        if (match.supprimer(new matching(14))) {
//            System.out.println("Supprimé avec succes.");
//        } else {
//            System.out.println("Erreur de suppression.");
//        }
        /*modifier un match*/
//        if (match.modifer(new matching(1))) {
//            System.out.println("Date modifié avec succes.");
//        } else {
//            System.out.println("Erreur de modification.");
//        }
        /*affichage de tout les matches effectuées*/
        System.out.println(user.afficher());
        System.out.println(react.afficher());
        System.out.println(match.afficher());
    }
}
