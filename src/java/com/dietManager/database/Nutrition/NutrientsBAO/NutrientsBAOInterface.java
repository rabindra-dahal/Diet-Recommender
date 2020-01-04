package com.dietManager.database.Nutrition.NutrientsBAO;

import com.dietManager.model.Nutrition.Nutrients;
import java.util.List;

public interface NutrientsBAOInterface {
    public int nutrientsSave(Nutrients n) throws Exception;
    public boolean nutrientsUpdate(Nutrients n,String n_name) throws Exception;
    public boolean nutrientsDelete(Nutrients n) throws Exception;
    public Nutrients nutrientsFindByPK(double n_id) throws Exception;
    public Nutrients nutrientsFindByNutrientsName(String n_name) throws Exception;
    public List<Nutrients> nutrientsFindAll() throws Exception;

}
