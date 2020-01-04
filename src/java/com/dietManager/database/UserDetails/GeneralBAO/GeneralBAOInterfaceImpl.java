package com.dietManager.database.UserDetails.GeneralBAO;

import com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterface;
import com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl;
import com.dietManager.model.UserDetails.General;
import java.util.List;

public class GeneralBAOInterfaceImpl implements GeneralBAOInterface {
private final GeneralDAOInterface impl=new GeneralDAOInterfaceImpl();
    @Override
    public int generalSave(General g) throws Exception {
      return impl.save(g);
    }

    @Override
    public boolean generalUpdate(General g, String u_name) throws Exception {
        return impl.update(g,u_name);
    }

    @Override
    public boolean generalDelete(General g) throws Exception {
        return impl.delete(g);
    }

    @Override
    public General generalFindByPK(double id) throws Exception {
        return impl.findByPK(id);
    }

    @Override
    public General generalFindByName(String name) throws Exception {
    return impl.findByName(name);
    
    }

    @Override
    public List<General> generalFindAll() throws Exception {
        return impl.findAll();
    }

    @Override
    public General generalFindByNameAndPassword(String u_name, String password) throws Exception {
        return impl.findByNameAndPassword(u_name, password);
    }
}
