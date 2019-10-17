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

import com.xerox.dbms.manageright.entity.DepartmentsAvailable;
@Transactional
@Repository
public class DepartmentsAvailabledao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(DepartmentsAvailable p)
    {    
        String sql="INSERT INTO DepartmentsAvailable(Company_ID,Departments) VALUES(?,?)";    
        return template.update(sql,p.getCompany_ID(),p.getDepartments());    
    }
    // public int update(DepartmentsAvailable p)
    // {    
    //     String sql="UPDATE DepartmentsAvailable SET Name ='"+p.getName()+"',MaxDuration="+p.getMaxduration()+",MinDuration="+p.getMinduration()+"WHERE Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    public int delete(int Company_ID,String Departments)
    {    
        String sql="DELETE FROM DepartmentsAvailable WHERE Company_ID="+Company_ID+"AND Departments="+Departments+";";    
        return template.update(sql);    
    }
    public DepartmentsAvailable getDepartmentsAvailableById(int Company_ID,String Departments)
    {
        String sql="SELECT * FROM DepartmentsAvailable WHERE Company_ID=? AND Departments=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<DepartmentsAvailable>(DepartmentsAvailable.class),Company_ID,Departments);
    }
    public boolean existsDepartmentsAvailable(int Company_ID,String Departments)
    {
        String sql="SELECT COUNT(*) FROM DepartmentsAvailable WHERE Company_ID=? AND Departments=?";
        int f=template.queryForObject(sql, Integer.class,Company_ID,Departments);
        if(f==0)
            return false;
        else
            return true;
    }
    public List<DepartmentsAvailable> getDepartmentsAvailableofCompany(int Company_ID)
    {
        return template.query("SELECT * FROM DepartmentsAvailable WHERE Company_ID="+Company_ID+";",
            new RowMapper<DepartmentsAvailable>(){
                public DepartmentsAvailable mapRow(ResultSet rs,int row) throws SQLException
                {
                    DepartmentsAvailable x = new DepartmentsAvailable();
                    x.setDepartments(rs.getString(1));
                    x.setCompany_ID(rs.getInt(2));
                    return x;
                }
            });
    }
    public List<Map<String,Object>> getCompaniesDepartments(int cid)
    {
        String sql="SELECT * FROM DepartmentsAvailable WHERE Company_ID=?";
        return template.queryForList(sql,cid);
    }
}
