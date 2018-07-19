package web;

import entities.Doctor;
import entities.Patient;
import entities.cards.Complaint;
import enums.Educations;
import enums.Sex;
import enums.Specialties;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.impl.ComplaintServiceImpl;
import services.impl.DoctorServiceImpl;
import services.impl.PatientServiceImpl;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        PatientServiceImpl psi = new PatientServiceImpl();
        List<Patient> list = psi.getAllByDoctorId(3);
        for (Patient patient : list) {
            System.out.println(patient.getId());
        }

    }
}
