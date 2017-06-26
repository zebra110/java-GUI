package org.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import org.entity.Readers;
import org.impl.ReaderDaoImpl;
import org.interfaceDao.ReaderDao;
import org.util.IOHelper;

/**
 * 
 *  处理客户端请求的线程类
 * @author Administrator
 *
 */
public class LibraryServerThread extends Thread {

	ReaderDao readerDao = new ReaderDaoImpl();
	
	private Socket socket ;
	
	public LibraryServerThread(Socket s) {
		// TODO Auto-generated constructor stub
		
		this.socket = s ;
	}
	
	public void	 run() {
		
		BufferedReader br = null ; //接受来自客户端的学号
		ObjectOutputStream oos = null ; //返回查询的结果
		
		try {
			//接受来自客户端的学号信息
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			//准备发送 返回数据
			oos = new  ObjectOutputStream(socket.getOutputStream());
			while(true){
				//接受读者号
				String readersNo = br.readLine();
				System.out.println("收到读者号：" + readersNo);
				
				//根据学号查询成绩
				Readers readers = null ;
				if(readersNo != null){
					
					 readers = readerDao.queryReaderById(Integer.parseInt(readersNo));
					 System.out.println("zhaodaoletushu"+ readers);
					
					
				}
				//把结果输出至客户端
				oos.writeObject(readers);
				oos.flush();  //真正写出去了
			}
		} catch (Exception e) {
			// TODO: handle exception
			IOHelper.outputException("客户端关闭了，无法连接服务器");
		}
	}
}
