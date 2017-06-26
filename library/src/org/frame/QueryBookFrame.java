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

//ͼ����� ��ѯͼ��


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
	 * �޸�ѧ����Ϣ����Ҫˢ�²�ѯҳ�棬���ô˷�������
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
					//���TableModel����
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("��ѯͼ����Ϣ");
				jLabelTitle.setBounds(318, 20, 141, 30);
				jLabelTitle.setFont(new java.awt.Font("����",1,20));
				jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelById = new JLabel();
				getContentPane().add(jLabelById);
				jLabelById.setText("����ͼ���");
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
				jButtonById.setText("����");
				jButtonById.setBounds(180, 65, 61, 24);
				jButtonById.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextId = jTextById.getText().trim();
						BookInfo bookInfo = bookDao.queryBookInfoById(Integer.parseInt(TextId));
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "��ͼ��Ų����ڣ�");
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
				jLabelByName.setText("����ͼ����");
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
				jButtonByName.setText("����");
				jButtonByName.setBounds(420, 65, 61, 24);
				jButtonByName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextName = jTextByName.getText().trim();
						BookInfo bookInfo = bookDao.queryBookInfoByName(TextName);
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "��ͼ�����Ʋ����ڣ�");
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
				jLabelblurry.setText("�ؼ���");
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
				jButtonblurry.setText("����");
				jButtonblurry.setBounds(660, 65, 61, 24);
				jButtonblurry.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String TextName = jTextblurry.getText().trim();
						List<BookInfo> bookInfo = bookDao.queryBookblurry(TextName);
						System.out.println(bookInfo.size());
						if(bookInfo==null){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "�ùؼ��ֲ����ڣ�");
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
				jButtonUpdate = new JButton();	//�޸İ�ť
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("�޸�");
				jButtonUpdate.setBounds(243, 397, 79, 26);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//���ѡ�е��к�
						int row = -1;
						row=jTable.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "û��ѡ�е��У�");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						else {
							//�����ѡ�е�ֵ�����������к���ȷ��ѡ��ĳһ����Ԫ��
							int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
							UpdateBookFrame update = new UpdateBookFrame(bookId);
							update.setVisible(true);
						}
						
					}
				});
			}
			{
				jButtonDelete = new JButton();	//ɾ����ť
				getContentPane().add(jButtonDelete);
				jButtonDelete.setText("ɾ��");
				jButtonDelete.setBounds(353, 397, 79, 26);
				jButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						int row = -1;
						row=jTable.getSelectedRow();
						if(row == -1){
							JOptionPane.showMessageDialog(QueryBookFrame.this, "û��ѡ�е���");
							QueryBookFrame queryBookFrame = new QueryBookFrame();
							queryBookFrame.setVisible(true);
						}
						//�����ѡ�е�ֵ�����������к���ȷ��ѡ��ĳһ����Ԫ��
						else{
							int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
							
							
							int i = JOptionPane.showConfirmDialog(QueryBookFrame.this, "ȷ��ɾ����");
							if(i == 0){
								//����deleteBookInfo����
								int result = bookDao.deleteBookInfo(bookId);
								if(result>0){
									JOptionPane.showMessageDialog(QueryBookFrame.this, "ɾ���ɹ���");
									//�ڴ˴����Ʊ����Ϊ��ˢ�²�ѯ���棬ͬ����Ӧ����
									TableModel jTableModel = getTableModel();
									jTable.setModel(jTableModel);//���´����ݿ��м������ݷŵ������
								}else{
									JOptionPane.showMessageDialog(QueryBookFrame.this, "ɾ��ʧ�ܣ�");
								}
							}
							
						}
						
						
						
					}
				});
			}
			{
				jButtonReturn = new JButton();	//���ذ�ť
				getContentPane().add(jButtonReturn);
				jButtonReturn.setText("����");
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
	 * ���ر����Ϣ����
	 * @return
	 */
	private TableModel getTableModel() {
		List<BookInfo> list = bookDao.queryBookInfo();
		System.out.println("list��"+list.size());
		//������ά�����ű����Ϣ
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//��ȡ�����е�Ԫ��
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "ͼ���", "ͼ����", "ͼ������" , "����" , "������" , "��������" , "�۸�"  };
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	
	
	private TableModel getTableModel(List<BookInfo> list) {
		
		System.out.println("list��"+list.size());
		//������ά�����ű����Ϣ
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//��ȡ�����е�Ԫ��
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "ͼ���", "ͼ����", "ͼ������" , "����" , "������" , "��������" , "�۸�"  };
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
		
		String[] column = new String[] { "ͼ���", "ͼ����", "ͼ������" , "����" , "������" , "��������" , "�۸�"  };
		
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	/**
	 * �޸����ݺ�ˢ�±�񷽷�
	 */
	public void refresh(){
		TableModel jTableModel = this.getTableModel();
		jTable.setModel(jTableModel);
	}

}
