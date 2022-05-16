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
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import tn.edu.esprit.model.Evenement;
import java.net.URL;
import java.sql.Connection;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.edu.esprit.model.Gerant;
import tn.edu.esprit.services.ServiceEvent;
import tn.edu.esprit.services.ServiceInvitation;
import tn.edu.esprit.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EventBackController implements Initializable {

    private Connection cnx;
    @FXML
    private Button refrech;
    @FXML
    private Button inv;

    public EventBackController() {
        cnx = MyDB.getInstance().getCnx();

    }

    ServiceEvent r = new ServiceEvent();

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
    private Button supprimer;
    @FXML
    private ListView<Evenement> tbviewEvent;
    @FXML
    private TextField rech;
    @FXML
    private Label alert;
    @FXML
    private Button bt_pdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvent ev = new ServiceEvent();
        tbviewEvent.getItems().addAll(ev.afficher());
        // TODO
    }

    @FXML

    private void addevent(ActionEvent event) {
        ServiceEvent e = new ServiceEvent();
        Evenement ev = new Evenement();

        if (TFnom.getText().isEmpty() || TFnom.getText().matches("[0-9]") || TFtheme.getText().isEmpty() || TFtheme.getText().matches("[0-9]") || TFadresse.getText().isEmpty() || TFadresse.getText().matches("[0-9]") || TFtel.getText().isEmpty() || TFtel.getText().matches("[a-z]")) {

            alert.setText("Remplir les champs");

        } else {

            ev.setNom_event(TFnom.getText());
            ev.setTheme_event(TFtheme.getText());
            ev.setAdresse_event(TFadresse.getText());
            ev.setTelephone(Integer.parseInt(TFtel.getText()));
            LocalDate FDate = DPdd.getValue();
            String Sdate = String.valueOf(FDate);
            ev.setDd_event(Date.valueOf(Sdate));
            LocalDate FFDate = DPdf.getValue();
            String SSdate = String.valueOf(FFDate);
            ev.setDf_event(Date.valueOf(SSdate));
            e.ajouter(ev);
            TFnom.setText("");
            TFtheme.setText("");
            TFadresse.setText("");
            TFtel.setText("");

            DPdd.getEditor().clear();
            DPdf.getEditor().clear();
        }
    }

    @FXML
    void modiffevent(ActionEvent event) {

        ServiceEvent g = new ServiceEvent();
        Evenement e = tbviewEvent.getSelectionModel().getSelectedItem();
        Evenement n = new Evenement();

        n.setId_event(e.getId_event());

        n.setArchive(e.getArchive());
        LocalDate FDate = DPdd.getValue();
        String Sdate = String.valueOf(FDate);
        n.setDd_event(Date.valueOf(Sdate));
        LocalDate FFDate = DPdf.getValue();
        String SSdate = String.valueOf(FFDate);
        n.setDf_event(Date.valueOf(SSdate));

        n.setTelephone(Integer.parseInt(TFtel.getText()));

        n.setNom_event(TFnom.getText());
        n.setAdresse_event(TFadresse.getText());

        n.setTheme_event(TFtheme.getText());

        System.out.println(n);
        g.modifer(n);

        TFnom.setText("");
        TFtel.setText("");
        TFtheme.setText("");
        TFadresse.setText("");
        DPdf.setValue(null);
        DPdd.setValue(null);
        tbviewEvent.getItems().clear();
        tbviewEvent.getItems().addAll(g.afficher());

    }

    @FXML
    private void index(javafx.scene.input.MouseEvent event) {
        Evenement g = tbviewEvent.getSelectionModel().getSelectedItem();

        TFnom.setText(g.getNom_event());

        TFtheme.setText(g.getTheme_event());

        TFadresse.setText(g.getAdresse_event());

        TFtel.setText(String.valueOf(g.getTelephone()));

        DPdd.setValue(g.getDd_event().toLocalDate());

        DPdf.setValue(g.getDf_event().toLocalDate());

    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceEvent ev = new ServiceEvent();
        Evenement e = tbviewEvent.getSelectionModel().getSelectedItem();
        ev.supprimer(e);
        tbviewEvent.getItems().remove(e);
    }

    @FXML
    private void rechercher(ActionEvent event) {
        ServiceEvent e = new ServiceEvent();

        Evenement ev = new Evenement(rech.getText());
        ObservableList<Evenement> liste = FXCollections.observableList(e.rechercher(ev));
        tbviewEvent.setItems((liste));

    }

    @FXML
    private void ref(ActionEvent event) {
        ObservableList<Evenement> listref = FXCollections.observableList(r.afficher());
        tbviewEvent.setItems(listref);
    }

    @FXML
    private void pdfE(ActionEvent event) throws SQLException {

        Document doc = new Document();

        String sql = "SELECT * FROM evenement";

        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(sql);

        try {

            PdfWriter.getInstance(doc, new FileOutputStream("Evenements.pdf"));
            doc.open();
            Font f = new Font(Font.FontFamily.HELVETICA, 50.0f, Font.UNDERLINE, BaseColor.PINK);
            doc.add(new Paragraph("Evenements : ", f));

            Image img;
            img = Image.getInstance("src\\tn\\edu\\esprit\\images\\matchy-cool-logo-png.png");
            img.setAlignment(Image.ALIGN_CENTER);

            img.setAbsolutePosition(400, 672);
            doc.add(img);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            ////////////////////////////
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Evenement", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Date debut", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Date fin", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Theme", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Adresse", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Telephone", FontFactory.getFont("Arial", 15)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            /////////////////////////////
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("nom_event").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("dd_event").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("df_event").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(rs.getString("theme_event").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("adresse_event").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("telephone").toString(), FontFactory.getFont("Arial", 15)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.GRAY);
                table.addCell(cell);
            }

            ////////////////////////////
            doc.add(table);

            doc.close();
            Desktop.getDesktop().open(new File("Evenements.pdf"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void invitation(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InvitationBack.fxml"));
            Parent root1;
            root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            Stage CurrentStage = (Stage) inv.getScene().getWindow();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
