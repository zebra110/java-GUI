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

	private JTextField jtfReaderNo;    //���ߺ�
	private JTextField jtfIP;     //ip��ַ
	private JButton jbtQuery;
	private JButton jbtConnect;
	private JButton jbtClose;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	
	private Socket  socket;    //��������
	private ObjectInputStream  ois = null  ;  //��������
 	private PrintWriter  pw = null;  //��������
	
	public ClientFrame() {
		
		
		this.setTitle("������Ϣ��ѯ");
		
		JPanel jPanel1 = new JPanel();		
		jtfIP = new JTextField(6);
		jtfIP.setText("127.0.0.1");
		jbtConnect = new JButton("����");
		jbtClose = new JButton("�ر�");
		jPanel1.add(new JLabel("IP��ַ��"));
		jPanel1.add(jtfIP);
		jPanel1.add(jbtConnect);
		jPanel1.add(jbtClose);
		getContentPane().add(jPanel1, BorderLayout.NORTH);
		
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new BorderLayout());
		JPanel jPanel3 = new JPanel();
		jtfReaderNo = new JTextField(15);
		jtfReaderNo.setText("");
		jbtQuery = new JButton("��ѯ");
		jPanel3.add(new JLabel("���ߺţ�"));
		jPanel3.add(jtfReaderNo);
		jPanel3.add(jbtQuery);
		jPanel2.add(jPanel3, BorderLayout.NORTH);
		getContentPane().add(jPanel2, BorderLayout.CENTER);
	
		TableModel jTable1Model = 
				new DefaultTableModel(new String[0][0] ,new String[] { "����","����", "�Ա�","��ϵ�绰" });
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
			return;  //�Ѿ����������� �Ͳ�Ҫ�ٴ�������
		
		try {
			//�׽��� 
            socket = new Socket(jtfIP.getText(),8888);
            ois = new ObjectInputStream(socket.getInputStream());  //����socket���� �������
            
            pw = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "���ӷ�����ʧ��");
			
			jbtQuery.setEnabled(false);
			jbtConnect.setEnabled(true);
			
			jbtClose.setEnabled(false);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "���ӷ������ɹ�");
		
		jbtQuery.setEnabled(true);
		jbtConnect.setEnabled(false);
		
		jbtClose.setEnabled(true);  //���Թر�
	}
	private void exit(){
		try {
			socket.close();    //������Դ�ر��׽���
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		socket = null;  // JAVA���������ջ��� ����Ϊnull �ᱻ����   �ȴ�java�� �����������Դ
		jbtQuery.setEnabled(false);
		jbtConnect.setEnabled(true);
		jbtClose.setEnabled(false);
	}
	private void queryScore(){
							
		if(jtfReaderNo.getText().length() == 0 ){
			JOptionPane.showMessageDialog(null, "������ѧ��");
			return;
		}
		
		Readers readers = null;  //׼���������ܷ������ĳɼ������б�
		try {

			//1. ��ѧ�ŷ���������
			
			pw.println(jtfReaderNo.getText());  //��ѧ���͸�������
			pw.flush();  //ǿ��ˢ��
			
			//2.���ܷ����������Ľ��
			
			readers = (Readers)ois.readObject();  //�������Է�����������
			
			
			
			
			
			//3.�������ʾ
			
			DefaultTableModel tm = new DefaultTableModel(
					new String[0][0],
					new String[]{ "����","����", "�Ա�","��ϵ�绰" });
			jTable1.setModel(tm);
			
			if(readers == null){
				return; //û�в鵽����
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
			JOptionPane.showMessageDialog(null,"��������ʧ�ܣ����������ӷ�����");
			try {
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				socket = null;  // JAVA���������ջ��� ����Ϊnull �ᱻ����   �ȴ�java�� �����������Դ
				jbtQuery.setEnabled(false);
				jbtConnect.setEnabled(true);
				jbtClose.setEnabled(false);
			}
		}
		
	}

}
