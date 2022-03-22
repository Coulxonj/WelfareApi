package com.jane.welfare.Transaction;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;


@RestController

public class TransactionController {

	 @Autowired
	 TransactionDAO transactionDAO;
	 
	  //get Transaction 
	  @RequestMapping(method = {RequestMethod.GET}, value = {"/Transaction"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<TransactionBean> fetchReport() throws SQLException {
	    return this.transactionDAO.fetchTransaction();
	  }
	//create Transaction
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/createTransaction"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<TransactionBean> createTransaction(@RequestBody TransactionBean transactionBean) throws SQLException {
	    return this.transactionDAO.createtransaction(transactionBean);
	  } 
	  
	  //update Transaction
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/updateTransaction"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<TransactionBean> updateTransaction(@RequestBody TransactionBean transactionBean) throws SQLException {
	    return this.transactionDAO.updateTransaction(transactionBean);
	  }
	  
	  
	  //delete Transaction
	  @RequestMapping(method = {RequestMethod.POST}, value = {"/deleteTransaction"})
	  @CrossOrigin(origins = "http://localhost:4200")
	  public List<TransactionBean> deleteTransaction(@RequestBody TransactionBean transactionBean) throws SQLException {
	    return this.transactionDAO.deleteTransaction(transactionBean);
	  }
}

