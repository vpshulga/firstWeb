package services.impl;

import dao.NurseDAO;
import dao.impl.NurseDAOImpl;
import entities.Nurse;
import java.io.Serializable;
import java.sql.SQLException;
import services.NurseService;

public class NurseSrviceImpl extends AbstractServiceImpl implements NurseService {
    private NurseDAO nurseDAO = NurseDAOImpl.getInstance();

    @Override
    public Nurse save(Nurse nurse) {
        try {
            startTransaction();
            nurseDAO.save(nurse);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nurse;
    }

    @Override
    public Nurse get(Serializable id) {
        Nurse nurse = new Nurse();
        try {
            startTransaction();
            nurse = nurseDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nurse;
    }

    @Override
    public void update(Nurse nurse) {
        try {
            startTransaction();
            nurseDAO.update(nurse);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int delete(Serializable id) {
        int countRows = 0;
        try {
            startTransaction();
            countRows = nurseDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}
