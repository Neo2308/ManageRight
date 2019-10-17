package com.xerox.dbms.manageright.service;

import com.xerox.dbms.manageright.entity.User;
// import com.example.demo2.entity.Role;
// import com.begin.hello.model.User;
import com.xerox.dbms.manageright.dao.Userdao;
import java.util.List;

// import com.begin.hello.dao.AppUserdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xerox.dbms.manageright.dao.Roledao;
import com.xerox.dbms.manageright.entity.Role;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private Userdao appuser;

    @Autowired
    private Roledao roledao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = appuser.findByUsername(username);
        System.out.println("\n");
        System.out.println(user.getUsername());
        System.out.println("\n");
        if (user == null)
            throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roledao.allRoleofuser(user.getUserID())) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);
    }
}
