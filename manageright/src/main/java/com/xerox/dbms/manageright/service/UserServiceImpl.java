package com.xerox.dbms.manageright.service;

import com.xerox.dbms.manageright.entity.User;
// import com.begin.hello.model.User;
// import com.begin.hello.dao.Roledao;
import com.xerox.dbms.manageright.dao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// import java.util.HashSet;

@Service
public class UserServiceImpl {
    @Autowired
    private Userdao appuser;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        appuser.save(user.getUsername(), user.getPassword());
    }

    public void updatepassword(int Id, String newpassword) {
        newpassword = bCryptPasswordEncoder.encode(newpassword);
        appuser.updatepassword(Id, newpassword);
    }

    public User findByUsername(String username) {
        return appuser.findByUsername(username);
    }

    public boolean findCount(String username) {
        int p = appuser.findCount(username);
        if (p == 0) {
            return true;
        } else {
            return false;
        }
    }
}
