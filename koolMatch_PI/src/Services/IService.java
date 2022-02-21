/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author BAZINFO
 */
public interface IService<T> {
 

    public void ajouter(T p);

    public List<T> afficher();

    public boolean modifer(T p);

    public boolean supprimer(T p);
    public boolean updateNbrPlace(T P ,int nbPlace_reservation);
}
   

