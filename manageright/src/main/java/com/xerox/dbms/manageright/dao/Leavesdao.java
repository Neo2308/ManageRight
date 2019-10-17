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

import com.xerox.dbms.manageright.entity.Leaves;
@Transactional
@Repository
public class Leavesdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Leaves p)
    {    
        String sql="INSERT INTO Leaves(Name,MaxDuration,MinDuration) VALUES('"+p.getName()+"',"+p.getMaxDuration()+","+p.getMinDuration()+")";    
        return template.update(sql);    
    }
    public int update(Leaves p)
    {    
        String sql="UPDATE Leaves SET Name ='"+p.getName()+"',MaxDuration="+p.getMaxDuration()+",MinDuration="+p.getMinDuration()+"WHERE Leave_ID="+p.getLeave_ID()+";";    
        return template.update(sql);    
    }
    public int delete(int id)
    {    
        String sql="DELETE FROM Leaves WHERE Leave_ID="+id+";";    
        return template.update(sql);    
    }
    public Leaves getLeavesById(int id)
    {
        String sql="SELECT * FROM Leaves WHERE Leave_ID=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Leaves>(Leaves.class),id);
    }
    public Leaves getLeaves(String name, int MinDuration,int MaxDuration)
    {
        String sql="SELECT * FROM Leaves WHERE Name=? and MinDuration=? and MaxDuration=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Leaves>(Leaves.class),name,MinDuration,MaxDuration);
    }
    public boolean LeavesExists(int id)
    {
        String sql="SELECT COUNT(*) FROM Leaves WHERE Leave_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean LeavesExists(String name, int MinDuration,int MaxDuration)
    {
        String sql="SELECT COUNT(*) FROM Leaves WHERE Name=? and MinDuration=? and MaxDuration=?";
        int b = template.queryForObject(sql, Integer.class,name,MinDuration,MaxDuration);
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
