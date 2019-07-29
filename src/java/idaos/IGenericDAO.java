/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;

/**
 *
 * @author Bella
 */
public interface IGenericDAO<T> {
    public List<T> getAll();
    public T getById(Object key);
    public List<T> getByName(Object key);
    public boolean insertUpdate(T model);
    public boolean delete(T model);


}
