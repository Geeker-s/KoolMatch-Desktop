/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;

import entities.admin;
import entities.gerant;
import entities.user;
import java.sql.Date;
import services.ServiceAdmin;
import services.ServiceGerant;
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

        
        //ServiceUser u = new ServiceUser();
        
        //AjouterUser
        
        //u.ajouter(new user("marwenyakoubi@gmail.com","maroo","1234ll","marwen","yakoubi", Date.valueOf("1998-05-14"),"homme",29163283,"photo.jpeg","I love lablebi",10,18,20,"ennasser",5000,8999,"10100100001010001010"));
        
        //ModifierUser
        
            //if (u.modifer(new user(1))) {
            //System.out.println("Description modifié avec succes.");
                //} else {
            //System.out.println("Erreur de modification.");
            //}
            
        //SupprimerUser
        
        //if (u.supprimer(new user(4))) {
            //System.out.println("Supprimé avec succes.");
                //} else {
            //System.out.println("Erreur de suppression.");
        //}
        //System.out.println(u.afficher());
        
        
        //ServiceAdmin a = new ServiceAdmin () ;
        
        //AjouterAdmin
        //a.ajouter(new admin("admin","123456l"));
        
        //ModifierAdmin
        
        //if (a.modifer(new admin(1))) {
            //System.out.println("MDP modifié avec succes.");
                //} else {
            //System.out.println("Erreur de modification.");
            //}
            
        //SuprimerAdmin
        
        //if (a.supprimer(new admin(5))) {
            //System.out.println("Supprimé avec succes.");
                //} else {
            //System.out.println("Erreur de suppression.");
        //}
        //System.out.println(a.afficher());
        
        
        ServiceGerant g = new ServiceGerant ();
        
        //AjouterGerant
        
        //g.ajouter(new gerant("test5","test6",22565454,Date.valueOf("2022-06-01"),Date.valueOf("2022-09-01")));
        
        //ModifierGerant
        
        //if (g.modifer(new gerant(1))) {
            //System.out.println("Numéro téléphone modifié avec succes.");
                //} else {
            //System.out.println("Erreur de modification.");
            //}
            
        //SupprimerGerant
        
        //if (g.supprimer(new gerant(15))) {
            //System.out.println("Supprimé avec succes.");
                //} else {
            //System.out.println("Erreur de suppression.");
        //}
        //System.out.println(g.afficher());
        
    }
    
}
