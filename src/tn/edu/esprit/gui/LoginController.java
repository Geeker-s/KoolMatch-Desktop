/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.util.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.user;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller
 *
 * @author MED ZOUARI
 */
public class LoginController implements Initializable {

    @FXML
    private VBox vbox;
    private Parent fxml;
    static public user CurrentUser = new user();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(8);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void open_signup(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(8);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void open_signin(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 60);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

//   
//            

    @FXML
    private void authentification(ActionEvent event) {
            try {
           ServiceUser us = new ServiceUser();
            user usr = new user();

            usr.setEmail_user(tfusername.getText());
            usr.setPassword_user(tfpassword.getText());
            boolean verify = us.login(usr.getEmail_user(), usr.getPassword_user());
            boolean verifyAd = false;
            if (verify) {
                try {
                    CurrentUser = us.AssignCurrentUser(usr.getEmail_user(), usr.getPassword_user());
                    Stage primaryStage;

                    if ("+".equals(CurrentUser.getId_user())) {

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("front.fxml"));
                        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("Host an event");

                        stage.setScene(new Scene(root1));

                        stage.show();

                    } else {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        

                        //Parent root = FXMLLoader.load(getClass().getResource("CRUDEvent.fxml"));
                        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

                        stage.setScene(new Scene(root1, screenSize.getWidth(), screenSize.getHeight()));

                        stage.show();

                    }

                    Stage CurrentStage = (Stage) login.getScene().getWindow();
                    CurrentStage.close();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setTitle("Host an event");

                    stage.setScene(new Scene(root1));

                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    

