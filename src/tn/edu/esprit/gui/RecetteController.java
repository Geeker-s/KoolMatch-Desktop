/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import tn.edu.esprit.model.Recette;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import tn.edu.esprit.services.ServiceRecette;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class RecetteController implements Initializable {

    ServiceRecette r = new ServiceRecette();
    ObservableList<Recette> list = FXCollections.observableList(r.afficher());
    ObservableList<Recette> listtnp = FXCollections.observableList(r.trinp());
    ObservableList<Recette> listtd = FXCollections.observableList(r.tridur());
    ObservableList<Recette> listtc = FXCollections.observableList(r.tricatg());

    ObservableList Listt = FXCollections.observableArrayList(
            "nom_plat", "durré", "categorie");
    // ObservableList<Recette> listtr=FXCollections.observableList(r.rechercherr(r));
    @FXML
    private Button AjouterR;
    @FXML
    private TextField nplat;
    private TextField prec;
    @FXML
    private TextArea desc;
    @FXML
    private ComboBox<String> catg;
    @FXML
    private TextField duree;
    @FXML
    private Button ModifierR;
    @FXML
    private Button SupprimerR;
    @FXML
    private ListView<Recette> listv;
    @FXML
    private ComboBox<String> tri;
    @FXML
    private TextField rech;
    private int a;
    @FXML
    private ImageView photo;
    private File Current_file;

    private String file_image;
    @FXML
    private Button jeu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        file_image = "src/tn/edu/esprit/images/" + file_image;

        afficher();

        tri.setItems(Listt);
        changemessage();
    }

    private void afficher() {
        ObservableList<String> listc = FXCollections.observableList(r.affichercat());
        ObservableList<Recette> list = FXCollections.observableList(r.afficher());
        listv.setItems(list);
        catg.setItems(listc);
    }

    @FXML
    private void bAjouer(ActionEvent event) {
        file_image = "src/tn/edu/esprit/images/" + file_image;

        ServiceRecette Recette = new ServiceRecette();
        if (nplat.getText().isEmpty() || nplat.getText().matches("[0-9]") || catg.getValue().equals("choisir categorie") || desc.getText().isEmpty() || desc.getText().matches("[0-9]") || Integer.parseInt(duree.getText()) < 0) {
            Notifications notificationBuilder = Notifications.create()
                    .title("Erreur").text("Veuillez verifier vos champs").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.CENTER_LEFT)
                    .onAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            System.out.println("clicked ON");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        } else {
            Recette r1 = new Recette(nplat.getText(), file_image, desc.getText(), catg.getValue(), Integer.parseInt(duree.getText()));
            Recette.ajouter(r1);
        }
    }

    @FXML
    private void Bmodifier(ActionEvent event) {
        file_image = "src/tn/edu/esprit/images/" + file_image;
        Recette c = new Recette();
        ServiceRecette sr = new ServiceRecette();
        c.setNom_recette(nplat.getText());
        c.setDescription_recette(desc.getText());
        c.setDuree_recette(Integer.parseInt(duree.getText()));
        c.setCategorie_recette(catg.getValue());
        c.setPhoto_recette(file_image);
        c.setId_recette(listv.getSelectionModel().getSelectedItem().getId_recette());
        sr.modifer(c);

        afficher();
    }

    @FXML
    private void Bsupprimer(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
        Recette r1 = new Recette(listv.getSelectionModel().getSelectedItem().getId_recette(), "b", "b", "a", "c", 0);
        Recette.supprimer(r1);
        System.out.println(a);
    }

    private void Laffichage(MouseEvent event) {
        ObservableList<Recette> list = FXCollections.observableList(r.afficher());
        listv.setItems(list);
    }

    @FXML
    private void trier(ActionEvent event) {
        ServiceRecette sr = new ServiceRecette();
        if (tri.getValue().equals("nom_plat")) {
            listv.setItems(listtnp);
        }
        if (tri.getValue().equals("durré")) {
            listv.setItems(listtnp);
        }
        if (tri.getValue().equals("categorie")) {
            listv.setItems(listtnp);
        }

    }

    @FXML
    private void cache(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
        Recette.supprimerc();
    }

    private void changemessage() {
        listv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                a = listv.getSelectionModel().getSelectedIndex();
            }
        });
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void insertion(MouseEvent event) {
        Recette c = listv.getSelectionModel().getSelectedItem();
        nplat.setText(c.getNom_recette());
        desc.setText(c.getDescription_recette());
        catg.setValue(c.getCategorie_recette());
        prec.setText(c.getPhoto_recette());
        duree.setText(String.valueOf(c.getDuree_recette()));

    }

    @FXML
    private void Drag(DragEvent event) {
        Dragboard board = event.getDragboard();
        if (board.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void Drop(DragEvent event) throws FileNotFoundException {
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
            Recette e = new Recette();
            e.setPhoto_recette(selectedFile.getName());
            photo.setImage(image);
        }
    }

    @FXML
    private void rechercher(MouseEvent event) {
        ServiceRecette sr = new ServiceRecette();
        // Recette recette = sr.recherchern(new Recette(rech.getText())).get(0) ;
        Recette rec = new Recette(rech.getText());
        ObservableList<Recette> listr = FXCollections.observableList(sr.rechercher(rec));
        listv.setItems((listr));
    }

    @FXML
    private void ref(MouseEvent event) {
        ObservableList<Recette> listref = FXCollections.observableList(r.afficher());
        listv.setItems(listref);
    }

    @FXML
    private void Ejeu(ActionEvent event) throws IOException {
        Stage primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Consulterjeu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        Stage CurrentStage = (Stage) jeu.getScene().getWindow();
//                    CurrentStage.close();
    }

}
