/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.services.ServiceEvent;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CardviewEventController implements Initializable {

   
    @FXML
    private Label nom;
    
    @FXML
    private Label adresse;
    
    @FXML
    private Label theme;
    @FXML
    private Label date;
    @FXML
    private Label contact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setAffichage(Evenement e) {
        ServiceEvent event = new ServiceEvent();
     
        nom.setText(e.getNom_event());
       theme.setText(e.getTheme_event());
       adresse.setText(e.getAdresse_event());
       date.setText(String.valueOf(e.getDd_event()));
        contact.setText(String.valueOf(e.getTelephone()));
        
    }

}
