package com.jane.welfare.Users;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;



@RestController
public class UsersController {

	 @Autowired
	 UsersDAO usersDAO;
	 
	  //get Users 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/User"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<UsersBean> fetchReport() throws SQLException {
	    return this.usersDAO.fetchUsers();
	  }
	//create Users
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createUsers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<UsersBean> createUsers(@RequestBody UsersBean usersBean) throws SQLException {
	    return this.usersDAO.createusers(usersBean);
	  } 
	  
	  //update Users
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateUsers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<UsersBean> updateUsers(@RequestBody UsersBean usersBean) throws SQLException {
	    return this.usersDAO.updateUsers(usersBean);
	  }
	  
	  
	  //delete Users
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteUsers"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<UsersBean> deleteUsers(@RequestBody UsersBean usersBean) throws SQLException {
	    return this.usersDAO.deleteUsers(usersBean);
	  }
}
