/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.interfaces.IService;
import tn.edu.esprit.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.utils.MyDB;

/**
 *
 * @author dedpy
 */
public class ServiceUser implements IService<User> {

    private Connection cnx;

    public ServiceUser() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(User p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> afficher() {
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getString(15),rs.getFloat(16),rs.getFloat(17),rs.getString(18)));
            }
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return users;
    }

    @Override
    public boolean modifer(User p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(User p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
