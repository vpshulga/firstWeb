package web.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    String MAIN_PAGE ="/WEB-INF/view/layouts/default.jspx";

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
