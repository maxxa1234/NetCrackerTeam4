package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserService implements EntityServiceForPaging<User> {

    //    @Autowired
//    private UserRepository dao;

    @Override
    public Page<User> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
