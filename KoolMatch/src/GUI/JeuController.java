/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Jeu;
import entities.Quiz;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import services.ServiceJeu;
import services.ServiceQuiz;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class JeuController implements Initializable {
    ServiceQuiz quiz = new ServiceQuiz();
         Quiz q = quiz.Recherche(new Quiz(6)).get(0);
          ServiceJeu jeu = new ServiceJeu();
         

    @FXML
    private TextField Q1;
    @FXML
    private TextField Q2;
    @FXML
    private TextField Q3;
    @FXML
    private CheckBox R2;
    @FXML
    private CheckBox R3;
    @FXML
    private CheckBox R1;
    @FXML
    private CheckBox R21;
    @FXML
    private CheckBox R22;
    @FXML
    private CheckBox R23;
    @FXML
    private CheckBox RC2;
    @FXML
    private CheckBox RC;
    @FXML
    private CheckBox R31;
    @FXML
    private CheckBox R32;
    @FXML
    private CheckBox R33;
    @FXML
    private CheckBox RC3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
              Q1.setText(q.getQ1());
              R1.setText(q.getRf11());
              R2.setText(q.getRf12());
              R3.setText(q.getRf13());
              RC.setText(q.getRc1());
              Q2.setText(q.getQ2());
              R21.setText(q.getRf21());
              R22.setText(q.getRf22());
              R23.setText(q.getRf23());
              RC2.setText(q.getRc2());
              Q3.setText(q.getQ3());
              R31.setText(q.getRf31());
              R32.setText(q.getRf32());
              R33.setText(q.getRf33());
              RC3.setText(q.getRc3());
    }    

    @FXML
    private void valide(ActionEvent event) {
        int sc = 0;
        if (RC.isSelected()) {
            sc=sc+10;
        }
        if (RC2.isSelected()) {
                 sc=sc+10;
        } 
        if (RC3.isSelected()) {
                        sc=sc+10;
        }
        Jeu j = new Jeu(sc, q.getId_quiz(), 0/*this user*/);
        
    }
    
}
