package com.dietManager.database.UserDetails.GoalTableDAO;

import com.dietManager.model.UserDetails.GoalTable ;
import java.util.List;

public interface GoalTableDAOinterface {
    public int save(GoalTable gt) throws Exception;
    public boolean update(GoalTable gt) throws Exception;
    public boolean delete(GoalTable gt) throws Exception;
    public GoalTable  findByAge(double age) throws Exception;
    public GoalTable findByEnergyLimit(double energyLimit) throws Exception;
    public List<GoalTable> findAll() throws Exception;
       
}
