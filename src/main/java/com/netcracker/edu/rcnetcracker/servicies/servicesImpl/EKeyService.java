package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EKeyService implements EntityServiceForPaging<Ekey> {

//    @Autowired
//    private EKeyRepository dao;

    @Override
    public Page<Ekey> findPagination(int page, int size) {
//        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
