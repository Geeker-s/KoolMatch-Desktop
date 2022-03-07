/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.Admin;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.services.ServiceAdmin;
import tn.edu.esprit.services.ServiceGerant;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class Login_backController implements Initializable {

    @FXML
    private TextField tfusernameBack;
    @FXML
    private PasswordField tfpasswordBack;
    @FXML
    private Button loginBack;
    static public Admin CurrentAdmin = new Admin();
    static public Gerant CurrentGerant = new Gerant();
    @FXML
    private Label emailcontrol;
    @FXML
    private Label passcontrol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void connexion(ActionEvent event) {
        try {
            ServiceAdmin admin = new ServiceAdmin();
            Admin root = new Admin();
            root.setLogin_admin(tfusernameBack.getText());
            root.setPassword_admin(tfpasswordBack.getText());
            boolean verify = admin.login(root.getLogin_admin(), root.getPassword_admin());

            ServiceGerant gerant = new ServiceGerant();
            Gerant roott = new Gerant();
            roott.setEmail_gerant(tfusernameBack.getText());
            roott.setPassword_gerant(tfpasswordBack.getText());
            boolean verifyy = gerant.login(roott.getEmail_gerant(), roott.getPassword_gerant());
            
            if (verify) {
                try {
                    CurrentAdmin = admin.AssignCurrentAdmin(root.getLogin_admin(), root.getPassword_admin());
                    Stage primaryStage;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("back.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) loginBack.getScene().getWindow();
                    CurrentStage.close();

                } catch (IOException ex) {
                    ex.getMessage();
                }
            } else if (verifyy) {
                try {
                    CurrentGerant = gerant.AssignCurrentGerant(roott.getEmail_gerant(), roott.getPassword_gerant());
                    Stage primaryStage;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gerant_back.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) loginBack.getScene().getWindow();
                    CurrentStage.close();

                } catch (IOException ex) {
                    ex.getMessage();
                }

            } else {
                
                
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void emailControl(KeyEvent event) {
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(tfusernameBack.getText());
        if (!match.matches()) {
            emailcontrol.setText("Veuillez saisire une adresse Email Valide");
        } else {
            emailcontrol.setText(null);
        }
    }

    @FXML
    private void mdpControl(KeyEvent event) {
        String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,15}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(tfpasswordBack.getText());
        if (!match.matches()) {
            passcontrol.setText("Invalide Mot de passe ");
        } else {
            passcontrol.setText(null);
        }
    }

}
