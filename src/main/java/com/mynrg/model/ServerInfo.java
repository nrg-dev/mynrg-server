package com.mynrg.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the server_info database table.
 * 
 */
@Entity
@Table(name="server_info")
@NamedQuery(name="ServerInfo.findAll", query="SELECT s FROM ServerInfo s")
public class ServerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SERVER_INFO_ID")
	private int serverInfoId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="CREATED_PERSON")
	private String createdPerson;

	@Column(name="DNS_NAME")
	private String dnsName;

	@Column(name="NAME")
	private String name;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="PRIVATE_HOSTNAME")
	private String privateHostname;

	@Column(name="PUBLIC_HOSTNAME")
	private String publicHostname;

	@Column(name="STATUS")
	private String status;

	@Column(name="UPDATED_PERSON")
	private String updatedPerson;

	@Temporal(TemporalType.DATE)
	@Column(name="`UPDATED-DATE`")
	private Date updatedDate;

	@Column(name="USER_NAME")
	private String userName;

	public ServerInfo() {
	}

	public int getServerInfoId() {
		return this.serverInfoId;
	}

	public void setServerInfoId(int serverInfoId) {
		this.serverInfoId = serverInfoId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedPerson() {
		return this.createdPerson;
	}

	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}

	public String getDnsName() {
		return this.dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivateHostname() {
		return this.privateHostname;
	}

	public void setPrivateHostname(String privateHostname) {
		this.privateHostname = privateHostname;
	}

	public String getPublicHostname() {
		return this.publicHostname;
	}

	public void setPublicHostname(String publicHostname) {
		this.publicHostname = publicHostname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedPerson() {
		return this.updatedPerson;
	}

	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}

	public Date getUpdated_date() {
		return this.updatedDate;
	}

	public void setUpdated_date(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}