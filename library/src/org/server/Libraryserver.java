package org.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.util.IOHelper;

/**
 * 
 * ���̵߳ķ�����
 * @author Administrator
 *
 */
public class Libraryserver extends Thread {

	//���Զ���ͻ��˵�����
	
	private List<Socket> sockets =  new ArrayList<Socket>();
	private ServerSocket server; //�׽��ֵķ�����
	
	public void run() {
		System.out.println("����������.....");
		try {
			server =  new ServerSocket(8888);
			//�������Կͻ��˵���������
			while(true){
				
				Socket s = server.accept();
				sockets.add(s); //�ѿͻ��˼��뵽�����б���
				System.out.println("��������ͻ��˵�����.....");
				//������������ķ�����
				new LibraryServerThread(s).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			server = null;
			System.out.println("�������ر�...");
		}
	}
	
	
	//����Ա�رշ�����
	public void close() {
		try {
			if(server != null){
				//�ر������Ѵ򿪵�Socket
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
