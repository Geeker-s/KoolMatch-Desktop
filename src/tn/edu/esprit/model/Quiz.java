/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author khaled
 */
public class Quiz {
    int id_quiz;
     int id_jeu;
     int archive ;
    String q1;
    String rc1;
    String rf11;
    String rf12;
    String rf13;
    String q2;
    String rc2;
    String rf21;
    String rf22;
    String rf23;
    String q3;
    String rc3;
    String rf31;
    String rf32;
    String rf33;

    public Quiz() {
    }

    public Quiz(int id_jeu) {
        this.id_jeu = id_jeu;
    }

    public Quiz(int id_quiz, int id_jeu) {
        this.id_quiz = id_quiz;
        this.id_jeu = id_jeu;
    }
    
    public Quiz(int id_quiz, int id_jeu, String q1, String rc1, String rf11, String rf12, String rf13, String q2, String rc2, String rf21, String rf22, String rf23, String q3, String rc3, String rf31, String rf32, String rf33) {
        this.id_quiz = id_quiz;
        this.id_jeu = id_jeu;
        this.q1 = q1;
        this.rc1 = rc1;
        this.rf11 = rf11;
        this.rf12 = rf12;
        this.rf13 = rf13;
        this.q2 = q2;
        this.rc2 = rc2;
        this.rf21 = rf21;
        this.rf22 = rf22;
        this.rf23 = rf23;
        this.q3 = q3;
        this.rc3 = rc3;
        this.rf31 = rf31;
        this.rf32 = rf32;
        this.rf33 = rf33;
        this.archive = 0;
    }

    public Quiz(int id_jeu, String q1, String rc1, String rf11, String rf12, String rf13, String q2, String rc2, String rf21, String rf22, String rf23, String q3, String rc3, String rf31, String rf32, String rf33) {
        this.id_jeu = id_jeu;
        this.q1 = q1;
        this.rc1 = rc1;
        this.rf11 = rf11;
        this.rf12 = rf12;
        this.rf13 = rf13;
        this.q2 = q2;
        this.rc2 = rc2;
        this.rf21 = rf21;
        this.rf22 = rf22;
        this.rf23 = rf23;
        this.q3 = q3;
        this.rc3 = rc3;
        this.rf31 = rf31;
        this.rf32 = rf32;
        this.rf33 = rf33;
        this.archive = 0;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public int getId_jeu() {
        return id_jeu;
    }

    public String getQ1() {
        return q1;
    }

    public String getRc1() {
        return rc1;
    }

    public String getRf11() {
        return rf11;
    }

    public String getRf12() {
        return rf12;
    }

    public String getRf13() {
        return rf13;
    }

    public String getQ2() {
        return q2;
    }

    public String getRc2() {
        return rc2;
    }

    public String getRf21() {
        return rf21;
    }

    public String getRf22() {
        return rf22;
    }

    public String getRf23() {
        return rf23;
    }

    public String getQ3() {
        return q3;
    }

    public String getRc3() {
        return rc3;
    }

    public String getRf31() {
        return rf31;
    }

    public String getRf32() {
        return rf32;
    }

    public String getRf33() {
        return rf33;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public void setId_jeu(int id_jeu) {
        this.id_jeu = id_jeu;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public void setRc1(String rc1) {
        this.rc1 = rc1;
    }

    public void setRf11(String rf11) {
        this.rf11 = rf11;
    }

    public void setRf12(String rf12) {
        this.rf12 = rf12;
    }

    public void setRf13(String rf13) {
        this.rf13 = rf13;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public void setRc2(String rc2) {
        this.rc2 = rc2;
    }

    public void setRf21(String rf21) {
        this.rf21 = rf21;
    }

    public void setRf22(String rf22) {
        this.rf22 = rf22;
    }

    public void setRf23(String rf23) {
        this.rf23 = rf23;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public void setRc3(String rc3) {
        this.rc3 = rc3;
    }

    public void setRf31(String rf31) {
        this.rf31 = rf31;
    }

    public void setRf32(String rf32) {
        this.rf32 = rf32;
    }

    public void setRf33(String rf33) {
        this.rf33 = rf33;
    }

    public int getEtat() {
        return archive;
    }

    public void setEtat(int archive) {
        this.archive = archive;
    }
    
    
}
