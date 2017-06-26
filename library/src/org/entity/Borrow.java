package org.entity;

public class Borrow {
	private int borrowId;
	private int readerId;
	private int bookId;
	private String borrowDate;
	private String backDate;
	
	public Borrow(){}
	
	public Borrow(int borrowId, int readerId, int bookId, String borrowDate,
			String backDate) {
		super();
		this.borrowId = borrowId;
		this.readerId = readerId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
	}

	public Borrow(int readerId, int bookId, String borrowDate, String backDate) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	

}
