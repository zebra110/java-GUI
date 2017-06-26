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
	private JRadioButton reader,operater,admin;//单选钮  用户类型
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//加载图片
				ImageIcon icon=new ImageIcon("images/b.jpg");
				JLabel label=new JLabel(icon);	
				//设置label的大小
				label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());	
				LoginFrame inst = new LoginFrame();
				//获取窗口的第二层，将label放入
				inst.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));	
				JPanel j=(JPanel)inst.getContentPane();
				j.setOpaque(false);
				JPanel panel=new JPanel();
				//必须设置为透明的。否则看不到图片
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
				jLabelLogin.setText("用户登录");
				jLabelLogin.setBounds(128, 36, 127, 28);
				jLabelLogin.setFont(new java.awt.Font("宋体",0,20));
				jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelMagName = new JLabel();
				getContentPane().add(jLabelMagName);
				jLabelMagName.setText("用户名");
				jLabelMagName.setBounds(58, 100, 59, 20);
				jLabelMagName.setFont(new java.awt.Font("宋体",0,14));
			}
			{
				jLabelPassword = new JLabel();
				getContentPane().add(jLabelPassword);
				jLabelPassword.setText("密码");
				jLabelPassword.setBounds(58, 153, 59, 20);
				jLabelPassword.setFont(new java.awt.Font("宋体",0,14));
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
				reader = new JRadioButton("读者",true);//默认选择
				getContentPane().add(reader);
				reader.setBounds(20, 200, 59, 20);
				reader.setFont(new java.awt.Font("宋体",0,11));

				
				
				admin = new JRadioButton("管理员");
				admin.setFont(new java.awt.Font("宋体",0,11));
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
				jButtonLogin = new JButton();		//登录按钮
				getContentPane().add(jButtonLogin);
				jButtonLogin.setText("登录");
				jButtonLogin.setBounds(90, 227, 74, 28);
				jButtonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						
							
						//获得用户名和密码
						String magName = jTextMagName.getText().trim();//trim用于截取空格
						String magPassword = String.valueOf(jTextPassword.getPassword());
					
						String identity="读者";
						//调用magLogin方法
						 if(admin.isSelected()){
							identity="管理员";
						}
						User mag = managerDao.magLogin(magName, magPassword,identity);
						if(mag != null){
							JOptionPane.showMessageDialog(LoginFrame.this, "登录成功");
							
							if(reader.isSelected()){
								ReaderMainFrame readermainFrame = new ReaderMainFrame(magName);
								readermainFrame.setVisible(true);
							}else if(admin.isSelected()){
									AdminMainFrame adiminmainFrame = new AdminMainFrame();
									adiminmainFrame.setVisible(true);
									}
								
							
							
							LoginFrame.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误！请重新登录");
							jTextMagName.setText("");
							jTextPassword.setText("");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();	//取消按钮
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("取消");
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
