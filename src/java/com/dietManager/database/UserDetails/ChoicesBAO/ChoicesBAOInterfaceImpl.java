package com.dietManager.database.UserDetails.ChoicesBAO;

import com.dietManager.database.UserDetails.ChoicesDAO.ChoicesDAOInterface;
import com.dietManager.database.UserDetails.ChoicesDAO.ChoicesDAOInterfaceImpl;
import com.dietManager.model.UserDetails.Choices;
import java.util.List;

public class ChoicesBAOInterfaceImpl implements ChoicesBAOInterface{
    ChoicesDAOInterface cdi=new ChoicesDAOInterfaceImpl();
    
    @Override
    public int choicesSave(Choices c) throws Exception {
        return cdi.save(c);
    }

    @Override
    public boolean choicesUpdate(Choices c, double u_id) throws Exception {
       return cdi.update(c, u_id);
    }

    @Override
    public boolean choicesDelete(Choices c) throws Exception {
        return cdi.delete(c);
    }

    @Override
    public List<Choices> choicesFindByFoodId(double f_id) throws Exception {
        return cdi.findByFoodId(f_id);
    }

    @Override
    public List<Choices> choicesFindByUserId(double u_id) throws Exception {
        return cdi.findByUserId(u_id);
    }

    @Override
    public List<Choices> choicesFindAll() throws Exception {
        return cdi.findAll();
    }

}
