package com.dietManager.database.Nutrition.NutrientsBAO;

import com.dietManager.database.Nutrition.NutrientsDAO.NutrientsDAOInterface;
import com.dietManager.database.Nutrition.NutrientsDAO.NutrientsDAOInterfaceImpl;
import com.dietManager.model.Nutrition.Nutrients;
import java.util.List;

public class NutrientsBAOInterfaceImpl implements NutrientsBAOInterface{
    NutrientsDAOInterface ndi=new NutrientsDAOInterfaceImpl();
    
    @Override
    public int nutrientsSave(Nutrients n) throws Exception {
        return ndi.save(n);
    }

    @Override
    public boolean nutrientsUpdate(Nutrients n, String n_name) throws Exception {
        return ndi.update(n, n_name);
    }

    @Override
    public boolean nutrientsDelete(Nutrients n) throws Exception {
        return ndi.delete(n);
    }

    @Override
    public Nutrients nutrientsFindByPK(double n_id) throws Exception {
        return ndi.findByPK(n_id);
    }

    @Override
    public Nutrients nutrientsFindByNutrientsName(String n_name) throws Exception {
        return ndi.findByNutrientsName(n_name);
    }

    @Override
    public List<Nutrients> nutrientsFindAll() throws Exception {
    
        return ndi.findAll();
    }

}
