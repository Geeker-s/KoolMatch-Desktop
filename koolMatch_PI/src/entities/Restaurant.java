/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author BAZINFO
 */
public class Restaurant {
    private int id_restaurant;
    private String nom_restaurant;
    private String adresse_restaurant;
    private int telephone_restaurant ;
    private String siteweb_restaurant ;
    private String specialite_restaurant;
    private int id_gerant ;
    private String image;
    private int statut_supprime  ;
    private int nb_placeResto;
    public int getAdresse_restaurant;

public Restaurant(){} 
public Restaurant(int id_restaurant){
this.id_restaurant = id_restaurant ;
} 
public Restaurant(String adresse_restaurant){
this.adresse_restaurant = adresse_restaurant ;
} 
    public Restaurant(int id_restaurant, String nom_restaurant, String adresse_restaurant, int telephone_restaurant, String siteweb_restaurant, String specialite_restaurant,int id_gerant,String image,int statut_supprime, int nb_placeResto  ) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.adresse_restaurant = adresse_restaurant;
        this.telephone_restaurant = telephone_restaurant;
        this.siteweb_restaurant = siteweb_restaurant;
        this.specialite_restaurant = specialite_restaurant;
        this.id_gerant = id_gerant;
         this.image = image;
         this.statut_supprime = statut_supprime;
         this.nb_placeResto=nb_placeResto;
    }







public Restaurant(int id_restaurant, String nom_restaurant, String adresse_restaurant, int telephone_restaurant, String siteweb_restaurant, String specialite_restaurant, int id_gerant) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.adresse_restaurant = adresse_restaurant;
        this.telephone_restaurant = telephone_restaurant;
        this.siteweb_restaurant = siteweb_restaurant;
        this.specialite_restaurant = specialite_restaurant;
        this.id_gerant = id_gerant;
    }

    public Restaurant(int id_restaurant, int nb_placeResto) {
        this.id_restaurant = id_restaurant;
        this.nb_placeResto = nb_placeResto;
    }


 public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public String getAdresse_restaurant() {
        return adresse_restaurant;
    }

    public void setAdresse_restaurant(String adresse_restaurant) {
        this.adresse_restaurant = adresse_restaurant;
    }

    public int getTelephone_restaurant() {
        return telephone_restaurant;
    }

    public void setTelephone_restaurant(int telephone_restaurant) {
        this.telephone_restaurant = telephone_restaurant;
    }

    public String getSiteweb_restaurant() {
        return siteweb_restaurant;
    }

    public void setSiteweb_restaurant(String siteweb_restaurant) {
        this.siteweb_restaurant = siteweb_restaurant;
    }

    public String getSpecialite_restaurant() {
        return specialite_restaurant;
    }

    public void setSpecialite_restaurant(String specialite_restaurant) {
        this.specialite_restaurant = specialite_restaurant;
    }

    public int getId_gerant() {
        return id_gerant;
    }

    public void setId_gerant(int id_gerant) {
        this.id_gerant = id_gerant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNb_placeResto() {
        return nb_placeResto;
    }

    public void setNb_placeResto(int nb_placeResto) {
        this.nb_placeResto = nb_placeResto;
    }

    
      public int getStatut_supprime() {
        return statut_supprime;
    }

    public void setStatut_supprime(int statut_supprime) {
        this.statut_supprime = statut_supprime;
    }
    
    @Override
    public String toString() {
        return "Restaurant{" + "id_restaurant=" + id_restaurant + ",nom_restaurant=" + nom_restaurant + ", adresse_restaurant=" + adresse_restaurant + ", telephone_restaurant=" + telephone_restaurant + ", siteweb_restaurant=" + siteweb_restaurant + ", specialite_restaurant=" + specialite_restaurant + ", image=" + image +  ", id_gerant=" + id_gerant + ",nb_placeResto" +nb_placeResto +'\n'+ '}';
    }

  
  
}
