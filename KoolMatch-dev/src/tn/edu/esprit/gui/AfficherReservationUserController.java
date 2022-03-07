/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import tn.edu.esprit.api.FB;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Reservation;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class AfficherReservationUserController implements Initializable {

    public String recherche = "";

    final Tooltip tooltip = new Tooltip();

    ServiceReservation service_pr = new ServiceReservation();
    Reservation p = new Reservation();
    @FXML
    private JFXListView<Pane> ListView_Produits;
    @FXML
    private JFXTextField rechercher;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // ListView_Produits.setMouseTransparent( true );
        ListView_Produits.setFocusTraversable(false);
        getShowPane();

    }

    public void getShowPane() {
        List<Reservation> AllProducts = new ArrayList();
        if (recherche.equals("")) {
            for (Reservation p : service_pr.afficher()) {
                AllProducts.add(p);

            }
        } else {
            for (Reservation p : service_pr.RechercheReservationsParNom(recherche)) {
                AllProducts.add(p);

            }

        }
        System.out.println(AllProducts);
        int i = 0;
        int j = 0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();

        List<Reservation> ThreeProducts = new ArrayList();
        for (Reservation p : AllProducts) {
            if (i == 0) {
                ThreeProducts.add(p);
                i++;
                j++;

                if (j == AllProducts.size()) {
                    System.out.println("hello322");
                    Panes.add(AddPane(ThreeProducts));

                    ThreeProducts.clear();

                }
            } else {
                ThreeProducts.add(p);
                i++;
                j++;
                if ((i % 3 == 0) || (j == AllProducts.size())) {

                    Panes.add(AddPane(ThreeProducts));

                    ThreeProducts.clear();

                }
            }
        }
        ListView_Produits.setItems(Panes);
    }

    public Pane AddPane(List<Reservation> ThreeProduct) {
        Pane pane = new Pane();
        int k = 1;
        for (Reservation p3 : ThreeProduct) {
            if (k == 1) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(25);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                Text t = new Text("quick view");

//                FontAwesomeIconView t1 = new FontAwesomeIconView(FontAwesomeIcon.BELL);
//                t1.setFill(Color.BROWN);
//                t1.setSize("20");
//                t1.setLayoutX(755);
//                t1.setLayoutY(85);
//                t1.setCursor(Cursor.HAND);
//
//                /**
//                 * ************* participate *******************
//                 */
//                t1.setOnMouseClicked((MouseEvent event) -> {
//
//                    System.out.println("aaaaaaa");
//                    Reservation.setId_courant(p3.getId_reservation());
//                    //int i =p3.getParticiate();
//                    System.out.println("aaa");
//                    // part.part(p3);
//
//                    t1.setIcon(FontAwesomeIcon.BELL_SLASH);
//                    t1.setDisable(true);
//
//                });
                /**
                 * ********** quick view**********
                 */
                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLACK);
                tq.setSize("18");

                tq.setCursor(Cursor.HAND);

                /**
                 * ********** Formulaire view**********
                 */
                FontAwesomeIconView btn = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
                btn.setFill(Color.BLACK);
                btn.setSize("18");
                btn.setLayoutX(210);
                btn.setLayoutY(240);

                btn.setCursor(Cursor.HAND);

                
                
                   btn.setOnMouseClicked((MouseEvent event) -> {
                       
                    Alert  b = new Alert(Alert.AlertType.NONE);
                    
                    
                                b.setAlertType(Alert.AlertType.CONFIRMATION);
        b.setTitle("Confirmation");
        b.setHeaderText(null);
        b.setContentText("Êtes-vous sûr de vouloir supprimer cette réservation");
      
        Optional <ButtonType> action = b.showAndWait();
         
        if(action.get()== ButtonType.OK)
        {    
            
        
           
      service_pr.supprimer(p3);
            
        getShowPane();
    }
        else
        {
            getShowPane();
        
        }
                    
                    
         
                });

                
                /**
                 * ******************************
                 */
                HBox hb = new HBox(tq);
                HBox hb2 = new HBox(btn);
                Restaurant p4 = new Restaurant();
                hb.setLayoutX(0);
                hb.setLayoutY(170);
                hb.setPrefWidth(hb.getWidth() + 190);
                hb.setPrefHeight(hb.getHeight() + 75);
                hb.setStyle("-fx-background-color: #2cbae3");

                hb2.setLayoutX(173);
                hb2.setLayoutY(170);
                hb2.setPrefWidth(hb.getWidth() + 45);
                hb2.setPrefHeight(hb.getHeight() + 75);
                hb2.setStyle("-fx-background-color: #2cbae3");
                pane2.getChildren().addAll(hb, hb2);

        Text nomt = new Text(String.valueOf("nom "+ ":"  + p3.getId_restaurant()));
                Text prenom = new Text("prenom"+ ":" +String.valueOf(p3.getId_user()));
                Text num = new Text("hello" + ""+ String.valueOf(p3.getNbPlace_reservation()));
                Label nom = new Label(" bonjour" + ":"+String.valueOf(p3.getNbPlace_reservation()));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
                String strDate = dateFormat.format(p3.getDate_reservation());
                Text prixt = new Text(strDate);

                nomt.setLayoutX(50);
                nomt.setLayoutY(80);
                prenom.setLayoutX(50);
                prenom.setLayoutY(110);
                num.setLayoutX(50);
                num.setLayoutY(140);
                nom.setLayoutX(50);
                nom.setLayoutY(154);
                prixt.setLayoutX(50);
                prixt.setLayoutY(200);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                nom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                num.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prenom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                /**
                 * ************* web view ***************
                 *
                 *
                 * /**
                 * **********************************************
                 */
                /**
                 * **********************partage facebook********************
                 */
                      pane.getChildren().addAll(pane2, nomt, prixt, nom, btn,prenom,num);
//                             

            }

            if (k == 2) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(300);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                //pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                /**
                 * ********** quick view**********
                 */
                /**
                 * ********************************************
                 */
                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLACK);
                tq.setSize("18");

                tq.setCursor(Cursor.HAND);
                /**
                 * ********** quick view**********
                 */

                FontAwesomeIconView btn = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
                btn.setFill(Color.BLACK);
                btn.setSize("18");
                btn.setLayoutX(470);
                btn.setLayoutY(240);

                btn.setCursor(Cursor.HAND);

               
                
               
                
               // ---------------------------------------------delete alert  
                
                
                btn.setOnMouseClicked((MouseEvent event) -> {
                       
                    Alert  b = new Alert(Alert.AlertType.NONE);
                    
                    
                                b.setAlertType(Alert.AlertType.CONFIRMATION);
        b.setTitle("Confirmation");
        b.setHeaderText(null);
        b.setContentText("Êtes-vous sûr de vouloir supprimer cette réservation");
      
        Optional <ButtonType> action = b.showAndWait();
         
        if(action.get()== ButtonType.OK)
        {    
            
        
           
      service_pr.supprimer(p3);
            
        getShowPane();
    }
        else
        {
            getShowPane();
        
        }
                    
                    
                    
                  //  service_pr.supprimer(p3);
                  //  ListView_Produits.setItems(null);
                  //  getShowPane();
                   
                });

                
                
                
                
                HBox hb = new HBox(tq);
                HBox hb2 = new HBox(btn);

                hb.setLayoutX(0);
                hb.setLayoutY(170);
                hb.setPrefWidth(hb.getWidth() + 190);
                hb.setPrefHeight(hb.getHeight() + 75);
                hb.setStyle("-fx-background-color: #2cbae3");

                hb2.setLayoutX(173);
                hb2.setLayoutY(170);
                hb2.setPrefWidth(hb.getWidth() + 45);
                hb2.setPrefHeight(hb.getHeight() + 75);
                hb2.setStyle("-fx-background-color: #2cbae3");
                pane2.getChildren().addAll(hb, hb2);

                Text nomt = new Text("Nom"+ CurrentUser.getNom_user());
                Text prenom = new Text("Prénom"+CurrentUser.getPrenom_user());
                Text num = new Text("Telephone"+String.valueOf(CurrentUser.getTelephone_user()));
