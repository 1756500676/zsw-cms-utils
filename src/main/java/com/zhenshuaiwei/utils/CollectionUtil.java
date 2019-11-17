/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CollectionUtil.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.zhenshuaiwei.utils 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月11日 上午8:53:03 
 * @version: V1.0   
 */
package com.zhenshuaiwei.utils;

import java.util.Collection;

/** 
 * @ClassName: CollectionUtil 
 * @Description: 集合工具类
 * @author:zsw 
 * @date: 2019年11月11日 上午8:53:03  
 */
public class CollectionUtil {
	
	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断集合是否为空
	 * @param src
	 * @return
	 * @return: boolean
	 * @date: 2019年11月11日上午8:55:12
	 */
	public static boolean isEmpty(Collection<?> src){
		if (src == null) {
			return true;
		}
		return src.isEmpty();
	}

}
