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

import com.xerox.dbms.manageright.entity.Eligibility;
@Repository
@Transactional
public class Eligibilitydao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Eligibility p)
    {    
        String sql="INSERT INTO Eligibility(Name,Type,Constraints) VALUES(?,?,?)";    
        return template.update(sql,p.getName(),p.getType(),p.getConstraints());    
    }
    public int update(Eligibility p)
    {    
        String sql="UPDATE Eligibility SET Name =?,Type=?,Constraints=? WHERE Eligibility_ID=?";    
        return template.update(sql,p.getName(),p.getType(),p.getConstraints(),p.getEligibility_ID());    
    }
    // public int delete(int Holiday_ID)
    // {    
    //     String sql="DELETE FROM Eligibility WHERE Holiday_ID="+Holiday_ID+";";    
    //     return template.update(sql);    
    // }
    public Eligibility getEligibilityById(int id)
    {
        String sql="SELECT * FROM Eligibility WHERE Eligibility_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Eligibility>(Eligibility.class),id);
    }
    public Eligibility getEligibility(String Name, String Type, String Constraints)
    {
        String sql="SELECT * FROM Eligibility WHERE Name =? AND Type=? AND Constraints=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Eligibility>(Eligibility.class),Name,Type,Constraints);
    }
    public boolean EligibilityExists(int id)
    {
        String sql="SELECT COUNT(*) FROM Eligibility WHERE Eligibility_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean EligibilityExists(String Name, String Type, String Constraints)
    {
        String sql="SELECT COUNT(*) FROM Eligibility WHERE Name =? AND Type=? AND Constraints=?";
        int b = template.queryForObject(sql, Integer.class,Name,Type,Constraints);
        if(b==0)
            return false;
        else
            return true;
    }
    // public List<Eligibility> getEligibilitybyName(String Name)
    // {
    //     return template.query("SELECT * FROM Eligibility WHERE Name='"+Name+"';",
    //         new RowMapper<Eligibility>(){
    //             public Eligibility mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 Eligibility x = new Eligibility();
    //                 x.setHoliday_id(rs.getInt(1));
    //                 x.setName(rs.getString(2));
    //                 x.setEnddate(rs.getDate(3));
    //                 x.setStartdate(rs.getDate(4));
    //                 return x;
    //             }
    //         });
    // }
}
