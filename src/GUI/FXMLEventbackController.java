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
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
    
    
    public void pdf() {
        
        Document doc = new Document();
         try {
             PdfWriter.getInstance(doc,new  FileOutputStream("C:\\Users\\Asus\\OneDrive\\Bureau\\Invitation.pdf"));
             doc.open();
              Font f=new Font(Font.FontFamily.HELVETICA,50.0f,Font.UNDERLINE,BaseColor.PINK);
             doc.add(new Paragraph("Invitation : ",f));
             
             Image img;
            img = Image.getInstance("C:\\Users\\Asus\\OneDrive\\Bureau\\KoolMatch\\src\\Images\\matchy-cool-logo-png.png");
             doc.add(img);
             
             doc.close();
             Desktop.getDesktop().open(new File ("C:\\Users\\Asus\\OneDrive\\Bureau\\Invitation.pdf"));
             
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (DocumentException ex) {
             Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    

    @FXML
    private void initialize(ActionEvent event) {
    }
}
