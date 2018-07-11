package web;

import entities.Patient;
import enums.Sex;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.impl.PatientServiceImpl;

@WebServlet("/addpatient")
public class AddPatientServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientServiceImpl psi = new PatientServiceImpl();
        req.setCharacterEncoding("UTF-8");
        psi.save(new Patient(req.getParameter("firstName"), req.getParameter("lastName"),
                Integer.parseInt(req.getParameter("age")), Sex.valueOf(req.getParameter("sex")),
                req.getParameter("city"), req.getParameter("street"), Integer.parseInt(req.getParameter("house")),
                Integer.parseInt(req.getParameter("apartament")), req.getParameter("complaint"),
                Integer.parseInt(req.getParameter("doctorId")), true));
    }
}
