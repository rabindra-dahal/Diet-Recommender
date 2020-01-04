package com.dietManager.database.UserDetails.FoodHabbitBAO;

import com.dietManager.database.UserDetails.FoodHabbitDAO.FoodHabbitDAOInterface;
import com.dietManager.database.UserDetails.FoodHabbitDAO.FoodHabbitDAOInterfaceImpl;
import com.dietManager.model.UserDetails.FoodHabbit;
import java.util.List;

public class FoodHabbitBAOInterfaceImpl  implements FoodHabbitBAOInterface{

    private final FoodHabbitDAOInterface fhdi=new FoodHabbitDAOInterfaceImpl();
    @Override
    public int foodHabbitSave(FoodHabbit f) throws Exception {
       return fhdi.save(f);
    }

    @Override
    public boolean foodHabbitUpdate(FoodHabbit f, double u_id) throws Exception {
        return fhdi.update(f, u_id);
    }

    @Override
    public boolean foodHabbitDelete(FoodHabbit f) throws Exception {
        return fhdi.delete(f);
    }

    @Override
    public List<FoodHabbit> foodHabbitFindByFoodId(double f_id) throws Exception {
       return fhdi.findByFoodId(f_id);
    }

    @Override
    public List<FoodHabbit> foodHabbitFindByMealType(String meal) throws Exception {
    return fhdi.findByMealType(meal);
    }

    @Override
    public List<FoodHabbit> foodHabbitFindByUserId(double u_id) throws Exception {
       return fhdi.findByUserId(u_id);
    }

    @Override
    public List<FoodHabbit> foodHabbitFindAll() throws Exception {
        return fhdi.findAll();
    }
    

}
