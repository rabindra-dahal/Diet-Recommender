package com.dietManager.database.Nutrition.CategoriesBAO;

import com.dietManager.database.Nutrition.CategoriesDAO.CategoriesDAOInterface;
import com.dietManager.database.Nutrition.CategoriesDAO.CategoriesDAOInterfaceImpl;
import com.dietManager.model.Nutrition.Categories;
import java.util.List;

public class CategoriesBAOInterfaceImpl implements CategoriesBAOInterface {
    CategoriesDAOInterface cdi=new CategoriesDAOInterfaceImpl();
    @Override
    public int categoriesSave(Categories c) throws Exception {
        return cdi.save(c);
    }

    @Override
    public boolean categoriesUpdate(Categories c, String c_name) throws Exception {
        return cdi.update(c, c_name);
    }

    @Override
    public boolean categoriesDelete(Categories c) throws Exception {
       return cdi.delete(c);
    }

    @Override
    public Categories categoriesFindByPK(double id) throws Exception {
        return cdi.findByPK(id);
    }

    @Override
    public Categories categoriesFindByCategoriesName(String c_name) throws Exception {
        return cdi.findByCategoriesName(c_name);
    }

    @Override
    public List<Categories> categoriesFindAll() throws Exception {
        return cdi.findAll();
    }
    

}
