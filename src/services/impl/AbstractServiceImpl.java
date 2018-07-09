package services.impl;

import db.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractServiceImpl {
    private Connection connection = ConnectionManager.getConnection();

    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() {
        try {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
