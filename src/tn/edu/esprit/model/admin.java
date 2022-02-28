/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author MED ZOUARI
 */
public class admin {
    private int id_admin ;
    private String login_admin;
    private String password_admin;
    private int archive;

    public admin() {
    }

    public admin(int id_admin, String login_admin, String password_admin) {
        this.id_admin = id_admin;
        this.login_admin = login_admin;
        this.password_admin = password_admin;
        this.archive = archive;
    }

    public admin(String login_admin, String password_admin) {
        this.login_admin = login_admin;
        this.password_admin = password_admin;
        this.archive = archive;
    }

    public admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getLogin_admin() {
        return login_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public int getArchive() {
        return archive;
    }
    

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setLogin_admin(String login_admin) {
        this.login_admin = login_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        return "admin{\n\t" + "id_admin=" + id_admin + ",\n\t login_admin=" + login_admin + ",\n\t password_admin=" + password_admin + ",\n\t archive=" + archive + '}';
    }

    
    
}
