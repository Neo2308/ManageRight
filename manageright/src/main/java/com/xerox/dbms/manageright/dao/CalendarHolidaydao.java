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

import com.xerox.dbms.manageright.entity.CalendarHoliday;
@Repository
@Transactional
public class CalendarHolidaydao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(CalendarHoliday p)
    {    
        String sql="INSERT INTO CalendarHoliday(Name,EndDate,StartDate) VALUES(?,?,?)";    
        return template.update(sql,p.getName(),p.getEndDate(),p.getStartDate());    
    }
    public int update(CalendarHoliday p)
    {    
        String sql="UPDATE CalendarHoliday SET Name =?,EndDate=?,StartDate=? WHERE Holiday_ID=?";    
        return template.update(sql,p.getName(),p.getEndDate(),p.getStartDate(),p.getHoliday_ID());    
    }
    // public int delete(int Holiday_ID)
    // {    
    //     String sql="DELETE FROM CalendarHoliday WHERE Holiday_ID="+Holiday_ID+";";    
    //     return template.update(sql);    
    // }
    public List<Map<String,Object>> getCalendarHolidays()
    {
        String sql="SELECT * FROM CalendarHoliday";
        return template.queryForList(sql);
    }
    public CalendarHoliday getCalendarHolidayById(int id)
    {
        String sql="SELECT * FROM CalendarHoliday WHERE Holiday_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<CalendarHoliday>(CalendarHoliday.class),id);
    }
    public CalendarHoliday getCalendarHoliday(String Name, String EndDate, String StartDate)
    {
        String sql="SELECT * FROM CalendarHoliday WHERE Name =? AND EndDate=? AND StartDate=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<CalendarHoliday>(CalendarHoliday.class),Name,EndDate,StartDate);
    }
    public boolean CalendarHolidayExists(int id)
    {
        String sql="SELECT COUNT(*) FROM CalendarHoliday WHERE Holiday_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean CalendarHolidayExists(String Name, String EndDate, String StartDate)
    {
        String sql="SELECT COUNT(*) FROM CalendarHoliday WHERE Name =? AND EndDate=? AND StartDate=?";
        int b = template.queryForObject(sql, Integer.class,Name,EndDate,StartDate);
        if(b==0)
            return false;
        else
            return true;
    }
    
    // public List<CalendarHoliday> getCalendarHolidaybyName(String Name)
    // {
    //     return template.query("SELECT * FROM CalendarHoliday WHERE Name='"+Name+"';",
    //         new RowMapper<CalendarHoliday>(){
    //             public CalendarHoliday mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 CalendarHoliday x = new CalendarHoliday();
    //                 x.setHoliday_id(rs.getInt(1));
    //                 x.setName(rs.getString(2));
    //                 x.setEnddate(rs.getDate(3));
    //                 x.setStartdate(rs.getDate(4));
    //                 return x;
    //             }
    //         });
    // }
}
