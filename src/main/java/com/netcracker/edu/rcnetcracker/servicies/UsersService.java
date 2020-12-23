package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class UsersService implements Service<User> {
    @Autowired
    private OracleDbAccess oracleDbAccess;

    @Override
    public User getById(Long id) {
        return oracleDbAccess.getById(User.class, id);
    }

    @Override
    public void create(User object) {
        oracleDbAccess.insert(object);
    }

    @Override
    public void delete(Long id) {
        oracleDbAccess.delete(User.class, id);
    }

    @Override
    public Integer update(User entrance) {
        return oracleDbAccess.update(entrance);
    }

    @Override
    public Page<User> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(User.class, pageable, filter, sort);
    }

    public User findUserByEmail(String email) {

        return null;
    }

    public User findByActivatedCode(String code){
        List<SearchCriteria> filter = new ArrayList<>();
        filter.add(new SearchCriteria("activationCode", "like '"+code+"' "));
        User user = oracleDbAccess.selectPage(User.class, null, filter, null)
                .getContent()
                .get(0);
        System.out.println();
        return null;
    }

    public boolean activateUser(String code) {
        User user = findByActivatedCode(code);

        if(user == null){       //если кода пользователя нет в бд
            return false;
        }

        user.setActivationCode(null);    //пользователь подтвердил почтовый ящик
        //.save(user); cохранить юзера б бд

        return true;
    }
}
