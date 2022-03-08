/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.edu.esprit.model.Restaurant;
import tn.edu.esprit.services.ServiceRestaurant;

/**
 * FXML Controller class
 *
 * @author BAZINFO
 */
public class FormulaireRestaurantController implements Initializable {

    @FXML
    private TextField Fidgerant;
    @FXML
    private TextField Fnom;
    @FXML
    private TextField Fadresse;
    @FXML
    private TextField Ftelephone;
    @FXML
    private TextField Fsite;
    @FXML
    private TextField Fspecialite;
    @FXML
    private TextField Fnombre;
    @FXML
    private TextField Fdescription;
    private TextField Fstructure;
    @FXML
    private Button Binsert;
    @FXML
    private ImageView imageView_resto;

    private Desktop desktop = Desktop.getDesktop();

    final FileChooser fileChooser = new FileChooser();

    private String file_image;

    private Path pathfrom;
    private Path pathto;
    private File Current_file;

    private String file_image1;
    private Path pathfrom1;
    private Path pathto1;
    private File Current_file1;

    @FXML
    private ImageView imageView_structure;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Insert(ActionEvent event) throws IOException {

        ServiceRestaurant sp = new ServiceRestaurant();
        Restaurant p = new Restaurant();
        // p.setId_restaurant(Integer.parseInt(Fid.getText()));
        p.setId_gerant(Integer.parseInt(Fidgerant.getText()));
        p.setNom_restaurant(Fnom.getText());
        p.setAdresse_restaurant(Fadresse.getText());
        p.setTelephone_restaurant(Integer.parseInt(Ftelephone.getText()));
        p.setSiteweb_restaurant(Fsite.getText());
        p.setSpecialite_restaurant(Fspecialite.getText());
        p.setNb_placeResto(Integer.parseInt(Fnombre.getText()));
        //  p.setImage(Fimage.getText());
        // p.setImage_structure_resturant(Fstructure.getText());
        p.setDescription(Fdescription.getText());

        file_image = "src/tn/edu/esprit/images/" + file_image;

        p.setImage(file_image);

        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("src/tn/edu/esprit/images/" + Current_file.getName());
        Path targetDir = FileSystems.getDefault().getPath("");
        System.out.println(targetDir);
        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);

        file_image1 = "src/tn/edu/esprit/images/" + file_image1;
        p.setImage_structure_resturant(file_image1);

        pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
        pathto = FileSystems.getDefault().getPath("src/tn/edu/esprit/images/" + Current_file.getName());
        Path targetDir1 = FileSystems.getDefault().getPath("src/tn/edu/esprit/images/");
        System.out.println(targetDir1);
        Files.copy(pathfrom, pathto, StandardCopyOption.REPLACE_EXISTING);

        sp.ajouter(p);
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AfficherRestaurant.fxml")));

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void imageDragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void imageDropped(DragEvent event) throws FileNotFoundException {

        Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
        fis = new FileInputStream(phil.get(0));
        Image image = new Image(fis);
        File selectedFile = phil.get(0);
        if (selectedFile != null) {

            String test = selectedFile.getAbsolutePath();
            System.out.println(test);

            Current_file = selectedFile.getAbsoluteFile();
            file_image = Current_file.getName();
            Restaurant e = new Restaurant();
            e.setImage(selectedFile.getName());
            imageView_resto.setImage(image);
        }
    }

    @FXML
    private void image1DragOver(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void image1Dropped(DragEvent event) throws FileNotFoundException {

        Dragboard board = event.getDragboard();
        List<File> philp = board.getFiles();
        FileInputStream fis;
        fis = new FileInputStream(philp.get(0));
        Image image = new Image(fis);
        File selectedFile = philp.get(0);
        if (selectedFile != null) {

            String test = selectedFile.getAbsolutePath();
            System.out.println(test);

            Current_file1 = selectedFile.getAbsoluteFile();
            file_image1 = Current_file1.getName();
            Restaurant e = new Restaurant();
            e.setImage(selectedFile.getName());
            imageView_structure.setImage(image);
        }
    }
}
