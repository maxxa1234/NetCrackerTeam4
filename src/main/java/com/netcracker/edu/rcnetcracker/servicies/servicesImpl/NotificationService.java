package com.netcracker.edu.rcnetcracker.servicies.servicesImpl;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.EntityServiceForPaging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements EntityServiceForPaging<Notification> {

    //    @Autowired
//    private NotificationRepository dao;

    @Override
    public Page<Notification> findPagination(int page, int size) {
        //        return dao.findAll(new PageRequest(page, size));
        return null;
    }
}
