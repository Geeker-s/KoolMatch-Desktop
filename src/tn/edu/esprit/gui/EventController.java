/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tn.edu.esprit.services.ServiceEvent;
import tn.edu.esprit.model.Evenement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tn.edu.esprit.services.ServiceInvitation;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EventController implements Initializable {

    

List<Evenement> events = new ArrayList<>();
    @FXML
    private GridPane event;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherU();

    }
    
    
 public void afficherU() {

        int colum = 0;
        int row = 0;
        ServiceEvent ev = new ServiceEvent();
        events = ev.afficher();
        try {
            for (int i = 0; i < events.size(); i++) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("CardviewEvent.fxml"));
                AnchorPane anchorPane = loader.load();
                CardviewEventController controller = loader.getController();
                controller.setAffichage(events.get(i));

                ++colum;

                event.add(anchorPane, colum++, row);
                GridPane.setMargin(anchorPane, new Insets(25, 15, 0, 0));
               
                

            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
