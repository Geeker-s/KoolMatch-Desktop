/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

import java.sql.Date;

/**
 *
 * @author dedpy
 */
public class User {


    private int id_user;
    private String email_user;
    private String login_user;
    private String password_user;
    private String nom_user;
    private String prenom_user;
    private Date dateNaissance_user;
    private String sexe_user;
    private int telephone_user;
    private String photo_user;
    private String description_user;
    private int maxDistance_user;
    private int preferredMinAge_user;
    private int preferredMaxAge_user;
    private String adresse_user;
    private double latitude_user;
    private double longitude_user;
    private int interet_user;
    private int archive;

    public User() {
    }

    public User(int id_user, String email_user, String login_user, String password_user, String nom_user, String prenom_user, Date dateNaissance_user, String sexe_user, int telephone_user, String photo_user, String description_user, int maxDistance_user, int preferredMinAge_user, int preferredMaxAge_user, String adresse_user, double latitude_user, double longitude_user, int interet_user) {
        this.id_user = id_user;
        this.email_user = email_user;
        this.login_user = login_user;
        this.password_user = password_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.dateNaissance_user = dateNaissance_user;
        this.sexe_user = sexe_user;
        this.telephone_user = telephone_user;
        this.photo_user = photo_user;
        this.description_user = description_user;
        this.maxDistance_user = maxDistance_user;
        this.preferredMinAge_user = preferredMinAge_user;
        this.preferredMaxAge_user = preferredMaxAge_user;
        this.adresse_user = adresse_user;
        this.latitude_user = latitude_user;
        this.longitude_user = longitude_user;
        this.interet_user = interet_user;
        this.archive = archive ;
    }

    public User(String email_user, String login_user, String password_user, String nom_user, String prenom_user, Date dateNaissance_user, String sexe_user, int telephone_user, String photo_user, String description_user, int maxDistance_user, int preferredMinAge_user, int preferredMaxAge_user, String adresse_user, double latitude_user, double longitude_user, int interet_user) {
        this.email_user = email_user;
        this.login_user = login_user;
        this.password_user = password_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.dateNaissance_user = dateNaissance_user;
        this.sexe_user = sexe_user;
        this.telephone_user = telephone_user;
        this.photo_user = photo_user;
        this.description_user = description_user;
        this.maxDistance_user = maxDistance_user;
        this.preferredMinAge_user = preferredMinAge_user;
        this.preferredMaxAge_user = preferredMaxAge_user;
        this.adresse_user = adresse_user;
        this.latitude_user = latitude_user;
        this.longitude_user = longitude_user;
        this.interet_user = interet_user;
        this.archive = archive ;
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

   

    public int getId_user() {
        return id_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public Date getDateNaissance_user() {
        return dateNaissance_user;
    }

    public String getSexe_user() {
        return sexe_user;
    }

    public int getTelephone_user() {
        return telephone_user;
    }

    public String getPhoto_user() {
        return photo_user;
    }

    public String getDescription_user() {
        return description_user;
    }

    public int getMaxDistance_user() {
        return maxDistance_user;
    }

    public int getPreferredMinAge_user() {
        return preferredMinAge_user;
    }

    public int getPreferredMaxAge_user() {
        return preferredMaxAge_user;
    }

    public String getAdresse_user() {
        return adresse_user;
    }

    public double getLatitude_user() {
        return latitude_user;
    }

    public double getLongitude_user() {
        return longitude_user;
    }

    public int getInteret_user() {
        return interet_user;
    }

    public int getArchive() {
        return archive;
    }
    

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setDateNaissance_user(Date dateNaissance_user) {
        this.dateNaissance_user = dateNaissance_user;
    }

    public void setSexe_user(String sexe_user) {
        this.sexe_user = sexe_user;
    }

    public void setTelephone_user(int telephone_user) {
        this.telephone_user = telephone_user;
    }

    public void setPhoto_user(String photo_user) {
        this.photo_user = photo_user;
    }

    public void setDescription_user(String description_user) {
        this.description_user = description_user;
    }

    public void setMaxDistance_user(int maxDistance_user) {
        this.maxDistance_user = maxDistance_user;
    }

    public void setPreferredMinAge_user(int preferredMinAge_user) {
        this.preferredMinAge_user = preferredMinAge_user;
    }

    public void setPreferredMaxAge_user(int preferredMaxAge_user) {
        this.preferredMaxAge_user = preferredMaxAge_user;
    }

    public void setAdresse_user(String adresse_user) {
        this.adresse_user = adresse_user;
    }

    public void setLatitude_user(double latitude_user) {
        this.latitude_user = latitude_user;
    }

    public void setLongitude_user(double longitude_user) {
        this.longitude_user = longitude_user;
    }

    public void setInteret_user(int interet_user) {
        this.interet_user = interet_user;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        return "user{\n\t" + "id_user=" + id_user + "\n\temail_user=" + email_user + "\n\tlogin_user=" + login_user + "\n\tpassword_user=" + password_user + "\n\tnom_user=" + nom_user + "\n\tprenom_user=" + prenom_user + "\n\tdateNaissance_user=" + dateNaissance_user + "\n\tsexe_user=" + sexe_user + "\n\ttelephone_user=" + telephone_user + "\n\tphoto_user=" + photo_user + "\n\tdescription_user=" + description_user + "\n\tmaxDistance_user=" + maxDistance_user + "\n\tpreferredMinAge_user=" + preferredMinAge_user + "\n\tpreferredMaxAge_user=" + preferredMaxAge_user + "\n\tadresse_user=" + adresse_user + "\n\tlatitude_user=" + latitude_user + "\n\tlongitude_user=" + longitude_user + "\n\tinteret_user=" + interet_user +"\n\t archive=" + archive + '}' + "\n";
    }

}
