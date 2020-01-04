package com.dietManager.database.Nutrition.FoodBAO;

import com.dietManager.model.Nutrition.Food;
import java.util.List;

public interface FoodBAOInterface {
     public int foodSave(Food f) throws Exception;
    public boolean foodUpdate(Food f,String f_name) throws Exception;
    public boolean foodDelete(Food f) throws Exception;
    public Food foodFindByPK(double id) throws Exception;
    public Food foodFindByFoodName(String f_name) throws Exception;
    public List<Food> foodFindAll() throws Exception;
    
}
