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
@RequestMapping("/Admin")
public class AdminController{
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
    private DepartmentsAvailabledao departmentsavailabledao; 
    
    @Autowired
    private ApplicableAtdao applicableatdao; 
    
    @Autowired
    private JdbcTemplate template;

    @GetMapping("/addsubcompany")
    public String addSubcompany(Model model)
    {
        model.addAttribute("obj", new SubCompany());
        return "addsubcompany";
    }
    @PostMapping("/addsubcompany")
    public String subcompanyadded(@ModelAttribute("obj") SubCompany subcompany,Model model)
    {
        boolean f=subcompanydao.SubCompanyExists(subcompany.getCompanyName());
        if(f==false)
        {
            model.addAttribute("msg", "New SubCompany Created");
            subcompanydao.save(subcompany);
        }
        else
        {
            model.addAttribute("msg", "SubCompany already exists");
        }
        SubCompany obj= subcompanydao.getSubCompany(subcompany.getCompanyName());
        System.out.println(obj.getCompany_ID());
        model.addAttribute("obj",obj);
        return "redirect:/Admin/subcompany/"+obj.getCompany_ID();
    }
    @GetMapping("/subcompany/{cid}")
    public String showsubcompany(@PathVariable("cid") int cid,Model model)
    {
        model.addAttribute("obj",subcompanydao.getSubCompanyById(cid));
        return "subcompanyinfo";
    }

    @GetMapping("/addregion")
    public String addregion(Model model)
    {
        model.addAttribute("obj", new Region());
        return "addregion";
    }
    @PostMapping("/addregion")
    public String regionadded(@ModelAttribute("obj") Region region,Model model)
    {
        boolean f=regiondao.RegionExists(region.getName());
        if(f==false)
        {
            model.addAttribute("msg", "New Region Created");
            regiondao.save(region);
        }
        else
        {
            model.addAttribute("msg", "Region already exists");
        }
        Region obj= regiondao.getRegion(region.getName());
        return "redirect:/Admin/region/"+obj.getRegion_ID();
    }
    @GetMapping("/region/{rid}")
    public String showregion(@PathVariable("rid") int rid,Model model)
    {
        model.addAttribute("obj",regiondao.getRegionById(rid));
        return "regioninfo";
    }
    
    @GetMapping("/addoffice")
    public String addOffice(Model model)
    {
        model.addAttribute("obj", new Office());
        return "addoffice";
    }
    @PostMapping("/addoffice")
    public String officeadded(@ModelAttribute("obj") Office office,Model model)
    {
        boolean f=officedao.OfficeExists(office.getMailing_Address(), office.getCompany(),office.getLocatedAt());
        if(f==false)
        {
            model.addAttribute("msg", "New Office Created");
            officedao.save(office);
        }
        else
        {
            model.addAttribute("msg", "Office already exists");
        }
        Office obj= officedao.getOffice(office.getMailing_Address(), office.getCompany(),office.getLocatedAt());
        model.addAttribute("obj",obj);
        return "redirect:/Admin/office/"+obj.getOffice_ID();
    }
    @GetMapping("/office/{oid}")
    public String showoffice(@PathVariable("oid") int oid,Model model)
    {
        model.addAttribute("obj",officedao.getOfficeById(oid));
        return "officeinfo";
    }
    
    @GetMapping("/addleaves")
    public String addleaves(Model model)
    {
        model.addAttribute("obj", new Leaves());
        return "addleaves";
    }
    @PostMapping("/addleaves")
    public String leavesadded(@ModelAttribute("obj") Leaves leaves,Model model)
    {
        boolean f=leavesdao.LeavesExists(leaves.getName(), leaves.getMinDuration(),leaves.getMaxDuration());
        if(f==false)
        {
            model.addAttribute("msg", "New Leave Created");
            leavesdao.save(leaves);
        }
        else
        {
            model.addAttribute("msg", "Leave already exists");
        }
        Leaves obj= leavesdao.getLeaves(leaves.getName(), leaves.getMinDuration(),leaves.getMaxDuration());
        return "redirect:/Admin/leave/"+obj.getLeave_ID();
    }
    @GetMapping("/leave/{lid}")
    public String showleaves(@PathVariable("lid") int lid,Model model)
    {
        model.addAttribute("obj",leavesdao.getLeavesById(lid));
        return "leavesinfo";
    }
    
