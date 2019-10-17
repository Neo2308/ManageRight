package com.xerox.dbms.manageright.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.xerox.dbms.manageright.entity.BenefitsProvided;

public class BenefitsProvideddao
{
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(BenefitsProvided p)
    {    
        String sql="INSERT INTO BenefitsProvided(Company_ID,Benefit_ID) VALUES("+p.getCompany_id()+","+p.getBenefit_id()+")";    
        return template.update(sql);    
    }
    // public int update(BenefitsProvided p)
    // {    
    //     String sql="UPDATE BenefitsProvided SET MaxAllowed ="+p.getMaxAllowed()+",Eligibility_ID="+p.getEligibility_id()+"WHERE Company_ID="+p.getCompany_id()+"AND Leave_ID="+p.getLeave_id()+";";    
    //     return template.update(sql);    
    // }
    public int delete(int Company_ID,int Benefit_ID)
    {    
        String sql="DELETE FROM BenefitsProvided WHERE Company_ID="+Company_ID+"AND Benefit_ID="+Benefit_ID+";";    
        return template.update(sql);    
    }
    public BenefitsProvided getBenefitsProvidedById(int Company_ID,int Benefit_ID)
    {
        String sql="SELECT * FROM BenefitsProvided WHERE Company_ID=? AND Benefit_ID=?";
        return template.queryForObject(sql, new Object[]{Company_ID,Benefit_ID},new BeanPropertyRowMapper<BenefitsProvided>(BenefitsProvided.class));
    }
    public List<BenefitsProvided> getBenefitsofCompany(int Company_ID)
    {
        return template.query("SELECT * FROM BenefitsProvided WHERE Company_ID="+Company_ID+";",
            new RowMapper<BenefitsProvided>(){
                public BenefitsProvided mapRow(ResultSet rs,int row) throws SQLException
                {
                    BenefitsProvided x = new BenefitsProvided();
                    x.setCompany_id(rs.getInt(1));
                    x.setBenefit_id(rs.getInt(2));
                    return x;
                }
            });
    }
    public List<BenefitsProvided> getCompaniesofBenefit(int Benefit_ID)
    {
        return template.query("SELECT * FROM BenefitsProvided WHERE Benefit_ID="+Benefit_ID+";",
            new RowMapper<BenefitsProvided>(){
                public BenefitsProvided mapRow(ResultSet rs,int row) throws SQLException
                {
                    BenefitsProvided x = new BenefitsProvided();
                    x.setCompany_id(rs.getInt(1));
                    x.setBenefit_id(rs.getInt(2));
                    return x;
                }
            });
    }
}
