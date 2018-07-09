package web.lesson26;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class PostServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        writer.print("<form method=\"post\" action=\"post\">" +
                "Имя<input type=\"text\" name=\"firstName\">" +
                "Фамилия<input type=\"text\" name=\"lastName\">" +
                "Имя<input type=\"submit\" value=\"Отправить\"> </form><br>");
        if (firstName.equals("") || lastName.equals("")) {
            writer.print("Заполните оба поля!");
        } else {
            writer.print("Имя и Фамилия: " + firstName + " " + lastName);
        }
    }
}
