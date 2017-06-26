package org.frame;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.entity.Readers;
import org.impl.ReaderDaoImpl;
import org.interfaceDao.ReaderDao;

//读者管理 添加读者信息

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
public class AddReaderFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JLabel jLabelPhone;
	private JButton jButtonUpdate;
	private ButtonGroup buttonGroup;
	private JRadioButton jRadioWoman;
	private JRadioButton jRadioMan;
	private JButton jButtonQuery;
	private JButton jButtonReset;
	private JButton jButtonEnsure;
	private JTextField jTextEndDate;
	private JTextField jTextStartDate;
	private JTextField jTextPhone;
	private JTextField jTextAge;
	private JTextField jTextFName;
	private JLabel jLabelEndDate;
	private JLabel jLabelStartDate;
	private JLabel jLabelSex;
	private JLabel jLabelAge;
	private JLabel jLabelName;
	private ReaderDao readerDao = new ReaderDaoImpl();
	private int readerId;

	/**
	* Auto-generated main method to display this JFrame
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddReaderFrame inst = new AddReaderFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	
	public AddReaderFrame() {
		super();
		initGUI();
	}
	public AddReaderFrame(int readerId) {
		super();
		this.readerId = readerId;
		initGUI();
		fillInfo();
	}
	/**
	 * 修改单击事件所用填充信息方法
	 */
	public void fillInfo(){
		jLabelTitle.setText("修改读者信息");
		jButtonEnsure.setVisible(false);
		jButtonUpdate.setVisible(true);
		Readers reader = readerDao.queryReaderById(readerId);
		jTextFName.setText(reader.getReaderName());
		jTextAge.setText(reader.getReaderAge()+"");
		jTextPhone.setText(reader.getReaderPhone());
		jTextStartDate.setText(reader.getStartDate());
		jTextEndDate.setText(reader.getEndDate());
		if(reader.getReaderSex().equals("女")){
			jRadioWoman.setSelected(true);
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("添加读者信息");
				jLabelTitle.setBounds(126, 31, 140, 30);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jLabelName = new JLabel();
				getContentPane().add(jLabelName);
				jLabelName.setText("姓名");
				jLabelName.setBounds(51, 81, 57, 17);
			}
			{
				jLabelAge = new JLabel();
				getContentPane().add(jLabelAge);
				jLabelAge.setText("年龄");
				jLabelAge.setBounds(51, 126, 57, 17);
			}
			{
				jLabelSex = new JLabel();
				getContentPane().add(jLabelSex);
				jLabelSex.setText("性别");
				jLabelSex.setBounds(51, 166, 57, 17);
			}
			{
				jLabelPhone = new JLabel();
				getContentPane().add(jLabelPhone);
				jLabelPhone.setText("电话");
				jLabelPhone.setBounds(51, 210, 57, 17);
			}
			{
				jLabelStartDate = new JLabel();
				getContentPane().add(jLabelStartDate);
				jLabelStartDate.setText("开证日期");
				jLabelStartDate.setBounds(51, 256, 57, 17);
			}
			{
				jLabelEndDate = new JLabel();
				getContentPane().add(jLabelEndDate);
				jLabelEndDate.setText("结证日期");
				jLabelEndDate.setBounds(51, 302, 57, 17);
			}
			{
				jTextFName = new JTextField();
				getContentPane().add(jTextFName);
				jTextFName.setBounds(126, 78, 185, 24);
			}
			{
				jTextAge = new JTextField();
				getContentPane().add(jTextAge);
				jTextAge.setBounds(126, 123, 115, 24);
			}
			{
				jTextPhone = new JTextField();
				getContentPane().add(jTextPhone);
				jTextPhone.setBounds(126, 207, 185, 24);
			}
			{
				jTextStartDate = new JTextField();
				getContentPane().add(jTextStartDate);
				jTextStartDate.setBounds(126, 253, 185, 24);
			}
			{
				jTextEndDate = new JTextField();
				getContentPane().add(jTextEndDate);
				jTextEndDate.setBounds(126, 299, 185, 24);
			}
			{
				jButtonEnsure = new JButton();	//确定按钮
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("确定");
				jButtonEnsure.setBounds(58, 353, 62, 24);
				jButtonEnsure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String readerName = jTextFName.getText().trim();
						int readerAge = Integer.parseInt(jTextAge.getText().trim());
						String readerSex = jRadioMan.getText();
						if(jRadioWoman.isSelected()){
							readerSex = jRadioWoman.getText();
						}
						String readerPhone = jTextPhone.getText();
						String startDate = jTextStartDate.getText();
						String endDate = jTextEndDate.getText();
						Readers reader = new Readers(readerName,readerAge,readerSex,readerPhone,startDate,endDate);
						//创建一个实例调用ReaderDaoImpl中的addReader方法
						int result = readerDao.addReader(reader);
						if(result>0){
							JOptionPane.showMessageDialog(AddReaderFrame.this, "添加成功！");
							reset();
						}else{
							JOptionPane.showMessageDialog(AddReaderFrame.this, "添加失败！");
						}
						
						
					}
				});
			}
			{
				jButtonReset = new JButton();	//重置按钮
				getContentPane().add(jButtonReset);
				jButtonReset.setText("重置");
				jButtonReset.setBounds(150, 353, 62, 24);
				jButtonReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						reset();
					}
				});
			}
			{
				jButtonQuery = new JButton();//查询按钮
				getContentPane().add(jButtonQuery);
				jButtonQuery.setText("查询");
				jButtonQuery.setBounds(243, 353, 62, 24);
				jButtonQuery.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryReaderFrame queryReader = QueryReaderFrame.getInstance();
						queryReader.setVisible(true);
						AddReaderFrame.this.dispose();
						
					}
				});
			}
			{
				jRadioMan = new JRadioButton();
				getContentPane().add(jRadioMan);
				jRadioMan.setText("男");
				jRadioMan.setBounds(126, 164, 42, 21);
				jRadioMan.setSelected(true);
				getButtonGroup().add(jRadioMan);
			}
			{
				jRadioWoman = new JRadioButton();
				getContentPane().add(jRadioWoman);
				getContentPane().add(getJButtonUpdate());
				jRadioWoman.setText("女");
				jRadioWoman.setBounds(200, 164, 38, 21);
				getButtonGroup().add(jRadioWoman);
			}
			pack();
			this.setSize(393, 442);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void reset(){
		
		jTextFName.setText("");
		jTextAge.setText("");
		jRadioMan.setSelected(true);
		jTextPhone.setText("");
		jTextStartDate.setText("");
		jTextEndDate.setText("");
	}
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	private JButton getJButtonUpdate() {
		if(jButtonUpdate == null) {
			jButtonUpdate = new JButton();//修改按钮
			jButtonUpdate.setText("修改");
			jButtonUpdate.setBounds(58, 353, 62, 24);
			jButtonUpdate.setVisible(false);
			jButtonUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String readerName = jTextFName.getText().trim();
					int readerAge = Integer.parseInt(jTextAge.getText().trim());
					String readerSex = jRadioMan.getText();//获得性别数据
					if(jRadioWoman.isSelected()){
						readerSex = jRadioWoman.getText();
					}
					String readerPhone = jTextPhone.getText();
					String startDate = jTextStartDate.getText();
					String endDate = jTextEndDate.getText();
					Readers reader = new Readers(readerId,readerName,readerAge,readerSex,readerPhone,startDate,endDate);
					//创建一个实例调用ReaderDaoImpl中的addReader方法
					int result = readerDao.updateReader(reader);
					if(result>0){
						JOptionPane.showMessageDialog(AddReaderFrame.this, "修改成功！");
						QueryReaderFrame queryFrame = QueryReaderFrame.getInstance();
						queryFrame.refresh();
						AddReaderFrame.this.dispose();
						reset();
					}else{
						JOptionPane.showMessageDialog(AddReaderFrame.this, "修改失败！");
					}
					
					
				}
			});
		}
		return jButtonUpdate;
	}

}
