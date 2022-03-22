package com.jane.welfare.Users;

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
public class UsersDAO {
	 PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get Users
	  public List<UsersBean> fetchUsers() throws SQLException {
		    String sqlQuery = "SELECT * FROM users";
		    List<UsersBean> users = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		    	  UsersBean fetch = new UsersBean();
		        fetch.setUserId(rs.getInt("user_id"));
		        fetch.setUserName(rs.getString("user_name"));
		        fetch.setUserpassword(rs.getString("user_password"));
		        fetch.setUserrank(rs.getString("user_rank"));
		        users.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return users; 
		    
		  }
	  
	  //create Users
		
	  public List<UsersBean> createusers(UsersBean usersBean) throws SQLException {
		    String sql = "INSERT INTO users(user_id, user_name, user_password, user_rank)"
		    + " VALUES ( "+ getNextPrimaryKey() +","
		    		+ "'"+ usersBean.getUserName()+"',"
		    		+ "'"+ usersBean.getUserPassword()+"',"
		    		+ "'"+ usersBean.getUserRank()+"',";
		    	
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchUsers();
		  }
	

	//getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "user_id";
		    String table_name = "users";
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
	   
	//update users
	  public List<UsersBean> updateUsers(UsersBean usersBean) throws SQLException {
		    String sql = "update users set user_id='" + usersBean.getUserId()  
		    + "',user_name=" + usersBean.getUserName()+  
		      " where user_id=" + usersBean.getUserId();
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
		    return fetchUsers();
		  } 
	  
	  
	  //delete users
	  public List<UsersBean> deleteUsers(UsersBean usersBean) throws SQLException {
	    String sql = "DELETE FROM users WHERE  user_id=" + usersBean.getUserId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchUsers();
	    
	  }

	}
		  


