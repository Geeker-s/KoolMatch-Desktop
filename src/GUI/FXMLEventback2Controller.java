/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



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
import entities.event;
import entities.invitation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.ServiceEvent;
import services.ServiceInvitation;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLEventback2Controller implements Initializable {

    @FXML
    private Button Ajouter_inv;
    @FXML
    private Button modif_inv;
    @FXML
    private Button bt_pdf;
    
    @FXML
    private TableView<String> tabv;
    
    
    ObservableList<invitation> invitations = FXCollections.observableArrayList();
    @FXML
    private TextField TF_ide;
    @FXML
    private TextField TF_idu;
    @FXML
    private TextField TF_supp_inv;
    @FXML
    private Button supp_in;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceInvitation ev = new ServiceInvitation();
    //tabv.setItems().addAll(ev.afficher());
    
      
        
        
        // TODO
    }    
    
    
    
    
     @FXML
    void addInv(ActionEvent event) {
        
         ServiceInvitation i = new ServiceInvitation();
         invitation in = new invitation();
        in.set(Integer.parseInt(TF_ide.getText()));
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
    private void pdf(ActionEvent event) throws SQLException {
        
        
          
        Document doc = new Document();
        
        
         try {
             
        
             
             PdfWriter.getInstance(doc,new  FileOutputStream("C:\\Users\\Asus\\OneDrive\\Bureau\\Invitation.pdf"));
             doc.open();
              Font f=new Font(Font.FontFamily.HELVETICA,50.0f,Font.UNDERLINE,BaseColor.PINK);
             doc.add(new Paragraph("Invitation : ",f));
             
             Image img;
            img = Image.getInstance("C:\\Users\\Asus\\OneDrive\\Bureau\\KoolMatch\\src\\Images\\matchy-cool-logo-png.png");
             doc.add(img);
             
             PdfPTable table = new PdfPTable(3);
             table.setWidthPercentage(100);
             ////////////////////////////
             PdfPCell cell;
             cell = new PdfPCell (new Phrase ("Id_invitation",FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             
             
             cell = new PdfPCell (new Phrase ("Id_event",FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             
             cell = new PdfPCell (new Phrase ("Id_user",FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             
             
             /////////////////////////////
             
             
             
             
              
             cell = new PdfPCell (new Phrase (("Id_invitation"),FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             
             
             cell = new PdfPCell (new Phrase ("Id_event",FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             
             cell = new PdfPCell (new Phrase ("Id_user",FontFactory.getFont("Arial",15)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             table.addCell(cell);
             
             ////////////////////////////
             
             
             
             
             
             
             doc.add(table);
             
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
    
}
