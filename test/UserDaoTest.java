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
    public void userTest() throws SQLException {
        User user = new User("log1", "pass1", Roles.PATIENT);
        List<String> list = userDAO.getAllLogins();
        int before = list.size();
        userDAO.save(user);
        List<String> newList = userDAO.getAllLogins();
        int after = newList.size();
        Assert.assertEquals(user.getLogin(), newList.get(newList.size() - 1));
        Assert.assertNotSame(list, newList);

    }

}
