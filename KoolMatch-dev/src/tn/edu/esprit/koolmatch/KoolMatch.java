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
import tn.edu.esprit.api.sendSMS;
import tn.edu.esprit.model.Conversations;
import tn.edu.esprit.model.Jeu;
import tn.edu.esprit.model.Messages;
import tn.edu.esprit.model.Quiz;
import tn.edu.esprit.model.Recette;
import tn.edu.esprit.model.Reservation;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.services.ServiceAdmin;
import tn.edu.esprit.services.ServiceConversation;
import tn.edu.esprit.services.ServiceGerant;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceJeu;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceMessage;
import tn.edu.esprit.services.ServiceQuiz;
import tn.edu.esprit.services.ServiceRecette;
import tn.edu.esprit.services.ServiceReservation;
import tn.edu.esprit.services.ServiceRestaurant;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.utils.Mail;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        --Services
        ServiceUser user = new ServiceUser();
        ServiceAdmin admin = new ServiceAdmin();
        ServiceGerant gerant = new ServiceGerant();
        ServiceMatching match = new ServiceMatching();
        ServiceInteraction react = new ServiceInteraction();
        ServiceRecette recette = new ServiceRecette();
        ServiceJeu jeu = new ServiceJeu();
        ServiceQuiz quiz = new ServiceQuiz();
        ServiceMessage msg = new ServiceMessage();
        ServiceConversation conv = new ServiceConversation();
        ServiceRestaurant restau = new ServiceRestaurant();
        ServiceReservation reserv = new ServiceReservation();

//        ---------
//        --Testing
        //Creation des utilisateurs
        User foulen = user.afficher()
                .stream()
                .filter(e -> e.getId_user() == 1)
                .findAny()
                .orElse(null);
        User foulena = user.afficher()
                .stream()
                .filter(e -> e.getId_user() == 2)
                .findAny()
                .orElse(null);

//        ---------Gestion Matching
//        match.hex("010"); //hexcode du profile
//        match.ajouter(new Matching(foulen.getId_user(), foulena.getId_user(), Date.valueOf(LocalDate.now())));
//        match.mapGPS(foulen);
//        double kilo = match.distance(foulen.getLatitude_user(), foulen.getLongitude_user(), foulena.getLatitude_user(), foulena.getLongitude_user());
//        System.out.println("\n\t" + kilo);
//        match.supprimer(new Matching(1));
//        match.modifer(new Matching(1));
//        System.out.println("\n--\n" + match.filter(foulen));
//        react.ajouter(new Interaction("o", Date.valueOf("2022-02-14"), foulen.getId_user(), foulena.getId_user()));
//        react.ajouter(new Interaction("o", Date.valueOf("2022-02-15"), foulena.getId_user(), foulen.getId_user()));
//        react.modifer(new Interaction(1));
//        react.supprimer(new Interaction(1));
//        Interaction interaction = new Interaction(1, 2);
//        if (react.userLIKE(interaction)) {
//            match.ajouter(new Matching(interaction.getId_user1(), interaction.getId_user2(), Date.valueOf(LocalDate.now())));
//        }//Matching automatique d'un user
//        -- -- -- ---Gestion Recette recette
//        .ajouter(new Recette(1, "omlette", "photo.jpg", "bnina", "Petit dej", 20));
//        Jeu j = new Jeu(8, 6, 1);
//        Quiz q = new Quiz(6, "q1", "rc1", "rf11", "rf12", "rf13", "q2", "rc2", "rf21", "rf22", "rf23", "q3", "rc3", "rf31", "rf32", "rf33");
//        quiz.ajouter(q);
//        Recette r1 = new Recette(7, "aa", "bz", "description_recette", "categorie_recette", 0);
//        recette.ajouter(r1);
//        recette.supprimer(r1);
//        jeu.ajouter(j);
//        System.out.println(recette.afficher());
//        System.out.println(jeu.rank());
//        Jeu j1 = new Jeu(5);
//        System.out.println(quiz.calcules(6, "rc1"));
//        -- -- -- ---Gestion Messagerie Conversations co = new Conversations("hell 0/world ", 12, 45);
//        conv.ajouter(co);
//        Messages m = new Messages(2, null);
//        msg.ajouter(m);
//        msg.ajouter(new Messages("hello"), co.getId_conversation());
//        System.out.println(conv.Recherche(new Conversations("mohamed said")));


//        -- -- -- ---Gestion Restaurant
       Restaurant resto = new Restaurant(3, "Kitchen", "Tunisia", 2202255, "www.kfc.com", "FastfOOD", 5, "aa", 0, 10, "aaaa", "uiuh", "ggg");
//        Restaurant resto1 = new Restaurant(10, "Kitchen", "klibya", 2202255, "www.kfc.com", "FastfOOD", 5, "aa", 0, 10, "aaaa", "uiuh", "ggg");
//        restau.ajouter(resto1);
//        restau.supprimer(resto);
 //       if (restau.modifer(resto)) {
  //          System.out.println("restaurant modifié avec succes.");
   //     } else {
    //        System.out.println("Erreur de modification.");
   //     }
//        System.out.println(restau.rechercher(resto1));
//        System.out.println(restau.rechercherSpecialite(resto1));
//        System.out.println(reserv.Tri());
       sendSMS s = new sendSMS();
        s.sendSMS(foulen);
//        if (restau.supprimer(new Restaurant(1))) {
//            System.out.println("retaurant supprimé.");
//        } else {
//            System.out.println("Erreur de suppression Interaction");
//        }
//
//        Reservation resev = new Reservation(1, Date.valueOf("2022-03-14"), 4, resto3.getId_restaurant(), foulen.getId_user(), 1);
//        reserv.ajouter(resev);
//
//        if (restau.updateNbrPlace(new Restaurant(5, resto3.getNb_placeResto()), 20)) {
//            System.out.println("restaurant modifié avec succes.");
//        } else {
//            System.out.println("Erreur de modification.");
//        }
//
//if (reserv.modifer(new Reservation(2))) { 
// System.out.println("reservation modifié avec succes.");
//   } else {
//     System.out.println("Erreur de modification.");
//}
//
//        if (reserv.supprimer(new Reservation(1))) {
//            System.out.println("reservation supprimé.");
//        } else {
//            System.out.println("Erreur de suppression Interaction");
//        }
//        -- -- -- ---Affichage
//        System.out.println(user.afficher());
//        System.out.println(admin.afficher());
//        System.out.println(gerant.afficher());
//        System.out.println(match.afficher());
//        System.out.println(react.afficher());
//        System.out.println(recette.afficher());
//        System.out.println(jeu.afficher());
//        System.out.println(quiz.afficher());
//        System.out.println(msg.afficher());
//        System.out.println(conv.afficher());
//        System.out.println(restau.afficher());
//        System.out.println(reserv.afficher());
    }
}
