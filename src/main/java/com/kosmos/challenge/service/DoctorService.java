package com.kosmos.challenge.service;

import com.kosmos.challenge.model.Doctor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    void saveDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    void deleteDoctorById(Long id);

    Page<Doctor> findPaginated(int pageNum, int pageSize,
                                    String sortField, String sortDirection);


}
