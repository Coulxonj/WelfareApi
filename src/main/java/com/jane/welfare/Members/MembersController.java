package com.jane.welfare.Members;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;



@RestController

public class MembersController {


	 @Autowired
	 MembersDAO membersDAO;
	 
	  //get Members
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/Members"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<MembersBean> fetchReport() throws SQLException {
	    return this.membersDAO.fetchMembers();
	  }
	//create Members
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createMembers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<MembersBean> createMembers(@RequestBody MembersBean membersBean) throws SQLException {
	    return this.membersDAO.createmembers(membersBean);
	  } 
	  
	  //update Members
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateMembers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<MembersBean> updateMembers(@RequestBody MembersBean membersBean) throws SQLException {
	    return this.membersDAO.updateMembers(membersBean);
	  }
	  
	  //delete Members
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteMembers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<MembersBean> deleteMembers(@RequestBody MembersBean membersBean) throws SQLException {
	    return this.membersDAO.deleteMembers(membersBean);
	  }
}