    @GetMapping("/addshift")
    public String addShift(Model model)
    {
        model.addAttribute("obj", new Shifts());
        return "addshift";
    }
    @PostMapping("/addshift")
    public String shiftadded(@ModelAttribute("obj") Shifts shift,@RequestParam("days") List<String> days,Model model)
    {
        shift.setName(String.join("",days));
        System.out.println(shift.getHoursPerWeek());
        boolean f=shiftsdao.existsShift(shift.getTimings(), shift.getName());
        if(f==false)
        {
            model.addAttribute("msg", "New Shift Create");
            shiftsdao.save(shift);
        }
        else
        {
            model.addAttribute("msg", "Shift already exists");
        }
        Shifts obj= shiftsdao.getShift(shift.getTimings(),shift.getName());
        return "redirect:/Admin/shift/"+obj.getShift_ID();
    }
    @GetMapping("/shift/{sid}")
    public String showshift(@PathVariable("sid") int sid,Model model)
    {
        model.addAttribute("obj",shiftsdao.getShiftsById(sid));
        return "shiftinfo";
    }
    
    @GetMapping("/addcalendarholiday")
    public String addcalendarholiday(Model model)
    {
        model.addAttribute("obj", new CalendarHoliday());
        return "addcalendarholiday";
    }
    @PostMapping("/addcalendarholiday")
    public String calendarholidayadded(@ModelAttribute("obj") CalendarHoliday calendarholiday,Model model)
    {
        boolean f=calendarholidaydao.CalendarHolidayExists(calendarholiday.getName(), calendarholiday.getEndDate(),calendarholiday.getStartDate());
        if(f==false)
        {
            model.addAttribute("msg", "New Holiday Created");
            calendarholidaydao.save(calendarholiday);
        }
        else
        {
            model.addAttribute("msg", "Holiday already exists");
        }
        CalendarHoliday obj= calendarholidaydao.getCalendarHoliday(calendarholiday.getName(), calendarholiday.getEndDate(),calendarholiday.getStartDate());
        return "redirect:/Admin/calendarholiday/"+obj.getHoliday_ID();
    }
    @GetMapping("/calendarholiday/{cid}")
    public String showcalendarholiday(@PathVariable("cid") int cid,Model model)
    {
        model.addAttribute("obj",calendarholidaydao.getCalendarHolidayById(cid));
        return "calendarholidayinfo";
    }

    @GetMapping("/addeligibility")
    public String addeligibility(Model model)
    {
        model.addAttribute("obj", new Eligibility());
        return "addeligibility";
    }
    @PostMapping("/addeligibility")
    public String eligibilityadded(@ModelAttribute("obj") Eligibility eligibility,Model model)
    {
        boolean f=eligibilitydao.EligibilityExists(eligibility.getName(), eligibility.getType(),eligibility.getConstraints());
        if(f==false)
        {
            model.addAttribute("msg", "New Eligibility Created");
            eligibilitydao.save(eligibility);
        }
        else
        {
            model.addAttribute("msg", "Eligibility already exists");
        }
        Eligibility obj= eligibilitydao.getEligibility(eligibility.getName(), eligibility.getType(),eligibility.getConstraints());
        return "redirect:/Admin/eligibility/"+obj.getEligibility_ID();
    }
    @GetMapping("/eligibility/{eid}")
    public String showeligibility(@PathVariable("eid") int eid,Model model)
    {
        model.addAttribute("obj",eligibilitydao.getEligibilityById(eid));
        return "eligibilityinfo";
    }
    
    @GetMapping("/addbenefits")
    public String addbenefits(Model model)
    {
        model.addAttribute("obj", new Benefits());
        return "addbenefits";
    }
    @PostMapping("/addbenefits")
    public String benefitsadded(@ModelAttribute("obj") Benefits benefits,Model model)
    {
        boolean f=benefitsdao.existsBenefit(benefits.getName(), benefits.getType());
        if(f==false)
        {
            model.addAttribute("msg", "New Benefit Created");
            benefitsdao.save(benefits);
        }
        else
        {
            model.addAttribute("msg", "Benefit already exists");
        }
        Benefits obj= benefitsdao.getBenefit(benefits.getName(), benefits.getType());
        return "redirect:/Admin/benefits/"+obj.getBenefit_ID();
    }
    @GetMapping("/benefits/{bid}")
    public String showbenefits(@PathVariable("bid") int bid,Model model)
    {
        model.addAttribute("obj",benefitsdao.getBenefitsById(bid));
        return "benefitsinfo";
    }
    
