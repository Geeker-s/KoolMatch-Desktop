/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import tn.edu.esprit.model.Admin;
import tn.edu.esprit.model.User;

/**
 *
 * @author BAZINFO
 */
public class sendSMSajouterresto {
       public static final String ACCOUNT_SID = System.getenv("ACf198f306860c58d1f6de11e2fe8759aa");
    public static final String AUTH_TOKEN = System.getenv("559d6982a7f76c098b9e238940915ed3");

    public static void sendSMSajouter(Admin o) {
        Twilio.init("ACf198f306860c58d1f6de11e2fe8759aa", "559d6982a7f76c098b9e238940915ed3");
        Message message = Message.creator(new PhoneNumber("+21628506368"),
                new PhoneNumber("+17579929823"),
               " ID: "+ o.getId_admin()+ " Nom: " + o.getLogin_admin()+ "ajoute un restaurant").create();

        System.out.println(message.getSid());
    }
}
