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

import com.xerox.dbms.manageright.entity.AllowedLeaves;
@Repository
@Transactional
public class AllowedLeavesdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(AllowedLeaves p)
    {    
        String sql="INSERT INTO AllowedLeaves(Company_ID,Leave_ID,Eligibility_ID,MaxAllowed) VALUES("+p.getCompany_id()+","+p.getLeave_id()+","+p.getEligibility_id()+","+p.getMaxAllowed()+")";    
        return template.update(sql);    
    }
    public int update(AllowedLeaves p)
    {    
        String sql="UPDATE AllowedLeaves SET MaxAllowed ="+p.getMaxAllowed()+",Eligibility_ID="+p.getEligibility_id()+"WHERE Company_ID="+p.getCompany_id()+"AND Leave_ID="+p.getLeave_id()+";";    
        return template.update(sql);    
    }
    public int delete(int Company_ID,int Leave_ID)
    {    
        String sql="DELETE FROM AllowedLeaves WHERE Company_ID="+Company_ID+"AND Leave_ID="+Leave_ID+";";    
        return template.update(sql);    
    }
    public AllowedLeaves getAllowedLeavesById(int Company_ID,int Leave_ID)
    {
        String sql="SELECT * FROM AllowedLeaves WHERE Company_ID=? AND Leave_ID=?";
        return template.queryForObject(sql, new Object[]{Company_ID,Leave_ID},new BeanPropertyRowMapper<AllowedLeaves>(AllowedLeaves.class));
    }
    public List<AllowedLeaves> getAllowedLeavesofCompany(int Company_ID)
    {
        return template.query("SELECT * FROM AllowedLeaves WHERE Company_ID="+Company_ID+";",
            new RowMapper<AllowedLeaves>(){
                public AllowedLeaves mapRow(ResultSet rs,int row) throws SQLException
                {
                    AllowedLeaves x = new AllowedLeaves();
                    x.setMaxAllowed(rs.getInt(1));
                    x.setCompany_id(rs.getInt(2));
                    x.setLeave_id(rs.getInt(3));
                    x.setEligibility_id(rs.getInt(4));
                    return x;
                }
            });
    }
    public List<AllowedLeaves> getCompaniesUsingHoliday(int Holiday_ID)
    {
        return template.query("SELECT * FROM AllowedLeaves WHERE Holiday_ID="+Holiday_ID+";",
            new RowMapper<AllowedLeaves>(){
                public AllowedLeaves mapRow(ResultSet rs,int row) throws SQLException
                {
                    AllowedLeaves x = new AllowedLeaves();
                    x.setMaxAllowed(rs.getInt(1));
                    x.setCompany_id(rs.getInt(2));
                    x.setLeave_id(rs.getInt(3));
                    x.setEligibility_id(rs.getInt(4));
                    return x;
                }
            });
    }
}
