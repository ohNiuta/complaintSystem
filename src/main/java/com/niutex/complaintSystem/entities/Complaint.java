package com.niutex.complaintSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaints")
public class Complaint {
	
	@Id
	@Column(name="id")
	private Integer complaintId;
	
	@Column(name="message")
	private String complaintMessage;
	
	@Column(name="sender_Name")
	private String senderName;
	
	@Column(name="sender_Email")
	private String senderEmail;

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintMessage() {
		return complaintMessage;
	}

	public void setComplaintMessage(String complaintMessage) {
		this.complaintMessage = complaintMessage;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Complaint() {
		super();
	}

	public Complaint(Integer complaintId, String complaintMessage, String senderName, String senderEmail) {
		super();
		this.complaintId = complaintId;
		this.complaintMessage = complaintMessage;
		this.senderName = senderName;
		this.senderEmail = senderEmail;
	}
	
	 

}
