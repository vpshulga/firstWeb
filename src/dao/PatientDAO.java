package dao;

import entities.Patient;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface PatientDAO extends DAO<Patient> {
    List<Patient> getAllById(Serializable doctorId) throws SQLException;
}
