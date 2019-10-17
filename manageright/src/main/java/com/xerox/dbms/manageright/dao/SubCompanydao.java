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

import com.xerox.dbms.manageright.entity.SubCompany;
@Transactional
@Repository
public class SubCompanydao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(SubCompany p)
    {    
        String sql="INSERT INTO SubCompany(CompanyName,HeadOffice) VALUES(?,?)";    
        return template.update(sql,p.getCompanyName(),p.getHeadOffice());
    }
    public int update(SubCompany p)
    {    
        String sql="UPDATE SubCompany SET CompanyName=? AND HeadOffice=? WHERE Company_ID=?";    
        return template.update(sql,p.getCompanyName(),p.getHeadOffice(),p.getCompany_ID());    
    }
    // public int delete(int id)
    // {    
    //     String sql="DELETE FROM Leaves WHERE Leave_ID="+id+";";    
    //     return template.update(sql);    
    // }
    public SubCompany getSubCompanyById(int id)
    {
        String sql="SELECT Company_ID,CompanyName, CASE WHEN HeadOffice IS NULL THEN 0 ELSE HeadOffice END AS HeadOffice FROM SubCompany WHERE Company_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<SubCompany>(SubCompany.class),id);
    }
    public SubCompany getSubCompany(String CompanyName, int HeadOffice)
    {
        String sql="SELECT * FROM SubCompany WHERE CompanyName=? AND HeadOffice=? ";
        return template.queryForObject(sql, new BeanPropertyRowMapper<SubCompany>(SubCompany.class),CompanyName,HeadOffice);
    }
    public SubCompany getSubCompany(String CompanyName)
    {
        String sql="SELECT Company_ID,CompanyName, CASE WHEN HeadOffice IS NULL THEN 0 ELSE HeadOffice END AS HeadOffice FROM SubCompany WHERE CompanyName=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<SubCompany>(SubCompany.class),CompanyName);
    }
    // public SubCompany getLeaves(String name, int MinDuration,int MaxDuration)
    // {
    //     String sql="SELECT * FROM Leaves WHERE Name=? and MinDuration=? and MaxDuration";
    //     return template.queryForObject(sql, new BeanPropertyRowMapper<Leaves>(Leaves.class),name,MinDuration,MaxDuration);
    // }
    public boolean SubCompanyExists(int id)
    {
        String sql="SELECT COUNT(*) FROM SubCompany WHERE SubCompany_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean SubCompanyExists(String CompanyName, int HeadOffice)
    {
        String sql="SELECT COUNT(*) FROM SubCompany WHERE CompanyName=? AND HeadOffice=?";
        int b = template.queryForObject(sql, Integer.class,CompanyName,HeadOffice);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean SubCompanyExists(String CompanyName)
    {
        String sql="SELECT COUNT(*) FROM SubCompany WHERE CompanyName=?";
        int b = template.queryForObject(sql, Integer.class,CompanyName);
        if(b==0)
            return false;
        else
            return true;
    }

    // public List<Leaves> getLeaves(String name)
    // {
    //     return template.query("SELECT * FROM Leaves WHERE Name='"+name+"';",
    //         new RowMapper<Leaves>(){
    //             public Leaves mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 Leaves x = new Leaves();
    //                 x.setName(rs.getString(1));
    //                 x.setMaxduration(rs.getInt(2));
    //                 x.setMinduration(rs.getInt(3));
    //                 x.setLeave_id(rs.getInt(4));
    //                 return x;
    //             }
    //         });
    // }
}
