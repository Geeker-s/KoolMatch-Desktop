/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.MapOptions;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author wassimromdhane
 */
public class FormController implements Initializable {

    @FXML
    private RadioButton r11;
    @FXML
    private RadioButton r12;
    @FXML
    private RadioButton r13;
    @FXML
    private RadioButton r21;
    @FXML
    private RadioButton r22;
    @FXML
    private RadioButton r23;
    @FXML
    private RadioButton r31;
    @FXML
    private RadioButton r41;
    @FXML
    private RadioButton r42;
    @FXML
    private RadioButton r51;
    @FXML
    private RadioButton r52;
    @FXML
    private RadioButton r53;
    @FXML
    private RadioButton r32;
    @FXML
    private RadioButton r33;
    @FXML
    private RadioButton r43;
    @FXML
    private TextField adresse;
    @FXML
    private TextField photo;
    @FXML
    private TextArea description;
    @FXML
    private Button valider;
    @FXML
    private Button importer;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final FileChooser fileChooser = new FileChooser();
        final Desktop desktop = Desktop.getDesktop();

        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();
        ToggleGroup group4 = new ToggleGroup();
        ToggleGroup group5 = new ToggleGroup();

        r11.setToggleGroup(group1);
        r12.setToggleGroup(group1);
        r13.setToggleGroup(group1);

        r21.setToggleGroup(group2);
        r22.setToggleGroup(group2);
        r23.setToggleGroup(group2);

        r31.setToggleGroup(group3);
        r32.setToggleGroup(group3);
        r32.setToggleGroup(group3);

        r41.setToggleGroup(group4);
        r42.setToggleGroup(group4);
        r43.setToggleGroup(group4);

        r51.setToggleGroup(group5);
        r52.setToggleGroup(group5);
        r53.setToggleGroup(group5);

        importer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                photo.clear();
                fileChooser.setTitle("Select image");

                fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), ""));
                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    List<File> files = Arrays.asList(file);
                    photo.setText(file.getName());
                }
            }
        }
        );
        /// 
        System.out.println(CurrentUser);

    }

    @FXML
    private void upload(ActionEvent event) {
    }

    @FXML
    private void valider(ActionEvent event) {

        ServiceMatching m = new ServiceMatching();
        ServiceUser us = new ServiceUser();
        User u = new User();

        String Interet = "";
        if (r11.isSelected()) {
            Interet += "100";
        } else if (r12.isSelected()) {
            Interet += "010";
        } else if (r13.isSelected()) {
            Interet += "001";
        }

        if (r21.isSelected()) {
            Interet += "100";
        } else if (r22.isSelected()) {
            Interet += "010";
        } else if (r23.isSelected()) {
            Interet += "001";
        }

        if (r31.isSelected()) {
            Interet += "100";
        } else if (r32.isSelected()) {
            Interet += "010";
        } else if (r33.isSelected()) {
            Interet += "001";
        }

        if (r41.isSelected()) {
            Interet += "100";
        } else if (r42.isSelected()) {
            Interet += "010";
        } else if (r43.isSelected()) {
            Interet += "001";
        }

        if (r51.isSelected()) {
            Interet += "100";
        } else if (r52.isSelected()) {
            Interet += "010";
        } else if (r53.isSelected()) {
            Interet += "001";
        }

        CurrentUser.setInteret_user(m.hex(Interet));
        CurrentUser.setDescription_user(description.getText());
        CurrentUser.setPhoto_user(photo.getText());
        CurrentUser.setAdresse_user(adresse.getText());
        us.modifer(CurrentUser);
        try {

            Stage primaryStage;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("front.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            Stage CurrentStage = (Stage) valider.getScene().getWindow();
            CurrentStage.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
//        System.out.println(u);

    }

    public void load(User u) {

        valider.setVisible(false);
        modifier.setVisible(true);
        adresse.setText(u.getAdresse_user());
        photo.setText(u.getPhoto_user());
        description.setText(u.getDescription_user());
        r11.setSelected(true);

    }

    @FXML
    private void mod(ActionEvent event) {
        ServiceMatching m = new ServiceMatching();
        ServiceUser us = new ServiceUser();
        User u = new User();

        String Interet = "";
        if (r11.isSelected()) {
            Interet += "100";
        } else if (r12.isSelected()) {
            Interet += "010";
        } else if (r13.isSelected()) {
            Interet += "001";
        }

        if (r21.isSelected()) {
            Interet += "100";
        } else if (r22.isSelected()) {
            Interet += "010";
        } else if (r23.isSelected()) {
            Interet += "001";
        }

        if (r31.isSelected()) {
            Interet += "100";
        } else if (r32.isSelected()) {
            Interet += "010";
        } else if (r33.isSelected()) {
            Interet += "001";
        }

        if (r41.isSelected()) {
            Interet += "100";
        } else if (r42.isSelected()) {
            Interet += "010";
        } else if (r43.isSelected()) {
            Interet += "001";
        }

        if (r51.isSelected()) {
            Interet += "100";
        } else if (r52.isSelected()) {
            Interet += "010";
        } else if (r53.isSelected()) {
            Interet += "001";
        }

        CurrentUser.setInteret_user(m.hex(Interet));
        CurrentUser.setDescription_user(description.getText());
        CurrentUser.setPhoto_user(photo.getText());
        CurrentUser.setAdresse_user(adresse.getText());
        us.modifer(CurrentUser);
    }

}
