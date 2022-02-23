/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.koolmatch;

import tn.edu.esprit.model.Interaction;
import tn.edu.esprit.model.Matching;
import tn.edu.esprit.model.User;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

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
        User foulen = new User(1);
        User foulena = new User(2);

        
//        match.ajouter(new Matching(1, 2, Date.valueOf(LocalDate.now())));
//        foulen = match.getUser(foulen);
//        foulena = match.getUser(foulena);
//        
//        System.out.println(foulen.getLatitude_user());
//        
//        double kilo = match.distance(foulen.getLatitude_user(), foulen.getLongitude_user(), foulena.getLatitude_user(), foulena.getLongitude_user());
//        System.out.println("\n\t"+kilo);
        //match.mapGPS(foulen);
        //Creation des reaction lors d'une Interaction
//        Interaction react1 = new Interaction("o", Date.valueOf("2022-02-14"), foulen.getId_user(), foulena.getId_user());
//        Interaction react2 = new Interaction("o", Date.valueOf("2022-02-15"), foulena.getId_user(), foulen.getId_user());

//        react.ajouter(react1);
//        react.ajouter(react2);
//        match.filter(match.updateUser(foulen));
//        System.out.println(match.algorithme(foulen));
//        System.out.println("\n\n------------------------\n\n");
        //match.hex("010"); //hexcode du profile
//        System.out.println(match.calculateAge(new User(1,Date.valueOf("1995-02-18"))));

//      match.ajouter(new Matching(react.userLIKE(react1).getId_user2(),react.userLIKE(react1).getId_user1(),  Date.valueOf(LocalDate.now())));
//        if (react.supprimer(new Interaction(3))) {
//            System.out.println("Interaction supprimé.");
//        } else {
//            System.out.println("Erreur de suppression Interaction");
//        }
//        if (react.modifer(new Interaction(4))) {
//            System.out.println("Date de reaction modifié avec succes.");
//        } else {
//            System.out.println("Erreur de modification.");
//        }
        /*supprimer un match*/
//        if (match.supprimer(new Matching(14))) {
//            System.out.println("Supprimé avec succes.");
//        } else {
//            System.out.println("Erreur de suppression.");
//        }
        /*modifier un match*/
//        if (match.modifer(new Matching(1))) {
//            System.out.println("Date modifié avec succes.");
//        } else {
//            System.out.println("Erreur de modification.");
//        }
        /*affichage de tout les matches effectuées*/
        System.out.println(user.afficher());
//        System.out.println(react.afficher());
//        System.out.println(match.afficher());
//        System.out.println(react.userLIKE(react1));
    }
}
