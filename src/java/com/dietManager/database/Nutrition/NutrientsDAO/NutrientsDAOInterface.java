package com.dietManager.database.Nutrition.NutrientsDAO;

import com.dietManager.model.Nutrition.Nutrients;
import java.util.List;

public interface NutrientsDAOInterface {
     public int save(Nutrients n) throws Exception;
    public boolean update(Nutrients n,String n_name) throws Exception;
    public boolean delete(Nutrients n) throws Exception;
    public Nutrients findByPK(double n_id) throws Exception;
    public Nutrients findByNutrientsName(String n_name) throws Exception;
    public List<Nutrients> findAll() throws Exception;
   

}
