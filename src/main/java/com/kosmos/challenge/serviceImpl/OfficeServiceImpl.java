package com.kosmos.challenge.serviceImpl;

import com.kosmos.challenge.model.Office;
import com.kosmos.challenge.repository.OfficeRepository;
import com.kosmos.challenge.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<Office> getAllOffices(){
        return officeRepository.findAll();
    }

    @Override
    public void saveOffice(Office doctor){
        this.officeRepository.save(doctor);
    }

    @Override
    public Office getOfficeById(Long id){
        Optional<Office> optionalOffice = officeRepository.findById(id);
        Office office = null;

        if(optionalOffice.isPresent()){
            office= optionalOffice.get();
        } else {
            throw new RuntimeException("Office not found by id" + id);
        }

        return office;
    }

    @Override
    public void deleteOfficeById(Long id){
        this.officeRepository.deleteById(id);
    }

    @Override
    public Page<Office> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

        return this.officeRepository.findAll(pageable);
    }
}
