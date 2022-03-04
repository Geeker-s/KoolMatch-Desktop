/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;
import java.sql.Date;
/**
 *
 * @author MED ZOUARI
 */
public class Gerant {
    private int id_gerant;
    private String nom_gerant;
    private String prenom_gerant;
    private int telephone_gerant;
    private Date dd_abonnement;
    private Date df_abonnement;
    private int archive;

    public Gerant() {
    }

    public Gerant(int id_gerant, String nom_gerant, String prenom_gerant, int telephone_gerant, Date dd_abonnement, Date df_abonnement) {
        this.id_gerant = id_gerant;
        this.nom_gerant = nom_gerant;
        this.prenom_gerant = prenom_gerant;
        this.telephone_gerant = telephone_gerant;
        this.dd_abonnement = dd_abonnement;
        this.df_abonnement = df_abonnement;
        this.archive = archive;
    }

    public Gerant(String nom_gerant, String prenom_gerant, int telephone_gerant, Date dd_abonnement, Date df_abonnement) {
        this.nom_gerant = nom_gerant;
        this.prenom_gerant = prenom_gerant;
        this.telephone_gerant = telephone_gerant;
        this.dd_abonnement = dd_abonnement;
        this.df_abonnement = df_abonnement;
        this.archive = archive;
    }

    public Gerant(int id_gerant) {
        this.id_gerant = id_gerant;
    }

    public int getId_gerant() {
        return id_gerant;
    }

    public String getNom_gerant() {
        return nom_gerant;
    }

    public String getPrenom_gerant() {
        return prenom_gerant;
    }

    public int getTelephone_gerant() {
        return telephone_gerant;
    }

    public Date getDd_abonnement() {
        return dd_abonnement;
    }

    public Date getDf_abonnement() {
        return df_abonnement;
    }

    public int getArchive() {
        return archive;
    }
    

    public void setId_gerant(int id_gerant) {
        this.id_gerant = id_gerant;
    }

    public void setNom_gerant(String nom_gerant) {
        this.nom_gerant = nom_gerant;
    }

    public void setPrenom_gerant(String prenom_gerant) {
        this.prenom_gerant = prenom_gerant;
    }

    public void setTelephone_gerant(int telephone_gerant) {
        this.telephone_gerant = telephone_gerant;
    }

    public void setDd_abonnement(Date dd_abonnement) {
        this.dd_abonnement = dd_abonnement;
    }

    public void setDf_abonnement(Date df_abonnement) {
        this.df_abonnement = df_abonnement;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }
    
    

    @Override
    public String toString() {
        return "gerant{\n\t" + "id_gerant=" + id_gerant + "\n\t nom_gerant=" + nom_gerant + "\n\t prenom_gerant=" + prenom_gerant + "\n\t telephone_gerant=" + telephone_gerant + "\n\t dd_abonnement=" + dd_abonnement + "\n\t df_abonnement=" + df_abonnement + "\n\t archive=" + archive + '}';
    }

    
   
    
    

    
}
