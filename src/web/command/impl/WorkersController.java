package web.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.DoctorService;
import services.NurseService;
import services.RegistryWorkerService;
import services.impl.DoctorServiceImpl;
import services.impl.NurseSrviceImpl;
import services.impl.RegistryWorkerServiceImpl;
import web.command.Controller;

public class WorkersController implements Controller {
    private DoctorService doctorService = new DoctorServiceImpl();
    private NurseService nurseService = new NurseSrviceImpl();
    private RegistryWorkerService registryWorkerService = new RegistryWorkerServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().setAttribute("doctors", doctorService.getAll());
        req.getSession().setAttribute("nurses", nurseService.getAll());
        req.getSession().setAttribute("regWorkers", registryWorkerService.getAll());
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
