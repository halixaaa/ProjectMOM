/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IStatusController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Status;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class StatusController implements IStatusController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public StatusController(){
        iGenericDAO = new GenericDAO(Status.class, sessionFactory);
    }
    
    @Override
    public List<Status> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Status getById(String id) {
        return (Status) iGenericDAO.getById(id);
    }

    @Override
    public List<Status> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String name) {
        String result = "";
        Status status = new Status(new BigDecimal(id), name);
        if(iGenericDAO.insertUpdate(status)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;  
    }

    @Override
    public String delete(String id) {
        String result = "";
        Status status = new Status (new BigDecimal(id));
        if(iGenericDAO.delete(status)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;  
    }
    
}
