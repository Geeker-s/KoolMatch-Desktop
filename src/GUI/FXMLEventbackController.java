/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.event;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceEvent;
import services.ServiceInvitation;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLEventbackController implements Initializable {

        ObservableList<Event> events = FXCollections.observableArrayList();
        
        
   private Stage stage;
   private Scene scene;
   private Parent root;

    
    @FXML
    private TableView<Event> tbviewEvent;
    @FXML
    private TableColumn<Event, String> colnom;
    @FXML
    private TableColumn<Event, String> colevent;
    @FXML
    private TableColumn<Event, String> coladresse;
    @FXML
    private TableColumn<Event, Date> coldated;
    @FXML
    private TableColumn<Event, Date> coldatef;
    @FXML
    private TableColumn<Event, Integer> coltel;
    @FXML
    private TextField TFnom;
    @FXML
    private TextField TFtheme;
    @FXML
    private TextField TFadresse;
    @FXML
    private TextField TFtel;
    @FXML
    private DatePicker DPdd;
    @FXML
    private DatePicker DPdf;
    @FXML
    private Button ADDevent;
    @FXML
    private Button Modify1;
    @FXML
    private Button supprimer;
    @FXML
    private ComboBox combo_event;

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    
    
    
     private void tbvEvent() {
    
    //tbviewEvent.setItems();
    ServiceEvent ev = new ServiceEvent();
     //   combo_event.getSelectionModel().getSelectedItem(ev.afficher_1);
    
    
            

     }
     
    

     
      @FXML
      
     private void addevent(ActionEvent event) {
        ServiceEvent e = new ServiceEvent();
        event ev = new event();
        ev.setNom_event(TFnom.getText());
        ev.setTheme_event(TFtheme.getText());
        ev.setAdresse_event(TFadresse.getText());
        ev.setTelephone(Integer.parseInt(TFtel.getText()));
        LocalDate FDate  = DPdd.getValue();
        String  Sdate = String.valueOf(FDate);
        ev.setDd_event(Date.valueOf(Sdate));
        LocalDate FFDate  = DPdf.getValue();
        String  SSdate = String.valueOf(FFDate);
        ev.setDf_event(Date.valueOf(SSdate));
        e.ajouter(ev);
        TFnom.setText("");
        TFtheme.setText("");
        TFadresse.setText("");
        TFtel.setText("");
        
        DPdd.getEditor().clear();
        DPdf.getEditor().clear();

    }
     
     
     @FXML
    void modiffevent(ActionEvent event) {

    }

}

    
    
   
    

    
