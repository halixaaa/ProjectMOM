/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Followup;

/**
 *
 * @author Bella
 */
public interface IFollowupController {
    public List<Followup> getAll();
    public Followup getById(String id);
    public List<Followup> getByName(String name);
    public String insertUpdate (String id, String name, String pic, String targetdate, String notes, String mom);
    public String delete(String id);
}
