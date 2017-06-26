/**
 * 解决普通IOHelper在读取多个对象时所存在的问题（只能读取第一个对象）
 * 问题原因：普通IOHelper在以追加方式写对象时，每次都会加入头部信息。
 *          而在读取对象时并不会过滤到后续的头部信息。
 */
package org.util;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamHeadFilter extends ObjectOutputStream {
	/**
	 * writeStreamHeader()方法是在ObjectOutputStream的构造方法里调用的
	 * 由于覆盖后的writeStreamHeader()方法用到了file。如果直接用此构造方法创建
	 * 一个ObjectOutputStreamHeadFilter对象，那么writeStreamHeader()中的file是空指针
	 * 因为file还没有初始化。所以这里采用单例模式
	 */
	private static File file;

	private ObjectOutputStreamHeadFilter(OutputStream out, File file)
			throws IOException, SecurityException {
		super(out);
	}

	// 返回一个ObjectOutputStreamHeadFilter对象，这里保证了new
	// ObjectOutputStreamHeadFilter(out, f)
	// 之前file已经指向一个File对象
	public static ObjectOutputStreamHeadFilter newInstance(File f,
			OutputStream out) throws IOException {
		file = f;// 本方法最重要的地方:构建文件对象，两个引用指向同一个文件对象
		return new ObjectOutputStreamHeadFilter(out, file);
	}

	@Override
	// 重写父类的writeStreamHeader方法
	protected void writeStreamHeader() throws IOException {
		// 文件不存在或文件为空,此时是第一次写入文件，所以要把头部信息写入。
		if (!file.exists() || (file.exists() && file.length() == 0)) {
			super.writeStreamHeader();
		} // 否则不需要做任何事情
	}
}
