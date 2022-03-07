/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class SplashController implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Label labe1;
    @FXML
    private Button Ajouter;
    @FXML
    private Button MesR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        setRotate(c1, true, 360, 10);
        setRotate(c2, true, 180, 18);
        setRotate(c3, true, 145, 24);
    }
int rotate = 0;

private void setRotate(Circle c , boolean reverse, int angle ,int duration){
RotateTransition rotateTransition = new RotateTransition (Duration.seconds(duration),c);
rotateTransition.setByAngle(angle);
rotateTransition.setAutoReverse(reverse);
rotateTransition.setRate(3);
rotateTransition.setDelay(Duration.seconds(0));
rotateTransition.setCycleCount(18);
rotateTransition.play();
}

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FormulaireRestaurant.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        }
    
  

    @FXML
    private void MesResto(ActionEvent event) throws IOException {
         Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AfficherRestaurantUser.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        }

    }
