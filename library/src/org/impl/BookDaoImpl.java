package org.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.BookInfo;
import org.interfaceDao.BookDao;

public class BookDaoImpl extends DBUtil implements BookDao {

	@Override
	public int addBookInfo(BookInfo book) {
		String sql = "insert into tbl_bookInfo values(?,?,?,?,?,?,?)";
		Object[] params = {book.getBookId(),book.getBookName(),
				book.getBookType(),book.getBookWriter(),
				book.getPublish(),book.getPublicDate(),book.getBookPrice()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteBookInfo(int bookId) {
		String sql = "delete from tbl_bookInfo where bookId=? ";
		Object[] params = {bookId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<BookInfo> queryBookInfo() {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql= "select * from tbl_bookInfo";
		try {
			rs = super.executeQuery(sql, null);
			while(rs.next()){
				BookInfo book = new BookInfo();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookType(rs.getString(3));
				book.setBookWriter(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setPublicDate(rs.getString(6));
				book.setBookPrice(rs.getFloat(7));
				list.add(book);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return list;
	}

	@Override
	public BookInfo queryBookInfoById(int bookId) {
		String sql = "select * from tbl_bookInfo where bookId=?";
		Object[] params = {bookId};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				BookInfo book = new BookInfo();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookType(rs.getString(3));
				book.setBookWriter(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setPublicDate(rs.getString(6));
				book.setBookPrice(rs.getFloat(7));
				return book;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public BookInfo queryBookInfoByName(String bookName) {
		String sql = "select * from tbl_bookInfo where bookName=?";
		Object[] params = {bookName};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				BookInfo book = new BookInfo();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookType(rs.getString(3));
				book.setBookWriter(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setPublicDate(rs.getString(6));
				book.setBookPrice(rs.getFloat(7));
				return book;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

	@Override
	public int updateBookInfo(BookInfo book) {
		String sql = "update tbl_bookInfo set bookName=?,bookType=?,bookWriter=?,publish=?,publicDate=?,bookPrice=? where bookId=?";
		Object[] params = {book.getBookName(),book.getBookType(),book.getBookWriter(),book.getPublish(),book.getPublicDate(),book.getBookPrice(),book.getBookId()};
		return super.executeUpdate(sql, params);
	}

	
	public List<BookInfo> queryBookblurry(String Name) {
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from tbl_bookInfo where bookName like ? or bookWriter like ? ";
		Object[] params = {Name,Name};

		try {
			rs = super.executeQuery2(sql, params);
			while(rs.next()){
				BookInfo book = new BookInfo();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookType(rs.getString(3));
				book.setBookWriter(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setPublicDate(rs.getString(6));
				book.setBookPrice(rs.getFloat(7));
				list.add(book);
			}

				return list;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return null;
	}

}
