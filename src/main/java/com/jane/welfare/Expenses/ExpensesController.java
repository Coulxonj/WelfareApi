package com.jane.welfare.Expenses;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;



@RestController

public class ExpensesController {

	 @Autowired
	 ExpensesDAO expensesDAO;
	 
	  //get Expenses 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/Expenses"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ExpensesBean> fetchReport() throws SQLException {
	    return this.expensesDAO.fetchExpenses();
	  }
	//create Expenses
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createExpenses"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ExpensesBean> createExpenses(@RequestBody ExpensesBean expensesBean) throws SQLException {
	    return this.expensesDAO.createexpenses(expensesBean);
	  } 
	  
	  //update Expenses
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateExpenses"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ExpensesBean> updateExpenses(@RequestBody ExpensesBean expensesBean) throws SQLException {
	    return this.expensesDAO.updateExpenses(expensesBean);
	  }
	  
	  
	  //delete Expenses
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteExpenses"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<ExpensesBean> deleteExpenses(@RequestBody ExpensesBean expensesBean) throws SQLException {
	    return this.expensesDAO.deleteExpense(expensesBean);
	  }
}
