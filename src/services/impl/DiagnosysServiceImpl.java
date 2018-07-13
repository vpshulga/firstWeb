package services.impl;

import dao.DiagnosysDAO;
import dao.impl.DiagnosysDAOImpl;
import entities.cards.Diagnosys;
import java.io.Serializable;
import java.sql.SQLException;
import services.DiagnosysService;

public class DiagnosysServiceImpl extends AbstractServiceImpl implements DiagnosysService{
    private DiagnosysDAO diagnosysDAO = DiagnosysDAOImpl.getInstance();

    @Override
    public Diagnosys save(Diagnosys diagnosys) {
        try {
            startTransaction();
            diagnosysDAO.save(diagnosys);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosys;
    }

    @Override
    public Diagnosys get(Serializable id) {
        Diagnosys diagnosys = new Diagnosys();
        try {
            startTransaction();
            diagnosys = diagnosysDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosys;
    }

    @Override
    public void update(Diagnosys diagnosys) {
        try {
            startTransaction();
            diagnosysDAO.update(diagnosys);
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
            countRows = diagnosysDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}