package com.jane.welfare.Transaction;

import java.sql.Date;

public class TransactionBean {

			private int  transactionId;
			private Date transactionDate;
			private int transactionMemberId;
			private int transactionSentAmount;
			private int transactionActualAmount;
			private String transactionRef;
			private String transactionPaymentMode;
			private String transactionDescription;
			
			//getters and setters
			public int getTransactionId() {
				return transactionId;
			}
			public void setTransactionId(int transactionId) {
				this.transactionId = transactionId;
			}
			public Date getTransactionDate() {
				return transactionDate;
			}
			public void setTransactionDate(Date transactionDate) {
				this.transactionDate = transactionDate;
			}
			public int getTransactionMemberId() {
				return transactionMemberId;
			}
			public void setTransactionMemberId(int transactionMemberId) {
				this.transactionMemberId = transactionMemberId;
			}
			public int getTransactionActualAmount() {
				return transactionActualAmount;
			}
			public void setTransactionActualAmount(int transactionActualAmount) {
				this.transactionActualAmount = transactionActualAmount;
			}
			public int getTransactionSentAmount() {
				return transactionSentAmount;
			}
			public void setTransactionSentAmount(int transactionSentAmount) {
				this.transactionSentAmount = transactionSentAmount;
			}
			public String getTransactionRef() {
				return transactionRef;
			}
			public void setTransactionRef(String transactionRef) {
				this.transactionRef = transactionRef;
			}
			public String getTransactionPaymentMode() {
				return transactionPaymentMode;
			}
			public void setTransactionPaymentMode(String transactionPaymentMode) {
				this.transactionPaymentMode = transactionPaymentMode;
			}
			public String getTransactionDescription() {
				return transactionDescription;
			}
			public void setTransactionDescription(String transactionDescription) {
				this.transactionDescription = transactionDescription;
			}
			
			
			
			
			
			
			
}



