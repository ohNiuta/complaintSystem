package com.niutex.complaintSystem;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niutex.complaintSystem.entities.Complaint;
import com.niutex.complaintSystem.entities.ComplaintDao;


@Controller
public class App {
	@Autowired
	SessionFactory sessionFactory;
	
    @RequestMapping("/fillComplaint")
    public String  fillComplaint() {
    	
    	Complaint p = new Complaint(1, "Hello","bob","bob@bob.com");
    	ComplaintDao dao = new ComplaintDao(sessionFactory);
    	dao.insertComplaint(p);
    	
    	for(Complaint i : dao.getAllComplaints()) {
    		System.out.println(i.getComplaintMessage());
    	}
    	
    	return "fillComplaint";
    }
        
    @RequestMapping("/submitComplaint")
    public String submitComplaint() {
    	return "submitComplaint";
    }
    
    @RequestMapping(name="/showComplaints", method=RequestMethod.GET)
    public String getComplaints() {
    	return "showEnterPassword";
    }
    
    @RequestMapping(name="/showComplaints", method=RequestMethod.POST)
    public String showComplaints() {
    	return "showComplaints";
    }
}
