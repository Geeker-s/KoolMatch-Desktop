/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.services.ServiceGerant;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class UpdateGerantController implements Initializable {

    @FXML
    private TextField nomGerant;
    @FXML
    private Label nomGcontrol;
    @FXML
    private TextField prenomGerant;
    @FXML
    private Label prenomGcontrol;
    @FXML
    private PasswordField mdpGerant;
    @FXML
    private Label mdpGcontrol;
    @FXML
    private TextField emailGerant;
    @FXML
    private Label emailGcontrol;
    @FXML
    private TextField telGerant;
    @FXML
    private Label telGcontrol;
    @FXML
    private DatePicker dda;
    @FXML
    private Label ddaGcontrol;
    @FXML
    private DatePicker ddf;
    @FXML
    private Label ddfGcontrol;
    @FXML
    private Label formulairecontrol;
    @FXML
    private Button update;

    List<Gerant> ger = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void nomGerantControl(KeyEvent event) {
    }

    @FXML
    private void prenomGerantControl(KeyEvent event) {
    }

    @FXML
    private void mdpGerantControl(KeyEvent event) {
    }

    @FXML
    private void emailGerantControl(KeyEvent event) {
    }

    @FXML
    private void telGerantControl(KeyEvent event) {
    }

    @FXML
    private void ddaGerantControl(KeyEvent event) {
    }

    @FXML
    private void ddfGerantControl(KeyEvent event) {
    }

    @FXML
    private void addGerant(MouseEvent event) {
    }

    @FXML
    private void UpdateG(ActionEvent event) {
        ServiceGerant g = new ServiceGerant();
       
        Gerant n = new Gerant();

//        n.setId_gerant(gerant.getId_gerant());
//        n.setArchive(gerant.getArchive());
//        LocalDate FDate = dda.getValue();
//        String Sdate = String.valueOf(FDate);
//        n.setDd_abonnement(Date.valueOf(Sdate));
//        LocalDate FFDate = ddf.getValue();
//        String SSdate = String.valueOf(FFDate);
//        n.setDf_abonnement(Date.valueOf(SSdate));
//        n.setEmail_gerant(emailGerant.getText());
//        n.setNom_gerant(nomGerant.getText());
//        n.setPassword_gerant(mdpGerant.getText());
//        n.setPrenom_gerant(prenomGerant.getText());
//        n.setTelephone_gerant(Integer.parseInt(telGerant.getText()));

        g.modifer(n);
        nomGerant.setText("");
        prenomGerant.setText("");
        mdpGerant.setText("");
        telGerant.setText("");
        emailGerant.setText("");
        dda.setValue(null);
        ddf.setValue(null);

    }

}
