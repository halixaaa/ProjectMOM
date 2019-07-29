/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IEmployeeController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Employee;
import models.Role;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class EmployeeController implements IEmployeeController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public EmployeeController(){
        iGenericDAO = new GenericDAO(Employee.class, sessionFactory);
    }
    
    @Override
    public List<Employee> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Employee getById(String id) {
        return (Employee) iGenericDAO.getById(id);
    }

    @Override
    public List<Employee> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public String insertUpdate(String id, String name, String role, String phone, String email, String password) {
        String result = "";
        Role newRole = new Role(role);
        Employee employee = new Employee (new BigDecimal(id), name, newRole, phone, email, password);
        if(iGenericDAO.insertUpdate(employee)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Employee employee = new Employee(new BigDecimal(id));
        if(iGenericDAO.delete(employee)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;
    }
    
}
