package org.frame;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.entity.BookInfo;
import org.impl.BookDaoImpl;
import org.interfaceDao.BookDao;

//ͼ����� �޸�ͼ��

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
public class UpdateBookFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JLabel jLabelName;
	private JLabel jLabelWriter;
	private JLabel jLabelDate;
	private JTextField jTextPrice;
	private JTextField jTextDate;
	private JButton jButtonReturn;
	private JButton jButtonReset;
	private JButton jButtonEnsure;
	private JTextField jTextPublish;
	private JTextField jTextWriter;
	private JTextField jTextType;
	private JTextField jTextName;
	private JLabel jLabelPrice;
	private JLabel jLabelPublish;
	private JLabel jLabelType;
	private int bookId;
	private BookDao bookDao = new BookDaoImpl();


	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public UpdateBookFrame() {
		super();
		initGUI();
	}
	public UpdateBookFrame(int bookId) {
		super();
		initGUI();
		this.bookId = bookId;
		fillInfo();
	}
	/**
	 * ��ʾͼ����Ϣ���޸Ľ�����
	 */
	private void fillInfo(){
		BookInfo book = bookDao.queryBookInfoById(bookId);
		jTextName.setText(book.getBookName());
		jTextType.setText(book.getBookType());
		jTextWriter.setText(book.getBookWriter());
		jTextPublish.setText(book.getPublish());
		jTextDate.setText(book.getPublicDate());
		jTextPrice.setText(book.getBookPrice()+"");
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("��ѯͼ����Ϣ");
				jLabelTitle.setBounds(128, 27, 143, 29);
				jLabelTitle.setFont(new java.awt.Font("����",1,20));
				jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelName = new JLabel();
				getContentPane().add(jLabelName);
				jLabelName.setText("ͼ����");
				jLabelName.setBounds(45, 90, 70, 17);
				jLabelName.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelType = new JLabel();
				getContentPane().add(jLabelType);
				jLabelType.setText("ͼ������");
				jLabelType.setBounds(45, 135, 70, 17);
				jLabelType.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelWriter = new JLabel();
				getContentPane().add(jLabelWriter);
				jLabelWriter.setText("����");
				jLabelWriter.setBounds(45, 179, 70, 17);
				jLabelWriter.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelPublish = new JLabel();
				getContentPane().add(jLabelPublish);
				jLabelPublish.setText("������");
				jLabelPublish.setBounds(45, 225, 70, 17);
				jLabelPublish.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelDate = new JLabel();
				getContentPane().add(jLabelDate);
				jLabelDate.setText("��������");
				jLabelDate.setBounds(45, 275, 70, 17);
				jLabelDate.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelPrice = new JLabel();
				getContentPane().add(jLabelPrice);
				jLabelPrice.setText("�۸�");
				jLabelPrice.setBounds(45, 324, 70, 17);
				jLabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextName = new JTextField();
				getContentPane().add(jTextName);
				jTextName.setBounds(140, 87, 166, 24);
			}
			{
				jTextType = new JTextField();
				getContentPane().add(jTextType);
				jTextType.setBounds(140, 132, 166, 24);
			}
			{
				jTextWriter = new JTextField();
				getContentPane().add(jTextWriter);
				jTextWriter.setBounds(140, 176, 166, 24);
			}
			{
				jTextPublish = new JTextField();
				getContentPane().add(jTextPublish);
				jTextPublish.setBounds(140, 222, 166, 24);
			}
			{
				jTextDate = new JTextField();
				getContentPane().add(jTextDate);
				jTextDate.setBounds(140, 272, 166, 24);
			}
			{
				jTextPrice = new JTextField();
				getContentPane().add(jTextPrice);
				jTextPrice.setBounds(140, 321, 166, 24);
			}
			{
				jButtonEnsure = new JButton();	//ȷ����ť
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("ȷ��");
				jButtonEnsure.setBounds(78, 389, 67, 25);
				jButtonEnsure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String bookName = jTextName.getText().trim();
						String bookType = jTextType.getText().trim();
						String bookWriter = jTextWriter.getText().trim();
						String publish = jTextPublish.getText().trim();
						String publicDate = jTextDate.getText().trim();
						float bookPrice = Float.parseFloat(jTextPrice.getText().trim());
						//����BookDaoImpl�е�updateBookInfo����
						BookInfo book = new BookInfo(bookId,bookName,bookType,bookWriter,publish,publicDate,bookPrice);
						int result = bookDao.updateBookInfo(book);
						if(result>0){
							JOptionPane.showMessageDialog(UpdateBookFrame.this, "�޸ĳɹ���");
							reset();
							QueryBookFrame queryFrame = QueryBookFrame.getInstance();
							queryFrame.refresh();
							UpdateBookFrame.this.dispose();
							
						}else{
							JOptionPane.showMessageDialog(UpdateBookFrame.this, "�޸�ʧ�ܣ�");
						}
						
						
					}
				});
			}
			{
				jButtonReset = new JButton();	//���ð�ť
				getContentPane().add(jButtonReset);
				jButtonReset.setText("����");
				jButtonReset.setBounds(169, 389, 67, 25);
				jButtonReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						reset();
					}

					
				});
			}
			{
				jButtonReturn = new JButton();	//ȡ����ť
				getContentPane().add(jButtonReturn);
				jButtonReturn.setText("ȡ��");
				jButtonReturn.setBounds(257, 389, 67, 25);
				jButtonReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						UpdateBookFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(417, 485);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * ���÷���
	 */
	private void reset() {
		jTextName.setText("");
		jTextType.setText("");
		jTextWriter.setText("");
		jTextPublish.setText("");
		jTextDate.setText("");
		jTextPrice.setText("");
	}
	

}
