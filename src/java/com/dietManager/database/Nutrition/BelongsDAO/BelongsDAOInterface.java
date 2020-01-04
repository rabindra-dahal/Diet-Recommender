package com.dietManager.database.Nutrition.BelongsDAO;

import com.dietManager.model.Nutrition.Belongs;
import java.util.List;

public interface BelongsDAOInterface {
public int save(Belongs b) throws Exception;
    public boolean update(Belongs b,double f_id) throws Exception;
    public boolean delete(Belongs b) throws Exception;
    public Belongs findByFoodId(double f_id) throws Exception;
    public List<Belongs> findByCategoriesId(double c_id) throws Exception;
    public List<Belongs> findAll() throws Exception;
}
