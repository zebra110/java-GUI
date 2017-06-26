package org.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.server.Libraryserver;

import javax.swing.SwingUtilities;

public class AdminMainFrame extends javax.swing.JFrame {
	private JMenuBar jMenuBar;
	private JMenu jMenuManager;
	private JMenuItem jItemBorrowBook;
	private JMenuItem jItemQueryBorrow;
	private JMenu jMenuReader;
	private JMenu jMenuBorrow;
	private JMenuItem jItemAddBook;
	private JMenuItem jItemQueryReader;
	private JMenuItem jMenuUpdateReader;
	private JMenuItem jItemAddReader;
	private JMenuItem jItemUpdateBook;
	private JMenuItem jItemQueryBook;
	private JMenuItem jItemManager;
	private JMenuItem jItemStartServer;
	private JMenuItem jItemQuitServer;
	private JMenu jMenuHelp;
	private JMenu jMenuServer;
	private JMenu jMenuBookInfo;

	
	private Libraryserver server;  // 服务器套接字准备
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdminMainFrame inst = new AdminMainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AdminMainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setBounds(0, 0, 600, 430);
			getContentPane().setLayout(null);
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenuManager = new JMenu();
					jMenuBar.add(jMenuManager);
					jMenuManager.setText("管理员信息");
					{
						jItemManager = new JMenuItem();//修改管理员信息菜单项
						jMenuManager.add(jItemManager);
						jItemManager.setText("修改管理员");
						jItemManager.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryManagerFrame updateManager = QueryManagerFrame.getInstance();
								updateManager.setVisible(true);
							}
						});
					}
				}
				{
					jMenuBookInfo = new JMenu();
					jMenuBar.add(jMenuBookInfo);
					jMenuBookInfo.setText("图书管理");
					{
						jItemQueryBook = new JMenuItem();	//查询图书菜单项
						jMenuBookInfo.add(jItemQueryBook);
						jItemQueryBook.setText("查询图书"); 
						jItemQueryBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemAddBook = new JMenuItem();//添加图书菜单项
						jMenuBookInfo.add(jItemAddBook);
						jItemAddBook.setText("添加图书");
						jItemAddBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddBookFrame addBookFrame = new AddBookFrame();
								addBookFrame.setVisible(true);
								
							}
						});
					}
					{
						jItemUpdateBook = new JMenuItem();	//修改图书信息菜单项
						jMenuBookInfo.add(jItemUpdateBook);
						jItemUpdateBook.setText("修改图书");
						jItemUpdateBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
				}
				{
					jMenuReader = new JMenu();
					jMenuBar.add(jMenuReader);
					jMenuReader.setText("读者管理");
					{
						jItemQueryReader = new JMenuItem();//查询读者信息菜单项
						jMenuReader.add(jItemQueryReader);
						jItemQueryReader.setText("查询读者信息");
						jItemQueryReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryReaderFrame queryReader = QueryReaderFrame.getInstance();
								queryReader.setVisible(true);
							}
						});
					}
					{
						jItemAddReader = new JMenuItem();//添加读者信息菜单项
						jMenuReader.add(jItemAddReader);
						jItemAddReader.setText("添加读者信息");
						jItemAddReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddReaderFrame add = new AddReaderFrame();
								add.setVisible(true);
							}
						});
					}
					{
						jMenuUpdateReader = new JMenuItem();//修改读者信息菜单项
						jMenuReader.add(jMenuUpdateReader);
						jMenuUpdateReader.setText("修改读者信息");
						jMenuUpdateReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddReaderFrame addFrame = new AddReaderFrame();
								addFrame.setVisible(true);
							}
						});
						
					}
				}
				{
					jMenuBorrow = new JMenu();
					jMenuBar.add(jMenuBorrow);
					jMenuBorrow.setText("借阅管理");
					{
						jItemQueryBorrow = new JMenuItem();//图书借阅查询
						jMenuBorrow.add(jItemQueryBorrow);
						jItemQueryBorrow.setText("查询借阅信息");
						jItemQueryBorrow.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBorrowFrame queryFrame = new QueryBorrowFrame();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemBorrowBook = new JMenuItem();//图书借阅管理
						jMenuBorrow.add(jItemBorrowBook);
						jItemBorrowBook.setText("图书借还管理");
						jItemBorrowBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddBorrowFrame add = new AddBorrowFrame();
								add.setVisible(true);
							}
						});
					}
				}
				{
					jMenuHelp = new JMenu();
					jMenuBar.add(jMenuHelp);
					jMenuHelp.setText("帮助");
				}
				{
					jMenuServer = new JMenu();
					jMenuBar.add(jMenuServer);
					jMenuServer.setText("服务器管理");
					
					{
						jItemStartServer = new JMenuItem();
						jMenuServer.add(jItemStartServer);
						jItemStartServer.setText("启动服务");
						jItemStartServer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(server != null) return;  //
								
								server = new Libraryserver();  //创建服务器对象
								server.start();  //启动服务
								jItemQuitServer.setEnabled(true);
								jItemStartServer.setEnabled(false);  //不能再启动服务了
								
								JOptionPane.showMessageDialog(null, "服务器启动成功");
								
							}
						});
					}
					{
						jItemQuitServer = new JMenuItem();
						jMenuServer.add(jItemQuitServer);
						jItemQuitServer.setText("关闭服务");
						jItemQuitServer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(server == null) return;  // 服务器 没有启动
								
								server.close();
								server = null ;
								jItemQuitServer.setEnabled(false);
								jItemStartServer.setEnabled(true);
								JOptionPane.showMessageDialog(null, "服务器关闭成功");
							}
						});
					}
					
					
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
