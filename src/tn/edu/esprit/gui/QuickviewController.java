/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.R;
import org.controlsfx.control.Rating;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.services.ServiceRestaurant;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class QuickviewController implements Initializable {

    private Restaurant p1;
    ServiceRestaurant service = new ServiceRestaurant();

    @FXML
    private Label nom_restaurant;
    @FXML
    private ImageView idimage_view;
   
    @FXML
    private Label is_spe;
    @FXML
    private Label id_addr;
    @FXML
    private Label id_num;
    @FXML
    private Label id_site;
    @FXML
    private Label id_nomb;
    @FXML
    private Label id_desc;
    @FXML
    private Label id_site1;
    @FXML
    private Rating rating;
    @FXML
    private Button id_valide;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            p1 = service.GetRestobyid(Restaurant.getId_courant());
        } catch (SQLException ex) {
            Logger.getLogger(QuickviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nom_restaurant.setText(p1.getNom_restaurant());

        String a = p1.getImage();
        System.out.println(p1.getImage());
        File file = new File("src/tn/edu/esprit/images/"+a);
        Image image1 = new Image(file.toURI().toString());

        idimage_view.setImage(image1);
        id_addr.setText(p1.getAdresse_restaurant());
        id_desc.setText(p1.getDescription());
        id_site.setText(p1.getSiteweb_restaurant());
        id_nomb.setText(Integer.toString(p1.getNb_placeResto()));
        id_num.setText(Integer.toString(p1.getTelephone_restaurant()));
        is_spe.setText(p1.getSpecialite_restaurant());
       
        String a1 = p1.getImage_structure_resturant();
        System.out.println(p1.getImage_structure_resturant());
        File file1 = new File("src/tn/edu/esprit/images/"+a1);
        Image image = new Image(file1.toURI().toString());

    }

    @FXML
    private void valider(ActionEvent event) {
       System.out.println("donner votre avis : "+rating.getRating());
    }

}
