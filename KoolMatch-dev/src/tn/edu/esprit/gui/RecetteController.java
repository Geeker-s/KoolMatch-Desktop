/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.model.Recette;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.services.ServiceRecette;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class RecetteController implements Initializable {

    @FXML
    private Button AjouterR;
    @FXML
    private Label label;
    @FXML
    private TextField nplat;
    @FXML
    private TextField prec;
    @FXML
    private TextArea desc;
    @FXML
    private TextField catg;
    @FXML
    private TextField duree;
    @FXML
    private Button ModifierR;
    @FXML
    private Button SupprimerR;
    @FXML
    private TextField idr;
    @FXML
    private Label listR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  

    @FXML
    private void bAjouer(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
           Recette r = new Recette(nplat.getText(),prec.getText(), desc.getText(), catg.getText(),Integer.parseInt(duree.getText())) ;
               Recette.ajouter(r);
    }

    @FXML
    private void Bmodifier(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
           Recette r = new Recette(Integer.parseInt(idr.getText()), desc.getText()) ;
               Recette.modifer(r);
    }

    @FXML
    private void Bsupprimer(ActionEvent event) {
         ServiceRecette Recette = new ServiceRecette();
            Recette r1 = new Recette(Integer.parseInt(idr.getText()),"b","b", "a", "c",0) ;
               Recette.supprimer(r1);
    }

  

    @FXML
    private void Laffichage(MouseEvent event) {
        ServiceRecette Recette = new ServiceRecette();
               Recette.afficher();
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void drag(MouseEvent event) {
        
    }
    
}
