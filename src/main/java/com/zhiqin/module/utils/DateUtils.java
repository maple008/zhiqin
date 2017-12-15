package com.zhiqin.module.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author panbo
 */
public class DateUtils {

    public static void main(String[] args) {
        System.out.println("当前小时开始：" + getCurrentHourStartTime().toString());
        System.out.println("当前小时结束：" + getCurrentHourEndTime().toString());
        System.out.println("当前天开始：" + getCurrentDayStartTime().toString());
        System.out.println("当前天时结束：" + getCurrentDayEndTime().toString());
        System.out.println("当前周开始：" + getCurrentWeekDayStartTime().toString());
        System.out.println("当前周结束：" + getCurrentWeekDayEndTime().toString());
        System.out.println("当前月开始：" + getCurrentMonthStartTime().toString());
        System.out.println("当前月结束：" + getCurrentMonthEndTime().toString());
        System.out.println("当前季度开始：" + getCurrentQuarterStartTime().toString());
        System.out.println("当前季度结束：" + getCurrentQuarterEndTime().toString());
        System.out.println("当前半年/后半年开始：" + getHalfYearStartTime().toString());
        System.out.println("当前半年/后半年结束：" + getHalfYearEndTime().toString());
        System.out.println("当前年开始：" + getCurrentYearStartTime().toString());
        System.out.println("当前年结束：" + getCurrentYearEndTime().toString());
    }

    /**
     * 获取 当前年、半年、季度、月、日、小时 开始结束时间
     */
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 获得本周的第一天，周一
     *
     * @return
     */
    public static Date getCurrentWeekDayStartTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     * 获得本周的最后一天，周日
     *
     * @return
     */
    public static Date getCurrentWeekDayEndTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE, 8 - weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     * 获得本天的开始时间
     *
     * @return
     */
    public static Date getCurrentDayStartTime() {
        Date now = new Date();
        try {
            now = shortSdf.parse(shortSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本天的结束时间
     *
     * @return
     */
    public static Date getCurrentDayEndTime() {
        Date now = new Date();
        try {
            now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本小时的开始时间
     *
     * @return
     */
    public static Date getCurrentHourStartTime() {
        Date now = new Date();
        try {
            now = longHourSdf.parse(longHourSdf.format(now));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本小时的结束时间
     *
     * @return
     */
    public static Date getCurrentHourEndTime() {
        Date now = new Date();
        try {
            now = longSdf.parse(longHourSdf.format(now) + ":59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本月的开始时间
     *
     * @return
     */
    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 本月的结束时间
     *
     * @return
     */
    public static Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的开始时间
     *
     * @return
     */
    public static Date getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前年的结束时间
     *
     * @return
     */
    public static Date getCurrentYearEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            /*
            月份，忽略魔法值
             */
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 3);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 4);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 9);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取前/后半年的开始时间
     *
     * @return
     */
    public static Date getHalfYearStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 6);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }

    /**
     * 获取前/后半年的结束时间
     *
     * @return
     */
    public static Date getHalfYearEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取当前日期前后i天的Date,i为0则到0点，为1则精确到当前时分秒，j为变更日期，正为后，负为前。
     */
    public static Date getDate(Integer isPreciseTime, Integer date) {
        Calendar today = Calendar.getInstance();
        try {
            if (isPreciseTime == 0) {
                String dateTime = shortSdf.format(new Date());
                //当前日期
                Date todayDate = shortSdf.parse(dateTime);
                //转成Calendar类
                today.setTime(todayDate);
            }
            today.add(Calendar.DATE, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return today.getTime();
    }

    /**
     * 获取给定日期前后days天的Date
     * isPreciseTime为0则到0点，为1则精确到当前时分秒
     * days为变更日期，正为后，负为前。
     */
    public static Date getDate(Integer isPreciseTime, Integer days, Date date) {
        Calendar calendar = Calendar.getInstance();
        if (isPreciseTime == 0) {
            calendar.setTime(getDatePart(date));
        } else {
            calendar.setTime(date);
        }
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 获取给定时间的日期部分
     */
    public static Date getDatePart(Date date) {
        String dateStr = shortSdf.format(date);
        return parseDate(dateStr);
    }

    /**
     * 格式化日期
     */
    public static Date parseDate(String dateStr) {
        Date date = new Date();
        try {
            date = shortSdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化时间
     */
    public static Date parseTime(String timeStr) {
        Date date = new Date();
        try {
            date = longSdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 转换日期
     */
    public static String formatDate(Date date) {
        return shortSdf.format(date);
    }

    /**
     * 转换时间
     */
    public static String formatTime(Date date) {
        return longSdf.format(date);
    }

    public static Integer getDatePoor(Date createDate, Date nowDate, int count) {
        long nd = 1000 * 24 * 60 * 60;
        long l = nowDate.getTime() - createDate.getTime();
        if (l >= count * nd) {
            return 1;
        }
        return 0;
    }

    public static final int UNIT_SECCENT = 1000;
    public static final int UNIT_MINUTE = UNIT_SECCENT * 60;
    public static final int UNIT_HOUR = UNIT_MINUTE * 60;
    public static final int UNIT_DAY = UNIT_HOUR * 24;

    public static int getTimeLag(Date date1, Date date2, int unit) {
        if (Objects.nonNull(date1) && Objects.nonNull(date2)) {
            return getTimeLag(date1.getTime(), date2.getTime(), unit);
        }
        return -1;
    }

    public static int getTimeLag(long date1, long date2, int unit) {
        long timeLag = getTimeLag(date1, date2);
        return (int) (timeLag / unit);
    }

    public static long getTimeLag(long date1, long date2) {
        long timeLag = Math.abs(date1 - date2);
        return timeLag;
    }

    public static long getTimeLag(Date date1, Date date2) {
        return getTimeLag(date1.getTime(), date2.getTime());
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date      日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差天数
     */
    public static int getIntervalDays(String date, String otherDate) {
        return getIntervalDays(parseTime(date), parseTime(otherDate));
    }

    /**
     * @param date      日期
     * @param otherDate 另一个日期
     * @return 相差天数
     */
    public static int getIntervalDays(Date date, Date otherDate) {
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return (int) time / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date      日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差小时数
     */
    public static int getIntervalHours(String date, String otherDate) {
        return getIntervalDays(parseTime(date), parseTime(otherDate));
    }

    /**
     * @param date      日期
     * @param otherDate 另一个日期
     * @return 相差小时数
     */
    public static int getIntervalHours(Date date, Date otherDate) {
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return (int) time / (60 * 60 * 1000);
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date      日期字符串
     * @param otherDate 另一个日期字符串
     * @return 相差分钟数
     */
    public static int getIntervalMin(String date, String otherDate) {
        return getIntervalMin(parseTime(date), parseTime(otherDate));
    }

    /**
     * @param date      日期
     * @param otherDate 另一个日期
     * @return 相差分钟数
     */
    public static int getIntervalMin(Date date, Date otherDate) {
        long time = Math.abs(date.getTime() - otherDate.getTime());
        return (int) time / (60 * 1000);
    }

    /**
     * 获取当前时间time，amount之后的时间
     *
     * @param time
     * @param amount
     * @return
     */
    public static Date addTimeForHour(String time, int amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR_OF_DAY, amount);
        return ca.getTime();
    }

    /**
     * 获取当前时间date,amount之后的时间
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addTimeForHour(Date date, int amount) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR_OF_DAY, amount);
        return ca.getTime();
    }
}





