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
package com.zhenshuaiwei.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: FileUtil 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月8日 下午6:27:07  
 */
public class FileUtil {

	@SuppressWarnings("resource")
	public static List<String> getFileRow(File file){
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
	
	
	
	
	
}
