package dao.impl;

import dao.AppointmentDAO;
import dao.DaoUtils;
import db.ConnectionManager;
import entities.cards.Appointment;
import java.io.Serializable;
import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import services.PatientService;
import services.impl.PatientServiceImpl;

public class AppointmentDAOImpl implements AppointmentDAO {
    private static volatile AppointmentDAO INSTANCE = null;
    private static final String saveAppQuery = "INSERT INTO appointments (patient_id, text) VALUES (?, ?)";

    private static final String updateAppQuery = "UPDATE appointments SET patient_id=?, text=? WHERE id=?";

    private static final String getAppQuery = "SELECT * FROM appointments WHERE id=?";

    private static final String deleteAppQuery = "DELETE FROM appointments WHERE id=?";

    private static final String getAppByPatientIdQuery = "SELECT * FROM appointments WHERE patient_id=?";

    private PreparedStatement psAppSave;

    private PreparedStatement psAppUpdate;

    private PreparedStatement psAppGet;

    private PreparedStatement psAppDelete;

    private PreparedStatement psAppGetByPatientId;

    private PatientService psi = PatientServiceImpl.getInstance();

    {
        try {
            Connection connection = ConnectionManager.getConnection();
            psAppSave = connection.prepareStatement(saveAppQuery, Statement.RETURN_GENERATED_KEYS);

            psAppUpdate = connection.prepareStatement(updateAppQuery);

            psAppGet = connection.prepareStatement(getAppQuery);

            psAppDelete = connection.prepareStatement(deleteAppQuery);

            psAppGetByPatientId = connection.prepareStatement(getAppByPatientIdQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AppointmentDAOImpl() {
    }

    public static AppointmentDAO getInstance() {
        AppointmentDAO appointmentDAO = INSTANCE;
        if (appointmentDAO == null) {
            synchronized (AppointmentDAOImpl.class) {
                appointmentDAO = INSTANCE;
                if (appointmentDAO == null) {
                    INSTANCE = appointmentDAO = new AppointmentDAOImpl();
                }
            }
        }

        return appointmentDAO;
    }

    @Override
    public Appointment save(Appointment appointment) throws SQLException {
        psAppSave.setInt(1, appointment.getPatient().getId());
        psAppSave.setString(2, appointment.getText());
        psAppSave.executeUpdate();
        ResultSet rs = psAppSave.getGeneratedKeys();
        if (rs.next()){
            appointment.setId(rs.getInt(1));
        }
        DaoUtils.close(rs);
        return appointment;
    }

    @Override
    public Appointment get(Serializable id) throws SQLException {
        Appointment appointment = new Appointment();
        psAppGet.setInt(1, (int) id);
        psAppGet.executeQuery();
        ResultSet rs = psAppGet.getResultSet();
        if (rs.next()){
            appointment.setId(rs.getInt(1));
            appointment.setPatient(psi.get(rs.getInt(2)));
            appointment.setText(rs.getString(3));
        }
        DaoUtils.close(rs);
        return appointment;
    }

    @Override
    public void update(Appointment appointment) throws SQLException {
        psAppUpdate.setInt(3, appointment.getId());
        psAppUpdate.setInt(1, appointment.getPatient().getId());
        psAppUpdate.setString(2, appointment.getText());
        psAppUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psAppDelete.setInt(1, (int) id);
        return psAppDelete.executeUpdate();
    }

    @Override
    public List<Appointment> getAllByPatientId(Serializable patientId) throws SQLException {
        List<Appointment> appointments = new CopyOnWriteArrayList<>();
        psAppGetByPatientId.setInt(1, (int) patientId);
        psAppGetByPatientId.executeQuery();
        ResultSet rs = psAppGetByPatientId.getResultSet();
        while (rs.next()){
            Appointment appointment = new Appointment();
            appointment.setId(rs.getInt(1));
            appointment.setPatient(psi.get(rs.getInt(2)));
            appointment.setText(rs.getString(3));
            appointments.add(appointment);
        }
        DaoUtils.close(rs);
        return appointments;
    }
}
