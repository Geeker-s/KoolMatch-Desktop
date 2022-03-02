/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.model.Recette;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.edu.esprit.services.ServiceRecette;

/**
 * FXML Controller class
 *
 * @author khaled
 */
public class RecetteController implements Initializable {
     ServiceRecette r =new ServiceRecette();
        ObservableList<Recette> list=FXCollections.observableList(r.afficher());
       ObservableList<Recette> listtnp=FXCollections.observableList(r.trinp());
       ObservableList<Recette> listtd=FXCollections.observableList(r.tridur());
       ObservableList<Recette> listtc=FXCollections.observableList(r.tricatg());
       
        ObservableList Listt = FXCollections.observableArrayList ( 
"nom_plat", "durré", "categorie");
   // ObservableList<Recette> listtr=FXCollections.observableList(r.rechercherr(r));
    @FXML
    private Button AjouterR;
    @FXML
    private Label label;
    @FXML
    private TextField nplat;
    @FXML
    private TextField prec;
    @FXML
    private TextArea desc;
    @FXML
    private TextField catg;
    @FXML
    private TextField duree;
    @FXML
    private Button ModifierR;
    @FXML
    private Button SupprimerR;
    @FXML
    private TextField idr;
    @FXML
    private ImageView source;
    @FXML
    private ListView<Recette> listv;
    @FXML
    private ComboBox<String> tri;
    @FXML
    private TextField rech;
    @FXML
    private Label remarque;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    listv.setItems(list);
     tri.setItems(Listt);
    }    

  

    @FXML
    private void bAjouer(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
      if ( nplat.getText().isEmpty() || nplat.getText().matches("[0-9]") ||catg.getText().isEmpty() || catg.getText().matches("[0-9]") ||desc.getText().isEmpty() || catg.getText().matches("[0-9]") || Integer.parseInt(duree.getText())<0 ) { remarque.setText("veuillez entrer un nom valide"); }
      else {
           Recette r = new Recette(nplat.getText(),prec.getText(), desc.getText(), catg.getText(),Integer.parseInt(duree.getText())) ;
               Recette.ajouter(r);
    }}

    @FXML
    private void Bmodifier(ActionEvent event) {
        ServiceRecette Recette = new ServiceRecette();
           Recette r = new Recette(Integer.parseInt(idr.getText()), desc.getText()) ;
               Recette.modifer(r);
    }

    @FXML
    private void Bsupprimer(ActionEvent event) {
         ServiceRecette Recette = new ServiceRecette();
            Recette r1 = new Recette(Integer.parseInt(idr.getText()),"b","b", "a", "c",0) ;
               Recette.supprimer(r1);
    }

  

    private void Laffichage(MouseEvent event) {
        ServiceRecette Recette = new ServiceRecette();
               Recette.afficher();
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void drag(MouseEvent event) {
        
    }

    @FXML
    private void trier(ActionEvent event) {
         ServiceRecette sr =new ServiceRecette();
        if ( tri.getValue().equals("nom_plat") )
        { listv.setItems(listtnp);}
        if ( tri.getValue().equals("durré") )
        { listv.setItems(listtnp);}
        if ( tri.getValue().equals("categorie") )
        { listv.setItems(listtnp);}
         
    }

    @FXML
    private void rechercher(ActionEvent event) {
        ServiceRecette sr =new ServiceRecette();
       // Recette recette = sr.recherchern(new Recette(rech.getText())).get(0) ;
       Recette rec = new Recette(rech.getText());
       ObservableList<Recette> listr=FXCollections.observableList(sr.rechercher(rec));
        listv.setItems((listr));
    }

    @FXML
    private void ref(ActionEvent event) {
        ObservableList<Recette> listref=FXCollections.observableList(r.afficher());
        listv.setItems(listref);
    }
    
}
