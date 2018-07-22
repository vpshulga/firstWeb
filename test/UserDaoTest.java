import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entities.User;
import enums.Roles;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class UserDaoTest {
    private UserDAO userDAO = UserDAOImpl.getInstance();

    @Test
    public void userTest() throws SQLException{
        User user = new User("log1", "pass1", Roles.PATIENT);
        List<String> list = userDAO.getAllLogins();
        System.out.println(userDAO.getAllLogins());
        if (!list.contains("log1")){
            userDAO.save(user);
        } else {
            System.out.println(123);
        }

    }

}
