package web;

import db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class DbCounterServlet extends HttpServlet {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int counter  = 0;
        resp.setContentType("text/html");

        Connection connection = ConnectionManager.getConnection();

        String updateQuery = "UPDATE test SET counter=?";
        String getQuery = "SELECT counter FROM test";
        try {
            connection.setAutoCommit(false);
            PreparedStatement psIns = connection.prepareStatement(updateQuery);
            PreparedStatement psGet = connection.prepareStatement(getQuery);
            psIns.setInt(1, atomicInteger.incrementAndGet());
            psIns.executeUpdate();
            ResultSet rs = psGet.executeQuery();
            if (rs.next()){
                counter = rs.getInt(1);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("count=" + counter);

    }
}
