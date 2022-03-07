/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private PasswordField mdp;
    @FXML
    private DatePicker datenaissance;
    @FXML
    private ComboBox sexe;
    @FXML
    private Button btnsignup;
    private TextField adresse;
    @FXML
    private TextField tel;

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private void select(ActionEvent event) {
        
        String s = sexe.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> l = FXCollections.observableArrayList("Homme","Femme");
        sexe.setItems(l);
    }

    @FXML
    private void signup(ActionEvent event) {
        ServiceUser us = new ServiceUser();
        User usr = new User();
        User u = new User();
        u.setNom_user(nom.getText());
        u.setPrenom_user(prenom.getText());
        u.setEmail_user(email.getText());
        u.setPassword_user(mdp.getText());
        u.setTelephone_user(Integer.parseInt(tel.getText()));
        LocalDate FDate = datenaissance.getValue();
        String Sdate = String.valueOf(FDate);
        u.setDateNaissance_user(Date.valueOf(Sdate));
        u.setSexe_user(sexe.getSelectionModel().getSelectedItem().toString());
        us.ajouter(u);
        nom.setText("");
        prenom.setText("");
        email.setText("");
        mdp.setText("");
        tel.setText("");
        datenaissance.getEditor().clear();
        sexe.setValue("");
        

    }

   
}
