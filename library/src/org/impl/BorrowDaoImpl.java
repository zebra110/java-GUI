package org.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.Borrow;
import org.interfaceDao.BorrowDao;

public class BorrowDaoImpl extends DBUtil implements BorrowDao {

	@Override
	public int backBook(int borrowId) {
		String sql = "delete tbl_borrow where borrowId=?";
		Object[] params = {borrowId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int borrowBook(Borrow borrow) {
		String sql = "insert into tbl_borrow values(?,?,?,?)";
		Object[] params = {borrow.getReaderId(),borrow.getBookId(),borrow.getBorrowDate(),borrow.getBackDate()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Borrow> queryBorrow() {
		List<Borrow> list = new ArrayList<Borrow>();
		String sql = "select *from tbl_borrow";
		try {
			rs = super.executeQuery(sql, null);
			while(rs.next()){
				Borrow b = new Borrow();
				b.setBorrowId(rs.getInt(1));
				b.setReaderId(rs.getInt(2));
				b.setBookId(rs.getInt(3));
				b.setBorrowDate(rs.getString(4));
				b.setBackDate(rs.getString(5));
				list.add(b);
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
	public Borrow queryBorrowByDate(String borrowDate) {
		String sql = "select * from tbl_borrow where borrowDate=?";
		Object[] params = {borrowDate};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				Borrow b = new Borrow();
				b.setBorrowId(rs.getInt(1));
				b.setReaderId(rs.getInt(2));
				b.setBookId(rs.getInt(3));
				b.setBorrowDate(rs.getString(4));
				b.setBackDate(rs.getString(5));
				return b;
				
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
	public Borrow queryBorrowById(int borrowId) {
		String sql = "select * from tbl_borrow where borrowId=?";
		Object[] params = {borrowId};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				Borrow b = new Borrow();
				b.setBorrowId(rs.getInt(1));
				b.setReaderId(rs.getInt(2));
				b.setBookId(rs.getInt(3));
				b.setBorrowDate(rs.getString(4));
				b.setBackDate(rs.getString(5));
				return b;
				
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

	
	

}
