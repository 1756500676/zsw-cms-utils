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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/** 
 * @ClassName: DateUtil 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月7日 下午4:25:17  
 */
public class DateUtil {
	
	/**
	 * 一天有多少毫秒
	 */
	static final long millionSecondsPerDay = 1000 * 60 * 60 * 24;

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
    /**
	 * 计算到将来的一个日期 还剩余多少天
	 * 
	 * @param futureDate
	 *            未来的某一天
	 * @return
	 * @throws CmsException
	 */
    public static int futureDays(Date date) {
    	Calendar cal = Calendar.getInstance();
    	if (date.compareTo(new Date()) < 0) {
    		return (int)((date.getTime() - new Date().getTime()) / millionSecondsPerDay);
		}else {
			throw new RuntimeException("日期输入错误");
		}
    }
    
    public static boolean isToday(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return sdf.format(date).equals(sdf.format(new Date()));
    }
    /**
	 * 判断是否在本周
	 * @param date
	 * @return
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		
		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
		
		firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime() < lastDayOfWeek.getTime().getTime()
				&& date.getTime() > firstDayOfWeek.getTime().getTime());

	}
	
	public static Date getBOM(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getEOM(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.MONTH, 1);
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		calendar.add(calendar.SECOND, -1);
		return calendar.getTime();
	}
    
}
