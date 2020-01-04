package com.dietManager.database.UserDetails.ChoicesDAO;

import com.dietManager.model.UserDetails.Choices;
import java.util.List;

public interface ChoicesDAOInterface {
    public int save(Choices c) throws Exception;
    public boolean update(Choices c,double u_id) throws Exception;
    public boolean delete(Choices c) throws Exception;
    public List<Choices> findByFoodId(double f_id) throws Exception;
    public List<Choices> findByUserId(double u_id) throws Exception;
    public List<Choices> findAll() throws Exception;


}
