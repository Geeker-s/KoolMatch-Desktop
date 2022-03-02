/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tn.edu.esprit.model.Jeu;
import tn.edu.esprit.model.Quiz;
import tn.edu.esprit.services.ServiceJeu;
import tn.edu.esprit.services.ServiceQuiz;

/**
 * FXML Controller class
 *
 * @author AZIZ
 */
public class ConsulterjeuController implements Initializable {
    ServiceJeu j =new ServiceJeu();
    ServiceQuiz q =new ServiceQuiz();
    
        ObservableList<Jeu> list=FXCollections.observableList(j.rank());
          ObservableList<Quiz> listt=FXCollections.observableList(q.afficher());
    @FXML
    private ListView<Jeu> listj;
    @FXML
    private ListView<Quiz> listq;
    @FXML
    private PieChart chart;
    @FXML
    private Button quiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        listj.setItems(list);
        listq.setItems(listt);
        chart.setTitle("Niveau joueurs"); 
        chart.getData().setAll(new PieChart.Data("Tres faible", j.calculz1()), new PieChart.Data("faible", j.calculz2()),  
                new PieChart.Data("Moyen", j.calculz3()), new PieChart.Data("Semi-pro", j.calculz4()), 
                new PieChart.Data("Pro", j.calculz5()), new PieChart.Data("légende", j.calculz6()));

    }    

    @FXML
    private void gquiz(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("BackJeu.fxml"));
        Parent root = loader.load();
        tn.edu.esprit.GUI.JeuController ap= loader.getController();
        quiz.getScene().setRoot(root);
    }
    
}
