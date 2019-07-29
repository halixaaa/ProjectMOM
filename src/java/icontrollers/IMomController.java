/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Mom;

/**
 *
 * @author Bella
 */
public interface IMomController {
    public List<Mom> getAll();
    public Mom getById(String id);
    public String insertUpdate (String id, String meetingdesc, String meeting, String status);
    public String delete(String id);
}
