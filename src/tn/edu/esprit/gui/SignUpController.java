/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Label nomcontrol;
    @FXML
    private Label prenomcontrol;
    @FXML
    private Label emailcontrol;
    @FXML
    private Label mdpcontrol;
    @FXML
    private Label telcontrol;
    @FXML
    private Label dncontrol;
    @FXML
    private Label sexcontrol;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void select(ActionEvent event) {

        String s = sexe.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> l = FXCollections.observableArrayList("Homme", "Femme");
        sexe.setItems(l);
    }

    @FXML
    private void signup(ActionEvent event) {
        if (this.isValidated()) {
            Statement stmt;
        
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
        dncontrol.setText(null);
        sexcontrol.setText(null);
        }
        else{
        dncontrol.setText("Vérifier vos informations");
        }
    }

    @FXML
    private void nomUControl(KeyEvent event) {
        String PATTERN = "^[a-z A-Z]{3,20}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(nom.getText());
        if (!match.matches()) {
            nomcontrol.setText("Nom non valide");
        } else {
            nomcontrol.setText(null);
        }
    }

    @FXML
    private void prenomUcontrol(KeyEvent event) {
        String PATTERN = "^[a-z A-Z]{3,20}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(prenom.getText());
        if (!match.matches()) {
            prenomcontrol.setText("Prenom non valide");
        } else {
            prenomcontrol.setText(null);
        }
    }

    @FXML
    private void emailUcontrol(KeyEvent event) {
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(email.getText());
        if (!match.matches()) {
            emailcontrol.setText("Email non valide");
        } else {
            emailcontrol.setText(null);
        }
    }

    @FXML
    private void mdpUcontrol(KeyEvent event) {
        String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*/])(?=\\S+$).{8,15}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(mdp.getText());
        if (!match.matches()) {
            mdpcontrol.setText("Mot de passe non valide");
        } else {
            mdpcontrol.setText(null);
        }
    }

    @FXML
    private void telUcontrol(KeyEvent event) {
        String PATTERN = "^(90|92|93|94|95|96|97|98|99|20|21|22|23|24|25|26|27|28|29|50|51|52|53|54|55|40|41|42|43)[0-9]{6}";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(tel.getText());
        if (!match.matches()) {
            telcontrol.setText("Numéro de téléphone non valide");
        } else {
            telcontrol.setText(null);
        }
    }
      private boolean isValidated() {

        if (nom.getText().equals("")) {
            nomcontrol.setText("Ajouter votre nom ");
        } else if (prenom.getText().equals("")) {
            prenomcontrol.setText("Ajouter votre prenom ");
        } else if (mdp.getText().equals("")) {
            mdpcontrol.setText("Ajouter un mot de passe ");
        } else if (email.getText().equals("")) {
            emailcontrol.setText("Ajouter votre email  ");
        } else if (tel.getText().equals("")) {
            telcontrol.setText("Ajouter votre numéro de téléphone ");
        } else if (datenaissance.getValue() == null) {
            dncontrol.setText("Ajouter votre date de naissance ");
        } else if (sexe.getValue() == null) {
            sexcontrol.setText("Ajouter votre sexe ");
        } else {
            return true;
        }
        return false;
    }

}
