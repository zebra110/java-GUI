package org.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import org.entity.User;
import org.impl.ManagerDaoImpl;
import org.interfaceDao.ManagerDao;

//管理员信息 修改管理员

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
public class QueryManagerFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane;
	private JTable jTable;
	private JButton jButtonBack;
	private JButton jButtonUpdate;
	private JLabel jLabelTitle;
	private ManagerDao managerDao = new ManagerDaoImpl();
	private static QueryManagerFrame queryFrame = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	private QueryManagerFrame() {
		super();
		initGUI();
	}
	/**
	 * 修改管理员信息后需要刷新查询页面，调用此方法即可（单例模式）
	 * @return
	 */
	public static QueryManagerFrame getInstance(){
		if(queryFrame == null){
			queryFrame = new QueryManagerFrame();
		}
		return queryFrame;
	}
	/**
	 * 修改数据后，刷新表格方法
	 */
	public void refresh(){
		jTable.setModel(this.getTableModel());
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane);
				jScrollPane.setBounds(12, 48, 460, 228);
				{
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("修改管理员信息");
				jLabelTitle.setBounds(168, 12, 166, 24);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jButtonUpdate = new JButton();//修改按钮
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("修改");
				jButtonUpdate.setBounds(61, 314, 71, 24);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						/**
						 * 修改按钮单击事件
						 */
						int row = -1;
						row= jTable.getSelectedRow();
						
						
						if(row==-1){
							
							JOptionPane.showMessageDialog(QueryManagerFrame.this, "请选择需要修改项！");
							QueryManagerFrame queryFrame = QueryManagerFrame.getInstance();
							queryFrame.refresh();
							
						
					}
						else{
						int magId=Integer.parseInt((jTable.getValueAt(row, 0))+"");
						UpdateManagerFrame magFrame = new UpdateManagerFrame(magId);
						magFrame.setVisible(true);
						}
					}
				});
			}
			{
				jButtonBack = new JButton();//返回按钮
				getContentPane().add(jButtonBack);
				jButtonBack.setText("返回");
				jButtonBack.setBounds(304, 314, 71, 24);
				jButtonBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryManagerFrame.this.setVisible(false);
					}
				});
			}
			pack();
			setSize(500, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 绘制表格方法
	 * @return
	 */
	private TableModel getTableModel() {
		//managerDao对象调用查询方法
		List<User> list = managerDao.queryManager();
		System.out.println("list中"+list.size());
		//创建二维数组存放表格信息
		String[][] tableContent = new String[list.size()][3];
		for(int i=0;i<list.size();i++){
			User manager = list.get(i);
			tableContent[i][0] = String.valueOf(manager.getMagId());
			tableContent[i][1] = manager.getMagName();
			tableContent[i][2] = manager.getMagPassword();
		}
		String[] columnName = { "序号","用户名","密码"};
		TableModel jTableModel = new DefaultTableModel(tableContent,columnName);
		return jTableModel;
	}

}
