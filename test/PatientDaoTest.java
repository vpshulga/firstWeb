import dao.PatientDAO;
import dao.impl.PatientDAOImpl;
import entities.Patient;
import enums.Sex;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientDaoTest {
    private PatientDAO patientDAO = PatientDAOImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String currentDateTime = sdf.format(date);
        Patient patient = new Patient("S", "S", 10, Sex.MALE, "N",
                "V", 9, 4, "AAA", 1, currentDateTime, 2);
        Patient newPatient = patientDAO.save(patient);
        Assert.assertSame(newPatient, patient);

        newPatient.setFirstName("Valera");
        patientDAO.update(newPatient);

        System.out.println(newPatient.getId());

        System.out.println(newPatient);
        Assert.assertEquals("Bad method update", "Valera", newPatient.getFirstName());


        int rows = patientDAO.delete(newPatient.getId());
        Assert.assertNotSame("Bad delete method", 0, rows);

        int before = patientDAO.getAllByDoctorId(1).size();
        newPatient.setFirstName("ggggggg");
        patientDAO.save(newPatient);
        int after = patientDAO.getAllByDoctorId(1).size();
        Assert.assertNotSame(before, after);


    }
}
