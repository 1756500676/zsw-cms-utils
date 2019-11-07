/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Demo01.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.se.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月7日 下午3:17:14 
 * @version: V1.0   
 */
package com.se.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.zhenshuaiwei.utils.StringUtils;

/** 
 * @ClassName: Demo01 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月7日 下午3:17:14  
 */
public class Demo01 {

	@Test
	public void test01(){
//		要求必须为true不会报错,否则会报错---断言
		assertTrue(StringUtils.isBlank(null));
	}
}
