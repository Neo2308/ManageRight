package com.xerox.dbms.manageright.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.xerox.dbms.manageright.entity.*;
import com.xerox.dbms.manageright.dao.*;

import org.springframework.jdbc.core.JdbcTemplate;

@Controller
@RequestMapping("/HR")
public class HRController{
    @Autowired
    private Employeedao employeedao;
    
    @Autowired
    private Employmentdao employmentdao;
    
    @Autowired
    private Shiftsdao shiftsdao;
    
    @Autowired
    private Officedao officedao; 
    
    @Autowired
    private SubCompanydao subcompanydao; 
    
    @Autowired
    private Regiondao regiondao; 
    
    @Autowired
    private CalendarHolidaydao calendarholidaydao; 
    
    @Autowired
    private PersonalRelationsdao personalrelationsdao; 
    
    @Autowired
    private Leavesdao leavesdao; 
    
    @Autowired
    private Eligibilitydao eligibilitydao; 
    
    @Autowired
    private Benefitsdao benefitsdao; 
    
    @Autowired
    private AllowedHolidaysdao allowedholidaysdao; 
    
    @Autowired
    private JdbcTemplate template;

    @GetMapping("/addemployee")
    public String addemployee(Model model)
    {
        model.addAttribute("obj", new Employee());
        return "addemployee";
    }
    @PostMapping("/addemployee")
    public String employeeadded(@ModelAttribute("obj") Employee employee,Model model)
    {
        boolean f = employeedao.EmployeeExists(employee.getFirstName(),employee.getLastName(),employee.getNationality(),employee.getDOB(),employee.getWorkEmail());
        if(f==false)
        {
            model.addAttribute("msg", "New Employee Created");
            employeedao.save(employee);
        }
        else
        {
            model.addAttribute("msg", "Employee already exists");
        }
        Employee obj= employeedao.getEmployee(employee.getFirstName(),employee.getLastName(),employee.getNationality(),employee.getDOB(),employee.getWorkEmail());
        System.out.println(obj.getEmployee_ID());
        model.addAttribute("obj",obj);
        return "employeeinfo";
    }
    @GetMapping("/employee/{eid}")
    public String showemployee(@PathVariable("eid") int eid,Model model)
    {
        model.addAttribute("obj",employeedao.getEmployee(eid));
        return "employeeinfo";
    }
    
    @GetMapping("/updateemployee/{eid}")
    public String updateemployee(@PathVariable("eid") int eid,Model model)
    {
        model.addAttribute("obj", employeedao.getEmployee(eid));
        return "updateemployee";
    }
    @PostMapping("/updateemployee/{eid}")
    public String updateemployeeset(@PathVariable("eid") int eid,@ModelAttribute("obj") Employee employee,Model model)
    {
        employee.setEmployee_ID(eid);
        employeedao.update(employee);
        // model.addAttribute("obj", employeedao.getEmployee(eid));
        return "redirect:/HR/employee/"+eid;
    }
    
