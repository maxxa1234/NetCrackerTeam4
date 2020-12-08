package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@org.springframework.stereotype.Service
public class UtilitiesService implements Service<Utility> {

    @Autowired
    private TestAccess testAccess;

    @Override
    public Utility getById(Long id) {
        return null;
    }

    @Override
    public void create(Utility object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer update(Utility object) {
        return null;
    }

    @Override
    public Page<Utility> getAll(RequestBuilder params) {
        testAccess.selectAll(Utility.class, params);
        return null;
    }
}
