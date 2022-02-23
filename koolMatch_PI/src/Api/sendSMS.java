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
   public static final String ACCOUNT_SID = System.getenv("ACdd4694f7755efbb29c9f88a958d82a65");
    public static final String AUTH_TOKEN = System.getenv("8d3245f599c43b76162cedbcd8636ca2");

    public void sendSMS(user o) {
        Twilio.init("ACdd4694f7755efbb29c9f88a958d82a65", "8d3245f599c43b76162cedbcd8636ca2");
        Message message = Message.creator(new PhoneNumber("+21658658857"),
        new PhoneNumber("+18608544709"), 
        "Nom: "+o.getNom_user()+" Numero: "+o.getTelephone_user()+" Email: "+o.getEmail_user()).create();
       

        System.out.println(message.getSid());
    }
    
    
    
    
}
    

