package com.dietManager.database.Nutrition.CategoriesDAO;

import com.dietManager.model.Nutrition.Categories;
import java.util.List;

public interface CategoriesDAOInterface {
     public int save(Categories c) throws Exception;
    public boolean update(Categories c,String c_name) throws Exception;
    public boolean delete(Categories c) throws Exception;
    public Categories findByPK(double id) throws Exception;
    public Categories findByCategoriesName(String c_name) throws Exception;
    public List<Categories> findAll() throws Exception;
   
    
}
