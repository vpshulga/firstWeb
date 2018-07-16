package services.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entities.User;
import java.io.Serializable;
import java.sql.SQLException;
import services.UserService;

public class UserServiceImpl extends AbstractServiceImpl implements UserService {
    private UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    public User save(User user) {
        try {
            startTransaction();
            userDAO.save(user);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User get(Serializable id) {
        User user = new User();
        try {
            startTransaction();
            user = userDAO.get(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try {
            startTransaction();
            userDAO.update(user);
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
            countRows = userDAO.delete(id);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public User getByLogin(String login) {
        User user = new User();
        try {
            startTransaction();
            user = userDAO.getByLogin(login);
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
