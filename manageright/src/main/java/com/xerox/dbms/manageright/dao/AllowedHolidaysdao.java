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

import com.xerox.dbms.manageright.entity.AllowedHolidays;
@Transactional
@Repository
public class AllowedHolidaysdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(AllowedHolidays p)
    {    
        String sql="INSERT INTO AllowedHolidays(Company_ID,Holiday_ID) VALUES("+p.getCompany_id()+","+p.getHoliday_id()+")";    
        return template.update(sql);    
    }
    public int save(int cid,int hid)
    {    
        String sql="INSERT INTO AllowedHolidays(Company_ID,Holiday_ID) VALUES(?,?)";    
        return template.update(sql,cid,hid);    
    }
    // public int update(AllowedHolidays p)
    // {    
    //     String sql="UPDATE AllowedHolidays SET Name ='"+p.getName()+"',MaxDuration="+p.getMaxduration()+",MinDuration="+p.getMinduration()+"WHERE Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    public int delete(int Company_ID,int Holiday_ID)
    {    
        String sql="DELETE FROM AllowedHolidays WHERE Company_ID="+Company_ID+"AND Holiday_ID="+Holiday_ID+";";    
        return template.update(sql);    
    }
    public AllowedHolidays getAllowedHolidaysById(int Company_ID,int Holiday_ID)
    {
        String sql="SELECT * FROM AllowedHolidays WHERE Company_ID=? AND Holiday_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<AllowedHolidays>(AllowedHolidays.class),Company_ID,Holiday_ID);
    }
    public boolean existsAllowedHolidays(int Company_ID,int Holiday_ID)
    {
        String sql="SELECT COUNT(*) FROM AllowedHolidays WHERE Company_ID=? AND Holiday_ID=?";
        int f= template.queryForObject(sql, Integer.class,Company_ID,Holiday_ID);
        if(f==0)
            return false;
        else
            return true;
    }
    public List<AllowedHolidays> getAllowedHolidaysofCompany(int Company_ID)
    {
        return template.query("SELECT * FROM AllowedHolidays WHERE Company_ID="+Company_ID+";",
            new RowMapper<AllowedHolidays>(){
                public AllowedHolidays mapRow(ResultSet rs,int row) throws SQLException
                {
                    AllowedHolidays x = new AllowedHolidays();
                    x.setCompany_id(rs.getInt(1));
                    x.setHoliday_id(rs.getInt(2));
                    return x;
                }
            });
    }
    public List<AllowedHolidays> getCompaniesUsingHoliday(int Holiday_ID)
    {
        return template.query("SELECT * FROM AllowedHolidays WHERE Holiday_ID="+Holiday_ID+";",
            new RowMapper<AllowedHolidays>(){
                public AllowedHolidays mapRow(ResultSet rs,int row) throws SQLException
                {
                    AllowedHolidays x = new AllowedHolidays();
                    x.setCompany_id(rs.getInt(1));
                    x.setHoliday_id(rs.getInt(2));
                    return x;
                }
            });
    }
}
