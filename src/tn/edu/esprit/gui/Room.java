package tn.edu.esprit.gui;

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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceUser;

//import static tn.edu.esprit.gui.Controller.loggedInUser;
//import static tn.edu.esprit.gui.Controller.users;
public class Room extends Thread implements Initializable {

    @FXML
    public Label clientName;
    public Button chatBtn;
    @FXML
    public Pane chat;
    @FXML
    public TextField msgField;
    @FXML
    public TextArea msgRoom;
    public Label online;
    public Label fullName;
    public Label email;
    public Label phoneNo;
    public Label gender;
    public Pane profile;
    public Button profileBtn;
    public TextField fileChoosePath;
    public ImageView proImage;
    @FXML
    public Circle showProPic;
    private FileChooser fileChooser;
    private File filePath;
    public boolean toggleChat = false, toggleProfile = false;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    ServiceUser u = new ServiceUser();

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
        Image image;
//        if (Controller.gender.equalsIgnoreCase("Male")) {
        image = new Image("tn/edu/esprit/images/icons/user.png");
//        } else {
//            image = new Image("images/icons/female.png", false);
//            proImage.setImage(image);
//        }
        showProPic.setFill(new ImagePattern(image));
        clientName.setText(CurrentUser.getNom_user());
//        connectSocket();
    }
}
