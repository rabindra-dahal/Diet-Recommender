package com.dietManager.database.Nutrition.ContainsBAO;

import com.dietManager.model.Nutrition.Contains;
import java.util.List;

public interface ContainsBAOInterface {
    public int containsSave(Contains c) throws Exception;
    public boolean containsUpdate(Contains c,double f_id) throws Exception;
    public boolean containsDelete(Contains c) throws Exception;
    public List<Contains> containsFindByFoodId(double f_id) throws Exception;
    public List<Contains> containsFindAll() throws Exception;

}
