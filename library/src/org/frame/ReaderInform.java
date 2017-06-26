package org.frame;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.entity.User;

import org.entity.Readers;
import org.impl.ManagerDaoImpl;
import org.impl.ReaderDaoImpl;
import org.interfaceDao.ManagerDao;
import org.interfaceDao.ReaderDao;

//管理员信息 修改管理员中修改页面

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ReaderInform extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	
	private JLabel jLabelUserId;
	private JLabel jLabelUserName;
	private JLabel jLabelUserAge;
	private JLabel jLabelUserSex;
	private JLabel jLabelUserPhone;
	
	private JTextField jTextUserId;
	private JTextField jTextUserName;
	private JTextField jTextUserAge;
	private JTextField jTextUserSex;
	private JTextField jTextUserPhone;
	
	
	private JButton jButtonCancel;
	private JButton jButtonEnsure;
	
	private int magId;
	private ReaderDao magDao = new ReaderDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public ReaderInform() {
		super();
		initGUI();
	}
	public ReaderInform(int magId) {
		super();
		this.magId = magId;
		initGUI();
		fillInfo();
	}
	private void fillInfo(){
		
		
		Readers manager = magDao.queryReaderById(magId);
		jTextUserId.setText(manager.getReaderId()+"");
		jTextUserName.setText(manager.getReaderName());
		jTextUserAge.setText(manager.getReaderAge()+"");
		jTextUserSex.setText(manager.getReaderSex());
		 jTextUserPhone.setText(manager.getReaderPhone());
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("个人信息");
				jLabelTitle.setBounds(64, 22, 157, 23);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jLabelUserId = new JLabel();
				getContentPane().add(jLabelUserId);
				jLabelUserId.setText("读者号");
				jLabelUserId.setBounds(35, 70, 52, 17);
				jLabelUserId.setHorizontalAlignment(SwingConstants.CENTER);
			}
			
			{
				jLabelUserName = new JLabel();
				getContentPane().add(jLabelUserName);
				jLabelUserName.setText("姓名");
				jLabelUserName.setBounds(35, 100, 52, 17);
				jLabelUserName.setHorizontalAlignment(SwingConstants.CENTER);
			}
			
			{
				jLabelUserSex = new JLabel();
				getContentPane().add(jLabelUserSex);
				jLabelUserSex.setText("性别");
				jLabelUserSex.setBounds(35, 130, 52, 17);
				jLabelUserSex.setHorizontalAlignment(SwingConstants.CENTER);
			{
				jLabelUserAge = new JLabel();
				getContentPane().add(jLabelUserAge);
				jLabelUserAge.setText("年龄");
				jLabelUserAge.setBounds(35, 160, 52, 17);
				jLabelUserAge.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelUserPhone = new JLabel();
				getContentPane().add(jLabelUserPhone);
				jLabelUserPhone.setText("电话");
				jLabelUserPhone.setBounds(35, 190, 52, 17);
				jLabelUserPhone.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				 jTextUserId = new JTextField();
				getContentPane().add(jTextUserId);
				jTextUserId.setBounds(105, 70, 139, 24);
			}
			{
				jTextUserName = new JTextField();
				getContentPane().add(jTextUserName);
				jTextUserName.setBounds(105, 100, 139, 24);
			}
			{
				jTextUserSex = new JTextField();
				getContentPane().add(jTextUserSex);
				jTextUserSex.setBounds(105, 130, 139, 24);
			}
			{
				jTextUserAge = new JTextField();
				getContentPane().add(jTextUserAge);
				jTextUserAge.setBounds(105,160, 139, 24);
			}
			{
				jTextUserPhone = new JTextField();
				getContentPane().add(jTextUserPhone);
				jTextUserPhone.setBounds(105, 190, 139, 24);
			}
			{
				jButtonEnsure = new JButton();
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("修改");
				jButtonEnsure.setBounds(57, 288, 63, 24);
				jButtonEnsure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
					
						String magId = jTextUserId.getText().trim();
						String magName = jTextUserName.getText().trim();
						String magSex = jTextUserSex.getText().trim();
						String magAge = jTextUserAge.getText().trim();
						String magPhone = jTextUserPhone.getText().trim();
						Readers manager = new Readers(Integer.parseInt(magId), magName, Integer.parseInt(magAge),magSex,magPhone,null,null);
						int result =magDao.updateReader(manager);
					
						if(result>0){
							JOptionPane.showMessageDialog(ReaderInform.this, "修改成功！");
							ReaderInform queryFrame = new ReaderInform();
							ReaderInform.this.dispose();
						}else{
							JOptionPane.showMessageDialog(ReaderInform.this, "修改失败！");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("返回");
				jButtonCancel.setBounds(165, 188, 63, 24);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ReaderInform.this.dispose();
					}
				});
			}
			pack();
			this.setSize(310, 280);
		} }catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
