/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;
import entities.Jeu;
import entities.Quiz;
import entities.Recette;
import services.ServiceJeu;
import services.ServiceQuiz;
import services.ServiceRecette;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       ServiceRecette Recette = new ServiceRecette();
      ServiceJeu Jeu = new ServiceJeu();
       // ServiceJeu jeu = new ServiceJeu();
        ServiceQuiz quiz = new ServiceQuiz();
       //Jeu j = new Jeu(8,6, 1) ;
       
       //Quiz q = new Quiz(6, "q1", "rc1", "rf11", "rf12", "rf13", "q2", "rc2", "rf21", "rf22", "rf23", "q3", "rc3", "rf31", "rf32", "rf33");
       //quiz.ajouter(q);
       
       //Recette r1 = new Recette(7,"aa","bz", "description_recette", "categorie_recette", 0) ;
        //Jeu.ajouter(j);
       //Recette.ajouter(r1);
      //Recette.supprimer(r1) ;
        //System.out.println(Recette.afficher());
      //  System.out.println(Jeu.rank());
        //Jeu j1 = new Jeu(5);
       // System.out.println(quiz.calcules(6,"rc1"));

    }
    
}
