/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koolmatch;

import entities.event;
import java.sql.Date;
import services.ServiceEvent;

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
       // e.ajouter(new event( "turki",Date.valueOf("2022-12-01"),Date.valueOf("2022-12-01")," valo","dghdghd", 99485632));
        System.out.println( e.afficher().toString());
       
        


    }
    
}
