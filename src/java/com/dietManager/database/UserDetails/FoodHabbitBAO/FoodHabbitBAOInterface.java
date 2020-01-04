package com.dietManager.database.UserDetails.FoodHabbitBAO;

import com.dietManager.model.UserDetails.FoodHabbit;
import java.util.List;

public interface FoodHabbitBAOInterface {
 public int foodHabbitSave(FoodHabbit f) throws Exception;
    public boolean foodHabbitUpdate(FoodHabbit f,double u_id) throws Exception;
    public boolean foodHabbitDelete(FoodHabbit f) throws Exception;
    public List<FoodHabbit> foodHabbitFindByFoodId(double f_id) throws Exception;
    public List<FoodHabbit> foodHabbitFindByMealType(String meal) throws Exception;
    public List<FoodHabbit> foodHabbitFindByUserId(double u_id) throws Exception;
    public List<FoodHabbit> foodHabbitFindAll() throws Exception;
}
