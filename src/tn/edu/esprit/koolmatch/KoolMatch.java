/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.koolmatch;

import tn.edu.esprit.model.Interaction;
import tn.edu.esprit.model.Matching;
import tn.edu.esprit.model.user;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import tn.edu.esprit.services.ServiceAdmin;
import tn.edu.esprit.services.ServiceGerant;
import tn.edu.esprit.services.ServiceInteraction;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.utils.Mail;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//--
        ServiceUser user = new ServiceUser();
        ServiceAdmin admin = new ServiceAdmin();
        ServiceGerant gerant = new ServiceGerant();
        ServiceMatching match = new ServiceMatching();
        ServiceInteraction react = new ServiceInteraction();
        
// Testing      
        
        
        
        
//--
        System.out.println(user.afficher());
        System.out.println(admin.afficher());
        System.out.println(gerant.afficher());
        System.out.println(match.afficher());
        System.out.println(react.afficher());
    }

}
