package web;

import entities.Doctor;
import entities.Patient;
import entities.cards.Complaint;
import enums.Educations;
import enums.Sex;
import enums.Specialties;
import java.io.IOException;
import java.io.PrintWriter;
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
        writer.write("посещиний:" + counter.incrementAndGet() + "<br/>");

        PatientServiceImpl psi = new PatientServiceImpl();
        DoctorServiceImpl dsi = new DoctorServiceImpl();
        Doctor doc = new Doctor("Valera", "Khadorkin", 50,
                Sex.MALE, Educations.HIGH, 10, Specialties.DENTIST);
//        dsi.save(doc);
//        writer.write(dsi.get(3).toString());

        Patient patient = psi.get(68);

        ComplaintServiceImpl csi = new ComplaintServiceImpl();
        csi.save(new Complaint(patient, patient.getComplaint()));
    }
}
