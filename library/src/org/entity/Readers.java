package org.entity;

import java.io.Serializable;

public class Readers implements Serializable {
	private int readerId;
	private String readerName;
	private int readerAge;
	private String readerSex;
	private String readerPhone;
	private String startDate;
	private String endDate;
	
	public Readers(){}
	
	public Readers(int readerId, String readerName, int readerAge,
			String readerSex, String readerPhone, String startDate,
			String endDate) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.readerAge = readerAge;
		this.readerSex = readerSex;
		this.readerPhone = readerPhone;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Readers(String readerName, int readerAge, String readerSex,
			String readerPhone, String startDate, String endDate) {
		super();
		this.readerName = readerName;
		this.readerAge = readerAge;
		this.readerSex = readerSex;
		this.readerPhone = readerPhone;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public int getReaderAge() {
		return readerAge;
	}
	public void setReaderAge(int readerAge) {
		this.readerAge = readerAge;
	}
	public String getReaderPhone() {
		return readerPhone;
	}
	public void setReaderPhone(String readerPhone) {
		this.readerPhone = readerPhone;
	}
	public String getReaderSex() {
		return readerSex;
	}
	public void setReaderSex(String readerSex) {
		this.readerSex = readerSex;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
