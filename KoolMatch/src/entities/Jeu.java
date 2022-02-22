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
public class Jeu {
     int id_jeu;
    int score_jeu;
    int id_recette;
    int id_user;
    int etat ;

    public Jeu() {
    }

    public Jeu(int id_jeu, int score_jeu, int id_recette, int id_user) {
        this.id_jeu = id_jeu;
        this.score_jeu = score_jeu;
        this.id_recette = id_recette;
        this.id_user = id_user;
        this.etat =1;
    }

    public Jeu(int id_jeu) {
        this.id_jeu = id_jeu;
    }

    public Jeu(int id_jeu, int score_jeu, int id_recette, int id_user, int etat) {
        this.id_jeu = id_jeu;
        this.score_jeu = score_jeu;
        this.id_recette = id_recette;
        this.id_user = id_user;
        this.etat = etat;
    }

    public Jeu(int score_jeu, int id_recette, int id_user) {
        this.score_jeu = score_jeu;
        this.id_recette = id_recette;
        this.id_user = id_user;
         this.etat =1;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getEtat() {
        return etat;
    }

    public int getId_jeu() {
        return id_jeu;
    }

    public int getScore_jeu() {
        return score_jeu;
    }

    public int getId_recette() {
        return id_recette;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_jeu(int id_jeu) {
        this.id_jeu = id_jeu;
    }

    public void setScore_jeu(int score_jeu) {
        this.score_jeu = score_jeu;
    }

    public void setId_recette(int id_recette) {
        this.id_recette = id_recette;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jeu other = (Jeu) obj;
        if (this.id_jeu != other.id_jeu) {
            return false;
        }
        if (this.score_jeu != other.score_jeu) {
            return false;
        }
        if (this.id_recette != other.id_recette) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jeu{" + "id_jeu=" + id_jeu + ", score_jeu=" + score_jeu + ", id_recette=" + id_recette + ", id_user=" + id_user + '}';
    }
  
}
