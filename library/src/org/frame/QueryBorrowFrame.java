package org.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import org.entity.Borrow;
import org.entity.Readers;
import org.impl.BorrowDaoImpl;
import org.interfaceDao.BorrowDao;


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
public class QueryBorrowFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JScrollPane jScrollPane;
	private JButton jButtonBorrowDate;
	private JButton jButtonBorrowId;
	private JTable jTable;
	private JButton jButtonCancel;
	private JButton jButtonBack;
	private JTextField jTextBorrowDate;
	private JTextField jTextBorrowId;
	private JLabel jLabelBorrowId;
	private BorrowDao borrowDao = new BorrowDaoImpl();
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public QueryBorrowFrame(Borrow TextName) {
		super();
		initGUI(TextName);
	}
	public QueryBorrowFrame() {
		super();
		initGUI(null);
	}                                                                                                                    
	private void initGUI(final Borrow TextName) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("查询图书借阅信息");                        
				jLabelTitle.setBounds(203, 22, 182, 23);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane);
				jScrollPane.setBounds(19, 95, 551, 206);
				{
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jLabelBorrowId = new JLabel();
				getContentPane().add(jLabelBorrowId);
				jLabelBorrowId.setText("输入借阅号");
				jLabelBorrowId.setBounds(27, 59, 67, 17);
			}
			{
				jTextBorrowId = new JTextField();
				getContentPane().add(jTextBorrowId);
				jTextBorrowId.setBounds(97, 56, 94, 24);
			}
			{
				jButtonBorrowId = new JButton();
				getContentPane().add(jButtonBorrowId);
				jButtonBorrowId.setText("检索");
				jButtonBorrowId.setBounds(200, 56, 61, 24);
				jButtonBorrowId.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextName = jTextBorrowId.getText().trim();
						Borrow borrow = borrowDao.queryBorrowById(Integer.parseInt(TextName));
						if(borrow==null){
							JOptionPane.showMessageDialog(QueryBorrowFrame.this, "该借书证号不存在！");
							QueryBorrowFrame queryBorrowFrame = new QueryBorrowFrame();
							queryBorrowFrame.setVisible(true);
						}
						else{
						TableModel jTableModel = getTableModel(borrow);
						System.out.println(1111);
						jTable = new JTable();
						jScrollPane.setViewportView(jTable);
						jTable.setModel(jTableModel);
						}
					}
				});
			}
			{
				jButtonBack = new JButton();	//归还图书按钮
				getContentPane().add(jButtonBack);
				jButtonBack.setText("归还");
				jButtonBack.setBounds(183, 322, 66, 24);
				jButtonBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int row =jTable.getSelectedRow();
						int borrowId = Integer.parseInt((jTable.getValueAt(row, 0))+"");
						
							//调用backBook方法
						int result = borrowDao.backBook(borrowId);
						if(result>0){
							JOptionPane.showMessageDialog(QueryBorrowFrame.this, "归还图书成功！");
							//在此处绘制表格是为了刷新查询界面，同步相应数据
							if(TextName==null){
								TableModel jTableModel = getTableModel();
								jTable.setModel(jTableModel);//重新从数据库中加载数据放到表格中
								
							}
							else{
								TableModel jTableModel = getTableModel(TextName);
								jTable.setModel(jTableModel);//重新从数据库中加载数据放到表格中
							}
							
						}else{
							JOptionPane.showMessageDialog(QueryBorrowFrame.this, "归还图书失败！");
						}
						
					}
				});
			}
			{
				jButtonCancel = new JButton();//返回按钮
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("返回");
				jButtonCancel.setBounds(324, 322, 66, 24);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryBorrowFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(603, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private TableModel getTableModel() {
		List<Borrow> list = borrowDao.queryBorrow();
		String[][] tableContent = new String[list.size()][5];
		for(int i=0;i<list.size();i++){
			Borrow borrow = list.get(i);
			tableContent[i][0] = String.valueOf(borrow.getBorrowId());
			tableContent[i][1] = borrow.getReaderId()+"";
			tableContent[i][2] = borrow.getBookId()+"";
			tableContent[i][3] = borrow.getBorrowDate();
			tableContent[i][4] = borrow.getBackDate();
		}
		String[] columnName = {"借阅号", "读者借阅证号", "图书号", "借阅日期", "归还日期" };
		TableModel jTableModel = new DefaultTableModel(tableContent,columnName);
		return jTableModel;
	}
	
	 TableModel getTableModel(Borrow borrow) {
		String[][] tableContent = new String[1][5];
		
			tableContent[0][0] = String.valueOf(borrow.getBorrowId());
			tableContent[0][1] = borrow.getReaderId()+"";
			tableContent[0][2] = borrow.getBookId()+"";
			tableContent[0][3] = borrow.getBorrowDate();
			tableContent[0][4] = borrow.getBackDate();
		
		String[] columnName = {"借阅号", "读者借阅证号", "图书号", "借阅日期", "归还日期" };
		TableModel jTableModel = new DefaultTableModel(tableContent,columnName);
		return jTableModel;
	}
}
