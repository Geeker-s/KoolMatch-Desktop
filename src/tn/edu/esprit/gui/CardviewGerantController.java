/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.services.ServiceGerant;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class CardviewGerantController implements Initializable {

    @FXML
    private Label dda;

    @FXML
    private Label ddf;

    @FXML
    private Label nom;

    @FXML
    private Label tel;

    List<Gerant> gerant = new ArrayList<>();
    @FXML
    private Rectangle rec;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    Gerant g;
    List<Gerant> gerants = new ArrayList<>();

    public Gerant getG() {
        return g;
    }

    public void setG(Gerant g) {
        this.g = g;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setAffichage(Gerant g) {

        nom.setText(g.getNom_gerant() + " " + g.getPrenom_gerant());
        tel.setText(String.valueOf(g.getTelephone_gerant()));
        dda.setText(String.valueOf(g.getDd_abonnement()));
        ddf.setText(String.valueOf(g.getDf_abonnement()));

    }

    @FXML
    private void updategerant(ActionEvent event) throws IOException {
        Stage primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateGerant.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        Stage CurrentStage = (Stage) update.getScene().getWindow();
        CurrentStage.close();

    }

    @FXML
    private void deletegerant(ActionEvent event) {
        ServiceGerant ge = new ServiceGerant();
        ge.supprimer(getG());
        rec.setFill(Color.BLACK);
    }

}
