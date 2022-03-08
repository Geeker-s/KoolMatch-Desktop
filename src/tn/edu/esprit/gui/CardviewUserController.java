/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class CardviewUserController implements Initializable {

    @FXML
    private Circle photo;
    @FXML
    private Label nom;
    @FXML
    private Label age;
    @FXML
    private Label adresse;
    @FXML
    private Label description;
    @FXML
    private Button sup;
    List<User> users = new ArrayList<>();

    User u;
    @FXML
    private Rectangle rec;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    public void setAffichage(User u) {
        ServiceUser user = new ServiceUser();
        File file = new File("src/tn/edu/esprit/images/" + u.getPhoto_user());
        Image image = new Image(file.toURI().toString());
        photo.setFill(new ImagePattern(image));
        nom.setText(u.getNom_user() + " " + u.getPrenom_user());
        age.setText(String.valueOf(user.calculateAge(u)));
        adresse.setText(u.getAdresse_user());
        description.setText(u.getDescription_user());
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        ServiceUser us = new ServiceUser();
        us.supprimer(getU());
        rec.setFill(Color.BLACK);
    }
}
