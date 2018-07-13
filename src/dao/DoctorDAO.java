package dao;

import entities.Doctor;
import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO extends DAO<Doctor>{
    List<Doctor> getAll() throws SQLException;
}
