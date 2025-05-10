package com.kosmos.challenge.service;

import com.kosmos.challenge.model.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    void saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    void deleteAppointmentById(Long id);

    Page<Appointment> findPaginated(int pageNum, int pageSize,
                                    String sortField, String sortDirection);

}
