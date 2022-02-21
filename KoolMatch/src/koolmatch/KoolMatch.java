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
import java.time.LocalDateTime;
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

        //Controllers
        ServiceUser user = new ServiceUser();
        ServiceInteraction react = new ServiceInteraction();
        ServiceMatching match = new ServiceMatching();

        //Creation des utilisateurs
        user foulen = new user(1);
        user foulena = new user(2);

        //Creation des reaction lors d'une interaction
        interaction react1 = new interaction("o", Date.valueOf("2022-02-14"), foulen.getId_user(), foulena.getId_user());
        interaction react2 = new interaction("o", Date.valueOf("2022-02-15"), foulena.getId_user(), foulen.getId_user());

//        react.ajouter(react1);
//        react.ajouter(react2);

//        System.out.println(match.algorithme(foulen));
//        System.out.println("\n\n------------------------\n\n");
        //match.hex("010"); //hexcode du profile
        System.out.println(match.calculateAge(new user(1,Date.valueOf("1998-01-09"))));
        
        

//      match.ajouter(new matching(react.userLIKE(react1).getId_user2(),react.userLIKE(react1).getId_user1(),  Date.valueOf(LocalDate.now())));
//        if (react.supprimer(new interaction(3))) {
//            System.out.println("Interaction supprimé.");
//        } else {
//            System.out.println("Erreur de suppression Interaction");
//        }
//        if (react.modifer(new interaction(4))) {
//            System.out.println("Date de reaction modifié avec succes.");
//        } else {
//            System.out.println("Erreur de modification.");
//        }
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
//        System.out.println(user.afficher());
//        System.out.println(react.afficher());
//        System.out.println(match.afficher());
//        System.out.println(react.userLIKE(react1));
    }
}
