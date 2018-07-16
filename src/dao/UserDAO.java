package dao;

import entities.User;
import java.sql.SQLException;

public interface UserDAO extends DAO<User> {
    User getByLogin(String login) throws SQLException;
}
