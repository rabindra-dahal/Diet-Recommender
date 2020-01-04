package com.dietManager.database.Nutrition.CategoriesBAO;

import com.dietManager.model.Nutrition.Categories;
import java.util.List;

public interface CategoriesBAOInterface {
    public int categoriesSave(Categories c) throws Exception;
    public boolean categoriesUpdate(Categories c,String c_name) throws Exception;
    public boolean categoriesDelete(Categories c) throws Exception;
    public Categories categoriesFindByPK(double id) throws Exception;
    public Categories categoriesFindByCategoriesName(String c_name) throws Exception;
    public List<Categories> categoriesFindAll() throws Exception;

}
