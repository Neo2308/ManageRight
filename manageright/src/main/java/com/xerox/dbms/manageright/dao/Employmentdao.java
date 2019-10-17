package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xerox.dbms.manageright.entity.Employment;
@Transactional
@Repository
public class Employmentdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Employment p)
    {    
        String sql="INSERT INTO Employment(WorkerType,JobTitle,HireDate,EndDate,StartDate,Employee_ID) VALUES(?,?,?,?,?,?)";    
        return template.update(sql,p.getWorkerType(),p.getJobTitle(),p.getHireDate(),p.getEndDate(),p.getStartDate(),p.getEmployee_ID());
    }
    public int update(Employment p)
    {    
        String sql="UPDATE Employment SET WorkerType=?,JobTitle=?,HireDate=?,EndDate=?,StartDate=? WHERE Employment_ID=?";    
        return template.update(sql,p.getWorkerType(),p.getJobTitle(),p.getHireDate(),p.getEndDate(),p.getStartDate(),p.getEmployment_ID());
    }
    public int changedepartment(int id,String Department)
    {
        String sql="Update Employment Set Department=? Where Employment_ID=?";
        return template.update(sql,Department,id);
    }
    public boolean isEmployed(int id)
    {
        String sql="SELECT COUNT(*) FROM Employment WHERE Employee_ID=? AND (EndDate is NULL OR EndDate>?)";
        int b = template.queryForObject(sql, Integer.class,id,new Date());
        if(b==0)
            return false;
        else
            return true; 
    }
    public int terminate(int id)
    {
        String sql="UPDATE Employment SET EndDate=? WHERE Employee_ID=? AND (EndDate is NULL OR EndDate>?)";
        return template.update(sql,new Date(),id,new Date());
    }
    public boolean wasEmployed(int id)
    {
        String sql="SELECT COUNT(*) FROM Employment WHERE Employee_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public Employment getEmployment(int Employee_ID)
    {
        String sql="SELECT * FROM Employment WHERE Employee_ID=? AND (EndDate is NULL OR EndDate>?)";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employment>(Employment.class),Employee_ID,new Date());
    } 
    public List<Map<String, Object>> getEmployments(int Employee_ID)
    {
        String sql="SELECT * FROM Employment WHERE Employee_ID=?";
        return template.queryForList(sql,Employee_ID);
    } 
    public Employment getEmploymentByID(int Employment_ID)
    {
        String sql="SELECT * FROM Employment WHERE Employment_ID=? AND (EndDate is NULL OR EndDate>?)";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employment>(Employment.class),Employment_ID,new Date());
    } 
    
    public int unterminate(int id)
    {
        String sql="SELECT Employment_ID FROM Employment WHERE Employee_ID=? ORDER BY EndDate DESC";
        int b = template.queryForObject(sql, Integer.class,id);
        sql="UPDATE Employment SET EndDate=NULL WHERE Employment_ID=?";
        return template.update(sql,b);
    }
    // public Employment getEmployment(int id)
    // {
    //     String sql="SELECT * FROM Employee WHERE Employee_ID=?";
    //     int b = template.queryForObject(sql, Integer.class,id);
    //     if(b==0)
    //         return false;
    //     else
    //         return true;
    // }
    // public boolean EmployeeExists(String fname, String sname,String Nationality,java.util.Date DOB,String WorkEmail)
    // {
    //     String sql="SELECT COUNT(*) FROM Employee WHERE FirstName=? and LastName=? and Nationality=? and DOB=? and WorkEmail=?";
    //     int b = template.queryForObject(sql, Integer.class,fname,sname,Nationality,DOB,WorkEmail);
    //     if(b==0)
    //         return false;
    //     else
    //         return true;
    // }
    
}