package com.jhw.util.timedate;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeDateUtil
 * @Description TODO(日期时间管理)
 * @author Administrator
 * @Date 2017年9月22日 下午2:38:29
 * @version 1.0.0
 */
public class TimeDateUtil {

    /**
     * @Description (TODO 获取当前时间戳)
     * @return
     */
    public static String getCurrentTimeStamp(){
        String stampStr = "";
        Date mDate = new Date();
        long time = mDate.getTime();
        stampStr = String.valueOf(time);
        return stampStr;
    }
   
    /**
     * 
     * @Description (TODO 以yyyy-MM-dd HH:mm:ss格式返回当前时间)
     * @return
     * @throws ParseException 
     */
    public static String formatCurrentDate() throws ParseException{
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(currentDate);
    }
    
    /**
     * @Description (TODO 根据日期时间字符串计算其与当前时间的间隔)
     * @param dateTime
     * @return
     */
    public static long countDateTimeSpace(String dateTime){
    	if (dateTime == null || dateTime.length()==0) {
			return 0;
		}
    	try {
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date paramDate = dateFormat.parse(dateTime);
    		long space = System.currentTimeMillis() - paramDate.getTime();
    		return space/1000/60/60/24;
		} catch (ParseException e) {
			return 0;
		}
    }
    
    
    /**
     * @Description (TODO 根据毫秒数转换为yyyy-MM-dd HH:mm:ss格式日期)
     * @param dateTime
     * @return
     */
    public static String formatLongToDate(long dateTime){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date paramDate = new Date(dateTime);
		return dateFormat.format(paramDate);
    }
    
}
