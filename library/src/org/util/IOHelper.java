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
	 * @Description: 输出相关信息
	 * @return 无
	 */
	public static void outputInfo(String prompt) {
		JOptionPane.showMessageDialog(null,prompt);
	}

	/**
	 * @Title: outputException
	 * @Description: 输出异常信息
	 * @return 无
	 */
	public static void outputException(String prompt) {
		JOptionPane.showMessageDialog(null,prompt);
	}

	/**
	 * @Title: write
	 * @Description: 把一个对象写入文件
	 * @param String
	 *            filePath 欲写入的文件名，包含路径 Object object 欲写入的对象 boolean isAppend
	 *            写入方式：true表示追加方式写，false表示重新写
	 * @return 无
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
	 * @Description: 把一个对象数组写入文件
	 * @param String
	 *            filePath 欲写入的文件名，包含路径 Object[] objects 欲写入的对象数组 boolean
	 *            isAppend 写入方式：true表示追加方式写，false表示重新写
	 * @return 无
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
	 * @Description: 从文件中读取对象
	 * @param String
	 *            filePath 欲写入的文件名，包含路径
	 * @return 读取到的对象
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
	 * @Description: 从文件中读取对象(多个)
	 * @param String
	 *            filePath 欲写入的文件名，包含路径 int count 欲读取的对象数量
	 * @return 读取到的对象数组
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
