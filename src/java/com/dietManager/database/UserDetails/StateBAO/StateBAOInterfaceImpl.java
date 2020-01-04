package com.dietManager.database.UserDetails.StateBAO;

import com.dietManager.database.UserDetails.StateDAO.StateDAOInterface;
import com.dietManager.database.UserDetails.StateDAO.StateDAOInterfaceImpl;
import com.dietManager.model.UserDetails.State;
import java.sql.Connection;
import java.util.List;

public class StateBAOInterfaceImpl implements StateBAOInterface{
private Connection con;
private final StateDAOInterface impl=new StateDAOInterfaceImpl();

    @Override
    public int stateSave(State s) throws Exception {
        return impl.save(s);
    }

    @Override
    public boolean stateUpdate(State s) throws Exception {
    return impl.update(s);
    }

    @Override
    public boolean stateDelete(State s, String u_name) throws Exception {
        return impl.delete(s, u_name);
    }

    @Override
    public State stateFindByPK(double id) throws Exception {
    return impl.findByPK(id);
    }

    @Override
    public List<State> stateFindByHeight(double height) throws Exception {
        return impl.findByHeight(height);
    }

    @Override
    public List<State> stateFindByWorkingHrs(double working_hrs) throws Exception {
    return impl.findByWorkingHrs(working_hrs);
    }

    @Override
    public List<State> stateFindByAge(double age) throws Exception {
    return impl.findByAge(age);
    }

    @Override
    public List<State> stateFindByFoodHabbit(String food_habbit) throws Exception {
       
    return impl.findByFoodHabbit(food_habbit);
    }

    @Override
    public List<State> stateFindAll() throws Exception {
    return impl.findAll();
    }
   

  

}
