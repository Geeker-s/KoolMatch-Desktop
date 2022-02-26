/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import services.ServiceJeu;
import services.ServiceQuiz;
import entities.Quiz;
import entities.Jeu;

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
    @FXML
    private TextField idq;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterQ(ActionEvent event) {
        ServiceQuiz q = new ServiceQuiz();
         Quiz quiz =new Quiz(0, inQ1.getText(), inrc.getText(), inrf11.getText(), inrf12.getText(), inrf13.getText(), inQ2.getText(), inrc2.getText(), inrf21.getText(), inrf22.getText(), inrf23.getText(), inQ3.getText(), inrc3.getText(), inrf31.getText(), inrf32.getText(), inrf33.getText());
               q.ajouter(quiz);
    }

    @FXML
    private void ModifierQ(ActionEvent event) {
        ServiceQuiz q = new ServiceQuiz();
             Quiz quiz =new Quiz(Integer.parseInt(idq.getText()), 1) ;
               q.modifer(quiz);
    }

    @FXML
    private void SuppQ(ActionEvent event) {
        ServiceQuiz q = new ServiceQuiz();
             Quiz quiz =new Quiz(Integer.parseInt(idq.getText()),2) ;
               q.supprimer(quiz);
    }
    
}
