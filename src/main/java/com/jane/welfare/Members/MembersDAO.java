package com.jane.welfare.Members;


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
public class MembersDAO {

	 PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get Members
	  public List<MembersBean> fetchMembers() throws SQLException {
		    String sqlQuery = "SELECT * FROM members";
		    List<MembersBean> members = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		    	  MembersBean fetch = new MembersBean();
		        fetch.setMemberId(rs.getInt("member_id"));
		        fetch.setMemberFullname(rs.getString("member_fullname"));
		        fetch.setMemberInceptionDate(rs.getDate("member_inception_date"));
		        fetch.setMemberDepartment(rs.getString("member_department"));
		        fetch.setMemberStaffno(rs.getString("member_staff_no"));
		        fetch.setMemberEmail(rs.getString("member_email"));
		        fetch.setMemberMobile(rs.getString("member_mobile"));
		        fetch.setMemberActive(rs.getString("member_active"));
		        members.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return members; 
		    
		  }
	  
	  //create members
		
	  public List<MembersBean> createmembers(MembersBean membersBean) throws SQLException {
		    String sql = "INSERT INTO members(member_id,member_fullname, member_inception_date, member_department, member_staff_no,member_email,member_mobile,member_active)"
		    + " VALUES ( "+ getNextPrimaryKey() +","
		    		+ "'"+ membersBean.getMemberFullname()+"',"
		    		+ "'"+ membersBean.getMemberInceptionDate()+"',"
		    		+ "'"+ membersBean.getMemberDepartment()+"',"
		    		+ "'"+ membersBean.getMemberStaffno()+"',"
		    		+ "'"+ membersBean.getMemberEmail()+"',"
		    		+ "'"+ membersBean.getMemberMobile()+"',"
		    		+ "'"+ membersBean.getMemberActive()+"',";
		    	
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchMembers();
		  }
	

	//getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "member_id";
		    String table_name = "members";
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
	   
	//update members
	  public List<MembersBean> updateMembers(MembersBean membersBean) throws SQLException {
		    String sql = "update members set member_id='" + membersBean.getMemberId()  
		    + "',member_fullname=" + membersBean.getMemberFullname()+  
		      " where member_id=" + membersBean.getMemberId();
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
		    return fetchMembers();
		    }
	  
	  
	  //delete Members
	  public List<MembersBean> deleteMembers(MembersBean membersBean) throws SQLException {
	    String sql = "DELETE FROM members WHERE  member_id=" + membersBean.getMemberId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchMembers();
	    
	  }

	}
		  


