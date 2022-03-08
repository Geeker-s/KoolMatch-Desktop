/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import tn.edu.esprit.model.Evenement;
import tn.edu.esprit.model.Invitation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import tn.edu.esprit.services.ServiceEvent;
import tn.edu.esprit.services.ServiceInvitation;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.utils.MyDB;


/**
 * FXML Controller class
 *
 * @author Asus
 */

public class InvitationBackController implements Initializable {
     private Connection cnx;
     ServiceInvitation ev = new ServiceInvitation();

    public InvitationBackController() {
        cnx = MyDB.getInstance().getCnx();

    }

    @FXML
    private Button Ajouter_inv;
    @FXML
    private Button modif_inv;
    @FXML
    private Button bt_pdf;
    

    @FXML
    private ListView<Invitation> tabv;
    
    @FXML
    private Button supp_in;
     @FXML
    private Button bt_ref;
    
    @FXML
     private ComboBox<String> combo_ide;
    
    @FXML
     private ComboBox<Integer> combo_idi;
    @FXML 
    private Label alert2;
    
   


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        ServiceEvent e = new ServiceEvent();
        ServiceInvitation i = new ServiceInvitation();
        ServiceUser u = new ServiceUser ();
        
        tabv.getItems().addAll(ev.afficher());
        combo_ide.getItems().addAll(e.affichernom());
        
        combo_idi.getItems().addAll(i.afficherid());
        
        
    
        

        
        // TODO
    }
    
     @FXML
    private void refINV(ActionEvent event) {
        ObservableList<Invitation> listref=FXCollections.observableList(ev.afficher());
        tabv.setItems(listref);
       
    }
    
    
    

    @FXML
    private void addInv(ActionEvent event) {
        
        
        

        ServiceInvitation i = new ServiceInvitation();
        Invitation inv = new Invitation();
        
       
        
        
        inv.setNom_event(combo_ide.getValue());
        inv.setId_user(combo_idi.getValue());
        

        i.ajouter(inv);
        
       
        
//

//
    }
    
    
    
     @FXML
    private void index(javafx.scene.input.MouseEvent event) {
        Invitation g = tabv.getSelectionModel().getSelectedItem();

         combo_ide.setValue(g.getNom_event());

        combo_idi.setValue(g.getId_user());


    }

    @FXML
    private void supprimerINV(ActionEvent event) {
        ServiceInvitation  in = new ServiceInvitation();
        Invitation i = tabv.getSelectionModel().getSelectedItem();
        in.supprimer(i);
        tabv.getItems().remove(i);
    }


    @FXML
    void modiffINV(ActionEvent event) {

        ServiceInvitation g = new ServiceInvitation();
        //Invitation e = tabv.getSelectionModel().getSelectedItem().getId_invitation();
        Invitation n = new Invitation();
        n.setId_invitation(tabv.getSelectionModel().getSelectedItem().getId_invitation());

//        n.setNom_event(e.getNom_event());
//        n.setId_user(e.getId_user());

     
        
      
        
        n.setNom_event(combo_ide.getValue());
        n.setId_user(combo_idi.getValue());
                
        
        
        
        g.modifer(n);

   
        combo_ide.getItems().clear();
       combo_idi.getItems().clear();
        
        
        
        tabv.getItems().clear();
        tabv.getItems().addAll(g.afficher());

    }
}
