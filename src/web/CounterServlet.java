package web;

import entities.Doctor;
import entities.Patient;
import entities.cards.Appointment;
import entities.cards.Complaint;
import enums.Educations;
import enums.Sex;
import enums.Specialties;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.PatientService;
import services.impl.AppointmentServiceImpl;
import services.impl.ComplaintServiceImpl;
import services.impl.DoctorServiceImpl;
import services.impl.PatientServiceImpl;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    private static AtomicInteger counter = new AtomicInteger(0);
    PatientService psi = PatientServiceImpl.getInstance();
    AppointmentService asi = AppointmentServiceImpl.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        LocalDateTime localDateTime = LocalDateTime.now();

        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());



        System.out.println(date);


    }
}
