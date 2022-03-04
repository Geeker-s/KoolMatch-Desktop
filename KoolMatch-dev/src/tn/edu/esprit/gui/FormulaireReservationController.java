/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.jfoenix.controls.JFXRippler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import tn.edu.esprit.model.Reservation;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceReservation;
import tn.edu.esprit.services.ServiceRestaurant;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class FormulaireReservationController implements Initializable {
 ServiceRestaurant sp1 = new ServiceRestaurant();
    private Restaurant p1;
    @FXML
    private AnchorPane basepane;
    @FXML
    private Pane mypane;
    private TextField Fidresto;
    @FXML
    private TextField Fnbrplace;
    @FXML
    private Button idvalider;
    @FXML
    private DatePicker disponibilite;

    private ImageView idimage;
    @FXML
    private TextField nomres;
    @FXML
    private TextField nomuser;
    @FXML
    private TextField prenom;
    @FXML
    private TextField numtel;

    private void valider(ActionEvent event) throws IOException {

      
        ServiceReservation sp = new ServiceReservation();
        
        ServiceUser sp2 = new ServiceUser();

        Restaurant p1 = new Restaurant();
        nomres.setText(p1.getNom_restaurant());
        String a = p1.getImage();
        System.out.println(p1.getImage());
        File file = new File(a);
        Image image1 = new Image(file.toURI().toString());
        idimage.setImage(image1);

        User p2 = new User();
        p2.setNom_user(nomuser.getText());
        p2.setPrenom_user(prenom.getText());
        p2.setTelephone_user(Integer.parseInt(numtel.getText()));

        Reservation p = new Reservation();

        p.setNbPlace_reservation(Integer.parseInt(Fnbrplace.getText()));
        Date Date_reservation = Date.valueOf(this.disponibilite.getValue());
        p.setDate_reservation(Date_reservation);

        sp.ajouter(p);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                try {
            p1 = sp1.GetRestobyid(Restaurant.getId_courant());
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFXRippler ripper = new JFXRippler(mypane);
        ripper.setRipplerFill(Paint.valueOf("#ff0000"));
        ripper.setRipplerRadius(60);
        ripper.setMaskType(JFXRippler.RipplerMask.RECT);
        basepane.getChildren().add(ripper);
    }

}
