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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class SignInController implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Button login;

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
            ServiceUser us = new ServiceUser();
            User usr = new User();
            usr.setEmail_user(tfusername.getText());
            usr.setPassword_user(tfpassword.getText());
            boolean verify = us.login(usr.getEmail_user(), usr.getPassword_user());
            if (verify) {
                try {
                    CurrentUser = us.AssignCurrentUser(usr.getEmail_user(), usr.getPassword_user());
                    Stage primaryStage;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("front.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) login.getScene().getWindow();
                    CurrentStage.close();

                } catch (IOException ex) {
                    ex.getMessage();
                }
            } else {

                //message errur 
                //iffasakh les champs el kol
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

}
