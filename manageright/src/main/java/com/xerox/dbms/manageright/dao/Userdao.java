package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xerox.dbms.manageright.entity.User;
@Transactional
@Repository
public class Userdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public void save(String Username, String Password) {
        String sql = "INSERT INTO User (Username, Password) VALUES (?,?)";
        template.update(sql, Username, Password);
    }

    public User findByUsername(String Username) {
        String sql = "SELECT * FROM User WHERE Username=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User stud = template.queryForObject(sql, rowMapper, Username);
        System.out.println("\n");
        System.out.println(stud.getUsername());
        System.out.println("\n");
        return stud;
    }

    public int findCount(String Username) {
        String sql = "SELECT COUNT(*) FROM User WHERE Username=?";
        int count = template.queryForObject(sql, Integer.class, Username);
        return count;
    }

    public void updatepassword(int UserID, String NewPassword) {
        String sql = "UPDATE User SET Password=? WHERE UserID=?";
        template.update(sql, NewPassword, UserID);
    }
}
