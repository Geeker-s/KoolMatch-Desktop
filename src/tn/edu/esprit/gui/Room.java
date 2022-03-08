package tn.edu.esprit.gui;

import com.mysql.cj.x.protobuf.Mysqlx;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import com.twilio.rest.conversations.v1.service.Conversation;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import org.apache.commons.lang3.StringUtils;
import javafx.scene.control.MenuItem;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.Conversations;
import tn.edu.esprit.model.Messages;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceConversation;
import tn.edu.esprit.services.ServiceMessage;
import tn.edu.esprit.services.ServiceUser;
import java.util.List;
import tn.edu.esprit.model.Emojis;
//import static tn.edu.esprit.gui.Controller.loggedInUser;
//import static tn.edu.esprit.gui.Controller.users;

public class Room extends Thread implements Initializable {

    @FXML
    public Label clientName;

    @FXML
    public Pane chat;
    @FXML
    public TextField msgField;
    @FXML
    public TextArea msgRoom;

    @FXML
    public Circle showProPic;

    public boolean toggleChat = false, toggleProfile = false;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    ServiceUser u = new ServiceUser();
    @FXML
    private TextField msgrech;
    @FXML
    private ListView<Conversations> listview;
    @FXML
    private SplitMenuButton BTMenu;
    @FXML
    private MenuItem supprimconv;
    @FXML
    private MenuItem signalconv;
    @FXML
    private ImageView emojie;
    @FXML
    private ListView<String> listemojis;
    private String msg_emoji;

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 8889);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);
                if (cmd.equalsIgnoreCase(CurrentUser.getNom_user() + ":")) {
                    continue;
                } else if (fulmsg.toString().equalsIgnoreCase("bye")) {
                    break;
                }
                msgRoom.appendText(msg + "\n");

            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void handleSendEvent(MouseEvent event) {
        ServiceUser u = new ServiceUser();
        java.util.List<User> users = u.afficher();
        send();
        for (User user : users) {
            System.out.println(user.getNom_user());
        }
    }

    public void send() {

        String msg = msgField.getText();

        Conversations g = (Conversations) listview.getSelectionModel().getSelectedItem();
        ServiceMessage ms = new ServiceMessage();
        ms.ajouter(new Messages(msg), g.getId_conversation());

        writer.println(CurrentUser.getNom_user() + ": " + msg);
        msgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        msgRoom.appendText("Me: " + msg + "\n");

        msgField.setText("");
        if (msg.equalsIgnoreCase("BYE") || (msg.equalsIgnoreCase("logout"))) {
            System.exit(0);
        }
    }

    @FXML
    public void sendMessageByKey(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            send();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showProPic.setStroke(Color.valueOf("#90a4ae"));

        ServiceConversation ev = new ServiceConversation();
//    java.util.List <Conversations> g = ev.afficher();
        listview.getItems().addAll(ev.afficher());
//       byte[] emojiByteCode = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x81};
//       String emoji = new String(emojiByteCode, Charset.forName("UTF-8"));

        Emojis emoji = new Emojis();
        listemojis.getItems().addAll(emoji.EMOJIS());
        msg_emoji = listemojis.getSelectionModel().getSelectedItem();
        listemojis.setVisible(false);

        connectSocket();
    }

    private void rechercher() {
//        ServiceEvent sr =new ServiceEvent();
        // Recette recette = sr.recherchern(new Recette(rech.getText())).get(0) ;
//       Evenement rec = new Evenement(rech.getText());
        ServiceConversation sr = new ServiceConversation();

        ObservableList<Conversations> listr = FXCollections.observableList(sr.rechercher(new Conversations(msgrech.getText())));
        listview.setItems((listr));

    }

    @FXML
    private void index(MouseEvent event) {
        Conversations g = (Conversations) listview.getSelectionModel().getSelectedItem();
        clientName.setText(g.getTitre_conversation());

        // image = new Image(CurrentUser.getPhoto_user());
        // showProPic.setFill(new ImagePattern(image));
        ServiceMessage ms = new ServiceMessage();

        ServiceUser u = new ServiceUser();

        File file = new File("src/tn/edu/esprit/images/" + u.afficher().stream().filter(e -> e.getId_user() == g.getId_user2()).findAny().orElse(null).getPhoto_user());
        Image image = new Image(file.toURI().toString());
        showProPic.setFill(new ImagePattern(image));

 
//        if (Controller.gender.equalsIgnoreCase("Male")) {
       
//        } else {
//            image = new Image("images/icons/female.png", false);
//            proImage.setImage(image);
//        }
//        showProPic.setFill(new ImagePattern(image));
        clientName.setText(CurrentUser.getNom_user());
        //  System.out.println(g.getId_conversation());
        msgRoom.setText(String.valueOf(ms.afficher(new Conversations(g.getId_conversation()))));

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
    private void sendd(KeyEvent event) {
        send();
    }

    @FXML
    private void emojj(MouseEvent event) {
        String e = listemojis.getSelectionModel().getSelectedItem();
        msgField.setText(msgField.getText() + e);
    }

}
