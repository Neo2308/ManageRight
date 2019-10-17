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

import com.xerox.dbms.manageright.entity.Benefits;
@Repository
@Transactional
public class Benefitsdao
{
    @Autowired
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template)
    {    
        this.template = template;    
    }
    public int save(Benefits p)
    {    
        String sql="INSERT INTO Benefits(Type,Name) VALUES(?,?)";    
        return template.update(sql,p.getType(),p.getName());    
    }
    public int update(Benefits p)
    {    
        String sql="UPDATE Benefits SET Type =? AND Name=? WHERE Benefit_ID=?";    
        return template.update(sql,p.getType(),p.getName(),p.getBenefit_ID());   
    }
    public int delete(int Benefit_ID)
    {    
        String sql="DELETE FROM Benefits WHERE Benefit_ID="+Benefit_ID+";";    
        return template.update(sql);    
    }
    public Benefits getBenefitsById(int Benefit_ID)
    {
        String sql="SELECT * FROM Benefits WHERE Benefit_ID=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Benefits>(Benefits.class),Benefit_ID);
    }
    public Boolean existsBenefit(String Name,String Type)
    {
        String sql="SELECT COUNT(*) FROM Benefits WHERE Type=? AND Name=?";
        int b = template.queryForObject(sql, Integer.class,Type,Name);
        if(b==0)
            return false;
        else
            return true;
    }
    
    public Benefits getBenefit(String Name,String Type)
    {
        String sql="SELECT * FROM Benefits WHERE Type=? AND Name=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Benefits>(Benefits.class),Type,Name);
    }
    
    // public List<Benefits> getBenefitsofType(String Type)
    // {
    //     return template.query("SELECT * FROM Benefits WHERE Type='"+Type+"';",
    //         new RowMapper<Benefits>(){
    //             public Benefits mapRow(ResultSet rs,int row) throws SQLException
    //             {
    //                 Benefits x = new Benefits();
    //                 x.setType(rs.getString(1));
    //                 x.setName(rs.getString(2));
    //                 x.setBenefit_id(rs.getInt(3));
    //                 return x;
    //             }
    //         });
    // }
}
