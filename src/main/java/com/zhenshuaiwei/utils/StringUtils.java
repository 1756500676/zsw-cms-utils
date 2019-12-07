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

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @ClassName: StringUtils 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月7日 下午3:14:19  
 */
public class StringUtils {

	/**
	 * 
	 * @Title: isBlank 
	 * @Description: 判断是否为空
	 * @param str
	 * @return
	 * @return: boolean
	 * @date: 2019年11月7日下午3:34:21
	 */
	public static boolean isBlank(String str) {
		return (str == null || "".equals(str.trim()));
	}

	/**
	 * 
	 * @Title: isTelphone 
	 * @Description: 判断是否为手机号
	 * @param tel
	 * @return
	 * @return: boolean
	 * @date: 2019年11月7日下午3:39:15
	 */
	public static boolean isTelphone(String tel) {
		return Pattern.matches("^(13[0-9]|14[5|7]|15[0-9]|18[0-9])\\d{8}$", tel);
	}
	
	/**
	 * 
	 * @Title: isEmail 
	 * @Description: 判断是否为邮箱
	 * @param email
	 * @return
	 * @return: boolean
	 * @date: 2019年11月7日下午3:43:35
	 */
	public static boolean isEmail(String email) {
		return Pattern.matches("^^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email);
	}
	
	/**
	 * 
	 * @Title: isEngils 
	 * @Description: 验证是否为英文
	 * @param str
	 * @return
	 * @return: boolean
	 * @date: 2019年11月7日下午3:46:09
	 */
	public static boolean isEngils(String str) {
		return Pattern.matches("[a-zA-Z]", str);
	}
	
	/**
	 * 
	 * @Title: getRandomStr 
	 * @Description: 获取随机大小写英文字符串
	 * @param n
	 * @return
	 * @return: String
	 * @date: 2019年11月7日下午4:10:05
	 */
	public static String getRandomEnglishStr(int n) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			if (random.nextBoolean()) {
				sb.append((char)('A' + random.nextInt(26)));
			}else {
				sb.append((char)('a' + random.nextInt(26)));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @Title: getRandomStrAndNumber 
	 * @Description: 获取随机大小写英文和数字字符串
	 * @param n
	 * @return
	 * @return: String
	 * @date: 2019年11月7日下午4:21:45
	 */
	public static String getRandomStr(int n) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			switch (random.nextInt(3)) {
			case 0:
				sb.append((char)('A' + random.nextInt(26)));
				break;
			case 1:
				sb.append((char)('a' + random.nextInt(26)));
				break;
			case 2:
				sb.append(random.nextInt(9));
				break;
			default:
				break;
			}
		}
		return sb.toString();
	}
	/**
	 * 
	 * @Title: getRandomNumber 
	 * @Description: 获取随机数字
	 * @param n
	 * @return
	 * @return: String
	 * @date: 2019年11月16日上午8:51:50
	 */
	public static String getRandomNumber(int n) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			sb.append(random.nextInt(9));
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @Title: GetRandomChinese 
	 * @Description: 获取随机中文字符串
	 * @param n
	 * @return
	 * @return: String
	 * @date: 2019年11月10日下午7:02:35
	 */
	public static String getRandomChinese(int n) {
        int hightPos; //
        int lowPos;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
        	String str = "";
        	hightPos = (176 + Math.abs(random.nextInt(39)));
        	lowPos = (161 + Math.abs(random.nextInt(93)));
        	
        	byte[] b = new byte[2];
        	b[0] = (Integer.valueOf(hightPos)).byteValue();
        	b[1] = (Integer.valueOf(lowPos)).byteValue();
        	
        	try {
        		str = new String(b, "GBK");
        	} catch (Exception e) {
        		e.printStackTrace();
        		System.out.println("错误");
        	}
			
        	sb.append(str);
		}
//        return str.charAt(0);
        return sb.toString();
	}
	
	public static String getRandomJianHan(int len)
    {
        String ret="";
          for(int i=0;i<len;i++){
              String str = null;
              int hightPos, lowPos; // 定义高低位
              Random random = new Random();
              hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
              lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
              byte[] b = new byte[2];
              b[0] = (new Integer(hightPos).byteValue());
              b[1] = (new Integer(lowPos).byteValue());
              try
              {
                  str = new String(b, "GBk"); //转成中文
              }
              catch (UnsupportedEncodingException ex)
              {
                  ex.printStackTrace();
              }
               ret+=str;
          }
      return ret;
    }
	
	/**
	 * 
	 * @Title: generateChineseName 
	 * @Description: 获取随机姓名
	 * @return
	 * @return: String
	 * @date: 2019年11月16日上午8:38:46
	 */
	public static String generateChineseName() {
		int hightPos; //
		int lowPos;
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		String[] arr = {"赵 ","钱","孙","李","周","吴","郑 ","王","冯","陈","褚","杨","朱","许","何","吕","张","孔","曹","严","华","金","魏"};
		sb.append(arr[random.nextInt(arr.length - 1)]);
		for (int i = 0; i < 2; i++) {
			String str = "";
			hightPos = (176 + Math.abs(random.nextInt(39)));
			lowPos = (161 + Math.abs(random.nextInt(93)));
			
			byte[] b = new byte[2];
			b[0] = (Integer.valueOf(hightPos)).byteValue();
			b[1] = (Integer.valueOf(lowPos)).byteValue();
			
			try {
				str = new String(b, "GBK");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("错误");
			}
			
			sb.append(str);
		}
		
//        return str.charAt(0);
		return sb.toString();
	}
	
	
	

	/**
	 * 
	 * @Title: isNumber 
	 * @Description: 判断是否为数字,包括小数,可选择是否允许负数
	 * @param str
	 * @return
	 * @return: boolean
	 * @date: 2019年11月10日下午7:06:31
	 */
	public static boolean isNumber(String str,boolean allowMiuns){
		if (allowMiuns) {
			return Pattern.matches("^\\-?\\d+(\\.\\d+)?$",str);
		}else {
			return Pattern.matches("^\\d+(\\.\\d+)?$",str);
		}
		
	}
	
	/**
	 * 
	 * @Title: getPlaceholderValue 
	 * @Description: 给定的正则表达式去匹配字符串
	 * @param src
	 * @param regex
	 * @return
	 * @return: String
	 * @date: 2019年11月8日上午9:25:55
	 */
	public static String getPlaceholderValue(String str, String regex){
		Pattern compile = Pattern.compile(regex);
		String string = compile.matcher(str).group();
		return string;
	}
	
	  
	/**
	 * 
	 * @Title: getMail 
	 * @Description: 随机生成邮箱
	 * @return
	 * @return: String
	 * @date: 2019年12月7日上午9:21:45
	 */
    public static String getMail(int minSize,int maxSize){
        String [] last = {"@qq.com", "@gmail.com", "@163.com", "@sina.com", "@hotmail.com", "@sohu.com"};
        StringBuffer sb = new StringBuffer();
        // 3~20长度，包含3及20
        Random random = new Random();
        int length = minSize + random.nextInt(maxSize - minSize);
        sb.append(getRandomStr(length));
        sb.append(last[random.nextInt(last.length)]);
        return sb.toString();
    }
	
	
	
}
