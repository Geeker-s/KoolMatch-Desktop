/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Guedo
 */
public class messages {
private int id_message;
private String msg_message;
private Date date_message ;

    public messages() {
    }


    public messages(String msg_message, Date date_message) {
        this.msg_message = msg_message;
        this.date_message = date_message;
    }

    public messages(int id_message, String msg_message, Date date_message) {
        this.id_message = id_message;
        this.msg_message = msg_message;
        this.date_message = date_message;
    }

    public messages(int id_message) {
        this.id_message = id_message;
    }

       public int getId_message() {
        return id_message;
    }
           public Date getDate_message() {
        return date_message;
    }

    public String getMsg_message() {
        return msg_message;
    }

    public void setDate_message(Date date_message) {
        this.date_message = date_message;
    }

 

    public void setMsg_message(String msg_message) {
        this.msg_message = msg_message;
    }

    @Override
    public String toString() {
        return "messages{" + "msg_message=" + msg_message + ", date_message=" + date_message + '}';
    }


    
    
  
}
