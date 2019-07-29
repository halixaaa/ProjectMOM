/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IRoleController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Role;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class RoleController implements IRoleController{
    
    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public RoleController(){
        iGenericDAO = new GenericDAO(Role.class, sessionFactory);
    }
    
    @Override
    public List<Role> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Role getById(String id) {
        return (Role) iGenericDAO.getById(id);
    }

    @Override
    public List<Role> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String name) {
        String result = "";
        Role role = new Role(new BigDecimal(id), name);
        if(iGenericDAO.insertUpdate(role)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;    
    }

    @Override
    public String delete(String id) {
        String result = "";
        Role role = new Role(new BigDecimal(id));
        if(iGenericDAO.delete(role)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;  
    }
    
}
