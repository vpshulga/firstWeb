package dao.impl;

import dao.DaoUtils;
import dao.UserDAO;
import db.ConnectionManager;
import entities.User;
import enums.Roles;
import java.io.Serializable;
import java.sql.*;

public class UserDAOImpl implements UserDAO{
    private static volatile UserDAO INSTANCE = null;
    private static final String saveUserQuery = "INSERT INTO users (login, password) VALUES (?, ?)";

    private static final String updateUserQuery = "UPDATE users SET login=?, password=? WHERE id=?";

    private static final String getUserQuery = "SELECT * FROM users WHERE id=?";

    private static final String deleteUserQuery = "DELETE FROM users WHERE id=?";

    private static final String getByLoginQuery = "SELECT * FROM users WHERE LOGIN=?";


    private PreparedStatement psUserSave;

    private PreparedStatement psUserUpdate;

    private PreparedStatement psUserGet;

    private PreparedStatement psUserDelete;

    private PreparedStatement psGetByLogin;

    {
        try {
            Connection connection = ConnectionManager.getConnection();
            psUserSave = ConnectionManager.getConnection().prepareStatement(saveUserQuery, Statement.RETURN_GENERATED_KEYS);

            psUserUpdate = connection.prepareStatement(updateUserQuery);

            psUserGet = connection.prepareStatement(getUserQuery);

            psUserDelete = connection.prepareStatement(deleteUserQuery);

            psGetByLogin = connection.prepareStatement(getByLoginQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private UserDAOImpl() {
    }

    public static UserDAO getInstance() {
        UserDAO userDAO = INSTANCE;
        if (userDAO == null) {
            synchronized (UserDAOImpl.class) {
                userDAO = INSTANCE;
                if (userDAO == null) {
                    INSTANCE = userDAO = new UserDAOImpl();
                }
            }
        }

        return userDAO;
    }

    @Override
    public User save(User user) throws SQLException {


        psUserSave.setString(1, user.getLogin());
        psUserSave.setString(2, user.getPassword());
        psUserSave.executeUpdate();
        ResultSet rs = psUserSave.getGeneratedKeys();
        if (rs.next()){
            user.setId(rs.getInt(1));
        }
        DaoUtils.close(rs);
        return user;
    }

    @Override
    public User get(Serializable id) throws SQLException {
        User user = new User();
        psUserGet.setInt(1, (int) id);
        psUserGet.executeQuery();
        ResultSet rs = psUserGet.getResultSet();
        if (rs.next()){
            user.setId(rs.getInt(1));
            user.setLogin(rs.getString(2));
            user.setPassword(rs.getString(2));
        }
        DaoUtils.close(rs);
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        psUserUpdate.setInt(3, user.getId());
        psUserUpdate.setString(1, user.getLogin());
        psUserUpdate.setString(2, user.getPassword());
        psUserUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psUserDelete.setInt(1, (int) id);
        return psUserDelete.executeUpdate();
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        User user = new User();
        psGetByLogin.setString(1, login);
        ResultSet rs = psGetByLogin.executeQuery();
        if (rs.next()){
            user.setId(rs.getInt(1));
            user.setLogin(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRole(Roles.valueOf(rs.getString(4)));
        }
        return user;
    }
}
