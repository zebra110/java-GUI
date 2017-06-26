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

	
	private Libraryserver server;  // �������׽���׼��
	
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
					jMenuManager.setText("����Ա��Ϣ");
					{
						jItemManager = new JMenuItem();//�޸Ĺ���Ա��Ϣ�˵���
						jMenuManager.add(jItemManager);
						jItemManager.setText("�޸Ĺ���Ա");
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
					jMenuBookInfo.setText("ͼ�����");
					{
						jItemQueryBook = new JMenuItem();	//��ѯͼ��˵���
						jMenuBookInfo.add(jItemQueryBook);
						jItemQueryBook.setText("��ѯͼ��"); 
						jItemQueryBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemAddBook = new JMenuItem();//���ͼ��˵���
						jMenuBookInfo.add(jItemAddBook);
						jItemAddBook.setText("���ͼ��");
						jItemAddBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddBookFrame addBookFrame = new AddBookFrame();
								addBookFrame.setVisible(true);
								
							}
						});
					}
					{
						jItemUpdateBook = new JMenuItem();	//�޸�ͼ����Ϣ�˵���
						jMenuBookInfo.add(jItemUpdateBook);
						jItemUpdateBook.setText("�޸�ͼ��");
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
					jMenuReader.setText("���߹���");
					{
						jItemQueryReader = new JMenuItem();//��ѯ������Ϣ�˵���
						jMenuReader.add(jItemQueryReader);
						jItemQueryReader.setText("��ѯ������Ϣ");
						jItemQueryReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryReaderFrame queryReader = QueryReaderFrame.getInstance();
								queryReader.setVisible(true);
							}
						});
					}
					{
						jItemAddReader = new JMenuItem();//��Ӷ�����Ϣ�˵���
						jMenuReader.add(jItemAddReader);
						jItemAddReader.setText("��Ӷ�����Ϣ");
						jItemAddReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddReaderFrame add = new AddReaderFrame();
								add.setVisible(true);
							}
						});
					}
					{
						jMenuUpdateReader = new JMenuItem();//�޸Ķ�����Ϣ�˵���
						jMenuReader.add(jMenuUpdateReader);
						jMenuUpdateReader.setText("�޸Ķ�����Ϣ");
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
					jMenuBorrow.setText("���Ĺ���");
					{
						jItemQueryBorrow = new JMenuItem();//ͼ����Ĳ�ѯ
						jMenuBorrow.add(jItemQueryBorrow);
						jItemQueryBorrow.setText("��ѯ������Ϣ");
						jItemQueryBorrow.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBorrowFrame queryFrame = new QueryBorrowFrame();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemBorrowBook = new JMenuItem();//ͼ����Ĺ���
						jMenuBorrow.add(jItemBorrowBook);
						jItemBorrowBook.setText("ͼ��軹����");
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
					jMenuHelp.setText("����");
				}
				{
					jMenuServer = new JMenu();
					jMenuBar.add(jMenuServer);
					jMenuServer.setText("����������");
					
					{
						jItemStartServer = new JMenuItem();
						jMenuServer.add(jItemStartServer);
						jItemStartServer.setText("��������");
						jItemStartServer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(server != null) return;  //
								
								server = new Libraryserver();  //��������������
								server.start();  //��������
								jItemQuitServer.setEnabled(true);
								jItemStartServer.setEnabled(false);  //����������������
								
								JOptionPane.showMessageDialog(null, "�����������ɹ�");
								
							}
						});
					}
					{
						jItemQuitServer = new JMenuItem();
						jMenuServer.add(jItemQuitServer);
						jItemQuitServer.setText("�رշ���");
						jItemQuitServer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(server == null) return;  // ������ û������
								
								server.close();
								server = null ;
								jItemQuitServer.setEnabled(false);
								jItemStartServer.setEnabled(true);
								JOptionPane.showMessageDialog(null, "�������رճɹ�");
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
