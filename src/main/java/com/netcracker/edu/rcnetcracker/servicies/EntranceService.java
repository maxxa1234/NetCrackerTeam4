package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@org.springframework.stereotype.Service
public class EntranceService implements Service<Entrance> {

    @Autowired
    private TestAccess testAccess;

    @Override
    public Entrance getById(Long id) {
        return null;
    }

    @Override
    public void create(Entrance object) {
        testAccess.insert(object);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer update(Entrance entrance) {
        return testAccess.update(entrance);
    }

    @Override
    public Page<Entrance> getAll(RequestBuilder params) {
        return null;
    }

}
