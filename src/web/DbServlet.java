package web;

import db.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.impl.PatientServiceImpl;

@WebServlet("/db")
public class DbServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        Connection connection = ConnectionManager.getConnection();
        StringBuilder sb = new StringBuilder();

        String query = "SELECT * FROM db_test";
        PatientServiceImpl psi = new PatientServiceImpl();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                sb.append(rs.getInt(1)).append(" ")
                        .append(rs.getString(2)).append(" ")
                        .append(rs.getString(3)).append(" ")
                        .append(rs.getString(4)).append("<br>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        printWriter.write(psi.get(60).toString());
        printWriter.write(sb.toString());
    }
}
