package com.okgo.leetcode.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/9/3 8:51
 * @title Function
 */
public class Test {
    public  static SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");

    public  static  void  main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 待确认交易日：15点之前取当前日期，15点之后取下一交易日
        String nextDay = sdf.format(new Date());
        if (cal.get(Calendar.HOUR_OF_DAY) >= 15) {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                cal.add(Calendar.DAY_OF_MONTH, 3);
                nextDay = sdf.format(cal.getTime());
            } else {
                nextDay = getNextDay(nextDay);
            }
        }

        nextDay = "20150930";
        // 时间必须要从小到大排序，否则会出问题
        String[] a = {"20150930", "20151002", "20151003", "20151005", "20151006"};
        List<String> holidayList = Arrays.asList(a);
        System.out.println("有效的最近交易日nextDay:"  + getDayAfterHoliday(nextDay, holidayList));
    }

    public  static  String getDayAfterHoliday(String nextDay, List<String> holidayList) {
        if  (null  != holidayList) {
            for  (int  i = 0; i < holidayList.size(); i++) {
                if  (holidayList.get(i).equals(nextDay)) {
                    nextDay = getDayAfterHoliday(getNextDay(nextDay), holidayList);
                }
            }
        }
        nextDay = getDayExceptWeekend(nextDay);
        return  nextDay;
    }

    /**
     * 获取下一天
     *
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  String getNextDay(String day) {
        Calendar cal = formatYYYYMMDD(day);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return  sdf.format(cal.getTime());
    }

    /**
     * 如果当前日期处于周末，则返回下周一
     *
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  String getDayExceptWeekend(String day) {
        Calendar cal = formatYYYYMMDD(day);
        if  (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 2);
        } else  if  (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return  sdf.format(cal.getTime());
    }

    /**
     * 将字符串类型日期转换为Calendar
     *
     * @param day 当前日期yyyyMMdd
     * @return
     */
    public  static  Calendar formatYYYYMMDD(String day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(day.substring(0, 4)), (Integer.parseInt(day.substring(4, 6)) - 1), Integer.parseInt(day.substring(6)));
        return  cal;
    }
}
