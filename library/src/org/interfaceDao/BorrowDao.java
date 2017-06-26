package org.interfaceDao;

import java.util.List;

import org.entity.Borrow;

public interface BorrowDao {
	
	public List<Borrow> queryBorrow();
	public Borrow queryBorrowByDate(String borrowDate);
	public Borrow queryBorrowById(int borrowId);
	public int borrowBook(Borrow borrow);
	public int backBook(int borrowId);
	
}
