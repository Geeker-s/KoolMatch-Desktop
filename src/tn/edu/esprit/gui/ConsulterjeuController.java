/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static tn.edu.esprit.GUI.BackJeuController.CurrentQuiz;
import static tn.edu.esprit.GUI.BackJeuController.CurrentRecette;
import tn.edu.esprit.model.Jeu;
import tn.edu.esprit.model.Quiz;
import tn.edu.esprit.services.ServiceJeu;
import tn.edu.esprit.services.ServiceQuiz;
import tn.edu.esprit.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author AZIZ
 */
public class ConsulterjeuController implements Initializable {

    ServiceJeu j = new ServiceJeu();
    ServiceQuiz q = new ServiceQuiz();

    ObservableList<Jeu> list = FXCollections.observableList(j.rank());
    ObservableList<Quiz> listt = FXCollections.observableList(q.afficher());
    @FXML
    private ListView<Jeu> listj;
    @FXML
    private ListView<Quiz> listq;
    @FXML
    private PieChart chart;
    @FXML
    private Button quiz;
    @FXML
    private Button excel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        listj.setItems(list);
        System.out.println(list);
        listq.setItems(listt);
        chart.setTitle("Niveau joueurs");
        chart.getData().setAll(new PieChart.Data("Tres faible", j.calculz1()), new PieChart.Data("faible", j.calculz2()),
                new PieChart.Data("Moyen", j.calculz3()), new PieChart.Data("Semi-pro", j.calculz4()),
                new PieChart.Data("Pro", j.calculz5()), new PieChart.Data("légende", j.calculz6()));

    }

    @FXML
    private void gquiz(ActionEvent event) throws IOException {
        CurrentQuiz.setId_quiz(-1);
        Stage primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BackJeu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        Stage CurrentStage = (Stage) quiz.getScene().getWindow();
//        CurrentStage.close();
    }

    @FXML
    private void excel(ActionEvent event) {
        Connection cnx = MyDB.getInstance().getCnx();
        excel.setFont(Font.font("Jeu", 15));
        excel.setOnAction(e -> {

            String req = "SELECT * FROM Jeu ";
            Statement st;
            try {
                st = cnx.prepareStatement(req);
                ResultSet rs = st.executeQuery(req);
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("khaled");
                XSSFRow header = sheet.createRow(0);
                header.createCell(0).setCellValue("id_jeu");
                header.createCell(1).setCellValue("score_jeu");
                header.createCell(2).setCellValue("id_quiz");
                header.createCell(3).setCellValue("id_user");

                int index = 1;
                while (rs.next()) {
                    XSSFRow row = sheet.createRow(index);
                    row.createCell(0).setCellValue(rs.getString("id_jeu"));

                    row.createCell(1).setCellValue(rs.getString("score_jeu"));
                    row.createCell(2).setCellValue(rs.getString("id_quiz"));
                    row.createCell(3).setCellValue(rs.getString("id_user"));
                    index++;

                }
                FileOutputStream fileout = new FileOutputStream("Jeu.xlsx");
                wb.write(fileout);
                fileout.close();

            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(ConsulterjeuController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConsulterjeuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success");
            alert.setContentText("Game is added successfully!");
            alert.show();

        });

    }

    @FXML
    private void gerer(ActionEvent event) throws IOException {
        CurrentQuiz.setId_quiz(listq.getSelectionModel().getSelectedItem().getId_quiz());
        Stage primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BackJeu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
//                  stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        Stage CurrentStage = (Stage) quiz.getScene().getWindow();
        CurrentStage.close();
    }

}
