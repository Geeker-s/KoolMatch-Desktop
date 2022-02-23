/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import entities.user;

/**
 *
 * @author BAZINFO
 */

public class sendSMS {
   public static final String ACCOUNT_SID = System.getenv("AC0f040f74c65e0af93886008a55e9987e");
    public static final String AUTH_TOKEN = System.getenv("8b806914368462163f4d778f7b00f458");

    public static void sendSMS(user o) {
        Twilio.init("AC0f040f74c65e0af93886008a55e9987e", "8b806914368462163f4d778f7b00f458");
        Message message = Message.creator(new PhoneNumber("+21658658857"),
        new PhoneNumber("+19034946252"), 
        "Nom: "+o.getNom_user()+" Numero: "+o.getTelephone_user()+" Email: "+o.getEmail_user()).create();
       

        System.out.println(message.getSid());
    }
    
}
    

