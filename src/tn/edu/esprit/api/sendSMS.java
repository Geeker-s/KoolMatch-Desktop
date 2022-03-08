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

    public static final String ACCOUNT_SID = System.getenv("AC819daf1663c267f81b66523a3ff664af");
    public static final String AUTH_TOKEN = System.getenv("aaa2795e8daceaa62b4ef9c056da4b1a");

    public static void sendSMS(User o) {
        Twilio.init("AC819daf1663c267f81b66523a3ff664af", "aaa2795e8daceaa62b4ef9c056da4b1a");
        Message message = Message.creator(new PhoneNumber("+21658658857"),
                new PhoneNumber("+19036648306"),
                "Votre Réservation est effectue avec succée: Nom: " + o.getNom_user() + " Numero: " + o.getTelephone_user() + " Email: " + o.getEmail_user()).create();

        System.out.println(message.getSid());
    }

}
