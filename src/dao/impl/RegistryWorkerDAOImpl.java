package dao.impl;

import dao.DaoUtils;
import dao.NurseDAO;
import dao.RegistryWorkerDAO;
import db.ConnectionManager;
import entities.Nurse;
import entities.RegistryWorker;
import enums.Educations;
import enums.Sex;
import java.io.Serializable;
import java.sql.*;

public class RegistryWorkerDAOImpl implements RegistryWorkerDAO {
    private static volatile RegistryWorkerDAO INSTANCE = null;
    private static final String saveRegQuery = "INSERT INTO nurses (first_name, last_name, age, sex, education, experience) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String updateRegQuery = "UPDATE nurses SET first_name=?, last_name=?, age=?, sex=?, education=?, experience=? WHERE id=?";

    private static final String getRegQuery = "SELECT * FROM nurses WHERE id=?";

    private static final String deleteRegQuery = "DELETE FROM nurses WHERE id=?";

    private PreparedStatement psRegSave;

    private PreparedStatement psRegUpdate;

    private PreparedStatement psRegGet;

    private PreparedStatement psRegDelete;

    {
        try {
            Connection connection = ConnectionManager.getConnection();
            psRegSave = ConnectionManager.getConnection().prepareStatement(saveRegQuery, Statement.RETURN_GENERATED_KEYS);

            psRegUpdate = connection.prepareStatement(updateRegQuery);

            psRegGet = connection.prepareStatement(getRegQuery);

            psRegDelete = connection.prepareStatement(deleteRegQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private RegistryWorkerDAOImpl() {
    }

    public static RegistryWorkerDAO getInstance() {
        RegistryWorkerDAO regDAO = INSTANCE;
        if (regDAO == null) {
            synchronized (RegistryWorkerDAOImpl.class) {
                regDAO = INSTANCE;
                if (regDAO == null) {
                    INSTANCE = regDAO = new RegistryWorkerDAOImpl();
                }
            }
        }

        return regDAO;
    }


    @Override
    public RegistryWorker save(RegistryWorker registryWorker) throws SQLException {
        psRegSave.setString(1, registryWorker.getFirstName());
        psRegSave.setString(2, registryWorker.getLastName());
        psRegSave.setInt(3, registryWorker.getAge());
        psRegSave.setString(4,registryWorker.getSex().toString());
        psRegSave.setString(5, registryWorker.getEducation().toString());
        psRegSave.setInt(6, registryWorker.getExperience());
        psRegSave.executeUpdate();
        ResultSet rs = psRegSave.getGeneratedKeys();
        if (rs.next()){
            registryWorker.setId(rs.getInt(1));
        }
        DaoUtils.close(rs);
        return registryWorker;
    }

    @Override
    public RegistryWorker get(Serializable id) throws SQLException {
        RegistryWorker registryWorker = new RegistryWorker();
        psRegGet.setInt(1, (int) id);
        psRegGet.executeQuery();
        ResultSet rs = psRegGet.getResultSet();
        if (rs.next()){
            registryWorker.setId(rs.getInt(1));
            registryWorker.setFirstName(rs.getString(2));
            registryWorker.setLastName(rs.getString(3));
            registryWorker.setAge(rs.getInt(4));
            registryWorker.setSex(Sex.valueOf(rs.getString(5)));
            registryWorker.setEducation(Educations.valueOf(rs.getString(6)));
            registryWorker.setExperience(rs.getInt(7));
        }
        DaoUtils.close(rs);
        return registryWorker;
    }

    @Override
    public void update(RegistryWorker registryWorker) throws SQLException {
        psRegUpdate.setInt(7, registryWorker.getId());
        psRegUpdate.setString(1,registryWorker.getFirstName());
        psRegUpdate.setString(2, registryWorker.getLastName());
        psRegUpdate.setInt(3, registryWorker.getAge());
        psRegUpdate.setString(4, registryWorker.getSex().toString());
        psRegUpdate.setString(5, registryWorker.getEducation().toString());
        psRegUpdate.setInt(6, registryWorker.getExperience());
        psRegUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psRegDelete.setInt(1, (int) id);
        return psRegDelete.executeUpdate();
    }
}
