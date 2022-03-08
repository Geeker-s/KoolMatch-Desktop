/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tn.edu.esprit.model.Gerant;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class CardviewGerantController implements Initializable {

    @FXML
    private Label dda;

    @FXML
    private Label ddf;

    @FXML
    private Label nom;

    @FXML
    private Label tel;
    
    List<Gerant> gerant = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void setAffichage(Gerant g) {
        
        
        nom.setText(g.getNom_gerant()+" "+ g.getPrenom_gerant());
        tel.setText(String.valueOf(g.getTelephone_gerant()));
        dda.setText(String.valueOf(g.getDd_abonnement()));
        ddf.setText(String.valueOf(g.getDf_abonnement()));
        
    }

}
