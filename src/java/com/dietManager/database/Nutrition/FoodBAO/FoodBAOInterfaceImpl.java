package com.dietManager.database.Nutrition.FoodBAO;

import com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterface;
import com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterfaceImpl;
import com.dietManager.model.Nutrition.Food;
import java.util.List;

public class FoodBAOInterfaceImpl implements FoodBAOInterface {
private final FoodDAOInterface impl=new FoodDAOInterfaceImpl();
    @Override
    public int foodSave(Food f) throws Exception {
        return impl.save(f);
    }

    /*
    @param f_name used for where clause in the sql query
    
    */
    @Override
    public boolean foodUpdate(Food f, String f_name) throws Exception {
        return impl.update(f, f_name);
    }

    @Override
    public boolean foodDelete(Food f) throws Exception {
      return impl.delete(f);
    }

    @Override
    public Food foodFindByPK(double id) throws Exception {
    return impl.findByPK(id);
    }

    @Override
    public Food foodFindByFoodName(String f_name) throws Exception {
      return impl.findByFoodName(f_name);
    }

    @Override
    public List<Food> foodFindAll() throws Exception {
        return impl.findAll();
    }
    
    
}
