package com.kosmos.challenge.service;

import com.kosmos.challenge.model.Office;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OfficeService {

    List<Office> getAllOffices();

    void saveOffice(Office appointment);

    Office getOfficeById(Long id);

    void deleteOfficeById(Long id);

    Page<Office> findPaginated(int pageNum, int pageSize,
                                    String sortField, String sortDirection);


}
