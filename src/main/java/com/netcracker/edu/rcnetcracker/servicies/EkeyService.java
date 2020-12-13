package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.RequestParams;
import org.springframework.data.domain.Page;

@org.springframework.stereotype.Service
public class EkeyService implements Service<Ekey> {

    @Override
    public Ekey getById(Long id) {
        return null;
    }

    @Override
    public void create(Ekey object) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer update(Ekey object) {
        return null;
    }

    @Override
    public Page<Ekey> getAll(RequestParams params) {
        return null;
    }
}
