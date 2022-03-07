/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tn.edu.esprit.services.ServiceInvitation;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class InvitationFrontController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<String> listvI;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceInvitation i = new ServiceInvitation();
        listvI.getItems().addAll(i.afficher().toString());

        // TODO
    }

}
