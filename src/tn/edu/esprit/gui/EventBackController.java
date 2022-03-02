/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import tn.edu.esprit.model.Evenement;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.services.ServiceEvent;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EventBackController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField TFnom;
    @FXML
    private TextField TFtheme;
    @FXML
    private TextField TFadresse;
    @FXML
    private TextField TFtel;
    @FXML
    private DatePicker DPdd;
    @FXML
    private DatePicker DPdf;
    @FXML
    private Button ADDevent;
    @FXML
    private Button supprimer;
    @FXML
    private ListView<Evenement> tbviewEvent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvent ev = new ServiceEvent();
        tbviewEvent.getItems().addAll(ev.afficher());
        // TODO
    }

    @FXML

    private void addevent(ActionEvent event) {
        ServiceEvent e = new ServiceEvent();
        Evenement ev = new Evenement();
        ev.setNom_event(TFnom.getText());
        ev.setTheme_event(TFtheme.getText());
        ev.setAdresse_event(TFadresse.getText());
        ev.setTelephone(Integer.parseInt(TFtel.getText()));
        LocalDate FDate = DPdd.getValue();
        String Sdate = String.valueOf(FDate);
        ev.setDd_event(Date.valueOf(Sdate));
        LocalDate FFDate = DPdf.getValue();
        String SSdate = String.valueOf(FFDate);
        ev.setDf_event(Date.valueOf(SSdate));
        e.ajouter(ev);
        TFnom.setText("");
        TFtheme.setText("");
        TFadresse.setText("");
        TFtel.setText("");

        DPdd.getEditor().clear();
        DPdf.getEditor().clear();

    }

    @FXML
    void modiffevent(ActionEvent event) {

        ServiceEvent g = new ServiceEvent();
        Evenement e = tbviewEvent.getSelectionModel().getSelectedItem();
        Evenement n = new Evenement();

        n.setId_event(e.getId_event());

        n.setArchive(e.getArchive());
        LocalDate FDate = DPdd.getValue();
        String Sdate = String.valueOf(FDate);
        n.setDd_event(Date.valueOf(Sdate));
        LocalDate FFDate = DPdf.getValue();
        String SSdate = String.valueOf(FFDate);
        n.setDf_event(Date.valueOf(SSdate));
        n.setTelephone(e.getTelephone());

        n.setNom_event(TFnom.getText());

        n.setTheme_event(e.getTheme_event());

        System.out.println(n);
        g.modifer(n);

        TFnom.setText("");
        TFtel.setText("");
        TFtheme.setText("");
        TFadresse.setText("");
        DPdf.setValue(null);
        DPdd.setValue(null);
        tbviewEvent.getItems().clear();
        tbviewEvent.getItems().addAll(g.afficher());

    }

    @FXML
    private void index(javafx.scene.input.MouseEvent event) {
        Evenement g = tbviewEvent.getSelectionModel().getSelectedItem();

        TFnom.setText(g.getNom_event());

        TFtheme.setText(g.getTheme_event());

        TFadresse.setText(g.getAdresse_event());

        TFtel.setText(String.valueOf(g.getTelephone()));

        DPdd.setValue(g.getDd_event().toLocalDate());

        DPdf.setValue(g.getDf_event().toLocalDate());

    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceEvent ev = new ServiceEvent();
        Evenement e = tbviewEvent.getSelectionModel().getSelectedItem();
        ev.supprimer(e);
        tbviewEvent.getItems().remove(e);
    }

}
