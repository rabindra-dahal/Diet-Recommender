package com.dietManager.database.UserDetails.GeneralDAO;

import com.dietManager.model.UserDetails.General;
import java.util.List;

public interface GeneralDAOInterface {
    public int save(General g) throws Exception;
    public boolean update(General g,String u_name) throws Exception;
    public boolean delete(General g) throws Exception;
    public boolean verifyUserLoginData(String u_name,String password) throws Exception;
    public General findByPK(double id) throws Exception;
    public General findByName(String name) throws Exception;
    public General findByNameAndPassword(String u_name,String password) throws Exception;
    public List<General> findAll() throws Exception;
    
    
}
