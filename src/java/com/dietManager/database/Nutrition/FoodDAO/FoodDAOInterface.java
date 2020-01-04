package com.dietManager.database.Nutrition.FoodDAO;

import com.dietManager.model.Nutrition.Food;
import java.util.List;

public interface FoodDAOInterface {
    public int save(Food f) throws Exception;
    public boolean update(Food f,String f_name) throws Exception;
    public boolean delete(Food f) throws Exception;
    public Food findByPK(double id) throws Exception;
    public Food findByFoodName(String f_name) throws Exception;
    public List<Food> findAll() throws Exception;
    
}
