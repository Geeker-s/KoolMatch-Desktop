/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;

import entities.conversations;
import services.ServiceConversation;
import services.ServiceUser;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     //   ServiceUser user = new ServiceUser();
      //  System.out.println(user.afficher());

        ServiceConversation s = new ServiceConversation ();
        s.ajouter(new conversations ("test",3,5));
        System.out.println(s.afficher());

    }
    
}
