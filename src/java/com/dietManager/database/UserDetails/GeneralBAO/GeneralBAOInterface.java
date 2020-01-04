
package com.dietManager.database.UserDetails.GeneralBAO;

import com.dietManager.model.UserDetails.General;
import java.util.List;

public interface GeneralBAOInterface {
 public int generalSave(General g) throws Exception;
    public boolean generalUpdate(General g,String u_name) throws Exception;
    public boolean generalDelete(General g) throws Exception;
    public General generalFindByPK(double id) throws Exception;
    public General generalFindByName(String name) throws Exception;
    public List<General> generalFindAll() throws Exception;
    public General generalFindByNameAndPassword(String u_name,String password) throws Exception;

    
}
