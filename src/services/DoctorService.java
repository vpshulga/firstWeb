package services;

import entities.Doctor;
import java.io.Serializable;

public interface DoctorService {
    Doctor save(Doctor doctor);

    Doctor get(Serializable id);

    void update(Doctor doctor);

    int delete(Serializable id);
}
