/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import services.ServiceEvent;
import entities.event;
import java.sql.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.ServiceInvitation;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLEventController implements Initializable {
    
    @FXML
    private ListView <Event> LvEvent; 
    
    ObservableList<Event> events = FXCollections.observableArrayList();
    //ObservableList<events>;

    

    /**
     * Initializes the controller class.
     */
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
ServiceEvent ev = new ServiceEvent();
    LvEvent.getItems().addAll(ev.afficher());
      
        
    
         LvEvent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
             
             
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
});
    }    
    
    
    
   
    

    
    
 
    
    
    
    
    
}
