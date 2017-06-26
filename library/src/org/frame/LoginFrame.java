package org.frame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.entity.User;
import org.impl.ManagerDaoImpl;
import org.interfaceDao.ManagerDao;

public class LoginFrame extends javax.swing.JFrame {
	private JLabel jLabelLogin;
	private JPasswordField jTextPassword;
	private JButton jButtonCancel;
	private JButton jButtonLogin;
	private JTextField jTextMagName;
	private JLabel jLabelPassword;
	private JLabel jLabelMagName;
	private ManagerDao managerDao = new ManagerDaoImpl();
	private JRadioButton reader,operater,admin;//��ѡť  �û�����
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//����ͼƬ
				ImageIcon icon=new ImageIcon("images/b.jpg");
				JLabel label=new JLabel(icon);	
				//����label�Ĵ�С
				label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());	
				LoginFrame inst = new LoginFrame();
				//��ȡ���ڵĵڶ��㣬��label����
				inst.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));	
				JPanel j=(JPanel)inst.getContentPane();
				j.setOpaque(false);
				JPanel panel=new JPanel();
				//��������Ϊ͸���ġ����򿴲���ͼƬ
				panel.setOpaque(false);
				inst.add(panel);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelLogin = new JLabel();
				getContentPane().add(jLabelLogin);
				jLabelLogin.setText("�û���¼");
				jLabelLogin.setBounds(128, 36, 127, 28);
				jLabelLogin.setFont(new java.awt.Font("����",0,20));
				jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelMagName = new JLabel();
				getContentPane().add(jLabelMagName);
				jLabelMagName.setText("�û���");
				jLabelMagName.setBounds(58, 100, 59, 20);
				jLabelMagName.setFont(new java.awt.Font("����",0,14));
			}
			{
				jLabelPassword = new JLabel();
				getContentPane().add(jLabelPassword);
				jLabelPassword.setText("����");
				jLabelPassword.setBounds(58, 153, 59, 20);
				jLabelPassword.setFont(new java.awt.Font("����",0,14));
			}
			{
				jTextMagName = new JTextField();
				getContentPane().add(jTextMagName);
				jTextMagName.setBounds(135, 100, 160, 24);
			}
			{
				jTextPassword = new JPasswordField();
				getContentPane().add(jTextPassword);
				jTextPassword.setBounds(135, 153, 160, 24);
			}
			
			{
					
				JPanel  p2 = new JPanel();
				reader = new JRadioButton("����",true);//Ĭ��ѡ��
				getContentPane().add(reader);
				reader.setBounds(20, 200, 59, 20);
				reader.setFont(new java.awt.Font("����",0,11));

				
				
				admin = new JRadioButton("����Ա");
				admin.setFont(new java.awt.Font("����",0,11));
				getContentPane().add(admin);
				admin.setBounds(100, 200, 59, 20);


			    ButtonGroup group = new ButtonGroup();
			        group.add(reader);
			      
			        group.add(admin);
//			        p2.add(reader);
//			        p2.add(operater);
//			        p2.add(admin);
//			        getContentPane().add(operater);
//			        getContentPane().add(p2,BorderLayout.CENTER);
//			        getContentPane().add(p2);
			}
			
			
			
			{
				jButtonLogin = new JButton();		//��¼��ť
				getContentPane().add(jButtonLogin);
				jButtonLogin.setText("��¼");
				jButtonLogin.setBounds(90, 227, 74, 28);
				jButtonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						
							
						//����û���������
						String magName = jTextMagName.getText().trim();//trim���ڽ�ȡ�ո�
						String magPassword = String.valueOf(jTextPassword.getPassword());
					
						String identity="����";
						//����magLogin����
						 if(admin.isSelected()){
							identity="����Ա";
						}
						User mag = managerDao.magLogin(magName, magPassword,identity);
						if(mag != null){
							JOptionPane.showMessageDialog(LoginFrame.this, "��¼�ɹ�");
							
							if(reader.isSelected()){
								ReaderMainFrame readermainFrame = new ReaderMainFrame(magName);
								readermainFrame.setVisible(true);
							}else if(admin.isSelected()){
									AdminMainFrame adiminmainFrame = new AdminMainFrame();
									adiminmainFrame.setVisible(true);
									}
								
							
							
							LoginFrame.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(LoginFrame.this, "�û�����������������µ�¼");
							jTextMagName.setText("");
							jTextPassword.setText("");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();	//ȡ����ť
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("ȡ��");
				jButtonCancel.setBounds(207, 227, 74, 28);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				});
			}
			pack();
			
			this.setSize(400, 340);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

}
