package org.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.entity.Borrow;
import org.entity.User;
import org.impl.BorrowDaoImpl;
import org.interfaceDao.BorrowDao;

public class ReaderMainFrame extends javax.swing.JFrame {
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
	private JMenu jMenuHelp;
	private JButton jMenuBookInfo;
	private BorrowDao borrowDao = new BorrowDaoImpl();

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
	
	public ReaderMainFrame(String n) {
		super();
		initGUI(n);
	}
	
	private void initGUI(final String n) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setBounds(0, 0, 600, 430);
			getContentPane().setLayout(null);
			
			{  jMenuBar = new JMenuBar();
				    setJMenuBar(jMenuBar);
				    {
						jMenuReader = new JMenu();
						jMenuBar.add(jMenuReader);
						jMenuReader.setText("��������");
						{
							jItemQueryReader = new JMenuItem();//��ѯ������Ϣ�˵���
							jMenuReader.add(jItemQueryReader);
							jItemQueryReader.setText("������Ϣ");
							jItemQueryReader.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ReaderInform magFrame = new ReaderInform(Integer.parseInt(n));
									magFrame.setVisible(true);
								}
							});
						}
//						{
//							jItemQueryReader = new JMenuItem();//��ѯ������Ϣ�˵���
//							jMenuReader.add(jItemQueryReader);
//							jItemQueryReader.setText("������ʷ");
//							jItemQueryReader.addActionListener(new ActionListener() {
//								public void actionPerformed(ActionEvent evt) {
//									QueryBorrowFrame queryReader = new QueryBorrowFrame();
//									Borrow borrow = borrowDao.queryBorrowById(Integer.parseInt(n));
//									queryReader.getTableModel(borrow);
//									queryReader.setVisible(true);
//								}
//							});
//						}
						
						
						
					}
				    
				    
					
					
					
				{
					jMenuReader = new JMenu();
					jMenuBar.add(jMenuReader);
					jMenuReader.setText("��ѯͼ����Ϣ");
					
					{
						jItemAddReader = new JMenuItem();//��ѯͼ��˵���
						jMenuReader.add(jItemAddReader);
						jItemAddReader.setText("��ѯͼ��");
						jItemAddReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
					
				}
//				 {
//						jMenuReader = new JMenu();
//						jMenuBar.add(jMenuReader);
//						jMenuReader.setText("�������");
//						{
//							jItemQueryReader = new JMenuItem();//��ѯ������Ϣ�˵���
//							jMenuReader.add(jItemQueryReader);
//							jItemQueryReader.setText("�������");
//							jItemQueryReader.addActionListener(new ActionListener() {
//								public void actionPerformed(ActionEvent evt) {
//									QueryReaderFrame queryReader = QueryReaderFrame.getInstance();
//									queryReader.setVisible(true);
//								}
//							});
//						}
//						
//						
//					}
				{
					jMenuHelp = new JMenu();
					jMenuBar.add(jMenuHelp);
					jMenuHelp.setText("����");
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
