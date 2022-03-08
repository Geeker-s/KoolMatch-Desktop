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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import org.controlsfx.control.Notifications;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Reservation;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceReservation;
import tn.edu.esprit.services.ServiceRestaurant;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.api.sendSMS;

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
    private DatePicker disponibilite;

    @FXML
    private ImageView idimage;
    @FXML
    private TextField nomres;
    @FXML
    private TextField nomuser;
    @FXML
    private Button button;

    /**
     * Initializes the controller class.
     */
      private boolean NoDate() {
        boolean test = false;
        System.out.println(ChronoUnit.DAYS.between(this.disponibilite.getValue(), (Temporal) Calendar.getInstance().getTime()));
        int b = (int) ChronoUnit.DAYS.between(LocalDate.now(), this.disponibilite.getValue());
        System.out.println("aaaaaaaaaa" + b);
        if (b < 0) {

            test = true;

        }
        return test;
    }
       private void notif(ActionEvent event) {
        Notifications n = Notifications.create().title("")
                .text("Date début doit étre supériur à date fin ou date début sépérieur au date d'aujourd'hui")
                .graphic(null)
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        System.out.println("clicked on notification");
                    }
                });
        n.showWarning();}
       
       
       
       
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

        nomres.setText(p1.getNom_restaurant());
        nomres.setEditable(false);

        nomuser.setText(p1.getAdresse_restaurant());
        nomuser.setEditable(false);
        String a = p1.getImage();
        System.out.println(a);
        System.out.println(p1.getImage());
        File file = new File(a);
        Image image1 = new Image(file.toURI().toString());
        idimage.setImage(image1);

    }

    @FXML
    private void insert(ActionEvent event) throws SQLException {
        p1 = sp1.GetRestobyid(Restaurant.getId_courant());
       sendSMS sms = new sendSMS();
       ServiceReservation sp = new ServiceReservation();
       

        ServiceUser sp2 = new ServiceUser();

       //nomres.setText(p1.getNom_restaurant());
  
      Reservation p = new Reservation();

        p.setId_restaurant(p1.getId_restaurant());
        // p.setId_user(CurrentUser.getId_user());
       // p.setId_user(1);

        //  p2.setNom_user(nomuser.getText());//nom cureetn user 
       // p.setNbPlace_reservation(Integer.parseInt(Fnbrplace.getText()));
      // Date Date_reservation = Date.valueOf(this.disponibilite.getValue());
      // p.setDate_reservation(Date_reservation);
       
            int b = (int) ChronoUnit.DAYS.between(LocalDate.now(), this.disponibilite.getValue());
       if (Fnbrplace.getText().equals(""))
       
       {
         Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("nombre invalid ");
            alert.setContentText("veuillez saisir le nombre de places");

            alert.showAndWait();
       }
      
       else if (b<=0)
           {
               
               Alert alert = new Alert(AlertType.ERROR);  
               

            alert.setTitle("Error alert");
            alert.setHeaderText("date invalid ");
            alert.setContentText("veuillez saisir une date supérieur à aujourd'hui");

            alert.showAndWait();
               
               }
           
           
       else if (sp.Already_reserved(CurrentUser.getId_user(), Date.valueOf(disponibilite.getValue())))
               
               {
                  Alert alert = new Alert(AlertType.ERROR);  
               

            alert.setTitle("Error alert");
            alert.setHeaderText("reservé déja ");
            alert.setContentText("vous avez déja reservé dans cette date");

            alert.showAndWait();
      } 
               
       else if (sp.place_disponible(p1, Integer.parseInt(Fnbrplace.getText()), Date.valueOf(disponibilite.getValue()) )==false) 
   
           
       {
                  Alert alert = new Alert(AlertType.ERROR);  
               

            alert.setTitle("Error alert");
            alert.setHeaderText("Complet");
            alert.setContentText("toute les places sont réservés");

            alert.showAndWait();
      }
       
       
       else {
       
               p.setId_restaurant(p1.getId_restaurant());
         p.setId_user(CurrentUser.getId_user());
      
        //  p2.setNom_user(nomuser.getText());//nom cureetn user 
        p.setNbPlace_reservation(Integer.parseInt(Fnbrplace.getText()));
       Date Date_reservation = Date.valueOf(this.disponibilite.getValue());
       p.setDate_reservation(Date_reservation);
       p.setNom_resto(p1.getNom_restaurant());
       p.setImage(p1.getImage());
       p.setAdresse(p1.getAdresse_restaurant());
       sp.ajouter(p);
       tn.edu.esprit.api.sendSMS.sendSMS(CurrentUser);
      
   
  
         
         Alert alert = new Alert(AlertType.INFORMATION);

            alert.setTitle("Bienvenue dans mon restaurant");
            alert.setHeaderText(null);
            alert.setContentText("Merci pour ta confiance");

            alert.showAndWait();

       
       
       
           System.out.println("ajoute avec succes ");
       
       // rodou yemchi l page okhra mes reservation par exemple 
       
       }
    
    }
       

       /* if (Integer.parseInt(Fnbrplace.getText()) > p1.getNb_placeResto()) {
            Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("Le nombre de places n'est pas disponible pour aujourd'hui, veuillez voir une autre date ");
            alert.setContentText("Le nombre de places est inférieur au nombre de restaurant que vous choisissez");

            alert.showAndWait();

        }else if (NoDate()) {
  
            notif(event);}
         else 

if (disponibilite.equals("")) {
    System.out.println("hello");
            Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh ");
            alert.setContentText("hhhhhhhhhhhhhhhhhhhhhhhhh");
            alert.showAndWait();
   
      System.out.println("uyfgoopm");
       }  else {
            sp.ajouter(p);
            sp1.updateNbrPlace(p1, Integer.parseInt(Fnbrplace.getText()));

        }
        

     
       */   
}

