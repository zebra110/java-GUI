package org.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.util.IOHelper;

/**
 * 
 * 多线程的服务类
 * @author Administrator
 *
 */
public class Libraryserver extends Thread {

	//来自多个客户端的连接
	
	private List<Socket> sockets =  new ArrayList<Socket>();
	private ServerSocket server; //套接字的服务器
	
	public void run() {
		System.out.println("服务器启动.....");
		try {
			server =  new ServerSocket(8888);
			//监听来自客户端的连接请求
			while(true){
				
				Socket s = server.accept();
				sockets.add(s); //把客户端加入到连接列表中
				System.out.println("建立了与客户端的连接.....");
				//处理连接请求的服务器
				new LibraryServerThread(s).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			server = null;
			System.out.println("服务器关闭...");
		}
	}
	
	
	//管理员关闭服务器
	public void close() {
		try {
			if(server != null){
				//关闭所有已打开的Socket
				for(Socket s : sockets){
					s.close();
				}
				server.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			IOHelper.outputException(e.getMessage());
		}
	}
}
