/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author khaled
 */
public class Recette {
     int id_recette;
    String nom_recette;
    String photo_recette;
    String description_recette;
    String categorie_recette ;
    int duree_recette;
    int etat ;
    public Recette() {
    }

    public Recette(String nom_recette, String photo_recette, String description_recette, String categorie_recette, int duree_recette) {
        this.nom_recette = nom_recette;
        this.photo_recette = photo_recette;
        this.description_recette = description_recette;
        this.categorie_recette = categorie_recette;
        this.duree_recette = duree_recette;
        this.etat = 1;
    }

    public Recette(int id_recette, String nom_recette, String photo_recette, String description_recette, String categorie_recette, int duree_recette) {
        this.id_recette = id_recette;
        this.nom_recette = nom_recette;
        this.photo_recette = photo_recette;
        this.description_recette = description_recette;
        this.categorie_recette = categorie_recette;
        this.etat = 1;
    }

    public Recette(int id_recette) {
        this.id_recette = id_recette;
    }
    
    public int getId_recette() {
        return id_recette;
    }

    public String getNom_recette() {
        return nom_recette;
    }

    public String getPhoto_recette() {
        return photo_recette;
    }

    public String getDescription_recette() {
        return description_recette;
    }

    public String getCategorie_recette() {
        return categorie_recette;
    }

    public int getDuree_recette() {
        return duree_recette;
    }

    public void setId_recette(int id_recette) {
        this.id_recette = id_recette;
    }

    public void setNom_recette(String nom_recette) {
        this.nom_recette = nom_recette;
    }

    public void setPhoto_recette(String photo_recette) {
        this.photo_recette = photo_recette;
    }

    public void setDescription_recette(String description_recette) {
        this.description_recette = description_recette;
    }

    public void setCategorie_recette(String categorie_recette) {
        this.categorie_recette = categorie_recette;
    }

    public void setDuree_recette(int duree_recette) {
        this.duree_recette = duree_recette;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    @Override
    public String toString() {
        return "Recette{" + "id_recette=" + id_recette + ", nom_recette=" + nom_recette + ", photo_recette=" + photo_recette + ", description_recette=" + description_recette + ", categorie_recette=" + categorie_recette + ", duree_recette=" + duree_recette + '}';
    }
    
}
