package services.impl;

import dao.AppointmentDAO;
import dao.impl.AppointmentDAOImpl;
import entities.cards.Appointment;
import java.io.Serializable;
import java.sql.SQLException;
import services.AppointmentService;

public class AppointmentServiceImpl extends AbstractServiceImpl implements AppointmentService{
    private AppointmentDAO appointmentDAO = AppointmentDAOImpl.getInstance();

    @Override
    public Appointment save(Appointment appointment) {
        try {
            startTransaction();
            appointmentDAO.save(appointment);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public Appointment get(Serializable id) {
        Appointment appointment = new Appointment();
        try {
            startTransaction();
            appointment = appointmentDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public void update(Appointment appointment) {
        try {
            startTransaction();
            appointmentDAO.update(appointment);
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
            countRows = appointmentDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }
}
