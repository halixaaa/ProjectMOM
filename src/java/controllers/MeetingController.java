/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IMeetingController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.Meeting;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class MeetingController implements IMeetingController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public MeetingController(){
        iGenericDAO = new GenericDAO(Meeting.class, sessionFactory);
    }
    
    @Override
    public List<Meeting> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Meeting getById(String id) {
        return (Meeting) iGenericDAO.getById(id);
    }

    @Override
    public List<Meeting> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String name, String project, String dates, String time, String chairedby, String type, String customer) {
        String result = "";
        Customer newCustomer = new Customer(customer);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = formatter.parse(dates);
        } catch (ParseException ex) {
            Logger.getLogger(FollowupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Meeting meeting = new Meeting(new BigDecimal(id), name, project, newDate, time, chairedby, type, newCustomer);
        if(iGenericDAO.insertUpdate(meeting)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;  
    }

    @Override
    public String delete(String id) {
        String result = "";
        Meeting meeting = new Meeting(new BigDecimal(id));
        if(iGenericDAO.delete(id)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;    
    
    }
    
}
