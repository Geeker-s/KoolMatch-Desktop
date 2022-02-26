/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Jeu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import utils.MyDB ; 
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
             String querry="INSERT INTO `jeu`(`score_jeu`, `id_quiz`,`id_user`) VALUES ('"+p.getScore_jeu()+"','"+p.getId_quiz()+"','"+p.getId_user()+"')";
            Statement stm =cnx.createStatement();
        
        stm.executeUpdate(querry);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    @Override
    public List<Jeu> afficher() {
       List<Jeu> jeux = new ArrayList<>();
        try {
            String req = "SELECT * FROM jeu WHERE etat = '" + 1+ "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                jeux.add(new Jeu(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return jeux;
    }

    @Override
    public boolean modifer(Jeu p) {
         Scanner sc = new Scanner(System.in);
        System.out.println("id_quiz ");
        String id_quiz = sc.nextLine();
        Integer.parseInt(id_quiz) ;
        
          try {
           String req = " UPDATE jeu SET id_quiz = '" + id_quiz+ "' WHERE id_jeu = '" + p.getId_jeu()+ "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
 public boolean supprimerc(Jeu p) {
 try {
            String querry = "DELETE FROM jeu WHERE id_jeu = '" + p.getId_jeu()+ "'";
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
           String req = " UPDATE jeu SET etat = '" +0+ "' WHERE id_jeu = '" + p.getId_jeu()+ "'";
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
            String req = "SELECT score_jeu, id_quiz,id_user, DENSE_RANK() over (order by score_jeu DESC) FROM jeu WHERE etat = '" + 1+ "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                jeux.add(new Jeu(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return jeux;
    }
     
public List<Jeu> Recherche(Jeu r) {
        List<Jeu> jeu = afficher();
        return jeu.stream().filter(b -> b.getId_jeu() == r.getId_jeu()).collect(Collectors.toList());
    }

    public List<Jeu> Tri() {
        Comparator<Jeu> comparator = Comparator.comparing(Jeu::getScore_jeu);
        List<Jeu> jeu = afficher();
        return jeu.stream().sorted(comparator).collect(Collectors.toList());
    }
    }