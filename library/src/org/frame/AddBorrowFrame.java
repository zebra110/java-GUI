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

import org.entity.Borrow;
import org.impl.BorrowDaoImpl;
import org.interfaceDao.BorrowDao;

//������Ϣ ͼ��軹����
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
public class AddBorrowFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JLabel jLabelReaderId;
	private JLabel jLabelDate;
	private JTextField jTextBookId;
	private JLabel jLabelBack;
	private JButton jButtonUpdate;
	private JButton jButtonCancel;
	private JButton jButtonEnsure;
	private JTextField jTextBackDate;
	private JTextField jTextBorrowDate;
	private JTextField jTextReaderId;
	private JLabel jLabelBookId;
	private BorrowDao borrowDao = new BorrowDaoImpl();
	//private int borrowId;


	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public AddBorrowFrame() {
		super();
		initGUI();
	}
		/*public AddBorrowFrame(int borrowId) {
			super();
			this.borrowId = borrowId;
			initGUI();
			fillInfo();
		}*/
	/*public void fillInfo(){
		jLabelTitle.setText("�޸Ľ�����Ϣ");
		jButtonEnsure.setVisible(false);
		jButtonUpdate.setVisible(true);
		Borrow borrow = borrowDao.queryBorrowById(borrowId);
		jTextReaderId.setText(borrow.getReaderId()+"");
		jTextBookId.setText(borrow.getBookId()+"");
		jTextBorrowDate.setText(borrow.getBorrowDate());
		jTextBackDate.setText(borrow.getBackDate());
	}*/
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("ͼ����Ĺ���");
				jLabelTitle.setBounds(90, 18, 139, 26);
				jLabelTitle.setFont(new java.awt.Font("����",1,20));
				jLabelTitle.setHorizontalTextPosition(SwingConstants.CENTER);
				jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelReaderId = new JLabel();
				getContentPane().add(jLabelReaderId);
				jLabelReaderId.setText("����֤��");
				jLabelReaderId.setBounds(49, 68, 59, 17);
			}
			{
				jLabelBookId = new JLabel();
				getContentPane().add(jLabelBookId);
				jLabelBookId.setText("ͼ���");
				jLabelBookId.setBounds(49, 122, 59, 17);
			}
			{
				jLabelDate = new JLabel();
				getContentPane().add(jLabelDate);
				jLabelDate.setText("��������");
				jLabelDate.setBounds(49, 171, 59, 17);
			}
			{
				jTextReaderId = new JTextField();
				getContentPane().add(jTextReaderId);
				jTextReaderId.setBounds(125, 65, 135, 24);
			}
			{
				jTextBookId = new JTextField();
				getContentPane().add(jTextBookId);
				jTextBookId.setBounds(125, 119, 135, 24);
			}
			{
				jTextBorrowDate = new JTextField();
				getContentPane().add(jTextBorrowDate);
				jTextBorrowDate.setBounds(125, 168, 135, 24);
			}
			{
				jLabelBack = new JLabel();
				getContentPane().add(jLabelBack);
				jLabelBack.setText("�黹����");
				jLabelBack.setBounds(49, 215, 58, 17);
			}
			{
				jTextBackDate = new JTextField();
				getContentPane().add(jTextBackDate);
				jTextBackDate.setBounds(125, 212, 135, 24);
			}
			{
				jButtonEnsure = new JButton();//ȷ����ť
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("ȷ��");
				jButtonEnsure.setBounds(61, 267, 64, 24);
				jButtonEnsure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						int readerId = Integer.parseInt(jTextReaderId.getText().trim());
						int bookId = Integer.parseInt(jTextBookId.getText().trim());
						String borrowDate = jTextBorrowDate.getText().trim();
						String backDate = jTextBackDate.getText().trim();
						Borrow borrow = new Borrow(readerId,bookId,borrowDate,backDate);
						int result = borrowDao.borrowBook(borrow);
						if(result>0){
							JOptionPane.showMessageDialog(AddBorrowFrame.this, "����ɹ���");
							reset();
						}else{
							JOptionPane.showMessageDialog(AddBorrowFrame.this, "����ʧ�ܣ�");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();//ȡ����ť
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("ȡ��");
				jButtonCancel.setBounds(181, 267, 64, 24);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						AddBorrowFrame.this.dispose();
					}
				});
			}
			
			pack();
			this.setSize(340, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void reset(){
		
		jTextBookId.setText("");
		jTextReaderId.setText("");
		jTextBorrowDate.setText("");
		jTextBackDate.setText("");
	}

}
