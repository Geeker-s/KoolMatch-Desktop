/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author wassimromdhane
 */
public class interaction {

    private int id_interaction;
    private String type_interaction;
    private Date date_interaction;
    private int id_user1;
    private int id_user2;

    public interaction() {
    }

    public interaction(int id_user1, int id_user2) {
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
    }

    public interaction(int id_interaction) {
        this.id_interaction = id_interaction;
    }

    public interaction(String type_interaction, Date date_interaction, int id_user1, int id_user2) {
        this.type_interaction = type_interaction;
        this.date_interaction = date_interaction;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
    }
    

    public interaction(int id_interaction, String type_interaction, Date date_interaction, int id_user1, int id_user2) {
        this.id_interaction = id_interaction;
        this.type_interaction = type_interaction;
        this.date_interaction = date_interaction;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
    }

    public int getId_interaction() {
        return id_interaction;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public Date getDate_interaction() {
        return date_interaction;
    }

    public int getId_user1() {
        return id_user1;
    }

    public int getId_user2() {
        return id_user2;
    }

    public void setId_interaction(int id_interaction) {
        this.id_interaction = id_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }

    public void setDate_interaction(Date date_interaction) {
        this.date_interaction = date_interaction;
    }

    public void setId_user1(int id_user1) {
        this.id_user1 = id_user1;
    }

    public void setId_user2(int id_user2) {
        this.id_user2 = id_user2;
    }

    @Override
    public String toString() {
        return "\ninteraction{" + "\n\tid_interaction=" + id_interaction + "\n\ttype_interaction=" + type_interaction + "\n\tdate_interaction=" + date_interaction + "\n\tid_user1=" + id_user1 + "\n\td_user2=" + id_user2 + '}'+"\n";
    }
}
