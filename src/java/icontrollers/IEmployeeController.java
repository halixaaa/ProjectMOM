/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author Bella
 */
public interface IEmployeeController {
    public List<Employee> getAll();
    public Employee getById(String id);
    public List<Employee> getByName(String name);
    public String insertUpdate (String id, String name, String role, String phone, String email, String password);
    public String delete(String id);
}