    @GetMapping("/addpersonalrelations")
    public String addpersonalrelations(Model model)
    {
        model.addAttribute("obj", new PersonalRelations());
        return "addpersonalrelations";
    }
    @PostMapping("/addpersonalrelations")
    public String personalrelationsadded(@ModelAttribute("obj") PersonalRelations personalrelations,Model model)
    {
        boolean f=personalrelationsdao.PersonalRelationsExists(personalrelations.getName(), personalrelations.getMobile(),personalrelations.getEmail(),personalrelations.getMailingAddress());
        if(f==false)
        {
            model.addAttribute("msg", "New Personal Relations Created");
            personalrelationsdao.save(personalrelations);
        }
        else
        {
            model.addAttribute("msg", "Personal Relations already exists");
        }
        PersonalRelations obj= personalrelationsdao.getPersonalRelations(personalrelations.getName(), personalrelations.getMobile(),personalrelations.getEmail(),personalrelations.getMailingAddress());
        return "redirect:/Admin/personalrelations/"+obj.getPR_ID();
    }
    @GetMapping("/personalrelations/{pid}")
    public String showpersonalrelations(@PathVariable("pid") int pid,Model model)
    {
        model.addAttribute("obj",personalrelationsdao.getPersonalRelationsById(pid));
        return "personalrelationsinfo";
    }
    
