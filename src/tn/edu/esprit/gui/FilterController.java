/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import static tn.edu.esprit.gui.LoginController.CurrentUser;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class FilterController implements Initializable {

    @FXML
    private Slider sliderage_min;
    @FXML
    private Slider sliderage_max;
    @FXML
    private Label age_min;
    @FXML
    private Label age_max;
    @FXML
    private Slider sliderdistance;
    @FXML
    private Label distance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sliderage_min.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                    Number oldValue, Number newValue) {
                age_min.setText(String.valueOf(newValue.intValue()));
                age_min.setVisible(true);
            }
        });

        sliderage_max.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                    Number oldValue, Number newValue) {
                age_max.setText(String.valueOf(newValue.intValue()));
                age_max.setVisible(true);
            }
        });
        sliderdistance.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                    Number oldValue, Number newValue) {
                distance.setText(String.valueOf(newValue.intValue()));
                distance.setVisible(true);
            }
        });

            System.out.println(getList());
        
        
    }

    public List<User> getList() {

        ServiceMatching m = new ServiceMatching();

        return m.filter(CurrentUser, Integer.parseInt(age_min.getText()), Integer.parseInt(age_max.getText()), Double.parseDouble(distance.getText()));

    }


}
