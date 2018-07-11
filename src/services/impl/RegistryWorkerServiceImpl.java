package services.impl;

import dao.RegistryWorkerDAO;
import dao.impl.RegistryWorkerDAOImpl;
import entities.RegistryWorker;
import java.io.Serializable;
import java.sql.SQLException;
import services.RegistryWorkerService;

public class RegistryWorkerServiceImpl extends AbstractServiceImpl implements RegistryWorkerService {
    private RegistryWorkerDAO registryWorkerDAO = RegistryWorkerDAOImpl.getInstance();

    @Override
    public RegistryWorker save(RegistryWorker registryWorker) {
        try {
            startTransaction();
            registryWorkerDAO.save(registryWorker);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registryWorker;
    }

    @Override
    public RegistryWorker get(Serializable id) {
        RegistryWorker registryWorker = new RegistryWorker();
        try {
            startTransaction();
            registryWorker = registryWorkerDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registryWorker;
    }

    @Override
    public void update(RegistryWorker registryWorker) {
        try {
            startTransaction();
            registryWorkerDAO.update(registryWorker);
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
            countRows = registryWorkerDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}
