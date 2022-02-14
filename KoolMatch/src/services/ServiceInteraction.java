/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.interaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author wassimromdhane
 */
public class ServiceInteraction implements IService<interaction> {

    private final Connection cnx;

    public ServiceInteraction() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(interaction p) {
        try {
            String querry = "INSERT INTO `interaction` (`type_interaction`,`date_interaction`,`id_user1`,`id_user2`) VALUES('" + p.getType_interaction() + "','" + p.getDate_interaction() + "','" + p.getId_user1() + "','" + p.getId_user2() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<interaction> afficher() {
        List<interaction> interactions = new ArrayList<>();
        try {
            String req = "SELECT * FROM interaction";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                interactions.add(new interaction(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return interactions;
    }

    @Override
    public boolean modifer(interaction p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean supprimer(interaction p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
