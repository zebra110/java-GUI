package org.interfaceDao;

import java.util.List;

import org.entity.BookInfo;


public interface BookDao {
	
	public int addBookInfo(BookInfo book);
	public int updateBookInfo(BookInfo book);
	public int deleteBookInfo(int bookId);
	public BookInfo queryBookInfoById(int bookId);
	public BookInfo queryBookInfoByName(String bookName);
	public List<BookInfo> queryBookblurry(String bookName);
	public List<BookInfo> queryBookInfo();
}
