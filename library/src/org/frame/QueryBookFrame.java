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
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import org.entity.BookInfo;
import org.entity.User;
import org.impl.BookDaoImpl;
import org.interfaceDao.BookDao;

//图书管理 查询图书


public class QueryBookFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane;
	private JLabel jLabelByName;
	private JButton jButtonReturn;
	private JTable jTable;
	private JButton jButtonDelete;
	private JButton jButtonUpdate;
	private JButton jButtonByName;
	private JButton jButtonById;
	private JTextField jTextByName;
	private JTextField jTextById;
	private JLabel jLabelById;
	private JLabel jLabelblurry;
	private JButton jButtonblurry;
	private JTextField jTextblurry;
	private JLabel jLabelTitle;
	private static QueryBookFrame queryFrame = null;
	private BookDao bookDao = new BookDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				QueryBookFrame inst = new QueryBookFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private QueryBookFrame() {
		super();
		initGUI();
	}
	/**
	 * 修改学生信息后需要刷新查询页面，调用此方法即可
	 * @return
	 */
	public static QueryBookFrame getInstance(){
		if(queryFrame == null){
			queryFrame = new QueryBookFrame();
		}
		return queryFrame;
	}

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane);
				jScrollPane.setBounds(12, 99, 768, 264);
				{
					//获得TableModel对象
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("查询图书信息");
				jLabelTitle.setBounds(318, 20, 141, 30);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
				jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelById = new JLabel();
				getContentPane().add(jLabelById);
				jLabelById.setText("输入图书号");
				jLabelById.setBounds(10, 68, 75, 17);
			}
			{
				jTextById = new JTextField();
				getContentPane().add(jTextById);
				jTextById.setBounds(80, 65, 91, 24);
			}
			{
				jButtonById = new JButton();
				getContentPane().add(jButtonById);
				jButtonById.setText("检索");
				jButtonById.setBounds(180, 65, 61, 24);
				jButtonById.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextId = jTextById.getText().trim();
						BookInfo bookInfo = bookDao.queryBookInfoById(Integer.parseInt(TextId));
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "该图书号不存在！");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						else{
						TableModel jTableModel = getTableModel(bookInfo);
						jTable = new JTable();
						jScrollPane.setViewportView(jTable);
						jTable.setModel(jTableModel);
						}
					}
				});
				
			}
			
			{
				jLabelByName = new JLabel();
				getContentPane().add(jLabelByName);
				jLabelByName.setText("输入图书名");
				jLabelByName.setBounds(250, 68, 75, 17);
			}
			{
				jTextByName = new JTextField();
				getContentPane().add(jTextByName);
				jTextByName.setBounds(320, 65,91, 24);
			}
			{
				jButtonByName = new JButton();
				getContentPane().add(jButtonByName);
				jButtonByName.setText("检索");
				jButtonByName.setBounds(420, 65, 61, 24);
				jButtonByName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextName = jTextByName.getText().trim();
						BookInfo bookInfo = bookDao.queryBookInfoByName(TextName);
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "该图书名称不存在！");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						else{
						TableModel jTableModel = getTableModel(bookInfo);
						jTable = new JTable();
						jScrollPane.setViewportView(jTable);
						jTable.setModel(jTableModel);
						}
					}
				});
			}
			
			{
				jLabelblurry = new JLabel();
				getContentPane().add(jLabelblurry);
				jLabelblurry.setText("关键字");
				jLabelblurry.setBounds(500, 68, 75, 17);
			}
			{
				jTextblurry = new JTextField();
				getContentPane().add(jTextblurry);
				jTextblurry.setBounds(560, 65, 91, 24);
			}
			{
				jButtonblurry = new JButton();
				getContentPane().add(jButtonblurry);
				jButtonblurry.setText("检索");
				jButtonblurry.setBounds(660, 65, 61, 24);
				jButtonblurry.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextName = jTextblurry.getText().trim();
						List<BookInfo> bookInfo = bookDao.queryBookblurry(TextName);
						System.out.println(bookInfo.size());
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "该关键字不存在！");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						else{
						TableModel jTableModel = getTableModel(bookInfo);
						System.out.println(1111);
						jTable = new JTable();
						jScrollPane.setViewportView(jTable);
						jTable.setModel(jTableModel);
						
						
						}
					}
				});
			}
			
			
			{
				jButtonUpdate = new JButton();	//修改按钮
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("修改");
				jButtonUpdate.setBounds(243, 397, 79, 26);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//获得选中的行号
						int row = -1;
						row=jTable.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "没有选中的行！");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						else {
							//获得所选行的值，两个参数行和列确定选中某一个单元格
							int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
							UpdateBookFrame update = new UpdateBookFrame(bookId);
							update.setVisible(true);
						}
						
					}
				});
			}
			{
				jButtonDelete = new JButton();	//删除按钮
				getContentPane().add(jButtonDelete);
				jButtonDelete.setText("删除");
				jButtonDelete.setBounds(353, 397, 79, 26);
				jButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						int row = -1;
						row=jTable.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "没有选中的行");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						//获得所选行的值，两个参数行和列确定选中某一个单元格
						else{
							int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
							
							
							int i = JOptionPane.showConfirmDialog(QueryBookFrame.this, "确定删除吗？");
							if(i == 0){
								//调用deleteBookInfo方法
								int result = bookDao.deleteBookInfo(bookId);
								if(result>0){
									JOptionPane.showMessageDialog(QueryBookFrame.this, "删除成功！");
									//在此处绘制表格是为了刷新查询界面，同步相应数据
									TableModel jTableModel = getTableModel();
									jTable.setModel(jTableModel);//重新从数据库中加载数据放到表格中
								}else{
									JOptionPane.showMessageDialog(QueryBookFrame.this, "删除失败！");
								}
							}
							
						}
						
						
						
					}
				});
			}
			{
				jButtonReturn = new JButton();	//返回按钮
				getContentPane().add(jButtonReturn);
				jButtonReturn.setText("返回");
				jButtonReturn.setBounds(459, 397, 79, 26);
				jButtonReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryBookFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(798, 504);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 加载表格信息方法
	 * @return
	 */
	private TableModel getTableModel() {
		List<BookInfo> list = bookDao.queryBookInfo();
		System.out.println("list中"+list.size());
		//创建二维数组存放表格信息
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//获取集合中的元素
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "图书号", "图书名", "图书类型" , "作者" , "出版社" , "出版日期" , "价格"  };
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	
	
	private TableModel getTableModel(List<BookInfo> list) {
		
		System.out.println("list中"+list.size());
		//创建二维数组存放表格信息
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//获取集合中的元素
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "图书号", "图书名", "图书类型" , "作者" , "出版社" , "出版日期" , "价格"  };
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	private TableModel getTableModel(BookInfo book) {
		
		String[][] content = new String[1][7];
		
			
			content[0][0] = String.valueOf(book.getBookId());
			content[0][1] = book.getBookName();
			content[0][2] = book.getBookType();
			content[0][3] = book.getBookWriter();
			content[0][4] = book.getPublish();
			content[0][5] = book.getPublicDate();
			content[0][6] = String.valueOf(book.getBookPrice());
		
		String[] column = new String[] { "图书号", "图书名", "图书类型" , "作者" , "出版社" , "出版日期" , "价格"  };
		
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	/**
	 * 修改数据后，刷新表格方法
	 */
	public void refresh(){
		TableModel jTableModel = this.getTableModel();
		jTable.setModel(jTableModel);
	}

}
