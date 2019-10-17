package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xerox.dbms.manageright.entity.Employee;
@Transactional
@Repository
public class Employeedao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Employee p)
    {    
        String sql="INSERT INTO Employee(BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
        return template.update(sql,p.getBaseSalary(),p.getOrigin(),p.getFirstName(),p.getLastName(),p.getNationality(),p.getDOB(),p.getGender(),p.getMaritalStatus(),p.getHomeAddress(),p.getWorkEmail(),p.getWorkMobile(),p.getMailingAddress(),p.getEduLevel(),p.getTaxIdentification());
    }
    
    public int update(Employee p)
    {    
        String sql="UPDATE Employee SET BaseSalary=?,Origin=?,FirstName=?,LastName=?,Nationality=?,DOB=?,Gender=?,MaritalStatus=?,HomeAddress=?,WorkEmail=?,WorkMobile=?,MailingAddress=?,EduLevel=?,TaxIdentification=? WHERE Employee_ID=?";    
        return template.update(sql,p.getBaseSalary(),p.getOrigin(),p.getFirstName(),p.getLastName(),p.getNationality(),p.getDOB(),p.getGender(),p.getMaritalStatus(),p.getHomeAddress(),p.getWorkEmail(),p.getWorkMobile(),p.getMailingAddress(),p.getEduLevel(),p.getTaxIdentification(),p.getEmployee_ID());
    }
    
    // public int update(Employee p)
    // {    
    //     String sql="UPDATE Employee SET Name ='"+p.getName()+"',MaxDuration="+p.getMaxduration()+",MinDuration="+p.getMinduration()+"WHERE Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    // public int delete(int id)
    // {    
    //     String sql="DELETE FROM Employee WHERE Leave_ID="+id+";";    
    //     return template.update(sql);    
    // }
    public Employee getEmployeeById(int id)
    {
        String sql="SELECT BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification,CASE WHEN ManagedBy IS NULL THEN 0 ELSE ManagedBy END AS ManagedBy,CASE WHEN WorksFor IS NULL THEN 0 ELSE WorksFor END AS WorksFor,CASE WHEN Shift IS NULL THEN 0 ELSE Shift END AS Shift FROM Employee WHERE Employee_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),id);
    }
    // public Employee getEmployee(String name, int MinDuration,int MaxDuration)
    // {
    //     String sql="SELECT * FROM Employee WHERE Name=? and MinDuration=? and MaxDuration";
    //     return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),name,MinDuration,MaxDuration);
    // }
    public int setmanager(int eid,int mid)
    {
        String sql="UPDATE Employee SET ManagedBy=? WHERE Employee_ID=?";
        return template.update(sql, mid,eid);
    }
    public int setWorksFor(int eid,int oid)
    {
        String sql="UPDATE Employee SET WorksFor=? WHERE Employee_ID=?";
        return template.update(sql, oid,eid);
    }
    public int setShift(int eid,int sid)
    {
        String sql="UPDATE Employee SET Shift=? WHERE Employee_ID=?";
        return template.update(sql, sid,eid);
    }
    public boolean EmployeeExists(int id)
    {
        String sql="SELECT COUNT(*) FROM Employee WHERE Employee_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean EmployeeExists(String fname, String sname,String Nationality,String DOB,String WorkEmail)
    {
        String sql="SELECT COUNT(*) FROM Employee WHERE FirstName=? and LastName=? and Nationality=? and DOB=? and WorkEmail=?";
        int b = template.queryForObject(sql, Integer.class,fname,sname,Nationality,DOB,WorkEmail);
        if(b==0)
            return false;
        else
            return true;
    }
    public Employee getEmployee(int id)
    {
        String sql="SELECT Employee_ID,BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification,CASE WHEN ManagedBy IS NULL THEN 0 ELSE ManagedBy END AS ManagedBy,CASE WHEN WorksFor IS NULL THEN 0 ELSE WorksFor END AS WorksFor,CASE WHEN Shift IS NULL THEN 0 ELSE Shift END AS Shift FROM Employee WHERE Employee_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),id);
    }
    public Employee getEmployee(String fname, String sname,String Nationality,String DOB,String WorkEmail)
    {
        String sql="SELECT Employee_ID,BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification,CASE WHEN ManagedBy IS NULL THEN 0 ELSE ManagedBy END AS ManagedBy,CASE WHEN WorksFor IS NULL THEN 0 ELSE WorksFor END AS WorksFor,CASE WHEN Shift IS NULL THEN 0 ELSE Shift END AS Shift FROM Employee WHERE FirstName=? and LastName=? and Nationality=? and DOB=? and WorkEmail=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),fname,sname,Nationality,DOB,WorkEmail);
    }
    public List<Map<String, Object>> getEmployeesbyOffice(int officeid)
    {
        String sql = "SELECT Employee_ID,BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification,CASE WHEN ManagedBy IS NULL THEN 0 ELSE ManagedBy END AS ManagedBy,CASE WHEN WorksFor IS NULL THEN 0 ELSE WorksFor END AS WorksFor,CASE WHEN Shift IS NULL THEN 0 ELSE Shift END AS Shift FROM Employee WHERE WorksFor=?";
        return template.queryForList(sql, officeid);
    }   
    public List<Map<String, Object>> getEmployees()
    {
        String sql = "SELECT Employee_ID,BaseSalary,Origin,FirstName,LastName,Nationality,DOB,Gender,MaritalStatus,HomeAddress,WorkEmail,WorkMobile,MailingAddress,EduLevel,TaxIdentification,CASE WHEN ManagedBy IS NULL THEN 0 ELSE ManagedBy END AS ManagedBy,CASE WHEN WorksFor IS NULL THEN 0 ELSE WorksFor END AS WorksFor,CASE WHEN Shift IS NULL THEN 0 ELSE Shift END AS Shift FROM Employee";
        return template.queryForList(sql);
    }   
    
    // public List<Employee> getEmployee(String name)
    // {
    //     return template.query("SELECT * FROM Employee WHERE Name='"+name+"';",
    //         new RowMapper<Employee>(){
    //             public Employee mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 Employee x = new Employee();
    //                 x.setName(rs.getString(1));
    //                 x.setMaxduration(rs.getInt(2));
    //                 x.setMinduration(rs.getInt(3));
    //                 x.setLeave_id(rs.getInt(4));
    //                 return x;
    //             }
    //         });
    // }
}
