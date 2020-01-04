package com.dietManager.database.UserDetails.StateBAO;

import com.dietManager.model.UserDetails.State;
import java.util.List;

public interface StateBAOInterface {
 public int stateSave(State s) throws Exception;
    public boolean stateUpdate(State s) throws Exception;
    public boolean stateDelete(State s,String u_name) throws Exception;
    public State stateFindByPK(double id) throws Exception;
    public List<State> stateFindByHeight(double height) throws Exception;
    public List<State> stateFindByWorkingHrs(double working_hrs) throws Exception;
    public List<State> stateFindByAge(double age) throws Exception;
    public List<State> stateFindByFoodHabbit(String food_habbit) throws Exception;
    public List<State> stateFindAll() throws Exception;
    


}
