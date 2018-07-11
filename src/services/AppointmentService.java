package services;

import entities.cards.Appointment;
import java.io.Serializable;

public interface AppointmentService {
    Appointment save(Appointment appointment);

    Appointment get(Serializable id);

    void update(Appointment appointment);

    int delete(Serializable id);
}