    @GetMapping("/setmanager/{eid}")
    public String setmanagerp1(@PathVariable("eid") int eid,Model model)
    {
        String sql= "SELECT * FROM Employee WHERE Employee_ID in (SELECT Employee_ID FROM Employee,Office WHERE Employee.WorksFor=Office.Office_ID AND Office.Company=(Select Office.Company FROM Employee,Office WHERE Employee.Employee_ID=? AND Employee.WorksFor=Office.Office_ID))";
        List<Map<String, Object>> lst = template.queryForList(sql,eid);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink","/HR/setmanager/"+eid+"/"+i.get("Employee_ID"));
            i.put("nextlinktext","Set");
        }
        model.addAttribute("employees", lst);
        return "showemployees";
    }
    
    @GetMapping("/setmanager/{eid}/{mid}")
    public String setmanagerp2(@PathVariable("eid") int eid,@PathVariable("mid") int mid,Model model)
    {
        employeedao.setmanager(eid, mid);
        return "redirect:/HR/employee/"+eid;
    }
    
    @GetMapping("/setoffice/{eid}")
    public String setofficep1(@PathVariable("eid") int eid,Model model)
    {
        String sql= "SELECT * FROM Office";
        List<Map<String, Object>> lst = template.queryForList(sql);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink","/HR/setoffice/"+eid+"/"+i.get("Office_ID"));
            i.put("nextlinktext","Set");
        }
        model.addAttribute("offices", lst);
        return "showoffices";
    }
    
    @GetMapping("/setoffice/{eid}/{oid}")
    public String setofficep2(@PathVariable("eid") int eid,@PathVariable("oid") int oid,Model model)
    {
        employeedao.setWorksFor(eid, oid);
        return "redirect:/HR/employee/"+eid;
    }
    
    @GetMapping("/setshift/{eid}")
    public String setshiftp1(@PathVariable("eid") int eid,Model model)
    {
        String sql= "SELECT * FROM Shifts";
        List<Map<String, Object>> lst = template.queryForList(sql);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink","/HR/setshift/"+eid+"/"+i.get("Shift_ID"));
            i.put("nextlinktext","Set");
        }
        model.addAttribute("shifts", lst);
        return "showshifts";
    }
    @GetMapping("/setshift/{eid}/{sid}")
    public String setshiftp2(@PathVariable("eid") int eid,@PathVariable("sid") int sid,Model model)
    {
        employeedao.setShift(eid,sid);
        return "redirect:/HR/employee/"+eid;
    }
    @GetMapping("/terminate/{eid}")
    public String terminate(@PathVariable("eid") int eid,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        if(f)
        {
            employmentdao.terminate(eid);
        }
        return "redirect:/HR/employee/"+eid;
    }
    @GetMapping("/unterminate/{eid}")
    public String unterminate(@PathVariable("eid") int eid,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        boolean g = employmentdao.wasEmployed(eid);
        if(g&&!f)
            employmentdao.unterminate(eid);
        return "redirect:/HR/employee/"+eid;
    }
    @GetMapping("/addemployment/{eid}")
    public String addemployment(@PathVariable("eid") int eid,Model model)
    {
        Employment emp=new Employment();
        emp.setEmployee_ID(eid);
        model.addAttribute("obj", emp);
        return "addemployment";
    }
    @PostMapping("/addemployment/{eid}")
    public String employmentadded(@ModelAttribute("obj") Employment employment,@PathVariable("eid") int eid,Model model)
    {
        employment.setEmployee_ID(eid);
        boolean f = employmentdao.isEmployed(employment.getEmployee_ID());
        if(f==false)
        {
            model.addAttribute("msg", "New Employment Created");
            employmentdao.save(employment);
        }
        else
        {
            employmentdao.terminate(employment.getEmployee_ID());
            employmentdao.save(employment);
            model.addAttribute("msg", "Employee already exists");
        }
        Employment obj=employmentdao.getEmployment(employment.getEmployee_ID());
        return "redirect:/HR/employment/"+obj.getEmployment_ID();
    }
    @GetMapping("/employmentofemp/{eid}")
    public String showemploymentofemp(@PathVariable("eid") int eid,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        if(f)
            model.addAttribute("obj",employmentdao.getEmployment(eid));
        return "employmentinfo";
    }
    
    @GetMapping("/employment/{eid}")
    public String showemployment(@PathVariable("eid") int eid,Model model)
    {
        model.addAttribute("obj",employmentdao.getEmploymentByID(eid));
        return "employmentinfo";
    }
    @GetMapping("/employments/{eid}")
    public String showemployments(@PathVariable("eid") int eid,Model model)
    {
        model.addAttribute("employments",employmentdao.getEmployments(eid));
        return "showemployments";
    }
    
    @GetMapping("/updateemployment/{eid}")
    public String updateemployment(@PathVariable("eid") int eid,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        if(f)
        {
            Employment employment=employmentdao.getEmployment(eid);
            employment.setEmployee_ID(eid);
            model.addAttribute("obj",employment);
        }
        return "updateemployment";
    }
    @PostMapping("/updateemployment/{eid}")
    public String updateemploymentset(@PathVariable("eid") int eid,@ModelAttribute("obj") Employment employment,Model model)
    {
        employment.setEmployment_ID(eid);
        employmentdao.update(employment);
        return "redirect:/HR/employment/"+eid;
    }
    @GetMapping("/setempdept/{eid}")
    public String setempdept1(@PathVariable("eid") int eid,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        if(f)
        {
            String sql="SELECT * FROM DepartmentsAvailable WHERE Company_ID IN(SELECT Company_ID FROM Office,Employee WHERE Employee_ID=? AND Office_ID=Employee.WorksFor)";
            List<Map<String, Object>> lst = template.queryForList(sql,eid);
            for(Map<String,Object> i:lst)
            {
                i.put("nextlink","/HR/setempdept/"+eid+"/"+i.get("Departments"));
                i.put("nextlinktext","Set");
            }
            model.addAttribute("departments",lst);
        }
        return "showdepartments";
    }
    @GetMapping("/setempdept/{eid}/{dept}")
    public String setempdept2(@PathVariable("eid") int eid,@PathVariable("dept") String dept,Model model)
    {
        boolean f = employmentdao.isEmployed(eid);
        if(f)
        {
            Employment employment=employmentdao.getEmployment(eid);
            employmentdao.changedepartment(employment.getEmployment_ID(), dept);
        }
        return "redirect:/HR/employee/"+eid;
    }
        
    // @PostMapping("/changedepartment")
    // public String departmentchanged(@ModelAttribute("obj") Employment employment,Model model)
    // {

    // }
    
    @GetMapping("/employeesofoffice/{oid}")
    public String showemployeesofoffice(@PathVariable("oid") int officeid, Model model) {
        List<Map<String, Object>> lst = employeedao.getEmployeesbyOffice(officeid);
        model.addAttribute("employees", lst);
        return "showemployees";
    }

    // @GetMapping("/officesforemployees/")
    // public String showofficesforemployees(Model model) {
    //     List<Map<String, Object>> lst = officedao.getOffices();
    //     for(Map<String,Object> i:lst)
    //     {
    //         i.put("nextlink","/HR/employeesofoffice/"+i.get("Office_ID"));
    //     }
    //     model.addAttribute("offices", lst);
    //     return "showoffices";
    // }
    
    @GetMapping("/offices/")
    public String showoffices(Model model) {
        List<Map<String, Object>> lst = officedao.getOffices();
        model.addAttribute("offices", lst);
        return "showoffices";
    }
    
    @GetMapping("/employees/")
    public String showemployees(Model model) {
        List<Map<String, Object>> lst = employeedao.getEmployees();
        model.addAttribute("employees", lst);
        return "showemployees";
    }
    
    @GetMapping("/holidays/{rid}")
    public String showholidaysofregion( Model model) {
        String sql = "SELECT * FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND Region.Region_ID=?";
        List<Map<String, Object>> lst = template.queryForList(sql);
        model.addAttribute("holidays", lst);
        return "showholidays";
    }

    @GetMapping("/holidays/")
    public String showholidays( Model model) {
        String sql = "SELECT CalendarHoliday.Holiday_ID as Holiday_ID,CalendarHoliday.Name as HolidayName,StartDate,EndDate,Region.Name as RegionName FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID";
        List<Map<String, Object>> lst = template.queryForList(sql);
        
        model.addAttribute("holidays", lst);
        return "showholidays";
    }

    @GetMapping("/selectholidaysofcompany/{cid}")
    public String selectholidays(@PathVariable("cid") int Companyid, Model model) {
        String sql = "SELECT * FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND Holiday_ID not in (SELECT Holiday_ID FROM AllowedHolidays WHERE AllowedHolidays.Company_ID=?)";
        List<Map<String, Object>> lst = template.queryForList(sql,Companyid);
        model.addAttribute("holidays", lst);
        return "selectholidaysofcompany";
    }
    @GetMapping("/selectholidaysofcompany/{cid}/{hid}")
    public String addholidaystocompany(@PathVariable("cid") int Companyid,@PathVariable("hid") int Holidayid, Model model) {
        AllowedHolidays p=new AllowedHolidays();
        p.setCompany_id(Companyid);
        p.setHoliday_id(Holidayid);
        allowedholidaysdao.save(p);
        return "redirect:/selectholidaysofcompany/${Companyid}";
    }
    
    @GetMapping("/selectleavesofcompany/{cid}")
    public String selectleaves(@PathVariable("cid") int Companyid, Model model) {
        String sql = "SELECT * FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND Holiday_ID not in (SELECT Holiday_ID FROM AllowedHolidays WHERE AllowedHolidays.Company_ID=?)";
        List<Map<String, Object>> lst = template.queryForList(sql,Companyid);
        model.addAttribute("leaves", lst);
        return "selectleavesofcompany";
    }
    
    @GetMapping("/selectdepartmentofemployee/{eid}/{enid}")
    public String selectdepartment(@PathVariable("eid") int Employeeid,@PathVariable("enid") int Employmentid, Model model) {
        String sql= "Select Departments FROM DepartmentsAvailable,SubCompany,Office,Employee WHERE Employee_ID=? AND Employment_ID=? AND WorksFor=Office_ID AND Company=SubCompany.Company_ID AND DepartmentsAvailable.Company_ID=SubCompany.Company_ID";
        List<Map<String, Object>> lst = template.queryForList(sql,Employeeid);
        model.addAttribute("departments", lst);
        return "selectdepartmentofemployee";
    }
    
    // public String update 
}