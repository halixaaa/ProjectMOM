/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Status;

/**
 *
 * @author Bella
 */
public interface IStatusController {
    public List<Status> getAll();
    public Status getById(String id);
    public List<Status> getByName(String name);
    public String insertUpdate (String id, String name);
    public String delete(String id);
}
