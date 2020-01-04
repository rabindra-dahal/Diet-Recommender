package com.dietManager.database.UserDetails.FoodHabbitDAO;

import com.dietManager.model.UserDetails.FoodHabbit;
import java.util.List;

public interface FoodHabbitDAOInterface {
     public int save(FoodHabbit f) throws Exception;
    public boolean update(FoodHabbit f,double u_id) throws Exception;
    public boolean delete(FoodHabbit f) throws Exception;
    public List<FoodHabbit> findByFoodId(double f_id) throws Exception;
    public List<FoodHabbit> findByMealType(String meal) throws Exception;
    public List<FoodHabbit> findByUserId(double u_id) throws Exception;
    public List<FoodHabbit> findAll() throws Exception;

}
