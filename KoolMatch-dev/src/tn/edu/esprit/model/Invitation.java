/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author Asus
 */
public class Invitation {
    
    private int id_invitation;
    private String nom_event;
    private int id_user;
     private int archive;

    public Invitation(int id_invitation, String nom_event, int id_user, int archive) {
        this.id_invitation = id_invitation;
        this.nom_event = nom_event;
        this.id_user = id_user;
        this.archive = archive;
    }

    public Invitation(int id_invitation,  String nom_event, int id_user) {
        this.id_invitation = id_invitation;
        this.nom_event = nom_event;
        this.id_user = id_user;
    }

   

    public Invitation( String nom_event, int id_user) {
        this.nom_event = nom_event;
        this.id_user = id_user;
    }

    public Invitation(int id_invitation) {
        this.id_invitation = id_invitation;
    }
    
    

    public Invitation() {
    }

    public int getId_invitation() {
        return id_invitation;
    }

    public String getNom_event() {
        return nom_event;
    }

    public int getId_user() {
        return id_user;
    }

    public int getArchive() {
        return archive;
    }
    

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_invitation(int id_invitation) {
        this.id_invitation = id_invitation;
    }
    

    public void setArchive(int archive) {
        this.archive = archive;
    }

  
    
    

    @Override
    public String toString() {
        return
                String.format( "%-20s",id_invitation)
               +  String.format("%-20s",nom_event)
                + String.format( "%-20s",id_user);
// "invitation{" + "id_invitation=" + id_invitation + ", nom_event=" + nom_event + ", id_user=" + id_user + '}';
    }


    
    
    
    
}
   
    
    
    
    

