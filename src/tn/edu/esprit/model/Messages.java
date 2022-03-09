/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guedo
 */
public class Messages {

    private int id_message;
    private String msg_message;
    private String date_msg;
    private java.util.Date date_message = new java.util.Date(System.currentTimeMillis());

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    public Messages() {
    }

    public Messages(int id_message, String msg_message, String date_msg) {
        this.id_message = id_message;
        this.msg_message = msg_message;
        this.date_msg = date_msg;
    }
    

    public Messages(String msg_message) {
        this.msg_message = msg_message;
    }
   
    public Messages(int id_message, String msg_message) {
        this.id_message = id_message;
        this.msg_message = msg_message;

    }

    public Messages(int id_message) {
        this.id_message = id_message;
    }

    public int getId_message() {
        return id_message;
    }

    public String getDate_msg() {
        return date_msg;
    }

    public String getDate_message() {
        return formatter.format(date_message) ;
    }

    public String getMsg_message() {
        return msg_message;
    }

    public void setDate_msg(String date_msg) {
        this.date_msg = date_msg;
    }

    public void setMsg_message(String msg_message) {
        this.msg_message = msg_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    @Override
    public String toString() {
        return  msg_message+'\n' + date_msg + '\n';
    }

}
