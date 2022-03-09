/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import tn.edu.esprit.model.User;

/**
 *
 * @author BAZINFO
 */
public class sendSMS {

    public static final String ACCOUNT_SID = System.getenv("AC74900876b5c27e0c2c667afe542f6934");
    public static final String AUTH_TOKEN = System.getenv("d44b6dbc8237514b3c000e08f3f805ff");

    public static void sendSMS(User o) {
        Twilio.init("AC74900876b5c27e0c2c667afe542f6934", "d44b6dbc8237514b3c000e08f3f805ff");
        Message message = Message.creator(new PhoneNumber("+21658658857"),
                new PhoneNumber("+19378882181"),
                "Votre Réservation est effectue avec succée: Nom: " + o.getNom_user() + " Numero: " + o.getTelephone_user() + " Email: " + o.getEmail_user()).create();

        System.out.println(message.getSid());
    }

}