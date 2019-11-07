/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: StringUtils.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.zhenshuaiwei.utils 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月7日 下午3:14:19 
 * @version: V1.0   
 */
package com.zhenshuaiwei.utils;

/** 
 * @ClassName: StringUtils 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月7日 下午3:14:19  
 */
public class StringUtils {

	public static boolean isBlank(String str) {
		return (str == null || "".equals(str.trim()));
	}
	
}
