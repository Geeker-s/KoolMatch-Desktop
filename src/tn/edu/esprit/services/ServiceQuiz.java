/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Quiz;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import tn.edu.esprit.utils.MyDB;
import java.util.stream.Collectors;

/**
 *
 * @author khaled
 */
public class ServiceQuiz implements IService<Quiz> {

    private Connection cnx;

    public ServiceQuiz() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Quiz p) {
        try {
            String querry = "INSERT INTO `quiz`(`id_recette`, `Q1`,`rc1`,`rf11`,`rf12`,`rf13`,`Q2`,`rc2`,`rf21`,`rf22`,`rf23`,`Q3`,`rc3`,`rf31`,`rf32`,`rf33`) VALUES ('" + p.getId_jeu() + "','" + p.getQ1() + "','" + p.getRc1() + "','" + p.getRf11() + "','" + p.getRf12() + "','" + p.getRf13() + "','" + p.getQ2() + "','" + p.getRc2() + "','" + p.getRf21() + "','" + p.getRf22() + "','" + p.getRf23() + "','" + p.getQ3() + "','" + p.getRc3() + "','" + p.getRf31() + "','" + p.getRf32() + "','" + p.getRf33() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Quiz> afficher() {
        List<Quiz> Quiz = new ArrayList<>();
        try {
            String req = "SELECT * FROM quiz WHERE archive =0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Quiz.add(new Quiz(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Quiz;
    }

    @Override
    public boolean modifer(Quiz r) {
        try {
            String req = " UPDATE quiz SET Q1 = '"+ r.getQ1()+"', rc1 = '" + r.getRc1()+"', rf11 = '" + r.getRf11() +"', rf12 = '" + r.getRf12()+"', rf13 = '" + r.getRf13()+"', Q2 = '" + r.getQ2()+"', rc2 = '" + r.getRc2()+"', rf21 = '" + r.getRf21()+"', rf22 = '" + r.getRf22()+"', rf23 = '" + r.getRf23()+"', Q3 = '" + r.getQ3()+"', rc3 = '" + r.getRc3()+"', rf31 = '" + r.getRf31()+"', rf32 = '" + r.getRf32()+"', rf33 = '" + r.getRf33()+ "' WHERE id_quiz = '" + r.getId_quiz()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean supprimerc(Quiz p) {
        try {
            String querry = "DELETE FROM quiz WHERE id_quiz = '" + p.getId_quiz() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;

    }

    @Override
    public boolean supprimer(Quiz q) {
        try {
            String req = " UPDATE quiz SET archive = 1 WHERE id_quiz = '" + q.getId_quiz() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public long calcules(int j, String r) {
        List<Quiz> quiz = afficher();
        return quiz.stream().filter(b -> j == b.getId_jeu()).filter(b -> r.equals(b.getRc2()) || r.equals(b.getRc1()) || r.equals(b.getRc3())).count();
    }

    @Override
    public List<Quiz> rechercher(Quiz r) {
        List<Quiz> quiz = afficher();
        return quiz.stream().filter(b -> b.getId_jeu() == r.getId_jeu()).collect(Collectors.toList());
    }
     public List<Quiz> rechercherq(Quiz r) {
        List<Quiz> quiz = afficher();
        return quiz.stream().filter(b -> b.getId_quiz()== r.getId_quiz()).collect(Collectors.toList());
    }

}
