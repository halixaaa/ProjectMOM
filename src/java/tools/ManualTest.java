/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.GenericDAO;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bella
 */
public class ManualTest {
    public static void main(String[] args) throws SQLException {
//        System.out.println(HibernateUtil.getSessionFactory());
//        IUserManagementController managementController = new UserManagementController();
////        IUserManagementDAO ium = new UserManagementDAO();
////        UserManagement um = new UserManagement();
//        System.out.println(managementController.insertUpdate("valen","uwu"));
//            System.out.println(ium.insert(new UserManagement("ajja", "djsdjs")));
            
//        IRegionDAO irdao = new RegionDAO();
/*        for (Region region : irdao.getAll()) {
            System.out.println(region.getRegionId()+" "+region.getRegionName());
            for (Country country : region.getCountryList()) {
                System.out.println(country.getCountryId());
                for (Location location : country.getLocationList()) {
                    System.out.println(location.getCity());
                    for (Department department : location.getDepartmentList()) {
                        System.out.println(department.getDepartmentName());
                        for (Employee employee : department.getEmployeeList()) {
                            System.out.println(employee.getFirstName());
                            System.out.println();
                        }System.out.println();
                    }System.out.println();
                }System.out.println();
            }System.out.println();
            
        } */
  
//        IJobDAO ijdao = new JobDAO();
//        System.out.println(ijdao.getById("AD_VIS").getJobTitle()); 

        /*Region region = new Region(regionId, "Bakso");
        System.out.println(irdao.insertupdate(region)); */
        
//        for (Region region : irdao.getByName("Se")){
//            System.out.println(region.getRegionId()+" "+region.getRegionName());
//        }
        
     //  BigDecimal regionId = new BigDecimal(666);
     //  Region r = new Region(regionId);
     //   System.out.println(irdao.delete(r));
        
    //manual test generic
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        IGenericDAO<Employee> reg = new GenericDAO<>(Employee.class, sessionFactory);
//        BigDecimal id = new BigDecimal(1);
//        Employee model = new Employee (id, "oke");
//        System.out.println(reg.insertUpdate(model));
//          IGenericDAO<Job> jobDAO = new GenericDAO<>(Job.class, sessionFactory);
          for (Employee region : reg.getAll()){
              System.out.println(region.getId()+" "+region.getName());
          }
////              System.out.println(job.getJobTitle());
//          System.out.println(jobDAO.delete(new Job("ADD")));
//        System.out.println(countryDAO.getById("AR").getCountryName());
//        for (Country country : countryDAO.getByName("a")){
//            System.out.println(country.getCountryName());
//        }

//        BigDecimal regionId = new BigDecimal(9);
//        System.out.println(countryDAO.insertUpdate(new Country("ID", "Indonesia", new Region(regionId))));
            
//        System.out.println(countryDAO.delete(new Country("ID")));
            
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        IGenericDAO genericDAO = new GenericDAO(UserManagement.class, sessionFactory);
//        UserManagement um = new UserManagement("bella", "nurha");
//        System.out.println(genericDAO.insertUpdate(um));

    
        }
        
    } 
