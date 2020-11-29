package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GateService implements EntityServiceForPaging<Gate> {

    //    @Autowired
//    private GateRepository dao;

    @Override
    public Page<Gate> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
