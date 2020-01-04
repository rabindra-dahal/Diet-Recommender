package com.dietManager.database.UserDetails.GoalTableBAO;

import com.dietManager.model.UserDetails.GoalTable ;
import java.util.List;

public interface GoalTableBAOinterface {
    public int goalTableSave(GoalTable gt) throws Exception;
    public boolean goalTableUpdate(GoalTable gt) throws Exception;
    public boolean goalTableDelete(GoalTable gt) throws Exception;
    public GoalTable  goalTableFindByAge(double age) throws Exception;
    public GoalTable goalTableFindByEnergyLimit(double energyLimit) throws Exception;
    public List<GoalTable> goalTableFindAll() throws Exception;
       
}
