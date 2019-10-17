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

import com.xerox.dbms.manageright.entity.Region;
@Transactional
@Repository
public class Regiondao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Region p)
    {    
        String sql="INSERT INTO Region(Name) VALUES(?)";    
        return template.update(sql,p.getName());
    }
    public int update(Region p)
    {    
        String sql="UPDATE Region SET Name=? AND LocatedIn=? WHERE Region_ID=?";    
        return template.update(sql,p.getName(),p.getLocatedIn(),p.getRegion_ID());    
    }
    public int setLocatedIn(int rid,int lid)
    {    
        String sql="UPDATE Region SET LocatedIn=? WHERE Region_ID=?";    
        return template.update(sql,lid,rid);    
    }
    // public int delete(int id)
    // {    
    //     String sql="DELETE FROM Leaves WHERE Leave_ID="+id+";";    
    //     return template.update(sql);    
    // }
    
    // public Map<String, Object> getRegionById(int id)
    // {
    //     String sql="SELECT * FROM Region WHERE Region_ID=?";
    //     return template.queryForMap(sql,id);
    // }
    public List<Map<String, Object>> getRegioninnone()
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE LocatedIn is NULL";
        return template.queryForList(sql);
    }
    public List<Map<String, Object>> getRegioninnone(int rid)
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE LocatedIn is NULL AND Region_ID!=?";
        return template.queryForList(sql,rid);
    }
    public List<Map<String, Object>> getRegioninregion(int lid)
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE LocatedIn =?";
        return template.queryForList(sql,lid);
    }
    public List<Map<String, Object>> getRegioninregion(int rid,int lid)
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE LocatedIn =? AND Region_ID!=?";
        return template.queryForList(sql,lid,rid);
    }
    
    public Region getRegionById(int id)
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE Region_ID=? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Region>(Region.class),id);
    }
    public Region getRegion(String Name)
    {
        String sql="SELECT Name,Region_ID, CASE WHEN LocatedIn IS NULL THEN 0 ELSE LocatedIn END AS LocatedIn FROM Region WHERE Name=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Region>(Region.class),Name);
    }
    public Region getRegion(String Name, int LocatedIn)
    {
        String sql="SELECT * FROM Region WHERE Name=? AND LocatedIn=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Region>(Region.class),Name,LocatedIn);
    }
    // public Region getLeaves(String name, int MinDuration,int MaxDuration)
    // {
    //     String sql="SELECT * FROM Leaves WHERE Name=? and MinDuration=? and MaxDuration";
    //     return template.queryForObject(sql, new BeanPropertyRowMapper<Leaves>(Leaves.class),name,MinDuration,MaxDuration);
    // }
    public boolean RegionExists(int id)
    {
        String sql="SELECT COUNT(*) FROM Region WHERE Region_ID=?";
        int b = template.queryForObject(sql, Integer.class,id);
        if(b==0)
            return false;
        else
            return true;
    }
    public boolean RegionExists(String Name)
    {
        String sql="SELECT COUNT(*) FROM Region WHERE Name=?";
        int b = template.queryForObject(sql, Integer.class,Name);
        if(b==0)
            return false;
        else
            return true;
    }
    
    public boolean RegionExists(String Name, int LocatedIn)
    {
        String sql="SELECT COUNT(*) FROM Region WHERE Name=? AND LocatedIn=?";
        int b = template.queryForObject(sql, Integer.class,Name,LocatedIn);
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
