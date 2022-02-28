/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.api;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import tn.edu.esprit.entities.user;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * 
 */
public class FB {
    
    public static void publish(String s) throws FileNotFoundException  {
       ////// lazemni nechoufhem  
        String MY_APP_ID = "339743583185311";
        String MY_APP_SECRET = "c4678b604004fd378b4d838993de2dbf";
        String MyAccessToken = "EAAE0ZCreXKZA8BAE0LCNlLOZBq8EyxMim2Jr3zAM2eBTGh9iOzODyzWuBJQLiZCQ0wnraTwA85PfpOFMoMrteZA7eVlHmIZBbapqFruM6kPBQp4gMYD2DYH61qjyYaBHKlD0ZCQrp33DUC36phOmDnEGemPHREORYbKBXrcnFRcwv6DaKTmjrqtAZBTGRwV0ZAJgZD";

        //AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(MY_APP_ID, MY_APP_SECRET);
        DefaultFacebookClient facebookClient = new DefaultFacebookClient(MyAccessToken);
        String fbMessage = "Hello from java!";
        FileInputStream fb = new FileInputStream("C:\\wamp64\\www\\images\\"+s);
        //facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", fbMessage));
        facebookClient.publish("me/photos", FacebookType.class,
               BinaryAttachment.with("jpg",fb ),
                Parameter.with("message",  "\n#PI_DEV\n#ESPRIT"));
        
         user user = facebookClient.fetchObject("me", user.class,
               Parameter.with("fields",
                       "id_user,nom_user,prenom_user,email_user"));
 
        System.out.println("Nom_user= " + user.getNom_user());
        System.out.println("Prenom_user= " + user.getPrenom_user());
        System.out.println("Email= " + user.getEmail_user());

        
        
    }
    
    
    
   
    
}