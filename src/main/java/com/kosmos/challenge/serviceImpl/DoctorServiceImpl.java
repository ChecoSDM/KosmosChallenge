package com.kosmos.challenge.serviceImpl;

import com.kosmos.challenge.model.Doctor;
import com.kosmos.challenge.repository.DoctorRepository;
import com.kosmos.challenge.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor){
        this.doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        Doctor doctor = null;

        if(optionalDoctor.isPresent()){
            doctor= optionalDoctor.get();
        } else {
            throw new RuntimeException("Doctor not found by id" + id);
        }

        return doctor;
    }

    @Override
    public void deleteDoctorById(Long id){
        this.doctorRepository.deleteById(id);
    }

    @Override
    public Page<Doctor> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

        return this.doctorRepository.findAll(pageable);
    }

}
