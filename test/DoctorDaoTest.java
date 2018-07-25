import dao.DoctorDAO;
import dao.UserDAO;
import dao.impl.DoctorDAOImpl;
import dao.impl.UserDAOImpl;
import entities.Doctor;
import entities.User;
import enums.Educations;
import enums.Roles;
import enums.Sex;
import enums.Specialties;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DoctorDaoTest {
    private DoctorDAO doctorDAO = DoctorDAOImpl.getInstance();
    private UserDAO userDAO = UserDAOImpl.getInstance();

    @Test
    public void userTest() throws SQLException {
        User user = new User("doc1", "pass1", Roles.DOCTOR);
        userDAO.save(user);
        userDAO.update(user);
        List<Doctor> doctors = doctorDAO.getAll();
        int before = doctors.size();
        Doctor doc = new Doctor("d1", "d2", 22, Sex.MALE,
                Educations.HIGH, 13, Specialties.DENTIST, user.getId());
        doctorDAO.save(doc);
        List<Doctor> newDoctors = doctorDAO.getAll();
        int after = newDoctors.size();
        Doctor newDoc = newDoctors.get(newDoctors.size() - 1);
        Assert.assertEquals(newDoc.getFirstName(), doc.getFirstName());
        Assert.assertEquals(newDoc.getLastName(), doc.getLastName());
        Assert.assertSame(newDoc.getAge(), doc.getAge());
        Assert.assertEquals(newDoc.getSex(), doc.getSex());
        Assert.assertEquals(newDoc.getSpetialty(), doc.getSpetialty());
        Assert.assertSame(newDoc.getUserId(), doc.getUserId());
        Assert.assertNotSame(before, after);


    }
}
