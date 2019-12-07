/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: FileUtil.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.zhenshuaiwei.utils 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月8日 下午6:27:07 
 * @version: V1.0   
 */
package com.zhenshuaiwei.fileutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/** 
 * @ClassName: FileUtil 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月8日 下午6:27:07  
 */
public class FileUtil {

	/**
	 * 
	 * @Title: getFileRow 
	 * @Description: 读取文本文件,一行为一个字符串对象存入集合
	 * @param file
	 * @return
	 * @return: List<String>
	 * @date: 2019年11月10日下午6:36:44
	 */
	@SuppressWarnings("resource")
	public static List<String> getFileRow(String filePath){
		File file = new File(filePath);
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (file.exists()) {
				BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String str = null;
				while((str = read.readLine()) != null) {
					list.add(str);
				}
				return list;
			}else {
				throw new RuntimeException("文件不存在");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @Title: delFileByPath 
	 * @Description: 删除文件夹
	 * @param filePath
	 * @return: void
	 * @date: 2019年11月10日下午6:45:06
	 */
	public static void delFileByPath(String filePath) {
		
		File file = new File(filePath);
		//文件不存在,不执行下代码
		if (!file.exists()) {
			return;
		}
		
		if(file.isFile()) {
			file.delete();
			return;
		}
		
		if (file.isDirectory()) {
			String[] files = file.list();
			for (String string : files) {
				//递归调用
				delFileByPath(filePath+"\\"+string);
			}
			//删除子目录后删除自己
			file.delete();
		}
	}

	/**
	 * 
	 * @Title: getFileSuffix 
	 * @Description: 获取文件的扩展名
	 * @param filePath
	 * @return
	 * @return: String
	 * @date: 2019年11月10日下午6:48:57
	 */
	public static String getFileSuffix(String filePath) {
		int indexOf = filePath.lastIndexOf(".");
		//不存在
		if (indexOf < 0 ) {
			return "";
		}
		//最后一个
		if (indexOf > filePath.length() ) {
			return "";
		}
		return filePath.substring(indexOf + 1);
	}
	
	/**
	 * 
	 * @Title: getFileSize 
	 * @Description: 获取文件的指定大小单位表示
	 * @param filePath
	 * @param fileSize
	 * @return
	 * @return: long
	 * @date: 2019年11月10日下午6:55:45
	 */
	public long getFileSize(String filePath,FileSize fileSize) {
		long size = new File(filePath).length();
		switch (fileSize) {
			case B:
				return size;
			case KB:
				return size/1024;
			case MB:
				return size/1024/1024;
			case GB:
				return size/1024/1024/1024;
			case TB:
				return size/1024/1024/1024/1024;
			case PB:
				return size/1024/1024/1024/1024/1024;
			default:
				return 0;
		}
	}
	
	
	
	
	
	
	
	
	
}
