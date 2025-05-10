package com.kosmos.challenge.serviceImpl;

import com.kosmos.challenge.model.Appointment;
import com.kosmos.challenge.repository.AppointmentRepository;
import com.kosmos.challenge.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    @Override
    public void saveAppointment(Appointment appointment){
        this.appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id){
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        Appointment appointment = null;

        if(optionalAppointment.isPresent()){
            appointment = optionalAppointment.get();
        } else {
            throw new RuntimeException("Appointment not found by id" + id);
        }

        return appointment;
    }

    @Override
    public void deleteAppointmentById(Long id){
        this.appointmentRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

        return this.appointmentRepository.findAll(pageable);
    }
}
