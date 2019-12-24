package com.mynrg.dto;

import java.util.ArrayList;
import java.util.List;



public class ProductionIssueDataBean {
	
	public String clientname; 
	public String issuenotes;
	public String priority;
	public String country;
	public String team;
	public String currentuser;
	public String issueStatus;
	public String product;
	public String IssueNumber;
	
	public int Newcount;
	public int Pendingcount;
	public int Inprogresscount;
	public int Completecount;
	public int Closedcount;
	public int Clarificationcount;
	public int Cancelcount;
	
	
	public int getNewcount() {
		return Newcount;
	}
	public void setNewcount(int newcount) {
		Newcount = newcount;
	}
	public int getPendingcount() {
		return Pendingcount;
	}
	public void setPendingcount(int pendingcount) {
		Pendingcount = pendingcount;
	}
	public int getInprogresscount() {
		return Inprogresscount;
	}
	public void setInprogresscount(int inprogresscount) {
		Inprogresscount = inprogresscount;
	}
	public int getCompletecount() {
		return Completecount;
	}
	public void setCompletecount(int completecount) {
		Completecount = completecount;
	}
	public int getClosedcount() {
		return Closedcount;
	}
	public void setClosedcount(int closedcount) {
		Closedcount = closedcount;
	}
	public int getClarificationcount() {
		return Clarificationcount;
	}
	public void setClarificationcount(int clarificationcount) {
		Clarificationcount = clarificationcount;
	}
	public int getCancelcount() {
		return Cancelcount;
	}
	public void setCancelcount(int cancelcount) {
		Cancelcount = cancelcount;
	}
	public String getIssueNumber() {
		return IssueNumber;
	}
	public void setIssueNumber(String issueNumber) {
		IssueNumber = issueNumber;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	public String getCurrentuser() {
		return currentuser;
	}
	public void setCurrentuser(String currentuser) {
		this.currentuser = currentuser;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getIssuenotes() {
		return issuenotes;
	}
	public void setIssuenotes(String issuenotes) {
		this.issuenotes = issuenotes;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
}
