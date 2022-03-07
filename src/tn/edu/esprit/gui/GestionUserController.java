/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceGerant;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author MED ZOUARI
 */
public class GestionUserController implements Initializable {

    @FXML
    private TextField nomGerant;
    @FXML
    private TextField prenomGerant;
    @FXML
    private PasswordField mdpGerant;
    @FXML
    private TextField telGerant;
    @FXML
    private DatePicker dda;
    @FXML
    private DatePicker ddf;
    @FXML
    private ListView<Gerant> listGerant;
    @FXML
    private ListView<User> listuser;
    @FXML
    private TextField emailGerant;
    private Label mdpcontrol;
    private Label emailcontrol;
    @FXML
    private Label nomGcontrol;
    @FXML
    private Label prenomGcontrol;
    @FXML
    private Label mdpGcontrol;
    @FXML
    private Label emailGcontrol;
    @FXML
    private Label telGcontrol;
    @FXML
    private Label ddaGcontrol;
    @FXML
    private Label ddfGcontrol;
    @FXML
    private Label ddfGcontrol1;
    @FXML
    private Label formulairecontrol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceGerant g = new ServiceGerant();
        listGerant.getItems().addAll(g.afficher());

        ServiceUser u = new ServiceUser();
        listuser.getItems().addAll(u.afficher());
    }

    @FXML
    private void addGerant(MouseEvent event) {
        if (this.isValidated()) {
            Statement stmt;
        }
        ServiceGerant g = new ServiceGerant();
        Gerant gr = new Gerant();
        gr.setNom_gerant(nomGerant.getText());
        gr.setPrenom_gerant(prenomGerant.getText());
        gr.setPassword_gerant(mdpGerant.getText());
        gr.setEmail_gerant(emailGerant.getText());
        gr.setTelephone_gerant(Integer.parseInt(telGerant.getText()));
        LocalDate FDate = dda.getValue();
        String Sdate = String.valueOf(FDate);
        gr.setDd_abonnement(Date.valueOf(Sdate));
        LocalDate FFDate = ddf.getValue();
        String SSdate = String.valueOf(FFDate);
        gr.setDf_abonnement(Date.valueOf(SSdate));

        g.ajouter(gr);
        nomGerant.setText("");
        prenomGerant.setText("");
        mdpGerant.setText("");
        telGerant.setText("");
        emailGerant.setText("");
        dda.getEditor().clear();
        ddf.getEditor().clear();
        listGerant.getItems().clear();
        listGerant.getItems().addAll(g.afficher());
        ddaGcontrol.setText(null);
        ddaGcontrol.setText(null);

    }

    @FXML
    private void updateGerant(MouseEvent event) {
        ServiceGerant g = new ServiceGerant();
        Gerant gerant = listGerant.getSelectionModel().getSelectedItem();
        Gerant n = new Gerant();

        n.setId_gerant(gerant.getId_gerant());
        n.setArchive(gerant.getArchive());
        LocalDate FDate = dda.getValue();
        String Sdate = String.valueOf(FDate);
        n.setDd_abonnement(Date.valueOf(Sdate));
        LocalDate FFDate = ddf.getValue();
        String SSdate = String.valueOf(FFDate);
        n.setDf_abonnement(Date.valueOf(SSdate));
        n.setEmail_gerant(emailGerant.getText());
        n.setNom_gerant(nomGerant.getText());
        n.setPassword_gerant(mdpGerant.getText());
        n.setPrenom_gerant(prenomGerant.getText());
        n.setTelephone_gerant(Integer.parseInt(telGerant.getText()));

        g.modifer(n);
        nomGerant.setText("");
        prenomGerant.setText("");
        mdpGerant.setText("");
        telGerant.setText("");
        emailGerant.setText("");
        dda.setValue(null);
        ddf.setValue(null);
        listGerant.getItems().clear();
        listGerant.getItems().addAll(g.afficher());

    }

    @FXML
    private void index(MouseEvent event) {
        Gerant g = listGerant.getSelectionModel().getSelectedItem();

        nomGerant.setText(g.getNom_gerant());
        prenomGerant.setText(g.getPrenom_gerant());
        mdpGerant.setText(g.getPassword_gerant());
        telGerant.setText(String.valueOf(g.getTelephone_gerant()));
        emailGerant.setText(g.getEmail_gerant());
        dda.setValue(g.getDd_abonnement().toLocalDate());
        ddf.setValue(g.getDf_abonnement().toLocalDate());

    }

    @FXML
    private void deleteUser(ActionEvent event) {
        ServiceUser u = new ServiceUser();
        User user = listuser.getSelectionModel().getSelectedItem();
        u.supprimer(user);
        listuser.getItems().remove(user);
    }

    @FXML
    private void deleteGerant(ActionEvent event) {
        ServiceGerant g = new ServiceGerant();
        Gerant gerant = listGerant.getSelectionModel().getSelectedItem();
        g.supprimer(gerant);
        listGerant.getItems().remove(gerant);
    }

    @FXML
    private void nomGerantControl(KeyEvent event) {
        String PATTERN = "^[a-z A-Z]{3,20}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(nomGerant.getText());
        if (!match.matches()) {
            nomGcontrol.setText("Nom non valide");
        } else {
            nomGcontrol.setText(null);
        }
    }

    @FXML
    private void prenomGerantControl(KeyEvent event) {
        String PATTERN = "^[a-z A-Z]{3,20}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(prenomGerant.getText());
        if (!match.matches()) {
            prenomGcontrol.setText("Prenom non valide");
        } else {
            prenomGcontrol.setText(null);
        }
    }

    @FXML
    private void mdpGerantControl(KeyEvent event) {
        String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*/])(?=\\S+$).{8,15}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(mdpGerant.getText());
        if (!match.matches()) {
            mdpGcontrol.setText("Mot de passe non valide");
        } else {
            mdpGcontrol.setText(null);
        }
    }

    @FXML
    private void emailGerantControl(KeyEvent event) {
        String PATTERN = "^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(emailGerant.getText());
        if (!match.matches()) {
            emailGcontrol.setText("Email non valide");
        } else {
            emailGcontrol.setText(null);
        }
    }

    @FXML
    private void telGerantControl(KeyEvent event) {
        String PATTERN = "^(90|92|93|94|95|96|97|98|99|20|21|22|23|24|25|26|27|28|29|50|51|52|53|54|55|40|41|42|43)[0-9]{6}";
        Pattern p = Pattern.compile(PATTERN);
        Matcher match = p.matcher(telGerant.getText());
        if (!match.matches()) {
            telGcontrol.setText("Numéro de téléphone non valide");
        } else {
            telGcontrol.setText(null);
        }
    }

    @FXML
    private void ddaGerantControl(KeyEvent event) {
       
            ddaGcontrol.setText(null);
        
    }

    @FXML
    private void ddfGerantControl(KeyEvent event) {
         ddaGcontrol.setText(null);
    }

    private boolean isValidated() {

        if (nomGerant.getText().equals("")) {
            nomGcontrol.setText("Ajouter le nom du gérant");
        } else if (prenomGerant.getText().equals("")) {
            prenomGcontrol.setText("Ajouter le prenom du gérant");
        } else if (mdpGerant.getText().equals("")) {
            mdpGcontrol.setText("Ajouter un mot de passe ");
        } else if (emailGerant.getText().equals("")) {
            emailGcontrol.setText("Ajouter l'email du gérant ");
        } else if (telGerant.getText().equals("")) {
            telGcontrol.setText("Ajouter le téléphone ");
        } else if (dda.getValue() == null) {
            ddaGcontrol.setText("Ajouter date début abonnement ");
        } else if (ddf.getValue() == null) {
            ddfGcontrol.setText("Ajouter date fin abonnement ");
        } else {
            return true;
        }
        return false;
    }
}
