/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.edu.esprit.model.Interaction;
import tn.edu.esprit.model.Matching;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class MatchingController implements Initializable {

    @FXML
    private ListView<Matching> matches;
    @FXML
    private ListView<Interaction> reactions;
    @FXML
    private ListView<User> users;

    List<User> u;
    User x = new User();
    @FXML
    private GridPane grid;
    @FXML
    private ListView<User> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceUser user = new ServiceUser();
        users.getItems().addAll(user.afficher());
//        afficher();

    }

//    void afficher() {
//
//        int colum = 0;
//        int row = 0;
//        ServiceUser us = new ServiceUser();
//        u = us.afficher();
//        try {
//            for (int i = 0; i < u.size(); i++) {
//
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
//                AnchorPane anchorPane = loader.load();
//                anchorPane.setScaleShape(true);
//                anchorPane.setPrefSize(183, 243);
//                anchorPane.setMaxWidth(183);
//                anchorPane.setMaxHeight(243);
//                anchorPane.setLayoutX(25);
//                anchorPane.setLayoutY(10);
//                anchorPane.se tPrefWidth(row, i);
//                CardController controller = loader.getController();
//                controller.setAffichage(u.get(i));
//                ++colum;
//                
//                grid.add(anchorPane, colum++, row);
//                GridPane.setMargin(anchorPane, new Insets(5, 20, 10, 10));
//
//            }
//        } catch (IOException e) {
//            e.getMessage();
//        }
//    }

    @FXML
    private void index(MouseEvent event) {
        matches.getItems().clear();
        reactions.getItems().clear();
        x = users.getSelectionModel().getSelectedItem();
        ServiceMatching match = new ServiceMatching();
        ServiceInteraction react = new ServiceInteraction();
        matches.getItems().addAll(match.afficher().stream().filter(e -> e.getId_user1() == x.getId_user() || e.getId_user2() == x.getId_user()).collect(Collectors.toList()));
        reactions.getItems().addAll(react.afficher().stream().filter(e -> e.getId_user1() == x.getId_user()).collect(Collectors.toList()));
    }

    @FXML
    private void supprimerMatch(ActionEvent event) {
        ServiceMatching match = new ServiceMatching();
        match.supprimer(matches.getSelectionModel().getSelectedItem());
        int selecteditem = matches.getSelectionModel().getSelectedIndex();
        matches.getItems().remove(selecteditem);
    }

    @FXML
    private void autoMatch(ActionEvent event) {
        ServiceInteraction react = new ServiceInteraction();
        react.userLIKE(reactions.getSelectionModel().getSelectedItem());

    }

}
