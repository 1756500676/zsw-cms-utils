/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: DateUtil.java 
 * @Prject: zhenshuaiwei-utils
 * @Package: com.zhenshuaiwei.utils 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月7日 下午4:25:17 
 * @version: V1.0   
 */
package com.zhenshuaiwei.utils;

import java.util.Calendar;
import java.util.Date;

/** 
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月7日 下午4:25:17  
 */
public class DateUtil {

	public static int compare(Date date1,Date date2) {
		if (date1 == null && date2 == null) {
			throw new RuntimeException("参数不可为空");
		}
		return date1.compareTo(date2);
	}
	
    public static  int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);   
 
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);   
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  
}
