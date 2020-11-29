package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EntranceService implements EntityServiceForPaging<Entrance> {

    //    @Autowired
//    private EntranceRepository dao;

    @Override
    public Page<Entrance> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
