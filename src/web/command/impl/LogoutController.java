package web.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.command.Controller;

public class LogoutController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().invalidate();
        req.getServletContext().getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
