package web.command.impl;

import entities.Doctor;
import entities.Patient;
import entities.User;
import enums.Roles;
import enums.Sex;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DoctorService;
import services.PatientService;
import services.impl.DoctorServiceImpl;
import services.impl.PatientServiceImpl;
import web.command.Controller;

public class RegistrationController implements Controller {
    private PatientService psi = PatientServiceImpl.getInstance();
    private DoctorService dsi = DoctorServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && !user.getRole().equals(Roles.REG_WORKER)) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=check");
            return;
        }

        if (req.getParameter("firstName") != null && req.getParameter("lastName") != null){

            psi.save(new Patient(req.getParameter("firstName"), req.getParameter("lastName"),
                    Integer.parseInt(req.getParameter("age")), Sex.valueOf(req.getParameter("sex")),
                    req.getParameter("city"), req.getParameter("street"), Integer.parseInt(req.getParameter("house")),
                    Integer.parseInt(req.getParameter("apartament")), req.getParameter("complaint"),
                    Integer.parseInt(req.getParameter("doctorId")), true, 11));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
