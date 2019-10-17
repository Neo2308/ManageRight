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

import com.xerox.dbms.manageright.entity.ApplicableAt;
@Repository
@Transactional
public class ApplicableAtdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(ApplicableAt p)
    {    
        String sql="INSERT INTO ApplicableAt(Holiday_ID,Region_ID) VALUES("+p.getHoliday_id()+","+p.getRegion_id()+")";    
        return template.update(sql);    
    }
    public int save(int hid,int rid)
    {    
        String sql="INSERT INTO ApplicableAt(Holiday_ID,Region_ID) VALUES(?,?)";    
        return template.update(sql,hid,rid);    
    }
    // public int update(ApplicableAt p)
    // {    
    //     String sql="UPDATE ApplicableAt SET MaxAllowed ="+p.getMaxAllowed()+",Eligibility_ID="+p.getEligibility_id()+"WHERE Company_ID="+p.getCompany_id()+"AND Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    public int delete(int Holiday_ID,int Region_ID)
    {    
        String sql="DELETE FROM ApplicableAt WHERE Holiday_ID="+Holiday_ID+"AND Region_ID="+Region_ID+";";    
        return template.update(sql);    
    }
    public boolean ApplicableAtExists(int Holiday_ID,int Region_ID)
    {
        String sql="SELECT COUNT(*) FROM ApplicableAt WHERE Holiday_ID=? AND Region_ID=?";
        int b = template.queryForObject(sql, Integer.class,Holiday_ID,Region_ID);
        if(b==0)
            return false;
        else
            return true;
    }
    public ApplicableAt getApplicableAtById(int Holiday_ID,int Region_ID)
    {
        String sql="SELECT * FROM ApplicableAt WHERE Holiday_ID=? AND Region_ID=?";
        return template.queryForObject(sql, new Object[]{Holiday_ID,Region_ID},new BeanPropertyRowMapper<ApplicableAt>(ApplicableAt.class));
    }
    public List<ApplicableAt> getRegionsofHoliday(int Holiday_ID)
    {
        return template.query("SELECT * FROM ApplicableAt WHERE Holiday_ID="+Holiday_ID+";",
            new RowMapper<ApplicableAt>(){
                public ApplicableAt mapRow(ResultSet rs,int row) throws SQLException
                {
                    ApplicableAt x = new ApplicableAt();
                    x.setHoliday_id(rs.getInt(1));
                    x.setRegion_id(rs.getInt(2));
                    return x;
                }
            });
    }
    public List<ApplicableAt> getHolidaysofRegion(int Region_ID)
    {
        return template.query("SELECT * FROM ApplicableAt WHERE Region_ID="+Region_ID+";",
            new RowMapper<ApplicableAt>(){
                public ApplicableAt mapRow(ResultSet rs,int row) throws SQLException
                {
                    ApplicableAt x = new ApplicableAt();
                    x.setHoliday_id(rs.getInt(1));
                    x.setRegion_id(rs.getInt(2));
                    return x;
                }
            });
    }
}
