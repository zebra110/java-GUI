/**
 * �����ͨIOHelper�ڶ�ȡ�������ʱ�����ڵ����⣨ֻ�ܶ�ȡ��һ������
 * ����ԭ����ͨIOHelper����׷�ӷ�ʽд����ʱ��ÿ�ζ������ͷ����Ϣ��
 *          ���ڶ�ȡ����ʱ��������˵�������ͷ����Ϣ��
 */
package org.util;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamHeadFilter extends ObjectOutputStream {
	/**
	 * writeStreamHeader()��������ObjectOutputStream�Ĺ��췽������õ�
	 * ���ڸ��Ǻ��writeStreamHeader()�����õ���file�����ֱ���ô˹��췽������
	 * һ��ObjectOutputStreamHeadFilter������ôwriteStreamHeader()�е�file�ǿ�ָ��
	 * ��Ϊfile��û�г�ʼ��������������õ���ģʽ
	 */
	private static File file;

	private ObjectOutputStreamHeadFilter(OutputStream out, File file)
			throws IOException, SecurityException {
		super(out);
	}

	// ����һ��ObjectOutputStreamHeadFilter�������ﱣ֤��new
	// ObjectOutputStreamHeadFilter(out, f)
	// ֮ǰfile�Ѿ�ָ��һ��File����
	public static ObjectOutputStreamHeadFilter newInstance(File f,
			OutputStream out) throws IOException {
		file = f;// ����������Ҫ�ĵط�:�����ļ�������������ָ��ͬһ���ļ�����
		return new ObjectOutputStreamHeadFilter(out, file);
	}

	@Override
	// ��д�����writeStreamHeader����
	protected void writeStreamHeader() throws IOException {
		// �ļ������ڻ��ļ�Ϊ��,��ʱ�ǵ�һ��д���ļ�������Ҫ��ͷ����Ϣд�롣
		if (!file.exists() || (file.exists() && file.length() == 0)) {
			super.writeStreamHeader();
		} // ������Ҫ���κ�����
	}
}
