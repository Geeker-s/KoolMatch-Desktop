/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Interaction;
import tn.edu.esprit.model.Matching;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author wassimromdhane
 */
public class FrontController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnConversation;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnRestaurant;
    @FXML
    private Button btnRecettes;
    @FXML
    private Button btnEvent;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnLogout;
    @FXML
    private Pane pnlHome;
    @FXML
    private Pane pnlConversation;
    @FXML
    private Pane pnlProfile;
    @FXML
    private Pane pnlRestaurant;
    @FXML
    private Pane pnlRecettes;
    @FXML
    private Pane pnlEvent;
    @FXML
    private Pane pnlSettings;
    @FXML
    private Pane pnlLogout;
    @FXML
    private Button btnSkip;
    @FXML
    private Button btnLike;
    @FXML
    private Pane card;

    CardController c;
    FilterController f;
    List<User> matches;
    int i;
    @FXML
    private Pane filter;
    @FXML
    private Label nom_user;
    @FXML
    private Circle photo_user;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public int addI() {
        return i++;
    }

    public void setMatches(User u, List<User> matches) {
        ServiceMatching match = new ServiceMatching();
        this.matches = match.algorithme(u);
    }

    public void setC(CardController c) {
        this.c = c;
    }

    public void setF(FilterController f) {
        this.f = f;
    }

    public Pane getCard() {
        return card;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("src/tn/edu/esprit/images/" + CurrentUser.getPhoto_user());
        Image image = new Image(file.toURI().toString());
        photo_user.setFill(new ImagePattern(image));
        photo_user.setEffect(new DropShadow(+25d, 0d, +2d, Color.TRANSPARENT));
        nom_user.setText(CurrentUser.getNom_user() + " " + CurrentUser.getPrenom_user());
        pnlHome.setStyle("-fx-background-color : #e7e5e5");
        pnlHome.toFront();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
        Pane newLoadedPane;
        try {
            newLoadedPane = loader.load();
            card.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            ex.getMessage();
        }
        CardController controller = (CardController) loader.getController();
        //setters
        setC(controller);
        setMatches(CurrentUser, matches);
        setI(0);
        c.setAffichage(matches.get(getI()));

        FXMLLoader loadFilter = new FXMLLoader(getClass().getResource("filter.fxml"));
        Pane newLoadfilter;
        try {
            newLoadfilter = loadFilter.load();
            filter.getChildren().add(newLoadfilter);
        } catch (IOException ex) {
            ex.getMessage();
        }
        FXMLLoader loadmsg = new FXMLLoader(getClass().getResource("Room.fxml"));
        Pane paneMsg;
        try {
            paneMsg = loadmsg.load();
            pnlConversation.getChildren().add(paneMsg);
        } catch (IOException ex) {
            ex.getMessage();
        }
//        FilterController fcontroller = (FilterController) loader.getController();
//        setters
//        setF(fcontroller);

    }

    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        ServiceInteraction react = new ServiceInteraction();

        if (actionEvent.getSource() == btnProfile) {
            pnlProfile.setStyle("-fx-background-color : #e7e5e5");
            pnlProfile.toFront();
        }
        if (actionEvent.getSource() == btnRestaurant) {
            pnlRestaurant.setStyle("-fx-background-color : #e7e5e5");
            pnlRestaurant.toFront();
        }
        if (actionEvent.getSource() == btnHome) {
            pnlHome.setStyle("-fx-background-color : #e7e5e5");
            pnlHome.toFront();
        }
        if (actionEvent.getSource() == btnConversation) {
            pnlConversation.setStyle("-fx-background-color : #e7e5e5");
            pnlConversation.toFront();
        }
        if (actionEvent.getSource() == btnLogout) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText("You're about to logout!");
            alert.initStyle(StageStyle.UNDECORATED);
            if (alert.showAndWait().get() == ButtonType.OK) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root1;
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) btnLogout.getScene().getWindow();
                    CurrentStage.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }

        if (actionEvent.getSource() == btnSettings) {
            pnlSettings.setStyle("-fx-background-color : #e7e5e5");
            pnlSettings.toFront();
        }
        if (actionEvent.getSource() == btnEvent) {
            pnlEvent.setStyle("-fx-background-color : #e7e5e5");
            pnlEvent.toFront();
        }
        if (actionEvent.getSource() == btnRecettes) {
            pnlRecettes.setStyle("-fx-background-color : #e7e5e5");
            pnlRecettes.toFront();
        }
        if (actionEvent.getSource() == btnLike) {
            react.ajouter(new Interaction("o", Date.valueOf(LocalDate.now()), CurrentUser.getId_user(), matches.get(getI()).getId_user()));
            addI();
            if (getI() >= matches.size()) {
                System.out.println("list vide");
            } else {

                User y = matches.get(getI());
                c.setAffichage(y);
            }
        }
        if (actionEvent.getSource() == btnSkip) {
            react.ajouter(new Interaction("x", Date.valueOf(LocalDate.now()), CurrentUser.getId_user(), matches.get(getI()).getId_user()));
            addI();

            if (getI() >= matches.size()) {
                System.out.println("list vide");
            } else {
                User y = matches.get(getI());
                c.setAffichage(y);
            }
        }
    }
}
