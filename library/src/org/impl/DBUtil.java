package org.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBUtil {
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs= null;
	
	/**
	 * �������ݿⷽ��
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getCon() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="JDBC:mysql://localhost:3306/test1";

		String user="root"; String password="123";

		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	/**
	 * �ͷ���Դ����
	 */
	public void closeAll(){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{
			con = null;
			ps = null;
			rs = null;
		}
		
	}
	/**
	 * ����ɾ���ķ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql,Object[] params){
		try {
			con = this.getCon();//�������ݿ�
			ps = con.prepareStatement(sql);//����Ԥ�������
			//������������ȷ��ռλ���Ƿ����
			if(params != null && params.length != 0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return 0;
	}
	/**
	 * ��ѯ����
	 * @param sql
	 * @param params
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet executeQuery2(String sql,Object[] params) throws ClassNotFoundException, SQLException{
		con = this.getCon();
		ps = con.prepareStatement(sql);
		if(params != null && params.length != 0){
			System.out.println(params[0]);
			for(int i=0;i<params.length;i++){
			
				ps.setObject(i+1,"%"+params[i]+"%");
			}
		}
		return ps.executeQuery();
	}
	
	public ResultSet executeQuery(String sql,Object[] params) throws ClassNotFoundException, SQLException{
		con = this.getCon();
		ps = con.prepareStatement(sql);
		if(params != null && params.length != 0){
			System.out.println(params[0]);
			for(int i=0;i<params.length;i++){
			
				ps.setObject(i+1,params[i]);
			}
		}
		return ps.executeQuery();
	}
	
	
	
}
