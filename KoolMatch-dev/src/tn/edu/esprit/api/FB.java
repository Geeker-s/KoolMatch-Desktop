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
import tn.edu.esprit.model.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 *
 */
public class FB {

    public static void publish(String s) throws FileNotFoundException {
        ////// lazemni nechoufhem  
        String MY_APP_ID = "721112175716489";
        String MY_APP_SECRET = "0144b8b1c177290e37a91b165a06b2ae";
        String MyAccessToken = "EAAKP2QMTqIkBAEkUAu1VnjCtp3W8GmZAlgSHlA9LaPs7nYS3e5kCxlE17wMLjrzjATiDRtOo1DvmtRwmkW8oMZAIUpKKFVjinAsRHQ3ACAkhUZBlOAVB5skT2ZAF9ptyimzLSftqVMIiRDr1ciiZCvqGHGDVVqex2r543tccNcja2z274xbOskwqNN2MDqp8BH6WV08pzqGZBn8656cL7P";

        AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(MY_APP_ID, MY_APP_SECRET);
        DefaultFacebookClient facebookClient = new DefaultFacebookClient(MyAccessToken);
        String fbMessage = "Hello from java!";
        FileInputStream fb = new FileInputStream(s);
        //facebookClient.publish("me/feed", FacebookType.class, Parameter.with("message", fbMessage));
        facebookClient.publish("me/photos", FacebookType.class,
                BinaryAttachment.with("jpg", fb),
                Parameter.with("message", "\n#PI_DEV\n#ESPRIT"));

        User user = facebookClient.fetchObject("me", User.class,
                Parameter.with("fields",
                        "id_user,nom_user,prenom_user,email_user"));

        System.out.println("Nom_user= " + user.getNom_user());
        System.out.println("Prenom_user= " + user.getPrenom_user());
        System.out.println("Email= " + user.getEmail_user());

    }

}
