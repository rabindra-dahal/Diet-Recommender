package com.dietManager.database.UserDetails.StateDAO;

import com.dietManager.model.UserDetails.State;
import java.util.List;

public interface StateDAOInterface {
 public int save(State s) throws Exception;
    public boolean update(State s) throws Exception;
    public boolean delete(State s,String u_name) throws Exception;
    public State findByPK(double id) throws Exception;
    public List<State> findByHeight(double height) throws Exception;
    public List<State> findByWorkingHrs(double working_hrs) throws Exception;
    public List<State> findByAge(double age) throws Exception;
    public List<State> findByFoodHabbit(String food_habbit) throws Exception;
    public List<State> findAll() throws Exception;
    


}
