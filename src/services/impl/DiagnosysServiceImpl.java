package services.impl;

import dao.DiagnosysDao;
import dao.impl.DiagnosysDAOImpl;
import entities.cards.Diagnosys;
import java.io.Serializable;
import java.sql.SQLException;
import services.DiagnosysService;

public class DiagnosysServiceImpl extends AbstractServiceImpl implements DiagnosysService{
    private DiagnosysDao diagnosysDao = DiagnosysDAOImpl.getInstance();

    @Override
    public Diagnosys save(Diagnosys diagnosys) {
        try {
            startTransaction();
            diagnosysDao.save(diagnosys);
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
            diagnosys = diagnosysDao.get(id);
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
            diagnosysDao.update(diagnosys);
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
            countRows = diagnosysDao.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}
