/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;

/**
 *
 * @author Asus
 */
public class Evenement {

    private int id_event;
    private String nom_event;
    private Date dd_event;
    private Date df_event;
    private String theme_event;
    private String adresse_event;
    private int telephone;
    private int archive;

    public Evenement() {
    }

    public Evenement(int id_event, String nom_event, Date dd_event, Date df_event, String theme_event, String adresse_event, int telephone, int archive) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.dd_event = dd_event;
        this.df_event = df_event;
        this.theme_event = theme_event;
        this.adresse_event = adresse_event;
        this.telephone = telephone;
        this.archive = archive;
    }

    public Evenement(String nom_event, Date dd_event, Date df_event, String theme_event, String adresse_event, int telephone) {
        this.nom_event = nom_event;
        this.dd_event = dd_event;
        this.df_event = df_event;
        this.theme_event = theme_event;
        this.adresse_event = adresse_event;
        this.telephone = telephone;
    }
    

    public Evenement(int id_event) {
        this.id_event = id_event;
    }

    public Evenement(Date dd_event) {
        this.dd_event = dd_event;
    }

    public Evenement(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_event() {
        return id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public Date getDd_event() {
        return dd_event;
    }

    public Date getDf_event() {
        return df_event;
    }

    public String getTheme_event() {
        return theme_event;
    }

    public String getAdresse_event() {
        return adresse_event;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    

    public void setDd_event(Date dd_event) {
        this.dd_event = dd_event;
    }

    public void setDf_event(Date df_event) {
        this.df_event = df_event;
    }

    public void setTheme_event(String theme_event) {
        this.theme_event = theme_event;
    }

    public void setAdresse_event(String adresse_event) {
        this.adresse_event = adresse_event;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        return 
      
                //"Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", dd_event=" + dd_event + ", df_event=" + df_event + ", theme_event=" + theme_event + ", adresse_event=" + adresse_event + ", telephone=" + telephone + ", archive=" + archive + '}';
                String.format( "%-20s",id_event)
               +  String.format( "%-20s",nom_event)
                + String.format( "%-20s",dd_event)
                + String.format( "%-20s",df_event)
                + String.format( "%-20s",theme_event)
                + String.format( "%-20s",adresse_event)
                
                + String.format( "%-20s",telephone) ;
                
    }
    
    
    



}
