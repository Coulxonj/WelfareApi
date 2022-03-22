package com.jane.welfare.Members;

import java.sql.Date;

public class MembersBean {



			private int  memberId;
			private String memberFullname;
			private Date memberInceptionDate;
			private String memberDepartment;
			private String memberStaffno;
			private String memberEmail;
			private String memberMobile;
			private String memberActive;
			
	//getters and setters
			public int getMemberId() {
				return memberId;
			}
			public void setMemberId(int memberId) {
				this.memberId = memberId;
			}
			public String getMemberFullname() {
				return memberFullname;
			}
			public void setMemberFullname(String memberFullname) {
				this.memberFullname = memberFullname;
			}
			public Date getMemberInceptionDate() {
				return memberInceptionDate;
			}
			public void setMemberInceptionDate(Date memberInceptionDate) {
				this.memberInceptionDate = memberInceptionDate;
			}
			public String getMemberDepartment() {
				return memberDepartment;
			}
			public void setMemberDepartment(String memberDepartment) {
				this.memberDepartment = memberDepartment;
			}
			public String getMemberEmail() {
				return memberEmail;
			}
			public void setMemberEmail(String memberEmail) {
				this.memberEmail = memberEmail;
			}
			public String getMemberStaffno() {
				return memberStaffno;
			}
			public void setMemberStaffno(String memberStaffno) {
				this.memberStaffno = memberStaffno;
			}
			public String getMemberMobile() {
				return memberMobile;
			}
			public void setMemberMobile(String memberMobile) {
				this.memberMobile = memberMobile;
			}
			public String getMemberActive() {
				return memberActive;
			}
			public void setMemberActive(String memberActive) {
				this.memberActive = memberActive;
			}
			
			
			
			
}


