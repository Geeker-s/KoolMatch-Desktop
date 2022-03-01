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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static tn.edu.esprit.gui.Login_backController.CurrentAdmin;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class BackController implements Initializable {

    @FXML
    private Circle photo_user;
    @FXML
    private Label nom_user;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnConversation;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnRestaurant;
    @FXML
    private Button btnRecettes;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnLogout;
    @FXML
    private Pane pnlHome;
    @FXML
    private Pane pnlConversation;
    @FXML
    private Pane pnlProfile;
    @FXML
    private Pane pnlRestaurant;
    @FXML
    private Pane pnlRecettes;
    @FXML
    private Pane pnlEvent;
    @FXML
    private Pane pnlSettings;
    @FXML
    private Pane pnlLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/tn/edu/esprit/images/admin.jpg");
        Image image = new Image(file.toURI().toString());
        photo_user.setFill(new ImagePattern(image));
        photo_user.setEffect(new DropShadow(+25d, 0d, +2d, Color.TRANSPARENT));
        nom_user.setText(CurrentAdmin.getLogin_admin());
        pnlHome.setStyle("-fx-background-color : #e7e5e5");
        pnlHome.toFront();

        FXMLLoader loadRecette = new FXMLLoader(getClass().getResource("Recette.fxml"));
        Pane newLoadedPane;
        try {
            newLoadedPane = loadRecette.load();
            pnlRecettes.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            ex.getMessage();
        }
        FXMLLoader loadMatching = new FXMLLoader(getClass().getResource("matching.fxml"));
        Pane newMatching;
        try {
            newMatching = loadMatching.load();
            pnlHome.getChildren().add(newMatching);
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    @FXML
    private void handleClicks(ActionEvent event) {
        if (event.getSource() == btnProfile) {
            pnlProfile.setStyle("-fx-background-color : #e7e5e5");
            pnlProfile.toFront();
        }
        if (event.getSource() == btnRestaurant) {
            pnlRestaurant.setStyle("-fx-background-color : #e7e5e5");
            pnlRestaurant.toFront();
        }
        if (event.getSource() == btnHome) {
            pnlHome.setStyle("-fx-background-color : #e7e5e5");
            pnlHome.toFront();
        }
        if (event.getSource() == btnConversation) {
            pnlConversation.setStyle("-fx-background-color : #e7e5e5");
            pnlConversation.toFront();
        }
        if (event.getSource() == btnLogout) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You're about to logout!");
            alert.initStyle(StageStyle.UNDECORATED);
            if (alert.showAndWait().get() == ButtonType.OK) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login_back.fxml"));
                    Parent root1;
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) btnLogout.getScene().getWindow();
                    CurrentStage.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        if (event.getSource() == btnSettings) {
            pnlSettings.setStyle("-fx-background-color : #e7e5e5");
            pnlSettings.toFront();
        }
        if (event.getSource() == btnEvent) {
            pnlEvent.setStyle("-fx-background-color : #e7e5e5");
            pnlEvent.toFront();
        }
        if (event.getSource() == btnRecettes) {
            pnlRecettes.setStyle("-fx-background-color : #e7e5e5");
            pnlRecettes.toFront();
        }
    }

}
