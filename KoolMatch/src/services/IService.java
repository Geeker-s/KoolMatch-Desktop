/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author dedpy
 */
public interface IService<T> {

    public void ajouter(T p);

    public List<T> afficher();

    public boolean modifer(T p);

    public boolean supprimer(T p);
    
    public List<T> rechercher(T p);
    
     
    
}
 