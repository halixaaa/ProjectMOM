/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Role;

/**
 *
 * @author Bella
 */
public interface IRoleController {
    public List<Role> getAll();
    public Role getById(String id);
    public List<Role> getByName(String name);
    public String insertUpdate (String id, String name);
    public String delete(String id);
}
