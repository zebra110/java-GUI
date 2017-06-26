package org.interfaceDao;

import java.util.List;

import org.entity.User;

/**
 * ����Ա�����ӿ�
 * @author Administrator
 *
 */
public interface ManagerDao {
	/**
	 * ����Ա��½
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
