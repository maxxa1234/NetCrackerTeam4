package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UtilitiesService implements EntityServiceForPaging<Utility> {

    //    @Autowired
//    private UtilitiesRepository dao;

    @Override
    public Page<Utility> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
