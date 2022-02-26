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
import tn.edu.esprit.model.Jeu;
import tn.edu.esprit.model.Quiz;
import tn.edu.esprit.model.Recette;
import tn.edu.esprit.services.ServiceAdmin;
import tn.edu.esprit.services.ServiceGerant;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceJeu;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceQuiz;
import tn.edu.esprit.services.ServiceRecette;
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

//--
        ServiceUser user = new ServiceUser();
        ServiceAdmin admin = new ServiceAdmin();
        ServiceGerant gerant = new ServiceGerant();
        ServiceMatching match = new ServiceMatching();
        ServiceInteraction react = new ServiceInteraction();
        ServiceRecette recette = new ServiceRecette();
        ServiceJeu jeu = new ServiceJeu();
        ServiceQuiz quiz = new ServiceQuiz();

// Testing      
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
//        System.out.println("\n--\n"+match.filter(foulen));
//        ---------Gestion Recette
//        recette.ajouter(new Recette(1, "omlette", "photo.jpg", "bnina", "Petit dej", 20));
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
//        ---------


//Creation des reaction lors d'une Interaction
//        Interaction react1 = new Interaction("o", Date.valueOf("2022-02-14"), foulen.getId_user(), foulena.getId_user());
//        Interaction react2 = new Interaction("o", Date.valueOf("2022-02-15"), foulena.getId_user(), foulen.getId_user());
//        react.ajouter(react1);
//        react.ajouter(react2);
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
//--Affichage
//        System.out.println(user.afficher());
//        System.out.println(admin.afficher());
//        System.out.println(gerant.afficher());
//        System.out.println(match.afficher());
//        System.out.println(react.afficher());
//        System.out.println(recette.afficher());
//        System.out.println(jeu.afficher());
//        System.out.println(quiz.afficher());
    }

}
