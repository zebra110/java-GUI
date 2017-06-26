package org.entity;

public class User {
	private int magId;
	private String magName;//读者的用户名是其借书证号
	private String magPassword;
	private String identity;
	
	
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public User(){}
	
	public User(int magId, String magName, String magPassword) {
		super();
		this.magId = magId;
		this.magName = magName;
		this.magPassword = magPassword;
	}

	public User(String magName, String magPassword) {
		super();
		this.magName = magName;
		this.magPassword = magPassword;
	}
	public int getMagId() {
		return magId;
	}
	public void setMagId(int magId) {
		this.magId = magId;
	}
	public String getMagName() {
		return magName;
	}
	public void setMagName(String magName) {
		this.magName = magName;
	}
	public String getMagPassword() {
		return magPassword;
	}
	public void setMagPassword(String magPassword) {
		this.magPassword = magPassword;
	}

}
