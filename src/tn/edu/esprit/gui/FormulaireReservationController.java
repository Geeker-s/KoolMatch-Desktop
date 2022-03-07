/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.Reservation;
import tn.edu.esprit.services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class FormulaireReservationController implements Initializable {

    @FXML
    private TextField Fidresto;
    @FXML
    private TextField Fnbrplace;
    @FXML
    private Button idvalider;
    @FXML
    private Button idAnnuler;
    @FXML
    private DatePicker disponibilite;
    @FXML
    private TextField FIdUSER;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void valider(ActionEvent event) throws IOException {

//        ServiceReservation sp = new ServiceReservation();
//        Reservation p = new Reservation();
//
//        p.setId_restaurant(Integer.parseInt(Fidresto.getText()));
//        p.setNbPlace_reservation(Integer.parseInt(Fnbrplace.getText()));
//        Date Date_reservation = Date.valueOf(this.disponibilite.getValue());
//        p.setDate_reservation(Date_reservation);
//        p.setId_user(Integer.parseInt(FIdUSER.getText()));
//        sp.ajouter(p);
 

    }

    @FXML
    private void Annuler(ActionEvent event) {
    }

}
