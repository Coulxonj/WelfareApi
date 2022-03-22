package com.jane.welfare.Contribution;

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

public class ContributionDAO {
	 PreparedStatement cst = null;
	  
	  Connection conn = null;
	  @Autowired 
	  DataSource dataSource;
	  
	  //Get contribution
	  public List<ContributionBean> fetchContribution() throws SQLException {
		    String sqlQuery = "SELECT * FROM contribution";
		    List<ContributionBean> contribution = new ArrayList<>();
		    try {
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sqlQuery);
		      ResultSet rs = this.cst.executeQuery();
		      while (rs.next()) {
		    	 ContributionBean fetch = new ContributionBean();
		        fetch.setContributionId(rs.getInt("contribution_Id"));
		        fetch.setContributionMemberId(rs.getInt("contribution_member_id"));
		        fetch.setContributionYear(rs.getInt("contribution_year"));
		        fetch.setContributionJan(rs.getInt("contribution_jan"));
		        fetch.setContributionFeb(rs.getInt("contribution_feb"));
		        fetch.setContributionMar(rs.getInt("contribution_mar"));
		        fetch.setContributionApr(rs.getInt("contribution_apr"));
		        fetch.setContributionMay(rs.getInt("contribution_may"));
		        fetch.setContributionJun(rs.getInt("contribution_jun"));
		        fetch.setContributionJul(rs.getInt("contribution_jul"));
		        fetch.setContributionAug(rs.getInt("contribution_aug"));
		        fetch.setContributionSep(rs.getInt("contribution_sep"));
		        fetch.setContributionOct(rs.getInt("contribution_oct"));
		        fetch.setContributionNov(rs.getInt("contribution_nov"));
		        fetch.setContributionDec(rs.getInt("contribution_dec"));
		        contribution.add(fetch);
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    }  
		    return contribution; 
		    
		  }
	  
	  //create contribution
	  public List<ContributionBean> createcontribution(ContributionBean contributionBean) throws SQLException {
		    String sql = "INSERT INTO contribution(contribution_id,contribution_member_id, contribution_year, contribution_jan,contribution_feb,contribution_mar,contribution_apr,contribution_may,contribution_jun,contribution_jul,contribution_aug,contribution_sep,contribution_oct,contribution_nov,contribution_dec)"
		    + " VALUES ( "+ getNextPrimaryKey() +",'"+ contributionBean.getContributionMemberId()+"','"+ contributionBean.getContributionYear()+"','"+ contributionBean.getContributionJan()+"','"+ contributionBean.getContributionFeb()+"','"+ contributionBean.getContributionMar()+"','"+ contributionBean.getContributionApr()+"','"+ contributionBean.getContributionMay()+"','"+ contributionBean.getContributionJun()+"','"+ contributionBean.getContributionJul()+"','"+ contributionBean.getContributionAug()+"','"+ contributionBean.getContributionSep()+"','"+ contributionBean.getContributionOct()+"','"+ contributionBean.getContributionNov()+"','"+ contributionBean.getContributionDec()+"')";
		    try { 
		      this.conn = this.dataSource.getConnection();
		      this.cst = this.conn.prepareStatement(sql);
		      this.cst.execute();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      this.conn.close();
		    } 
		    return fetchContribution();
		  }
	  
	  
	  //getting the next primary key 
	  public int getNextPrimaryKey() throws SQLException {
		    String column_name = "contribution_id";
		    String table_name = "contribution";
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
	   
	//update contribution
	  public List<ContributionBean> updateContribution(ContributionBean contributionBean) throws SQLException {
		    String sql = "update contribution set contribution_id='" + contributionBean.getContributionId()  + "',contribution_member_id=" + contributionBean.getContributionId()+  
		      " where contribution_id=" + contributionBean.getContributionId();
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
		    return fetchContribution();
		  } 
	  
	  
	  //delete contribution
	  public List<ContributionBean> deleteContribution(ContributionBean contributionBean) throws SQLException {
	    String sql = "DELETE FROM contribution WHERE  contribution_id=" + contributionBean.getContributionId();
	    try {
	      this.conn = this.dataSource.getConnection();
	      this.cst = this.conn.prepareStatement(sql);
	      this.cst.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      this.conn.close();
	    } 
	    return fetchContribution();
	    
	  }
		  
}


