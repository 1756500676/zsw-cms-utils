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

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zhenshuaiwei.utils.DateUtil;
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
		assertTrue(StringUtils.isTelphone("15131027368"));
		String randomStr = StringUtils.getRandomStr(10);
		System.out.println(randomStr);
		String randomStrAndNumber = StringUtils.getRandomStrAndNumber(10);
		System.out.println(randomStrAndNumber);
		String randomChinese = StringUtils.GetRandomChinese(5);
		System.out.println(randomChinese);
	}
	@Test
	public void testDate() {
		int compare = DateUtil.compare(new Date(2000), new Date(1000));
		System.out.println(compare);
	}
	
	@Test
	public void testUrl() {
		String str = "http://news.cnstock.com/news,yw-201908-4413224.htm";
		Pattern p = Pattern.compile("441\\d*");
		Matcher m = p.matcher(str);
		boolean find = m.find();
//		^((?!不想包含的字符串).)*$
		int start = m.start();
		System.out.println(m.group());
		System.out.println(find);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDateAge() throws Throwable {
//		sss
		int age = DateUtil.getAge(new Date("Sat,12 Aug 2001 13:30:00 GMT"));
		System.out.println(age);
		int futureDays = DateUtil.futureDays(new Date("Sat,12 Aug 2019 13:30:00 GMT"));
		System.out.println(futureDays);
	}
	
	@Test
	public void testIsNumber() {
		boolean number = StringUtils.isNumber("-5.0.1");
		System.out.println(number);
	}
}
