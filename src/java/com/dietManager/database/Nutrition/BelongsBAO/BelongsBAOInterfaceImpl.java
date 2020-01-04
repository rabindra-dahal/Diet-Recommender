package com.dietManager.database.Nutrition.BelongsBAO;

import com.dietManager.database.Nutrition.BelongsDAO.BelongsDAOInterface;
import com.dietManager.database.Nutrition.BelongsDAO.BelongsDAOInterfaceImpl;
import com.dietManager.model.Nutrition.Belongs;
import java.util.List;

public class BelongsBAOInterfaceImpl implements BelongsBAOInterface {

    BelongsDAOInterface bdi=new BelongsDAOInterfaceImpl();
    @Override
    public int belongsSave(Belongs b) throws Exception {
        return bdi.save(b);
    }

    @Override
    public boolean belongsUpdate(Belongs b, double f_id) throws Exception {
       return bdi.update(b, f_id);
    }

    @Override
    public boolean belongsDelete(Belongs b) throws Exception {
        return bdi.delete(b);
    }

    @Override
    public Belongs belongsfindByFoodId(double f_id) throws Exception {
       return bdi.findByFoodId(f_id);
    }

    @Override
    public List<Belongs> belongsFindByCategoriesId(double c_id) throws Exception {
        return bdi.findByCategoriesId(c_id);
    }

    @Override
    public List<Belongs> belongsFindAll() throws Exception {
        return bdi.findAll();
    }

}
