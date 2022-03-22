package com.jane.welfare.Expenses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpensesDAO {
	 PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get expenses
	  public List<ExpensesBean> fetchExpenses() throws SQLException {
		    String sqlQuery = "SELECT * FROM expenses";
		    List<ExpensesBean> expenses = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		    	  ExpensesBean fetch = new ExpensesBean();
		        fetch.setExpenseId(rs.getInt("Expense_id"));
		        fetch.setExpenseDate(rs.getDate("Expense_date"));
		        fetch.setExpenseDesc(rs.getString("Expense_desc"));
		        fetch.setExpenseTotalCost(rs.getInt("Expense_total_cost"));
		        expenses.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return expenses; 
		    
		  }
	  
	  //create expenses
		
	  public List<ExpensesBean> createexpenses(ExpensesBean expensesBean) throws SQLException {
		    String sql = "INSERT INTO expenses(Expense_id, Expense_date, Expense_desc,Expense_total_cost)"
		    + " VALUES ( "+ getNextPrimaryKey() +","
		    		+ "'"+ expensesBean.getExpenseDate()+"',"
		    		+ "'"+ expensesBean.getExpenseDesc()+"',"
		    		+ "'"+ expensesBean.getExpenseTotalCost()+"',";
		    	
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchExpenses();
		  }
	

	//getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "Expense_id";
		    String table_name = "expenses";
		    String sql = "SELECT MAX(" + column_name + ") FROM " + table_name;
		    int primary = 0;
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		        primary = rs.getInt(1);
		        primary++;
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return primary;
		  }
	   
	//update expenses
	  public List<ExpensesBean> updateExpenses(ExpensesBean expensesBean) throws SQLException {
		    String sql = "update expenses set Expense_id='" + expensesBean.getExpenseId()  
		    + "',expenses_date=" + expensesBean.getExpenseDate()+  
		      " where expense_id=" + expensesBean.getExpenseId();
		    System.out.println(sql);
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchExpenses();
		  } 
	  
	  
	  //delete contribution
	  public List<ExpensesBean> deleteExpense(ExpensesBean expensesBean) throws SQLException {
	    String sql = "DELETE FROM expenses WHERE  Expense_id=" + expensesBean.getExpenseId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchExpenses();
	    
	  }

	}
		  


