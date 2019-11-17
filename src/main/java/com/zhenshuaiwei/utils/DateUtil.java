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

	/**
	 * 
	 * @Title: compare 
	 * @Description: 判断两个日期那个大,.0代表第一个大,1代表第二个
	 * @param date1
	 * @param date2
	 * @return
	 * @return: int
	 * @date: 2019年11月10日下午6:31:21
	 */
	public static int compare(Date date1,Date date2) {
		if (date1 == null && date2 == null) {
			throw new RuntimeException("参数不可为空");
		}
		return date1.compareTo(date2);
	}
	
	/**
	 * 
	 * @Title: getAge 
	 * @Description: 根据生日获取年龄
	 * @param birthDay
	 * @return
	 * @throws Exception
	 * @return: int
	 * @date: 2019年11月10日下午6:32:07
	 */
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
    
    /**
     * 
     * @Title: isToday 
     * @Description: 判断是否是今天
     * @param date
     * @return
     * @return: boolean
     * @date: 2019年11月10日下午6:32:35
     */
    public static boolean isCurrentToday(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return sdf.format(date).equals(sdf.format(new Date()));
    }
    
    /**
	 * 3.4.4判断是否为当月
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
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
	
	/**
	 * 
	 * @Title: getBOM 
	 * @Description: 获取这个月的第一天
	 * @param date
	 * @return
	 * @return: Date
	 * @date: 2019年11月10日下午6:32:51
	 */
	public static Date getMonthStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.DAY_OF_MONTH, 1);
		calendar.set(calendar.HOUR, 0);
		calendar.set(calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @Title: getEOM 
	 * @Description: 获取这个月的最后一天
	 * @param date
	 * @return
	 * @return: Date
	 * @date: 2019年11月10日下午6:33:12
	 */
	public static Date getMonthEnd(Date date) {
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
	
	
	public static Date randomHireday2() {
		int startYear=1950;
		int endYear=2019;
		int year = (int)(Math.random()*(endYear-startYear+1))+startYear;	//随机年
		int month= (int)(Math.random()*12)+1;								//随机月
		Calendar c = Calendar.getInstance();				//创建Calendar对象
		c.set(year, month, 0);								//设定日期
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);		//获取对应年月有几天
		int day=(int)(Math.random()*dayOfMonth+1)	;		//产生随机日
		Date hireday=java.sql.Date.valueOf(year+"-"+month+"-"+day);	//通过valueOf方法生成Date对象
		return hireday;
	}
    
}
