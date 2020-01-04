package com.dietManager.database.UserDetails.ChoicesBAO;

import com.dietManager.model.UserDetails.Choices;
import java.util.List;

public interface ChoicesBAOInterface {
     public int choicesSave(Choices c) throws Exception;
    public boolean choicesUpdate(Choices c,double u_id) throws Exception;
    public boolean choicesDelete(Choices c) throws Exception;
    public List<Choices> choicesFindByFoodId(double f_id) throws Exception;
    public List<Choices> choicesFindByUserId(double u_id) throws Exception;
    public List<Choices> choicesFindAll() throws Exception;

}
