package org.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.User;

import org.interfaceDao.ManagerDao;


public class ManagerDaoImpl extends DBUtil implements ManagerDao {

	@Override
	public User magLogin(String magName, String magPassword,String identity) {
		User mag = null;	//在此处设置mag为空
		String sql = "select magName,magPassword from tbl_manager where magName=? and magPassword=? and magIdentify=?";
		Object[] params = {magName,magPassword,identity};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				mag = new User();
				mag.setMagId(rs.getInt(1));
				mag.setMagName(rs.getString(2));
				
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
		
		return mag;
	}

	@Override
	public int deleteManager(int magId) {
		String sql = "delete tbl_Manager where magId=? ";
		Object[] params = {magId};
		return super.executeUpdate(sql, params);
	}

	@Override
	public List<User> queryManager() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from tbl_manager";
		try {
			rs = super.executeQuery(sql, null);
			while(rs.next()){
				User mag = new User();
				mag.setMagId(rs.getInt(1));
				mag.setMagName(rs.getString(2));
				mag.setMagPassword(rs.getString(3));
				list.add(mag);
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
	public int updateReader(User manager) {
		String sql = "update tbl_manager set magName=?,magPassword=? where id=?";
		Object[] params = {manager.getMagName(),manager.getMagPassword(),manager.getMagId()};
		return super.executeUpdate(sql, params);
	}

	@Override
	public User queryManagerById(int magId) {
		String sql = "select * from tbl_manager where id=?";
		Object[] params = {magId};
		try {
			rs = super.executeQuery(sql, params);
			if(rs.next()){
				User mag = new User();
				mag.setMagId(rs.getInt(1));
				mag.setMagName(rs.getString(2));
				mag.setMagPassword(rs.getString(3));
				return mag;
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
