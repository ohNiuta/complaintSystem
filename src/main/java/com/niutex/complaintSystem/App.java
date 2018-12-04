package com.niutex.complaintSystem;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niutex.complaintSystem.entities.Complaint;
import com.niutex.complaintSystem.entities.ComplaintDao;

@PropertySource({"classpath:admin-properties.properties"})

@Controller
public class App {
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
    @RequestMapping("/fillComplaint")
    public String  fillComplaint() {
    	return "fillComplaint";
    }
        
    @RequestMapping("/submitComplaint")
    public String submitComplaint(
    		@RequestParam("complaint") String complaint,
    		@RequestParam("name") String name,
    		@RequestParam("email") String email) {
    	
    	ComplaintDao dao = new ComplaintDao(sessionFactory);
    	Complaint newComplaint = new Complaint(complaint, name, email);
    	dao.insertComplaint(newComplaint);
    	System.out.println("Inserted complaint");
    	return "submitComplaint";
    }
    
    @RequestMapping(name="/showComplaints", method=RequestMethod.GET)
    public String getComplaints() {
    	return "showEnterPassword";
    }
    
    @RequestMapping(name="/showComplaints", method=RequestMethod.POST)
    public ModelAndView showComplaints(@RequestParam("pass") String pass, ModelAndView modelAndView) {
    	
    	if (pass.equals(env.getProperty("admin.password"))) {
    		
    		ComplaintDao dao = new ComplaintDao(sessionFactory);
    		List<Complaint> complaints =  dao.getAllComplaints();
    		
    		modelAndView.addObject("complaints", complaints);
    		modelAndView.setViewName("showComplaints");    		
    	}
    	else {
    		modelAndView.setViewName("showEnterPassword");
    		modelAndView.addObject("ErrorMessage", "Wrong password. Please try again");
    	}
    	return modelAndView;
    }
}
