/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IGenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class GenericDAO<T> implements IGenericDAO<T>{
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;
    private Class general = null;
    String name;
    
    
    public GenericDAO(Class general, SessionFactory sessionFactory){
        this.general = general;
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<T> getAll() {
        List<T> listData = new ArrayList<T>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            listData = session.createQuery("FROM " + general.getSimpleName() +"").list();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listData;
    }

    public T getById(Object key) {
        T model = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            model = (T) session.createQuery("FROM " + general.getSimpleName() + 
                    " WHERE " + general.getSimpleName().toLowerCase() + "Id=:keyword")
                    .setParameter("keyword", key).uniqueResult();
            transaction.commit();
        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally{
           session.close();
        }
        return model;
    }

    public List<T> getByName(Object key) {
        List<T> listData = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            listData = session.createQuery("FROM " + general.getSimpleName() + 
                    " WHERE lower(" + paramCondition().toLowerCase() + 
                     name +") like lower (concat('%', :keyword,'%'))")
                    .setParameter("keyword", key).list();
              
            transaction.commit();
        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally{
           session.close();
        }
        return listData;
    }



    @Override
    public boolean delete(T model) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(model);
            transaction.commit();
            result = true;
        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally{
           session.close();
        }
        return result;
    }
    
    private String paramCondition(){
        String simpString = general.getSimpleName();
        if (general.getSimpleName().equals("Employee")) {
            name = "lastName || firstName";
            simpString = "";
        } else if (general.getSimpleName().equals("Job")) {
            name = "Title";
        } else if (general.getSimpleName().equals("Location")) {
            name = "City";
            simpString = "";
        } else {
            name = "Name";
        }
        return simpString;
    }




    public boolean insertUpdate(T model) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(model);
            transaction.commit();
            result = true;
        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally{
           session.close();
        }
        return result;
    }
}
