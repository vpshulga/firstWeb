package web.command.impl;

import entities.Doctor;
import entities.Patient;
import entities.User;
import entities.cards.Appointment;
import entities.cards.Diagnosys;
import enums.AppointmentsType;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.DiagnosysService;
import services.DoctorService;
import services.PatientService;
import services.impl.AppointmentServiceImpl;
import services.impl.DiagnosysServiceImpl;
import services.impl.DoctorServiceImpl;
import services.impl.PatientServiceImpl;
import web.command.Controller;

public class DoctorController implements Controller{
    private AppointmentService appointmentService = AppointmentServiceImpl.getInstance();
    private PatientService patientService = PatientServiceImpl.getInstance();
    private DoctorService doctorService = DoctorServiceImpl.getInstance();
    private DiagnosysService diagnosysService = DiagnosysServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Doctor doc = null;
        List<Diagnosys> diagnoses = diagnosysService.getAll();
        if (req.getParameter("patientId") != null && req.getParameter("appointment") != null){
            appointmentService.save(new Appointment(patientService.get(Integer.parseInt(req.getParameter("patientId"))),
                     AppointmentsType.valueOf(req.getParameter("appointmentType")),
                     req.getParameter("appointment")));
        }


        if (req.getParameter("patientId") != null && req.getParameter("diagnosys") != null){
            Diagnosys diagnosys = diagnosysService.getByPatientId(Integer.parseInt(req.getParameter("patientId")));

            int count = 0;
            if (diagnoses.size() > 0){
                for (Diagnosys d : diagnoses) {
                    if (d.equals(diagnosys)) {
                        count ++;
                    }
                }
            }
            if (count == 0) {
                diagnosysService.save(new Diagnosys(patientService.get(Integer.parseInt(req.getParameter("patientId")))
                        , req.getParameter("diagnosys")));
            } else {

                diagnosys.setText(req.getParameter("diagnosys"));
                diagnosysService.update(diagnosys);
            }
        }

        List<Patient> patients = new CopyOnWriteArrayList<>();
        User user = (User) req.getSession().getAttribute("user");
        if (user != null){
            doc = doctorService.getDoctorByUID(user.getId());
        }
        if (doc != null){
            patients = patientService.getAllByDoctorId(doc.getId());
        }
        req.setAttribute("patients", patients);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }
}
