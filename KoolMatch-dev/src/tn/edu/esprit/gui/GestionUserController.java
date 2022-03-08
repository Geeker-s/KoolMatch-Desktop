/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceGerant;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class GestionUserController implements Initializable {

    @FXML
    private TextField nomGerant;
    @FXML
    private TextField prenomGerant;
    @FXML
    private PasswordField mdpGerant;
    @FXML
    private TextField telGerant;
    @FXML
    private DatePicker dda;
    @FXML
    private DatePicker ddf;
    @FXML
    private ListView<Gerant> listGerant;
    @FXML
    private ListView<User> listuser;
    @FXML
    private TextField emailGerant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceGerant g = new ServiceGerant();
        listGerant.getItems().addAll(g.afficher());

        ServiceUser u = new ServiceUser();
        listuser.getItems().addAll(u.afficher());
    }

    @FXML
    private void addGerant(MouseEvent event) {

        ServiceGerant g = new ServiceGerant();
        Gerant gr = new Gerant();
        gr.setNom_gerant(nomGerant.getText());
        gr.setPrenom_gerant(prenomGerant.getText());
        gr.setPassword_gerant(mdpGerant.getText());
        gr.setEmail_gerant(emailGerant.getText());
        gr.setTelephone_gerant(Integer.parseInt(telGerant.getText()));
        LocalDate FDate = dda.getValue();
        String Sdate = String.valueOf(FDate);
        gr.setDd_abonnement(Date.valueOf(Sdate));
        LocalDate FFDate = ddf.getValue();
        String SSdate = String.valueOf(FFDate);
        gr.setDf_abonnement(Date.valueOf(SSdate));
        g.ajouter(gr);
        nomGerant.setText("");
        prenomGerant.setText("");
        mdpGerant.setText("");
        telGerant.setText("");
        emailGerant.setText("");
        dda.getEditor().clear();
        ddf.getEditor().clear();
        listGerant.getItems().clear();
        listGerant.getItems().addAll(g.afficher());

    }

    @FXML
    private void updateGerant(MouseEvent event) {
        ServiceGerant g = new ServiceGerant();
        Gerant gerant = listGerant.getSelectionModel().getSelectedItem();
        Gerant n = new Gerant();

        n.setId_gerant(gerant.getId_gerant());
        n.setArchive(gerant.getArchive());
        LocalDate FDate = dda.getValue();
        String Sdate = String.valueOf(FDate);
        n.setDd_abonnement(Date.valueOf(Sdate));
        LocalDate FFDate = ddf.getValue();
        String SSdate = String.valueOf(FFDate);
        n.setDf_abonnement(Date.valueOf(SSdate));
        n.setEmail_gerant(emailGerant.getText());
        n.setNom_gerant(nomGerant.getText());
        n.setPassword_gerant(mdpGerant.getText());
        n.setPrenom_gerant(prenomGerant.getText());
        n.setTelephone_gerant(Integer.parseInt(telGerant.getText()));

        g.modifer(n);
        nomGerant.setText("");
        prenomGerant.setText("");
        mdpGerant.setText("");
        telGerant.setText("");
        emailGerant.setText("");
        dda.setValue(null);
        ddf.setValue(null);
        listGerant.getItems().clear();
        listGerant.getItems().addAll(g.afficher());

    }

    @FXML
    private void index(MouseEvent event) {
        Gerant g = listGerant.getSelectionModel().getSelectedItem();

        nomGerant.setText(g.getNom_gerant());
        prenomGerant.setText(g.getPrenom_gerant());
        mdpGerant.setText(g.getPassword_gerant());
        telGerant.setText(String.valueOf(g.getTelephone_gerant()));
        emailGerant.setText(g.getEmail_gerant());
        dda.setValue(g.getDd_abonnement().toLocalDate());
        ddf.setValue(g.getDf_abonnement().toLocalDate());

    }

    @FXML
    private void deleteUser(ActionEvent event) {
        ServiceUser u = new ServiceUser();
        User user = listuser.getSelectionModel().getSelectedItem();
        u.supprimer(user);
        listuser.getItems().remove(user);
    }

    @FXML
    private void deleteGerant(ActionEvent event) {
        ServiceGerant g = new ServiceGerant();
        Gerant gerant = listGerant.getSelectionModel().getSelectedItem();
        g.supprimer(gerant);
        listGerant.getItems().remove(gerant);
    }

}