//                Text nomt = new Text(String.valueOf("nom "+ ":"  + p3.getId_restaurant()));
//                Text prenom = new Text("prenom"+ ":" +String.valueOf(p3.getId_user()));
//                Text num = new Text("hello" + ""+ String.valueOf(p3.getNbPlace_reservation()));
                Label nom = new Label(" bonjour" + ":"+String.valueOf(p3.getNbPlace_reservation()));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
                String strDate = dateFormat.format(p3.getDate_reservation());
                Text prixt = new Text(strDate);

                nomt.setLayoutX(327);
                nomt.setLayoutY(80);
                prenom.setLayoutX(327);
                prenom.setLayoutY(110);
                num.setLayoutX(327);
                num.setLayoutY(140);
                nom.setLayoutX(327);
                nom.setLayoutY(154);
                prixt.setLayoutX(327);
                prixt.setLayoutY(200);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                nom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                num.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prenom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                /**
                 * **********************************************
                 *
                 **********************partage facebook********************
                 */
                pane.getChildren().addAll(pane2, nomt, prixt, nom, btn,prenom,num);
            }

            if (k == 3) {
                Pane pane2 = new Pane();
                pane2.setLayoutX(575);
                pane2.setLayoutY(50);
                pane2.setPrefWidth(pane2.getWidth() + 215);
                pane2.setPrefHeight(pane2.getHeight() + 200);
                //pane2.setStyle("-fx-background-radius: 50;");
                pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

                FontAwesomeIconView tq = new FontAwesomeIconView(FontAwesomeIcon.EXPAND);
                tq.setFill(Color.BLACK);
                tq.setSize("18");

                tq.setCursor(Cursor.HAND);

                FontAwesomeIconView btn = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
                btn.setFill(Color.BLACK);
                btn.setSize("18");
                btn.setLayoutX(750);
                btn.setLayoutY(240);

                btn.setCursor(Cursor.HAND);
                        
                
                btn.setOnMouseClicked((MouseEvent event) -> {
                       
                    Alert  b = new Alert(Alert.AlertType.NONE);
                    
                    
                                b.setAlertType(Alert.AlertType.CONFIRMATION);
        b.setTitle("Confirmation");
        b.setHeaderText(null);
        b.setContentText("Êtes-vous sûr de vouloir supprimer cette réservation");
      
        Optional <ButtonType> action = b.showAndWait();
         
        if(action.get()== ButtonType.OK)
        {    
            
        
           
      service_pr.supprimer(p3);
            
        getShowPane();
    }
        else
        {
            getShowPane();
        
        }
                    
          
                   
                });


                Text t1 = new Text("");
                HBox hb = new HBox(tq);
                HBox hb2 = new HBox(btn);

                Restaurant p4 = new Restaurant();
                hb.setLayoutX(0);
                hb.setLayoutY(170);
                hb.setPrefWidth(hb.getWidth() + 190);
                hb.setPrefHeight(hb.getHeight() + 75);
                hb.setStyle("-fx-background-color: #2cbae3");

                hb2.setLayoutX(173);
                hb2.setLayoutY(170);
                hb2.setPrefWidth(hb.getWidth() + 45);
                hb2.setPrefHeight(hb.getHeight() + 75);
                hb2.setStyle("-fx-background-color: #2cbae3");
                pane2.getChildren().addAll(hb, hb2);

                String A = p4.getImage();
          Text nomt = new Text(String.valueOf("nom "+ ":"  + p3.getId_restaurant()));
                Text prenom = new Text("prenom"+ ":" +String.valueOf(p3.getId_user()));
                Text num = new Text("hello" + ""+ String.valueOf(p3.getNbPlace_reservation()));
                Label nom = new Label(" bonjour" + ":"+String.valueOf(p3.getNbPlace_reservation()));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");
                String strDate = dateFormat.format(p3.getDate_reservation());
                Text prixt = new Text(strDate);

                nomt.setLayoutX(600);
                nomt.setLayoutY(80);
                prenom.setLayoutX(600);
                prenom.setLayoutY(110);
                num.setLayoutX(600);
                num.setLayoutY(140);
                nom.setLayoutX(600);
                nom.setLayoutY(154);
                prixt.setLayoutX(600);
                prixt.setLayoutY(200);
                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                nom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                num.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                prenom.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");

                /**
                 * ************* web view ***************
                 *
                 *
                 * /**
                 * **********************************************
                 */
                /**
                 * **********************partage facebook********************
                 */
                      pane.getChildren().addAll(pane2, nomt, prixt, nom, btn,prenom,num);

            }
            k++;

        }
        return pane;
    }

    @FXML
    private void search(KeyEvent event) {

        recherche = rechercher.getText();
        getShowPane();

    }

}
