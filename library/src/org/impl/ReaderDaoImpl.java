package org.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.Readers;
import org.interfaceDao.ReaderDao;

public class ReaderDaoImpl extends DBUtil implements ReaderDao {

	@Override
	public int addReader(Readers reader) {
		String sql = "insert into tbl_reader values(?,?,?,?,?,?)";
		Object[] params = {reader.getReaderName(),reader.getReaderAge(),reader.getReaderSex(),reader.getReaderPhone(),reader.getStartDate(),reader.getEndDate(),reader.getReaderId()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public int deleteReader(int readerId) {
		String sql = "delete from tbl_reader where readerId=? ";
		Object[] params = {readerId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<Readers> queryReader() {
		List<Readers> list = new ArrayList<Readers>();
		String sql = "select * from tbl_reader";
		try {
			rs = super.executeQuery(sql, null);
			while(rs.next()){
				Readers reader = new Readers();
				reader.setReaderId(rs.getInt(1));
				reader.setReaderName(rs.getString(2));
				reader.setReaderAge(rs.getInt(3));
				reader.setReaderSex(rs.getString(4));
				reader.setReaderPhone(rs.getString(5));
				reader.setStartDate(rs.getString(6));
				reader.setEndDate(rs.getString(7));
				list.add(reader);
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
	public Readers queryReaderById(int readerId) {
		String sql = "select * from tbl_reader where readerId=?";
		Object[] params ={readerId};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				Readers reader = new Readers();
				reader.setReaderId(rs.getInt(1));
				reader.setReaderName(rs.getString(2));
				reader.setReaderAge(rs.getInt(3));
				reader.setReaderSex(rs.getString(4));
				reader.setReaderPhone(rs.getString(5));
				reader.setStartDate(rs.getString(6));
				reader.setEndDate(rs.getString(7));
				return reader;
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
	public int updateReader(Readers reader) {
		String sql = "update tbl_reader set readerName=?,readerAge=?,readerSex=?,readerPhone=?,startDate=?,endDate=? where readerId=?";
		Object[] params = {reader.getReaderName(),reader.getReaderAge(),reader.getReaderSex(),reader.getReaderPhone(),reader.getStartDate(),reader.getEndDate(),reader.getReaderId()};
		return super.executeUpdate(sql, params);
	}

}
