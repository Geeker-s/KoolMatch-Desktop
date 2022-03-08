/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class SignInController implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Button login;
    @FXML
    private Label emailcontrol;
    @FXML
    private Label passcontrol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void connexion(ActionEvent event) {
        try {
            ServiceUser us = new ServiceUser();
            User usr = new User();
            usr.setEmail_user(tfusername.getText());
            usr.setPassword_user(tfpassword.getText());
            boolean verify = us.login(usr.getEmail_user(), usr.getPassword_user());
            CurrentUser = us.AssignCurrentUser(usr.getEmail_user(), usr.getPassword_user());

            if (verify && !CurrentUser.getAdresse_user().equals("x")) {
                try {

                    Stage primaryStage;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("front.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) login.getScene().getWindow();
                    CurrentStage.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }

            } else if (verify) {
                try {
                    Stage primaryStage;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root1));
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.show();
                    Stage CurrentStage = (Stage) login.getScene().getWindow();
                    CurrentStage.close();

                } catch (IOException ex) {
                    ex.getMessage();
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void emailControl(KeyEvent event
    ) {
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(tfusername.getText());
        if (!match.matches()) {
            emailcontrol.setText("Veuillez saisire une adresse Email Valide");
        } else {
            emailcontrol.setText(null);
        }
    }

    @FXML
    private void mdpControl(KeyEvent event
    ) {
        String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!/@#$%^&*])(?=\\S+$).{8,15}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(tfpassword.getText());
        if (!match.matches()) {
            passcontrol.setText("Mot de passe non valide");
        } else {
            passcontrol.setText(null);
        }
    }

//    @FXML
//    private void ForgetPassword(ActionEvent event) {
//        ServiceUser us = new ServiceUser();
//
//        String to = us.selectEmail(tfusername.getText());
//        String from = "emailmteei";
//        String host = "smtp.gmail.com";
//        final String username = "emailmteei";
//        final String password = "mdp";
//
//        //setup mail server
//        Properties props = System.getProperties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//
//            //create mail
//            MimeMessage m = new MimeMessage(session);
//            m.setFrom(new InternetAddress(from));
//            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
//            m.setSubject("Reset your password!");
//            m.setText("Hey! your password is : " + us.selectPassword(tfusername.getText()));
//
//            //send mail
//            Transport.send(m);
//
//            System.out.println("Message sent!");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//        tfusername.clear();
//        tfpassword.clear();
//    }

}
