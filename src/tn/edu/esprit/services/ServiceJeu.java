/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Jeu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import tn.edu.esprit.utils.MyDB;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author khaled
 */
public class ServiceJeu implements IService<Jeu> {

    private Connection cnx;

    public ServiceJeu() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Jeu p) {
        try {
            String querry = "INSERT INTO `jeu`(`score_jeu`, `id_quiz`,`id_user`) VALUES ('" + p.getScore_jeu() + "','" + p.getId_quiz() + "','" + p.getId_user() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Jeu> afficher() {
        List<Jeu> jeux = new ArrayList<>();
        try {
            String req = "SELECT * FROM jeu WHERE archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                jeux.add(new Jeu(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return jeux;
    }

    @Override
    public boolean modifer(Jeu p) {
        try {
            String req = " UPDATE jeu SET id_quiz = '" + p.getId_quiz() + "' WHERE id_jeu = '" + p.getId_jeu()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean supprimerc() {
        try {
            String querry = "DELETE FROM jeu WHERE archive =1'" ;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Jeu p) {
        try {
            String req = " UPDATE jeu SET archive =1 WHERE id_jeu = '" + p.getId_jeu() + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /*SELECT
Row_number() over (partition by <col x> order by <col_y>
DESC/ASC), Col1,...colN
FROM <nom_table> ; */
    public List<Jeu> rank() {
        List<Jeu> jeux = new ArrayList<>();
        try {
            String req = "SELECT score_jeu, DENSE_RANK() over (order by score_jeu DESC) FROM jeu WHERE archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                jeux.add(new Jeu(rs.getInt(1),rs.getInt(2)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return jeux;
    }

    @Override
    public List<Jeu> rechercher(Jeu r) {
        List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getId_jeu() == r.getId_jeu()).collect(Collectors.toList());
    }

    public List<Jeu> Tri() {
        Comparator<Jeu> comparator = Comparator.comparing(Jeu::getScore_jeu);
        List<Jeu> jeu = afficher();
        return jeu.stream().sorted(comparator).collect(Collectors.toList());
    }
     public long calculz1() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu()< 20).count();
    }
       public long calculz2() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu() > 20).filter(b -> b.getScore_jeu() < 50 ).count();
    }
            public long calculz3() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu() > 50).filter(b -> b.getScore_jeu() > 90 ).count();
    }
                 public long calculz4() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu() > 90).filter(b -> b.getScore_jeu() > 120 ).count();
    }
           public long calculz5() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu() > 120).filter(b -> b.getScore_jeu() > 150 ).count();
    }   
                public long calculz6() {
        
          List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getScore_jeu() > 150).count();
    }
}
