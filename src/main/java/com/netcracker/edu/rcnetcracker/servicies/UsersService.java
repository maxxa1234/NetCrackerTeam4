package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.exceptions.ResourceNotFoundException;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class UsersService implements Service<User> {

    private final OracleDbAccess oracleDbAccess;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UsersService(OracleDbAccess oracleDbAccess, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.oracleDbAccess = oracleDbAccess;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User getById(Long id) {
        return oracleDbAccess.getById(User.class, id);
    }

    @Override
    public boolean create(User object) {
        object.setRole(roleService.getById(421L));
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        if (oracleDbAccess.insert(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (oracleDbAccess.delete(User.class, id) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean update(User object) {
        if (oracleDbAccess.update(object) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Page<User> getAll(Pageable pageable, List<SearchCriteria> filter, SortCriteria sort) {
        return oracleDbAccess.selectPage(User.class, pageable, filter, sort);
    }

    public User findUserByEmail(String email) {
        List<SearchCriteria> filter = new ArrayList<>();
        filter.add(new SearchCriteria("email", " = '" + email + "' "));

        return oracleDbAccess.selectPage(User.class, null, filter, null)
                .getContent()
                .get(0);
    }

    public User findByActivatedCode(String code) {
        List<SearchCriteria> filter = new ArrayList<>();
        filter.add(new SearchCriteria("activationCode", " = '" + code + "' "));

        if(oracleDbAccess.selectPage(User.class, null, filter, null).getContent().size() != 0){
            return oracleDbAccess.selectPage(User.class, null, filter, null).getContent().get(0);
        }else {
            return null;
        }
    }

    public boolean activateUser(String code) {
        User user = findByActivatedCode(code);

        if (user == null) {       //если кода пользователя нет в бд
            return false;
        }

        user.setActivationCode(null);    //пользователь подтвердил почтовый ящик
        update(user);

        return true;
    }

    public User findByLoginAndPass(String login, String password)  {
        User user = findUserByEmail(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        throw new ResourceNotFoundException();
    }
}
