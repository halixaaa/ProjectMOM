/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IFollowupController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Followup;
import models.Mom;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class FollowupController implements IFollowupController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public FollowupController(){
        iGenericDAO = new GenericDAO(Followup.class, sessionFactory);
    }
    
    @Override
    public List<Followup> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Followup getById(String id) {
        return (Followup) iGenericDAO.getById(id);
    }

    @Override
    public List<Followup> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String name, String pic, String targetdate, String notes, String mom) {
        String result = "";
        Mom newMom = new Mom(mom);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = formatter.parse(targetdate);
        } catch (ParseException ex) {
            Logger.getLogger(FollowupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Followup followup = new Followup(new BigDecimal(id), name, pic, newDate, notes, newMom);
        if(iGenericDAO.insertUpdate(followup)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;    
    }

    @Override
    public String delete(String id) {
        String result = "";
        Followup followup = new Followup(new BigDecimal(id));
        if(iGenericDAO.delete(followup)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;    
    }
    
}
