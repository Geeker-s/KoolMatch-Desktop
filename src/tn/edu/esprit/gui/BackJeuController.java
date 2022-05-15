/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import tn.edu.esprit.services.ServiceJeu;
import tn.edu.esprit.services.ServiceQuiz;
import tn.edu.esprit.model.Quiz;
import tn.edu.esprit.model.Jeu;
import tn.edu.esprit.model.Recette;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class BackJeuController implements Initializable {

    @FXML
    private TextField inQ1;
    @FXML
    private TextField inrf11;
    @FXML
    private TextField inrf12;
    @FXML
    private TextField inrf13;
    @FXML
    private TextField inrc;
    @FXML
    private TextField inQ2;
    @FXML
    private TextField inrf21;
    @FXML
    private TextField inrf22;
    @FXML
    private TextField inrf23;
    @FXML
    private TextField inrc2;
    @FXML
    private TextField inQ3;
    @FXML
    private TextField inrf31;
    @FXML
    private TextField inrf32;
    @FXML
    private TextField inrf33;
    @FXML
    private TextField inrc3;
    
    static public Quiz CurrentQuiz = new Quiz();
    static public Recette CurrentRecette = new Recette();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceQuiz quiz = new ServiceQuiz();
        if (CurrentQuiz.getId_quiz() > -1) {
            Quiz q = quiz.rechercherq(CurrentQuiz).get(0);

            inQ1.setText(q.getQ1());
            inrf11.setText(q.getRf11());
            inrf12.setText(q.getRf12());
            inrf13.setText(q.getRf13());
            inrc.setText(q.getRc1());
            inQ2.setText(q.getQ2());
            inrf21.setText(q.getRf21());
            inrf22.setText(q.getRf22());
            inrf23.setText(q.getRf23());
            inrc2.setText(q.getRc2());
            inQ3.setText(q.getQ3());
            inrf31.setText(q.getRf31());
            inrf32.setText(q.getRf32());
            inrf33.setText(q.getRf33());
            inrc3.setText(q.getRc3());
        }
    }

    @FXML
    private void AjouterQ(ActionEvent event) {
        ServiceQuiz q = new ServiceQuiz();
        
        Quiz quiz = new Quiz(0, inQ1.getText(), inrc.getText(), inrf11.getText(), inrf12.getText(), inrf13.getText(), inQ2.getText(), inrc2.getText(), inrf21.getText(), inrf22.getText(), inrf23.getText(), inQ3.getText(), inrc3.getText(), inrf31.getText(), inrf32.getText(), inrf33.getText());
        q.ajouter(quiz);
    }

    @FXML
    private void ModifierQ(ActionEvent event) {
        ServiceQuiz q = new ServiceQuiz();
        if (CurrentQuiz.getId_quiz() > -1) {
            Quiz quiz = new Quiz(CurrentQuiz.getId_quiz(), 0, inQ1.getText(), inrc.getText(), inrf11.getText(), inrf12.getText(), inrf13.getText(), inQ2.getText(), inrc2.getText(), inrf21.getText(), inrf22.getText(), inrf23.getText(), inQ3.getText(), inrc3.getText(), inrf31.getText(), inrf32.getText(), inrf33.getText());
            q.modifer(quiz);
            CurrentQuiz.setId_quiz(-1);
        } else {
            Notifications notificationBuilder = Notifications.create()
                    .title("Erreur").text("Veuillez choisir un Quiz depuis la liste précédente").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER_LEFT)
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            System.out.println("clicked ON");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
    }

    @FXML
    private void SuppQ(ActionEvent event) {
        if (CurrentQuiz.getId_quiz() > -1) {
            ServiceQuiz q = new ServiceQuiz();
            Quiz quiz = new Quiz(CurrentQuiz.getId_quiz(), 2);
            q.supprimer(quiz);
            CurrentQuiz.setId_quiz(-1);
        } else {
            Notifications notificationBuilder = Notifications.create()
                    .title("Erreur").text("Veuillez choisir un Quiz depuis la liste précédente").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER_LEFT)
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            System.out.println("clicked ON");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        }
    }
}
