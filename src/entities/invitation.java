/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class invitation {
    
    private int id_invitation;
    private int id_event;
    private int id_user;

    public invitation(int id_invitation, int id_event, int id_user) {
        this.id_invitation = id_invitation;
        this.id_event = id_event;
        this.id_user = id_user;
    }

    public invitation(int id_event, int id_user) {
        this.id_event = id_event;
        this.id_user = id_user;
    }

    public invitation(int id_invitation) {
        this.id_invitation = id_invitation;
    }
    
    

    public invitation() {
    }

    public int getId_invitation() {
        return id_invitation;
    }

    public int getId_event() {
        return id_event;
    }

    public int getId_user() {
        return id_user;
    }

    @Override
    public String toString() {
        return "invitation{" + "id_invitation=" + id_invitation + ", id_event=" + id_event + ", id_user=" + id_user + '}';
    }
    
    
    
}
