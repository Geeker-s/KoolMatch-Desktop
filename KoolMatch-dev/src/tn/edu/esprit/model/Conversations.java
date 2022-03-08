/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author Guedo
 */
public class Conversations {

    private int id_conversation;
    private String titre_conversation;
    private int id_user1;
    private int id_user2;

    public Conversations() {
    }

    public Conversations(int id_conversation, String titre_conversation, int id_user1, int id_user2) {
        this.id_conversation = id_conversation;
        this.titre_conversation = titre_conversation;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
    }

    public Conversations(String titre_conversation, int id_user1, int id_user2) {
        this.titre_conversation = titre_conversation;
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
    }

    public Conversations(int id_conversation) {
        this.id_conversation = id_conversation;
    }

    public int getId_conversation() {
        return id_conversation;
    }

    public String getTitre_conversation() {
        return titre_conversation;
    }

    public int getId_user1() {
        return id_user1;
    }

    public int getId_user2() {
        return id_user2;
    }

    public void setId_conversation(int id_conversation) {
        this.id_conversation = id_conversation;
    }

    public void setTitre_conversation(String titre_conversation) {
        this.titre_conversation = titre_conversation;
    }

    public void setId_user1(int id_user1) {
        this.id_user1 = id_user1;
    }

    public void setId_user2(int id_user2) {
        this.id_user2 = id_user2;
    }

    @Override
    public String toString() {
        return "conversations{" + "id_conversation=" + id_conversation + ", titre_conversation=" + titre_conversation + ", id_user1=" + id_user1 + ", id_user2=" + id_user2 + '}';
    }

}
