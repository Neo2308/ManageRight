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

import com.xerox.dbms.manageright.entity.Office;
@Transactional
@Repository
public class Officedao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Office p)
    {    
        String sql="INSERT INTO Office(Mailing_Address,Company,LocatedAt) VALUES(?,?,?)";    
        return template.update(sql,p.getMailing_Address(),p.getCompany(),p.getLocatedAt());
    }
    public int update(Office p)
    {    
        String sql="UPDATE Office SET Mailing_Address=? AND Company=? AND LocatedAt=? WHERE Office_ID=?";    
        return template.update(sql,p.getMailing_Address(),p.getCompany(),p.getLocatedAt(),p.getOffice_ID());    
    }
    public int setCompany(int officeid,int companyid)
    {    
        String sql="UPDATE Office SET Company=? WHERE Office_ID=?";    
        return template.update(sql,companyid,officeid);    
    }
    // public int delete(int id)
    // {    
    //     String sql="DELETE FROM Leaves WHERE Leave_ID="+id+";";    
    //     return template.update(sql);    
    // }
    public Office getOfficeById(int id)
    {
        String sql="SELECT * FROM Office WHERE Office_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Office>(Office.class),id);
    }
    public Office getOffice(String Mailing_Address, int Company,int LocatedAt)
    {
        String sql="SELECT * FROM Office WHERE Mailing_Address=? and Company=? and LocatedAt=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Office>(Office.class),Mailing_Address,Company,LocatedAt);
    }
    public List<Map<String, Object>> getOffices()
    {
        String sql="SELECT * FROM Office";
        return template.queryForList(sql);
    }
    // public Office getLeaves(String name, int MinDuration,int MaxDuration)
    // {
    //     String sql="SELECT * FROM Leaves WHERE Name=? and MinDuration=? and MaxDuration";
    //     return template.queryForObject(sql, new BeanPropertyRowMapper<Leaves>(Leaves.class),name,MinDuration,MaxDuration);
    // }
    public boolean OfficeExists(int id)
    {
        String sql="SELECT COUNT(*) FROM Office WHERE Office_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean OfficeExists(String Mailing_Address, int Company,int LocatedAt)
    {
        String sql="SELECT COUNT(*) FROM Office WHERE Mailing_Address=? and Company=? and LocatedAt=?";
        int b = template.queryForObject(sql, Integer.class,Mailing_Address,Company,LocatedAt);
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
