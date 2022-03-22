package com.jane.welfare.Contribution;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ContributionController {

	 @Autowired
	 ContributionDAO contributionDAO;
	 
	  //get department 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/Contribution"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ContributionBean> fetchReport() throws SQLException {
	    return this.contributionDAO.fetchContribution();
	  }
	//create department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createContribution"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ContributionBean> createContribution(@RequestBody ContributionBean contributionBean) throws SQLException {
	    return this.contributionDAO.createcontribution(contributionBean);
	  } 
	  
	  //update department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateContribution"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ContributionBean> updateContribution(@RequestBody ContributionBean contributionBean) throws SQLException {
	    return this.contributionDAO.updateContribution(contributionBean);
	  }
	  
	  
	  //delete department
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteContribution"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ContributionBean> deleteContribution(@RequestBody ContributionBean contributionBean) throws SQLException {
	    return this.contributionDAO.deleteContribution(contributionBean);
	  }
}
