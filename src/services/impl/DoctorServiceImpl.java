package services.impl;

import dao.DoctorDAO;
import dao.impl.DoctorDAOImpl;
import entities.Doctor;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import services.DoctorService;

public class DoctorServiceImpl extends AbstractServiceImpl implements DoctorService{

    private DoctorDAO doctorDAO = DoctorDAOImpl.getInstance();
    @Override
    public Doctor save(Doctor doctor) {
        try {
            startTransaction();
            doctorDAO.save(doctor);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public Doctor get(Serializable id) {
        Doctor doc = new Doctor();
        try {
            startTransaction();
            doc = doctorDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doc;
    }

    @Override
    public void update(Doctor doctor) {
        try {
            startTransaction();
            doctorDAO.update(doctor);
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
            countRows = doctorDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> list = new CopyOnWriteArrayList<>();
        try {
            startTransaction();
            list = doctorDAO.getAll();
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
