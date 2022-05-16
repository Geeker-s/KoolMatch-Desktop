/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Conversations;
import tn.edu.esprit.model.Emojis;
import tn.edu.esprit.model.Messages;
import tn.edu.esprit.services.ServiceConversation;
import tn.edu.esprit.services.ServiceMessage;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Guedo
 */
public class Room implements Initializable {

    @FXML
    private Label clientName;
    @FXML
    private Circle showProPic;
    @FXML
    private SplitMenuButton BTMenu;
    @FXML
    private MenuItem supprimconv;
    @FXML
    private MenuItem signalconv;
    @FXML
    private Pane chat;
    @FXML
    private TextField msgField;
    @FXML
    private ListView<String> listemojis;
    @FXML
    private ImageView emojie;
    @FXML
    private TextArea msgRoom;
    @FXML
    private TextField msgrech;
    @FXML
    private ListView<Conversations> listview;

    private String msg_emoji;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProPic.setStroke(Color.valueOf("#90a4ae"));

        ServiceConversation ev = new ServiceConversation();
        listview.getItems().addAll(ev.afficher().stream().filter(e->e.getId_user1()==CurrentUser.getId_user()).findAny().orElse(null));

        Emojis emoji = new Emojis();
        listemojis.getItems().addAll(emoji.EMOJIS());
        msg_emoji = listemojis.getSelectionModel().getSelectedItem();
        listemojis.setVisible(false);
    }

    @FXML
    private void con_surpprimer(ActionEvent event) {
        ServiceConversation ev = new ServiceConversation();
        Conversations e = listview.getSelectionModel().getSelectedItem();
        ev.supprimer(e);
        listview.getItems().remove(e);
    }

    @FXML
    private void consignal(ActionEvent event) {
        ServiceConversation ev = new ServiceConversation();
        Conversations e = listview.getSelectionModel().getSelectedItem();
        ev.signal(e);
        listview.getItems().remove(e);
    }

    @FXML
    private void sendMessageByKey(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            String msg = msgField.getText();
            send(msg);
        }
    }

    @FXML
    private void emojj(MouseEvent event) {
        String e = listemojis.getSelectionModel().getSelectedItem();
        msgField.setText(msgField.getText() + e);

    }

    @FXML
    private void affiemojis(MouseEvent event) {
        emojie.setVisible(false);
        listemojis.setVisible(true);

        String aff = listemojis.getSelectionModel().getSelectedItem();
        if (aff != null) {
            listemojis.setVisible(false);
            emojie.setVisible(true);
        }
    }

    @FXML
    private void sendd(KeyEvent event) {
        String msg = msgField.getText();
        send(msg);

    }

    @FXML
    private void handleSendEvent(MouseEvent event) {
    }

    @FXML
    private void recherche_name(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            rechercher();
        } else {

            ServiceConversation sr = new ServiceConversation();

            ObservableList<Conversations> listr = FXCollections.observableList(sr.afficher());
            listview.setItems((listr));

        }
    }

    @FXML
    private void index(MouseEvent event) {
        Conversations g = (Conversations) listview.getSelectionModel().getSelectedItem();
        clientName.setText(g.getTitre_conversation());

        ServiceMessage ms = new ServiceMessage();

        ServiceUser u = new ServiceUser();

        File file = new File("src/tn/edu/esprit/images/" + u.afficher().stream().filter(e -> e.getId_user() == g.getId_user2()).findAny().orElse(null).getPhoto_user());
        Image image = new Image(file.toURI().toString());
        showProPic.setFill(new ImagePattern(image));

        clientName.setText(CurrentUser.getNom_user());
        msgRoom.setText(String.valueOf(ms.afficher(new Conversations(g.getId_conversation()))));
    }

    private void rechercher() {

        ServiceConversation sr = new ServiceConversation();

        ObservableList<Conversations> listr = FXCollections.observableList(sr.rechercher(new Conversations(msgrech.getText())));
        listview.setItems((listr));

    }

    public void send(String msg) {

        Conversations g = (Conversations) listview.getSelectionModel().getSelectedItem();
        ServiceMessage ms = new ServiceMessage();
        ms.ajouter(new Messages(msg), g.getId_conversation());
        // List<String> mm = ms.afficher(new Conversations(g.getId_conversation()));

        msgRoom.setText(String.valueOf(ms.afficher(new Conversations(g.getId_conversation()))));

        msgField.setText("");

    }
}
