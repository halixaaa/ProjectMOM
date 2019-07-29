/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Customer;

/**
 *
 * @author Bella
 */
public interface ICustomerController {
    public List<Customer> getAll();
    public Customer getById(String id);
    public List<Customer> getByName(String name);
    public String insertUpdate (String id, String name, String pic, String address, String phone, String email);
    public String delete(String id);
}
