/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.model.Recette;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author Khaled
 */
public class ServiceRecette implements IService<Recette> {

    private Connection cnx;

    public ServiceRecette() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Recette r) {
        try {
            String querry = "INSERT INTO `recette`(`nom_recette`, `photo_recette`,`description_recette`,`categorie_recette`,`duree_recette`) VALUES ('" + r.getNom_recette() + "','" + r.getPhoto_recette() + "','" + r.getDescription_recette() + "','" + r.getCategorie_recette() + "','" + r.getDuree_recette() + "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Recette> afficher() {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = "SELECT * FROM recette WHERE archive = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(new Recette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }

    @Override
    public List<Recette> rechercher(Recette p) {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = " select * from recette  WHERE nom_recette = '" + p.getNom_recette() + "' AND archive = 0";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Recette.add(new Recette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }

    @Override
    public boolean modifer(Recette r) {
        try {
            String req = " UPDATE recette SET nom_recette = '"+ r.getNom_recette()+"', photo_recette = '" + r.getPhoto_recette()+"', description_recette = '" + r.getDescription_recette() +"', categorie_recette = '" + r.getCategorie_recette()+"', duree_recette = '" + r.getDuree_recette()+ "' WHERE id_recette = '" + r.getId_recette() + "'";
        
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Recette r) {
        try {
            String req = " UPDATE recette SET archive = 1 WHERE id_recette = '" + r.getId_recette() + "'";
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
            String querry = "DELETE FROM recette WHERE archive =1" ;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public List<Recette> Tri() {
        Comparator<Recette> comparator = Comparator.comparing(Recette::getDuree_recette);
        List<Recette> recette = afficher();
        return recette.stream().sorted(comparator).collect(Collectors.toList());
    }
     public List<String> affichernp() {
        List<String> Recette = new ArrayList<>();
        try {
            String req = "SELECT nom_recette FROM recette WHERE archive = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }
     public List<String> affichercat() {
        List<String> Recette = new ArrayList<>();
        try {
            String req = "SELECT categorie_recette FROM recette WHERE archive = 0 ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }
     public List<Recette> trinp() {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = "SELECT * FROM recette WHERE archive = 0 order by nom_recette ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(new Recette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }
     public List<Recette> tridur() {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = "SELECT * FROM recette WHERE archive = 0 order by duree_recette ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(new Recette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }
     public List<Recette> tricatg() {
        List<Recette> Recette = new ArrayList<>();
        try {
            String req = "SELECT * FROM recette WHERE archive = 0 order by categorie_recette ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Recette.add(new Recette(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return Recette;
    }
 public List<Recette> rechercherr(Recette r) {
        List<Recette> recette = afficher();
        return recette.stream().filter(b -> r.getNom_recette().equals(b.getNom_recette())).filter(b -> r.getCategorie_recette().equals(b.getCategorie_recette()) || r.getDescription_recette().equals(b.getDescription_recette()) || r.getDuree_recette()==b.getDuree_recette()).collect(Collectors.toList());
}
  public List<Recette> recherchern(Recette r) {
        List<Recette> quiz = afficher();
        return quiz.stream().filter(b -> b.getNom_recette().equals(r.getNom_recette())).collect(Collectors.toList());
}
    public List<Recette> recherchernn(String r) {
        List<Recette> quiz = afficher();
        return quiz.stream().filter(b -> b.getNom_recette().equals(r)).collect(Collectors.toList());
}
    public List<Recette> rechercher(int id) {
        List<Recette> quiz = afficher();
        return quiz.stream().filter(b -> b.getId_recette()== id).collect(Collectors.toList());
    }
  /* public List<Recette> rechercherrr(String r) {
        List<Recette> recette = afficher();
        return recette.stream().filter(b -> r.equals(b.getCategorie_recette()) || r.equals(b.getDescription_recette()) || r.equals(Integer.toString(b.getDuree_recette()))).collect(Collectors.toList());
} */
  }
