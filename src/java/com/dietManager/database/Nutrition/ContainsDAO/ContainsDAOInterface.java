package com.dietManager.database.Nutrition.ContainsDAO;

import com.dietManager.model.Nutrition.Contains;
import java.util.List;

public interface ContainsDAOInterface {
    public int save(Contains c) throws Exception;
    public boolean update(Contains c,double f_id) throws Exception;
    public boolean delete(Contains c) throws Exception;
    public List<Contains> findByFoodId(double f_id) throws Exception;
    public List<Contains> findAll() throws Exception;

}
