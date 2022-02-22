/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;

import entities.event;
import entities.invitation;
import java.sql.Date;
import services.ServiceEvent;
import services.ServiceInvitation;

/**
 *
 * @author dedpy
 */
public class KoolMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
       
          ServiceEvent e ;
        e = new ServiceEvent();
       
        ServiceInvitation i ;
        i = new ServiceInvitation();
       
       //AJOUT ET AFFICHAGE EVENT
       //e.ajouter(new event( "scary night ",Date.valueOf("2022-10-31"),Date.valueOf("2022-10-31")," halloween","esprit", 99485632));
       //System.out.println( e.afficher().toString() )  ;
        //e.supprimer(new  event (3) );
      
        
        
        //System.out.println( e.Recherche(new event ("test")));
       
       // System.out.println(i.Tri());
        
        
                
                
                
       
       // AJOUT ET AFFICHAGE INVITATION
      // i.ajouter(new invitation(159,23));
       //System.out.println( i.afficher().toString());
       
       //SUPPRIMER EVENT 
 //if (e.supprimer(new event(3))) {
          //  System.out.println("Supprimé avec succes.");
       // } else {
         //   System.out.println("Erreur de suppression.");
      //  }
//System.out.println( e.afficher().toString());
    
    //MODIFIER EVENT
      //  if (e.modifer(new event(4))) {
       //    System.out.println("Numéro modifié avec succes.");
       //} else {
          //  System.out.println("Erreur de modification.");    
        //}
       
        //MODIFIER INVITATION
       //   if (i.modifer(new invitation(1))) {
         // System.out.println("id modifié avec succes.");
       //} else {
         //   System.out.println("Erreur de modification.");    
        //}
          //    System.out.println( i.afficher().toString());

        //SUPPRIMER INVITATION
          //if (i.supprimer(new invitation(2))) {
            //System.out.println("Supprimé avec succes.");
       // } else {
           // System.out.println("Erreur de suppression.");
       // }
         //System.out.println( i.afficher().toString());
    } }
