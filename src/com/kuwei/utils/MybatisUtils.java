package com.kuwei.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sf;
	private static InputStream inputStream;
	
	static{
		try {
			String resource = "sqlMapConfig.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sf = new SqlSessionFactoryBuilder().build(inputStream);
	}
	

}
