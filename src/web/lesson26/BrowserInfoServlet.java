package web.lesson26;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class BrowserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getHeader("User-Agent");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        if (info.contains("Chrome") && !info.contains("Firefox")){
            printWriter.write("Приветствую пользователя Chrome!");
        } else if (info.contains("Firefox")){
            printWriter.write("Приветствую пользователя FireFox!");
        } else {
            printWriter.write("Используйте хорошие браузеры");
        }
    }
}
