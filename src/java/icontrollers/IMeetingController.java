/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Meeting;

/**
 *
 * @author Bella
 */
public interface IMeetingController {
    public List<Meeting> getAll();
    public Meeting getById(String id);
    public List<Meeting> getByName(String name);
    public String insertUpdate (String id, String name, String project, String dates, String time, String chairedby, String type, String customer);
    public String delete(String id);
}
