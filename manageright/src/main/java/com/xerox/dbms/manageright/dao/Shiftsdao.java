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

import com.xerox.dbms.manageright.entity.Shifts;
@Transactional
@Repository
public class Shiftsdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Shifts p)
    {    
        String sql="INSERT INTO Shifts(Name,Timings,HoursPerWeek) VALUES('"+p.getName()+"','"+p.getTimings()+"',"+p.getHoursPerWeek()+")";    
        return template.update(sql);    
    }
    public int update(Shifts p)
    {    
        String sql="UPDATE Shifts SET Name ='"+p.getName()+"',Timings='"+p.getTimings()+"',HoursPerWeek="+p.getHoursPerWeek()+"WHERE Shift_ID="+p.getShift_ID()+";";    
        return template.update(sql);    
    }
    public int delete(int id)
    {    
        String sql="DELETE FROM Shifts WHERE Shift_ID="+id+";";    
        return template.update(sql);    
    }
    public Shifts getShiftsById(int id)
    {
        String sql="SELECT * FROM Shifts WHERE Shift_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Shifts>(Shifts.class),id);
    }
    public Boolean existsShift(String Timings,String Name)
    {
        String sql="SELECT COUNT(*) FROM Shifts WHERE Timings=? AND Name=?";
        int b = template.queryForObject(sql, Integer.class,Timings,Name);
        if(b==0)
            return false;
        else
            return true;
    }
    public Shifts getShift(String Timings,String Name)
    {
        String sql="SELECT * FROM Shifts WHERE Timings=? AND Name=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Shifts>(Shifts.class),Timings,Name);
    } 
    // public List<Shifts> getShiftsByName(String name)
    // {
    //     return template.query("SELECT * FROM Shifts WHERE Name='"+name+"';",
    //         new RowMapper<Shifts>(){
    //             public Shifts mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 Shifts x = new Shifts();
    //                 x.setTimings(rs.getString(1));
    //                 x.setName(rs.getString(2));
    //                 x.setShift_id(rs.getInt(3));
    //                 x.setHoursPerWeek(rs.getInt(4));
    //                 return x;
    //             }
    //         });
    // }
}
