package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.servicies.EntityService;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntityServiceImpl<T> implements EntityService<T> {

//    @Autowired
//    private EntityRepository<T> dao;

    @Override
    public List<T> findPagination(int size) {
//        return dao.findAll(size);
        return null;
    }

    @Override
    public List<T> getFiltrated(EntitySpecification<T> specification) {
//        return dao.findAll(Specification.where(specification));
        return null;
    }
}
