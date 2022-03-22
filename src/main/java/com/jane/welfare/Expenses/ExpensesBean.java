package com.jane.welfare.Expenses;

import java.sql.Date;

public class ExpensesBean {

			private int  expenseId;
			private Date expenseDate;
			private String expenseDesc;
			private int expenseTotalCost;
			
			//getters and setters
			
			public int getExpenseId() {
				return expenseId;
			}
			
			
			public void setExpenseId(int expenseId) {
				this.expenseId = expenseId;
			}
			
			public Date getExpenseDate() {
				return expenseDate;
			}

			public void setExpenseDate(Date expenseDate) {
				this.expenseDate = expenseDate;
			}

			public String getExpenseDesc() {
				return expenseDesc;
			}

			public void setExpenseDesc(String expenseDesc) {
				this.expenseDesc = expenseDesc;
			}

			public int getExpenseTotalCost() {
				return expenseTotalCost;
			}

			public void setExpenseTotalCost(int expenseTotalCost) {
				this.expenseTotalCost = expenseTotalCost;
			}
			
}


