package org.interfaceDao;

import java.util.List;

import org.entity.User;

/**
 * 管理员操作接口
 * @author Administrator
 *
 */
public interface ManagerDao {
	/**
	 * 管理员登陆
	 * @param magId
	 * @param magPassword
	 * @return
	 */
	public User magLogin(String magName,String magPassword,String identity);
	public int updateReader(User manager);
	public int deleteManager(int magId);
	public List<User> queryManager();
	public User queryManagerById(int magId);
}
