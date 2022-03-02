/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Recette;
import tn.edu.esprit.services.ServiceRecette;

/**
 * FXML Controller class
 *
 * @author AZIZ
 */
public class RecetteFrontController implements Initializable {
     ServiceRecette r =new ServiceRecette();
        ObservableList<String> list=FXCollections.observableList(r.affichernp());
    @FXML
    private ComboBox<String> listr;
    @FXML
    private TextArea desc;
    @FXML
    private Button play;
    @FXML
    private ImageView img;
    @FXML
    private TextField duree;
    @FXML
    private TextField catg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        listr.setItems(list);
    }    

    @FXML
    private void selected(ActionEvent event) {
        Recette rec = r.recherchern(new Recette(listr.getValue())).get(0) ;
        desc.setText(rec.getDescription_recette());
        catg.setText(rec.getCategorie_recette());
        duree.setText(Integer.toString(rec.getDuree_recette()));
        File file = new File(rec.getPhoto_recette());
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
        
    }

    @FXML
    private void play(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("jeu.fxml"));
        Parent root = loader.load();
        tn.edu.esprit.GUI.JeuController ap= loader.getController();
        play.getScene().setRoot(root);
    }
    
}
