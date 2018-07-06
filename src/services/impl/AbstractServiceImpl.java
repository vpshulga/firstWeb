package services.impl;

import db.ConnectorManager;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractServiceImpl {
    private Connection connection = ConnectorManager.getConnection();

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
