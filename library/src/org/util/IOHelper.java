/**
 * 
 */
package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class IOHelper {
	
	public static String inputInfo(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();
	}

	/**
	 * @Title: outputInfo
	 * @Description: ��������Ϣ
	 * @return ��
	 */
	public static void outputInfo(String prompt) {
		JOptionPane.showMessageDialog(null,prompt);
	}

	/**
	 * @Title: outputException
	 * @Description: ����쳣��Ϣ
	 * @return ��
	 */
	public static void outputException(String prompt) {
		JOptionPane.showMessageDialog(null,prompt);
	}

	/**
	 * @Title: write
	 * @Description: ��һ������д���ļ�
	 * @param String
	 *            filePath ��д����ļ���������·�� Object object ��д��Ķ��� boolean isAppend
	 *            д�뷽ʽ��true��ʾ׷�ӷ�ʽд��false��ʾ����д
	 * @return ��
	 */
	public static void write(String filePath, Object object, boolean isAppend)
			throws Exception {
		if (object == null)
			return;
		File file = new File(filePath);
		ObjectOutputStreamHeadFilter out = ObjectOutputStreamHeadFilter
				.newInstance(file, new FileOutputStream(file, isAppend));
		try {
			out.writeObject(object);
		} finally {
			out.close();
		}
	}

	/**
	 * @Title: write
	 * @Description: ��һ����������д���ļ�
	 * @param String
	 *            filePath ��д����ļ���������·�� Object[] objects ��д��Ķ������� boolean
	 *            isAppend д�뷽ʽ��true��ʾ׷�ӷ�ʽд��false��ʾ����д
	 * @return ��
	 */
	public static void write(String filePath, Object[] objects, boolean isAppend) {
		if (objects == null)
			return;
		try {
			File file = new File(filePath);
			ObjectOutputStreamHeadFilter out = ObjectOutputStreamHeadFilter
					.newInstance(file, new FileOutputStream(file, isAppend));
			try {
				for (Object o : objects)
					out.writeObject(o);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			outputException(e.getMessage());
		}
	}

	/**
	 * @Title: read
	 * @Description: ���ļ��ж�ȡ����
	 * @param String
	 *            filePath ��д����ļ���������·��
	 * @return ��ȡ���Ķ���
	 */
	public static Object read(String filePath) throws Exception {
		Object object = null;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				filePath));
		try {
			object = in.readObject();
		} finally {
			in.close();
		}
		return object;
	}

	/**
	 * @Title: read
	 * @Description: ���ļ��ж�ȡ����(���)
	 * @param String
	 *            filePath ��д����ļ���������·�� int count ����ȡ�Ķ�������
	 * @return ��ȡ���Ķ�������
	 */
	public static Object[] read(String filePath, int count) {
		Object[] objects = new Object[count];
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					filePath));
			try {
				for (int i = 0; i < count; i++) {
					objects[i] = in.readObject();
				}
			} finally {
				in.close();
			}
		} catch (Exception e) {
			outputException(e.getMessage());
		}
		return objects;
	}
}
