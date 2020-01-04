package com.dietManager.database.Nutrition.ContainsBAO;

import com.dietManager.database.Nutrition.ContainsDAO.ContainsDAOInterface;
import com.dietManager.database.Nutrition.ContainsDAO.ContainsDAOInterfaceImpl;
import com.dietManager.model.Nutrition.Contains;
import java.util.List;

public class ContainsBAOInterfaceImpl implements ContainsBAOInterface{
    ContainsDAOInterface cdi=new ContainsDAOInterfaceImpl();
    @Override
    public int containsSave(Contains c) throws Exception {
        return cdi.save(c);
    }

    @Override
    public boolean containsUpdate(Contains c, double f_id) throws Exception {
        return cdi.update(c, f_id);
    }

    @Override
    public boolean containsDelete(Contains c) throws Exception {
        return cdi.delete(c);
    }

    @Override
    public List<Contains> containsFindByFoodId(double f_id) throws Exception {
        return cdi.findByFoodId(f_id);
    }

    @Override
    public List<Contains> containsFindAll() throws Exception {
        return cdi.findAll();
    }
    

}
