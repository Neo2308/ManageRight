package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.xerox.dbms.manageright.entity.EmergencyColleagues;

public class EmergencyColleaguesdao
{
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(EmergencyColleagues p)
    {    
        String sql="INSERT INTO EmergencyColleagues(Employee,Colleague) VALUES("+p.getEmployee()+","+p.getColleague()+")";    
        return template.update(sql);    
    }
    // public int update(EmergencyColleagues p)
    // {    
    //     String sql="UPDATE EmergencyColleagues SET MaxAllowed ="+p.getMaxAllowed()+",Eligibility_ID="+p.getEligibility_id()+"WHERE Employee="+p.getEmployee()+"AND Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    public int delete(int Employee,int Colleague)
    {    
        String sql="DELETE FROM EmergencyColleagues WHERE Employee="+Employee+"AND Colleague="+Colleague+";";    
        return template.update(sql);    
    }
    public EmergencyColleagues getEmergencyColleaguesById(int Employee,int Colleague)
    {
        String sql="SELECT * FROM EmergencyColleagues WHERE Employee=? AND Colleague=?";
        return template.queryForObject(sql, new Object[]{Employee,Colleague},new BeanPropertyRowMapper<EmergencyColleagues>(EmergencyColleagues.class));
    }
    public List<EmergencyColleagues> getColleagueofEmployee(int Employee)
    {
        return template.query("SELECT * FROM EmergencyColleagues WHERE Employee="+Employee+";",
            new RowMapper<EmergencyColleagues>(){
                public EmergencyColleagues mapRow(ResultSet rs,int row) throws SQLException
                {
                    EmergencyColleagues x = new EmergencyColleagues();
                    x.setEmployee(rs.getInt(1));
                    x.setColleague(rs.getInt(2));
                    return x;
                }
            });
    }
    public List<EmergencyColleagues> getEmployeehavingColleague(int Colleague)
    {
        return template.query("SELECT * FROM EmergencyColleagues WHERE Colleague="+Colleague+";",
            new RowMapper<EmergencyColleagues>(){
                public EmergencyColleagues mapRow(ResultSet rs,int row) throws SQLException
                {
                    EmergencyColleagues x = new EmergencyColleagues();
                    x.setEmployee(rs.getInt(1));
                    x.setColleague(rs.getInt(2));
                    return x;
                }
            });
    }
}
