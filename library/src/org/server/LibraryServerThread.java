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
 *  ����ͻ���������߳���
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
		
		BufferedReader br = null ; //�������Կͻ��˵�ѧ��
		ObjectOutputStream oos = null ; //���ز�ѯ�Ľ��
		
		try {
			//�������Կͻ��˵�ѧ����Ϣ
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			//׼������ ��������
			oos = new  ObjectOutputStream(socket.getOutputStream());
			while(true){
				//���ܶ��ߺ�
				String readersNo = br.readLine();
				System.out.println("�յ����ߺţ�" + readersNo);
				
				//����ѧ�Ų�ѯ�ɼ�
				Readers readers = null ;
				if(readersNo != null){
					
					 readers = readerDao.queryReaderById(Integer.parseInt(readersNo));
					 System.out.println("zhaodaoletushu"+ readers);
					
					
				}
				//�ѽ��������ͻ���
				oos.writeObject(readers);
				oos.flush();  //����д��ȥ��
			}
		} catch (Exception e) {
			// TODO: handle exception
			IOHelper.outputException("�ͻ��˹ر��ˣ��޷����ӷ�����");
		}
	}
}
