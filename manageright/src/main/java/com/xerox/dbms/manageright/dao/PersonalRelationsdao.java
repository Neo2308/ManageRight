package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xerox.dbms.manageright.entity.PersonalRelations;
@Transactional
@Repository
public class PersonalRelationsdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(PersonalRelations p)
    {    
        String sql="INSERT INTO PersonalRelations(Name,Mobile,Email,MailingAddress) VALUES(?,?,?,?)";
        return template.update(sql,p.getName(),p.getMobile(),p.getEmail(),p.getMailingAddress());   
    }
    public int update(PersonalRelations p)
    {    
        String sql="UPDATE PersonalRelations SET Name =?,Mobile=?,Email=?,MailingAddress=? WHERE PR_ID=?";
        return template.update(sql,p.getName(),p.getMobile(),p.getEmail(),p.getMailingAddress(),p.getPR_ID());    
    }
    public int delete(int id)
    {    
        String sql="DELETE FROM PersonalRelations WHERE PR_ID=?";    
        return template.update(sql,id);    
    }
    public PersonalRelations getPersonalRelationsById(int id)
    {
        String sql="SELECT * FROM PersonalRelations WHERE PR_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<PersonalRelations>(PersonalRelations.class),id);
    }
    public PersonalRelations getPersonalRelations(String Name, String Mobile,String Email, String MailingAddress)
    {
        String sql="SELECT * FROM PersonalRelations WHERE Name =? AND Mobile=? AND Email=? AND MailingAddress=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<PersonalRelations>(PersonalRelations.class),Name,Mobile,Email,MailingAddress);
    }
    public boolean PersonalRelationsExists(int id)
    {
        String sql="SELECT COUNT(*) FROM PersonalRelations WHERE PR_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean PersonalRelationsExists(String Name, String Mobile,String Email, String MailingAddress)
    {
        String sql="SELECT COUNT(*) FROM PersonalRelations WHERE Name =? AND Mobile=? AND Email=? AND MailingAddress=?";
        int b = template.queryForObject(sql, Integer.class,Name,Mobile,Email,MailingAddress);
        if(b==0)
            return false;
        else
            return true;
    }

    // public List<PersonalRelations> getPersonalRelationsByName(String name)
    // {
    //     return template.query("SELECT * FROM PersonalRelations WHERE Name='"+name+"';",
    //         new RowMapper<PersonalRelations>(){
    //             public PersonalRelations mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 PersonalRelations x = new PersonalRelations();
    //                 // x.setTimings(rs.getString(1));
    //                 x.setName(rs.getString(2));
    //                 // x.setShift_id(rs.getInt(3));
    //                 // x.setHoursperweek(rs.getInt(4));
    //                 return x;
    //             }
    //         });
    // }
}
