package com.jane.welfare.Transaction;



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
public class TransactionDAO {
	 PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get Transaction
	  public List<TransactionBean> fetchTransaction() throws SQLException {
		    String sqlQuery = "SELECT * FROM transaction";
		    List<TransactionBean> transaction = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		    	  TransactionBean fetch = new TransactionBean();
		        fetch.setTransactionId(rs.getInt("transaction_id"));
		        fetch.setTransactionDate(rs.getDate("transaction_date"));
		        fetch.setTransactionMemberId(rs.getInt("transaction_member_id"));
		        fetch.setTransactionSentAmount(rs.getInt("transaction_sent_amount"));
		        fetch.setTransactionActualAmount(rs.getInt("transaction_actual_amount"));
		        fetch.setTransactionRef(rs.getString("transaction_ref"));
		        fetch.setTransactionPaymentMode(rs.getString("transaction_payment_mode"));
		        fetch.setTransactionDescription(rs.getString("transaction_description"));
		        transaction.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return transaction; 
		    
		  }
	  
	  //create Transaction
		
	  public List<TransactionBean> createtransaction(TransactionBean transactionBean) throws SQLException {
		    String sql = "INSERT INTO transaction(transaction_id, transaction_date, transaction_member_id, transaction_sent_amoumt, transaction_actual_amount,transaction_ref, transaction_paymentmode, transaction_description)"
		    + " VALUES ( "+ getNextPrimaryKey() +","
		    		+ "'"+ transactionBean.getTransactionDate()+"',"
		    		+ "'"+ transactionBean.getTransactionMemberId()+"',"
		    		+ "'"+ transactionBean.getTransactionSentAmount()+"',"
		    		+ "'"+ transactionBean.getTransactionActualAmount()+"',"
		    		+ "'"+ transactionBean.getTransactionRef()+"',"
		    		+ "'"+ transactionBean.getTransactionPaymentMode()+"',"
		    		+ "'"+ transactionBean.getTransactionDescription()+"',";
		    	
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchTransaction();
		  }
	

	//getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "transaction_id";
		    String table_name = "transaction";
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
	   
	//update Transaction
	  public List<TransactionBean> updateTransaction(TransactionBean transactionBean) throws SQLException {
		    String sql = "update transaction set transaction_id='" + transactionBean.getTransactionId()  
		    + "',transaction_date=" + transactionBean.getTransactionDate()+  
		      " where transaction_id=" + transactionBean.getTransactionId();
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
		    return fetchTransaction();
		  } 
	  
	  
	  //delete Transaction
	  public List<TransactionBean> deleteTransaction(TransactionBean transactionBean) throws SQLException {
	    String sql = "DELETE FROM transaction WHERE  transaction_id=" + transactionBean.getTransactionId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchTransaction();
	    
	  }

	}
		  


