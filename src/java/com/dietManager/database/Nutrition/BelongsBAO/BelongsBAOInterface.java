package com.dietManager.database.Nutrition.BelongsBAO;

import com.dietManager.model.Nutrition.Belongs;
import java.util.List;

public interface BelongsBAOInterface {
    public int belongsSave(Belongs b) throws Exception;
    public boolean belongsUpdate(Belongs b,double f_id) throws Exception;
    public boolean belongsDelete(Belongs b) throws Exception;
    public Belongs belongsfindByFoodId(double f_id) throws Exception;
    public List<Belongs> belongsFindByCategoriesId(double c_id) throws Exception;
    public List<Belongs> belongsFindAll() throws Exception;

}
