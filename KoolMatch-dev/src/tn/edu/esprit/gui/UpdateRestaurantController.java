/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.services.ServiceRestaurant;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class UpdateRestaurantController implements Initializable {

    private Restaurant p1;
    ServiceRestaurant service = new ServiceRestaurant();
    @FXML
    private TextField id_nom;
    @FXML
    private Button Id_modifier;
    @FXML
    private TextField id_sp;
    @FXML
    private TextField id_desc;
    @FXML
    private TextField id_nomb;
    @FXML
    private TextField id_tel;
    @FXML
    private TextField id_adr;
    @FXML
    private ImageView id_imag;

    /**
     * Initializes the controller class.
     */
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {

        try {
            p1 = service.GetRestobyid(Restaurant.getId_courant());
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id_nom.setText(p1.getNom_restaurant());
        id_adr.setText(p1.getAdresse_restaurant());
        id_desc.setText(p1.getDescription());
        id_sp.setText(p1.getSpecialite_restaurant());
        id_nomb.setText(Integer.toString(p1.getNb_placeResto()));
        id_tel.setText(Integer.toString(p1.getTelephone_restaurant()));
        String a = p1.getImage();
        System.out.println(p1.getImage());
        File file = new File(a);
        Image image1 = new Image(file.toURI().toString());
        id_imag.setImage(image1);

    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException, IOException {

        System.out.println(p1.getId_restaurant());
        service.UpdateResto(p1);
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
