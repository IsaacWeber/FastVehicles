/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Isaac
 */
public interface Dao <T> {
	
    public T get(long id); //get by id

    public List<T> getAll(); 

    public void save(T t);

    public void update(T t, String[] tData);

    public void delete(T t);

	
}
