/**
 * 
 */
package org.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.entity.Readers;
import org.util.IOHelper;


public class ClientFrame extends JFrame implements ActionListener{

	private JTextField jtfReaderNo;    //读者号
	private JTextField jtfIP;     //ip地址
	private JButton jbtQuery;
	private JButton jbtConnect;
	private JButton jbtClose;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	
	private Socket  socket;    //网络连接
	private ObjectInputStream  ois = null  ;  //接受数据
 	private PrintWriter  pw = null;  //发送数据
	
	public ClientFrame() {
		
		
		this.setTitle("读者信息查询");
		
		JPanel jPanel1 = new JPanel();		
		jtfIP = new JTextField(6);
		jtfIP.setText("127.0.0.1");
		jbtConnect = new JButton("连接");
		jbtClose = new JButton("关闭");
		jPanel1.add(new JLabel("IP地址："));
		jPanel1.add(jtfIP);
		jPanel1.add(jbtConnect);
		jPanel1.add(jbtClose);
		getContentPane().add(jPanel1, BorderLayout.NORTH);
		
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new BorderLayout());
		JPanel jPanel3 = new JPanel();
		jtfReaderNo = new JTextField(15);
		jtfReaderNo.setText("");
		jbtQuery = new JButton("查询");
		jPanel3.add(new JLabel("读者号："));
		jPanel3.add(jtfReaderNo);
		jPanel3.add(jbtQuery);
		jPanel2.add(jPanel3, BorderLayout.NORTH);
		getContentPane().add(jPanel2, BorderLayout.CENTER);
	
		TableModel jTable1Model = 
				new DefaultTableModel(new String[0][0] ,new String[] { "姓名","年龄", "性别","联系电话" });
		jTable1 = new JTable();
		jTable1.setModel(jTable1Model);
		jScrollPane1 = new JScrollPane(jTable1);
		jPanel2.add(jScrollPane1, BorderLayout.CENTER);		

		jbtQuery.setEnabled(false);
		jbtConnect.setEnabled(true);
		jbtClose.setEnabled(false);
		jbtQuery.addActionListener(this);	
		jbtConnect.addActionListener(this);
		jbtClose.addActionListener(this);
		
		this.setSize(320, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtConnect){
			connect();
		}else	if(e.getSource()==jbtQuery){
			queryScore();
		}else if(e.getSource()==jbtClose){
			exit();
		}
		
	}
	private  void connect(){
		if(socket!=null)
			return;  //已经存在连接了 就不要再次连接了
		
		try {
			//套接字 
            socket = new Socket(jtfIP.getText(),8888);
            ois = new ObjectInputStream(socket.getInputStream());  //创建socket对象 输入对象
            
            pw = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "连接服务器失败");
			
			jbtQuery.setEnabled(false);
			jbtConnect.setEnabled(true);
			
			jbtClose.setEnabled(false);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "连接服务器成功");
		
		jbtQuery.setEnabled(true);
		jbtConnect.setEnabled(false);
		
		jbtClose.setEnabled(true);  //可以关闭
	}
	private void exit(){
		try {
			socket.close();    //回收资源关闭套接字
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		socket = null;  // JAVA的垃圾回收机制 对象为null 会被回收   等待java的 虚拟机回收资源
		jbtQuery.setEnabled(false);
		jbtConnect.setEnabled(true);
		jbtClose.setEnabled(false);
	}
	private void queryScore(){
							
		if(jtfReaderNo.getText().length() == 0 ){
			JOptionPane.showMessageDialog(null, "请输入学号");
			return;
		}
		
		Readers readers = null;  //准备用来接受服务器的成绩对象列表
		try {

			//1. 把学号发给服务器
			
			pw.println(jtfReaderNo.getText());  //把学号送给服务器
			pw.flush();  //强制刷出
			
			//2.接受服务器发来的结果
			
			readers = (Readers)ois.readObject();  //接受来自服务器的数据
			
			
			
			
			
			//3.将结果显示
			
			DefaultTableModel tm = new DefaultTableModel(
					new String[0][0],
					new String[]{ "姓名","年龄", "性别","联系电话" });
			jTable1.setModel(tm);
			
			if(readers == null){
				return; //没有查到数据
			}
			
				
//				int readersNo = readers.getReaderId();
				String readersName = readers.getReaderName();
				int readerAge = readers.getReaderAge();
				String readerSex = readers.getReaderSex();
				String readerPhone = readers.getReaderPhone();
				tm.addRow(new String[]{readersName , readerAge+"" , readerSex,readerPhone});
			
		} catch (Exception e) {
			// TODO: handle exception
			IOHelper.outputException(e.getMessage());
			JOptionPane.showMessageDialog(null,"发送数据失败，请重新连接服务器");
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				socket = null;  // JAVA的垃圾回收机制 对象为null 会被回收   等待java的 虚拟机回收资源
				jbtQuery.setEnabled(false);
				jbtConnect.setEnabled(true);
				jbtClose.setEnabled(false);
			}
		}
		
	}

}
