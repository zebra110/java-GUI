package org.entity;

public class BookInfo {
	private int bookId;
	private String bookName;
	private String bookType;
	private String bookWriter;
	private String publish;
	private String publicDate;
	private float bookPrice;
	
	public BookInfo(){}
	
	public BookInfo(int bookId,String bookName, String bookType, String bookWriter,
			String publish, String publicDate, float bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookWriter = bookWriter;
		this.publish = publish;
		this.publicDate = publicDate;
		this.bookPrice = bookPrice;
	}
	public BookInfo(String bookName, String bookType, String bookWriter,
			String publish, String publicDate, float bookPrice) {
		super();
		
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookWriter = bookWriter;
		this.publish = publish;
		this.publicDate = publicDate;
		this.bookPrice = bookPrice;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

}
