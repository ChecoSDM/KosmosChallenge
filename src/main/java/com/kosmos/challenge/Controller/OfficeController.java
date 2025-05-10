package com.kosmos.challenge.Controller;

import ch.qos.logback.core.model.Model;
import com.kosmos.challenge.service.AppointmentService;
import com.kosmos.challenge.service.DoctorService;
import com.kosmos.challenge.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficeController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/home")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/doctors")
    public String viewDoctorsPage(){
        return "doctors";
    }

    @GetMapping("/offices")
    public String viewOfficesPage(){
        return "offices";
    }

    @GetMapping("/appointments")
    public String viewAppointmentsPage(){
        return "appointments";
    }



}
