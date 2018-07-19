package services.impl;

import dao.PatientDAO;
import dao.impl.PatientDAOImpl;
import entities.Patient;
import services.PatientService;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PatientServiceImpl extends AbstractServiceImpl implements PatientService {
    private PatientDAO patientDAO = PatientDAOImpl.getInstance();

    @Override
    public Patient save(Patient patient) {
        try {
            startTransaction();
            patient = patientDAO.save(patient);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient get(Serializable id) {
        Patient patient = new Patient();
        try {
            startTransaction();
            patient = patientDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public void update(Patient patient) {

        try {
            startTransaction();
            patientDAO.update(patient);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int delete(Serializable id) {
        int countDeletedRows = 0;
        try {
            startTransaction();
            countDeletedRows = patientDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countDeletedRows;
    }

    @Override
    public List<Patient> getAllByDoctorId(Serializable doctorId) {
        List<Patient> patients = new CopyOnWriteArrayList<>();
        try {
            startTransaction();
            patients = patientDAO.getAllByDoctorId(doctorId);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