    @GetMapping("/setcompany/{oid}")
    public String setcompanyp1(@PathVariable("oid") int oid,Model model)
    {
        String sql= "SELECT * FROM SubCompany";
        List<Map<String, Object>> lst = template.queryForList(sql);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink","/Admin/setcompany/"+oid+"/"+i.get("Company_ID"));
            i.put("nextlinktext","Set");
        }
        model.addAttribute("companies", lst);
        return "showsubcompanies";
    }
    @GetMapping("/setcompany/{oid}/{cid}")
    public String setcompanyp2(@PathVariable("oid") int oid,@PathVariable("cid") int cid,Model model)
    {
        officedao.setCompany(oid, cid);
        return "redirect:/Admin/office/"+oid;
    }
    
    @GetMapping("/setregionlocatedin/{rid}")
    public String setregionlocatedinp1(@PathVariable("rid") int rid,Model model)
    {
        List<Map<String, Object>> lst = regiondao.getRegioninnone(rid);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink1","/Admin/setregionlocatedin/"+rid+"/"+i.get("Region_ID"));
            i.put("nextlinktext1","Open");
            i.put("nextlink2","/Admin/setregionlocatedinset/"+rid+"/"+i.get("Region_ID"));
            i.put("nextlinktext2","Set");
        }
        model.addAttribute("regions", lst);
        return "showregions";
    }
    @GetMapping("/setregionlocatedin/{rid}/{lid}")
    public String setregionlocatedinp2(@PathVariable("rid") int rid,@PathVariable("lid") int lid,Model model)
    {
        List<Map<String, Object>> lst = regiondao.getRegioninregion(rid, lid);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink1","/Admin/setregionlocatedin/"+rid+"/"+i.get("Region_ID"));
            i.put("nextlinktext1","Open");
            i.put("nextlink2","/Admin/setregionlocatedinset/"+rid+"/"+i.get("Region_ID"));
            i.put("nextlinktext2","Set");
        }
        model.addAttribute("regions", lst);
        return "showregions";
    }
    @GetMapping("/setregionlocatedinset/{rid}/{lid}")
    public String setregionlocatedinp3(@PathVariable("rid") int rid,@PathVariable("lid") int lid,Model model)
    {
        regiondao.setLocatedIn(rid, lid);
        return "redirect:/Admin/region/"+rid;
    }
    
    @GetMapping("/setholidayregion/{hid}")
    public String setholidayregionp1(@PathVariable("hid") int hid,Model model)
    {
        List<Map<String, Object>> lst = regiondao.getRegioninnone();
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink1","/Admin/setholidayregion/"+hid+"/"+i.get("Region_ID"));
            i.put("nextlinktext1","Open");
            i.put("nextlink2","/Admin/setholidayregionset/"+hid+"/"+i.get("Region_ID"));
            i.put("nextlinktext2","Set");
        }
        model.addAttribute("regions", lst);
        return "showregions";
    }
    @GetMapping("/setholidayregion/{hid}/{rid}")
    public String setholidayregionp2(@PathVariable("hid") int hid,@PathVariable("rid") int rid,Model model)
    {
        List<Map<String, Object>> lst = regiondao.getRegioninregion(rid);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink1","/Admin/setholidayregion/"+hid+"/"+i.get("Region_ID"));
            i.put("nextlinktext1","Open");
            i.put("nextlink2","/Admin/setholidayregionset/"+hid+"/"+i.get("Region_ID"));
            i.put("nextlinktext2","Set");
        }
        model.addAttribute("regions", lst);
        return "showregions";
    }
    
    @GetMapping("/setholidayregionset/{hid}/{rid}")
    public String setholidayregionp3(@PathVariable("hid") int hid,@PathVariable("rid") int rid,Model model)
    {
        if(applicableatdao.ApplicableAtExists(hid, rid)==false)
            applicableatdao.save(hid, rid);
        return "redirect:/Admin/calendarholiday/"+hid;
    }
    
    @GetMapping("/setcompanydept/{cid}")
    public String setcompanydeptp1(@PathVariable("cid") int cid,Model model)
    {
        DepartmentsAvailable obj=new DepartmentsAvailable();
        obj.setCompany_ID(cid);
        model.addAttribute("obj", obj);
        return "adddepartment";
    }
    @PostMapping("/setcompanydept/{cid}")
    public String setcompanydeptp2(@PathVariable("cid") int cid,@ModelAttribute DepartmentsAvailable dept, Model model)
    {
        dept.setCompany_ID(cid);
        boolean f=departmentsavailabledao.existsDepartmentsAvailable(dept.getCompany_ID(),dept.getDepartments());
        if(f==false)
        {
            dept.setCompany_ID(cid);
            departmentsavailabledao.save(dept);
        }
        return "redirect:/Admin/subcompany/"+cid;
    }
    
    @GetMapping("/departments/{cid}")
    public String showdepartments(@PathVariable("cid") int cid,Model model)
    {
        List<Map<String, Object>> lst = departmentsavailabledao.getCompaniesDepartments(cid);
        model.addAttribute("departments", lst);
        return "showdepartments";
    }
    
    @GetMapping("/updateholiday/{hid}")
    public String updateholiday(@PathVariable("hid") int hid,Model model)
    {
        boolean f = calendarholidaydao.CalendarHolidayExists(hid);
        if(f)
        {
            CalendarHoliday holiday=calendarholidaydao.getCalendarHolidayById(hid);
            model.addAttribute("obj",holiday);
        }
        return "updateholiday";
    }
    @PostMapping("/updateholiday/{hid}")
    public String updateholidayset(@PathVariable("hid") int hid,@ModelAttribute("obj") CalendarHoliday holiday,Model model)
    {
        holiday.setHoliday_ID(hid);
        calendarholidaydao.update(holiday);
        return "redirect:/Admin/calendarholiday/"+hid;
    }
    
    @GetMapping("/setcompanyholiday/{cid}")
    public String setcompanyholidayp1(@PathVariable("cid") int cid,Model model)
    {
        String sql = "SELECT CalendarHoliday.Holiday_ID as Holiday_ID,CalendarHoliday.Name as HolidayName,StartDate,EndDate,Region.Name as RegionName FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND CalendarHoliday.Holiday_ID not in (SELECT Holiday_ID FROM AllowedHolidays WHERE AllowedHolidays.Company_ID=?)";
        List<Map<String, Object>> lst = template.queryForList(sql,cid);
        for(Map<String,Object> i:lst)
        {
            i.put("nextlink","/Admin/setcompanyholiday/"+cid+"/"+i.get("Holiday_ID"));
            i.put("nextlinktext","Set");
        }
        model.addAttribute("holidays", lst);
        return "showholidays";
    }
    
    @GetMapping("/setcompanyholiday/{cid}/{hid}")
    public String setcompanyholidayp2(@PathVariable("cid") int cid,@PathVariable("hid") int hid,Model model)
    {
        if(allowedholidaysdao.existsAllowedHolidays(cid, hid)==false)
            allowedholidaysdao.save(cid, hid);
        return "redirect:/Admin/subcompany/"+cid;
    }
    @GetMapping("/showcompanyholidays/{cid}")
    public String showcompanyholidays(@PathVariable("cid") int cid,Model model)
    {
        String sql = "SELECT CalendarHoliday.Holiday_ID as Holiday_ID,CalendarHoliday.Name as HolidayName,StartDate,EndDate,Region.Name as RegionName FROM CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND CalendarHoliday.Holiday_ID in (SELECT Holiday_ID FROM AllowedHolidays WHERE AllowedHolidays.Company_ID=?)";
        List<Map<String, Object>> lst = template.queryForList(sql,cid);
        model.addAttribute("holidays", lst);
        return "showholidays";
    }
    
    @GetMapping("/showofficeholidays/{cid}")
    public String showofficeholidays(@PathVariable("cid") int cid,Model model)
    {
        String sql = "SELECT CalendarHoliday.Holiday_ID as Holiday_ID,CalendarHoliday.Name as HolidayName,StartDate,EndDate,Region.Name as RegionName FROM Office,CalendarHoliday,ApplicableAt,Region WHERE CalendarHoliday.Holiday_ID=ApplicableAt.Holiday_ID AND ApplicableAt.Region_ID=Region.Region_ID AND Region.Region_ID=LocatedAt AND CalendarHoliday.Holiday_ID in (SELECT Holiday_ID FROM AllowedHolidays WHERE AllowedHolidays.Company_ID=?)";
        List<Map<String, Object>> lst = template.queryForList(sql,cid);
        model.addAttribute("holidays", lst);
        return "showholidays";
    }
    
}