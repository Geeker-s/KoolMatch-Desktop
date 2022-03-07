/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author BAZINFO
 */
public class Restaurant {

    //  this item for making a static id to manipulate between pages (update/resrvation/delete )
    private static int id_courant;

    public static int getId_courant() {
        return id_courant;
    }
    private static int id_courant_do;

    public static int getId_courant_do() {
        return id_courant_do;
    }

    public static void setId_courant(int id_courant) {
        Restaurant.id_courant = id_courant;
    }

    private int id_restaurant;
    private String nom_restaurant;
    private String adresse_restaurant;
    private int telephone_restaurant;
    private String siteweb_restaurant;
    private String specialite_restaurant;
    private int id_gerant;
    private String image;
    private int archive;
    private int nb_placeResto;
    public int getAdresse_restaurant;
    private String image_structure_resturant;
    private String description;
    private String lien;

    public Restaurant() {
    }

    public Restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public Restaurant(String adresse_restaurant) {
        this.adresse_restaurant = adresse_restaurant;
    }

    public Restaurant(int id_restaurant, String nom_restaurant, String adresse_restaurant, int telephone_restaurant, String siteweb_restaurant, String specialite_restaurant, int id_gerant, String image, int archive, int nb_placeResto, String image_structure_resturant, String description, String lien) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.adresse_restaurant = adresse_restaurant;
        this.telephone_restaurant = telephone_restaurant;
        this.siteweb_restaurant = siteweb_restaurant;
        this.specialite_restaurant = specialite_restaurant;
        this.id_gerant = id_gerant;
        this.image = image;
        this.archive = archive;
        this.nb_placeResto = nb_placeResto;
        this.image_structure_resturant = image_structure_resturant;
        this.description = description;
        this.lien = lien;
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

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public int getGetAdresse_restaurant() {
        return getAdresse_restaurant;
    }

    public void setGetAdresse_restaurant(int getAdresse_restaurant) {
        this.getAdresse_restaurant = getAdresse_restaurant;
    }

    public String getImage_structure_resturant() {
        return image_structure_resturant;
    }

    public void setImage_structure_resturant(String image_structure_resturant) {
        this.image_structure_resturant = image_structure_resturant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id_restaurant=" + id_restaurant + ",nom_restaurant=" + nom_restaurant + ", adresse_restaurant=" + adresse_restaurant + ", telephone_restaurant=" + telephone_restaurant + ", siteweb_restaurant=" + siteweb_restaurant + ", specialite_restaurant=" + specialite_restaurant + ", image=" + image + ", id_gerant=" + id_gerant + ",nb_placeResto" + nb_placeResto + ",description" + description + '\n' + '}';
    }

}
