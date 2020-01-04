package com.dietManager.database.UserDetails.GoalTableBAO;

import com.dietManager.database.UserDetails.GoalTableDAO.GoalTableDAOImpl;
import com.dietManager.database.UserDetails.GoalTableDAO.GoalTableDAOinterface;
import com.dietManager.model.UserDetails.GoalTable;
import java.sql.Connection;
import java.util.List;

public class GoalTableBAOImpl implements GoalTableBAOinterface{
private Connection con;
GoalTableDAOinterface gtbo=new GoalTableDAOImpl();

    @Override
    public int goalTableSave(GoalTable gt) throws Exception {
        return gtbo.save(gt);
    }

    @Override
    public boolean goalTableUpdate(GoalTable gt) throws Exception {
    return gtbo.update(gt);   
    }

    @Override
    public boolean goalTableDelete(GoalTable gt) throws Exception {
    return gtbo.delete(gt);    
    }

    @Override
    public GoalTable goalTableFindByAge(double age) throws Exception {
        return gtbo.findByAge(age);
    }

    @Override
    public GoalTable goalTableFindByEnergyLimit(double energyLimit) throws Exception {
       return gtbo.findByEnergyLimit(energyLimit);
    }

    @Override
    public List<GoalTable> goalTableFindAll() throws Exception {
       return gtbo.findAll();
    }
    
    
}
