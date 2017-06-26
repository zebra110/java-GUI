package org.interfaceDao;

import java.util.List;

import org.entity.Readers;


public interface ReaderDao {
	
	public int addReader(Readers reader);
	public int updateReader(Readers reader);
	public int deleteReader(int readerId);
	public Readers queryReaderById(int readerId);
	public List<Readers> queryReader();
	
}
