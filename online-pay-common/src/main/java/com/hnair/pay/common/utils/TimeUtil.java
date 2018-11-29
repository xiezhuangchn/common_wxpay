package com.hnair.pay.common.utils;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtil {
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;
    public static final long MILLIS_PER_DAY = 86400000L;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public static final String yyyy_MM_dd_CH = "yyyy年MM月dd日";
    public static final String yyyy_MM_dd_HH_mm_CH = "yyyy年MM月dd日 HH:mm";
    public static final String MM_dd_CH = "MM月dd日";
    public static final String MM_dd = "MM-dd";
    public static final String HH_mm = "HH:mm";
    public static final String HH_mm_ss = "HH:mm:ss";
    public static final String MM_dd_CH_HH_mm = "MM月dd日 HH:mm";
    public static final String MM_dd_HH_mm = "MM-dd HH:mm";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy_MM = "yyyy-MM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddHH = "yyyyMMddHH";
    public static final String yyyy_MM_dd_00_00_00 = "yyyy-MM-dd 00:00:00";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public TimeUtil() {
    }

    public static Date parse_yyyy_MM_dd(String timeStr) {
        return parse("yyyy-MM-dd", timeStr);
    }

    public static Date parse_yyyy_MM(String timeStr) {
        return parse("yyyy-MM", timeStr);
    }

    public static Date parse_yyyy_MM_dd_HH_mm_ss(String timeStr) {
        return parse("yyyy-MM-dd HH:mm:ss", timeStr);
    }

    public static String format_yyyy_MM_dd_HH_mm_ss(Date date) {
        return formate("yyyy-MM-dd HH:mm:ss", date);
    }

    public static String format_MM_dd(Date date) {
        return formate("MM-dd", date);
    }

    public static String format_MM_dd_HH_mm(Date date) {
        return formate("MM-dd HH:mm", date);
    }

    public static String format_yyyy_MM_dd_HH_mm(Date date) {
        return formate("yyyy-MM-dd HH:mm", date);
    }

    public static String format_HH_mm(Date date) {
        return formate("HH:mm", date);
    }

    public static String format_yyyy_mm_dd_ch(Date date) {
        return formate("yyyy年MM月dd日", date);
    }

    public static String format_yyyyMMddHH(Date date) {
        return formate("yyyyMMddHH", date);
    }

    public static String format_yyyy_mm_dd_HH_mm_ch(Date date) {
        return formate("yyyy年MM月dd日 HH:mm", date);
    }

    public static String format_MM_dd_CH(Date date) {
        return formate("MM月dd日", date);
    }

    public static String format_MM_dd_CH_HH_mm(Date date) {
        return formate("MM月dd日 HH:mm", date);
    }

    public static String format_yyyy_MM_dd_00_00_00(Date date) {
        return formate("yyyy-MM-dd 00:00:00", date);
    }

    public static String format_yyyy_MM_dd(Date date) {
        return formate("yyyy-MM-dd", date);
    }

    public static String format_yyyy_MM(Date date) {
        return formate("yyyy-MM", date);
    }

    public static String yyyyMMdd(Date date) {
        return formate("yyyyMMdd", date);
    }

    public static Date parse_yyyy_MM_dd_HH_mm(String timeStr) {
        return parse("yyyy-MM-dd HH:mm", timeStr);
    }

    public static Date parse(String format, String timeStr) {
        SimpleDateFormat formatSim = new SimpleDateFormat(format);
        Date d = null;

        try {
            d = formatSim.parse(timeStr);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return d;
    }

    public static String formate(String format, Date date) {
        SimpleDateFormat formatSim = new SimpleDateFormat(format);
        String s = formatSim.format(date);
        return s;
    }

    public static String getDayBefore(String timeFormat, String dayStr) {
        Calendar c = Calendar.getInstance();
        Date date = parse(timeFormat, dayStr);
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day - 1);
        String dayBefore = formate(timeFormat, c.getTime());
        return dayBefore;
    }

    public static Date getDayBefore(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day - 1);
        return c.getTime();
    }

    public static Date getDayBeforeBetween(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day - days);
        return c.getTime();
    }

    public static Date getDayBeforeZero(int beforeDay) {
        Date dayBefore = null;

        try {
            Calendar now = Calendar.getInstance();
            int day = now.get(5);
            now.set(5, day - beforeDay);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            dayBefore = sdf.parse(sdf.format(now.getTime()));
        } catch (ParseException var5) {
            ;
        }

        return dayBefore;
    }

    public static int getHoursByLong(long time) {
        int d = (int)(time / 3600000L);
        return d;
    }

    public static Date getYesterdayZero() {
        return getDayBeforeZero(1);
    }

    public static String getDayAfterBetween(String timeFormat, String dayStr, int days) {
        Calendar c = Calendar.getInstance();
        Date date = parse(timeFormat, dayStr);
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day + days);
        String dayAfter = formate(timeFormat, c.getTime());
        return dayAfter;
    }

    public static Date getDayAfterBetween(String timeFormat, Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day + days);
        return c.getTime();
    }

    public static String getDayAfter(String timeFormat, String dayStr) {
        Calendar c = Calendar.getInstance();
        Date date = parse(timeFormat, dayStr);
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day + 1);
        String dayAfter = formate(timeFormat, c.getTime());
        return dayAfter;
    }

    public static int days(String startTime, String endTime) throws ParseException {
        startTime = convertStr(startTime);
        endTime = convertStr(endTime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Long c = sf.parse(endTime).getTime() - sf.parse(startTime).getTime();
        int d = (int)(c / 1000L / 60L / 60L / 24L);
        return d;
    }

    public static String convertStr(String oldTime) {
        String newTime = oldTime.replace("-", "");
        return newTime;
    }

    public static int daysCount(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date start = sdf.parse("1970-01-01");
            date = sdf.parse(sdf.format(date));
            long time1 = start.getTime();
            long time2 = date.getTime();
            long between_days = (time2 - time1) / 86400000L;
            return (int)between_days;
        } catch (Exception var9) {
            var9.printStackTrace();
            return -1;
        }
    }

    public static Date getDayAfter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(5);
        c.set(5, day + 1);
        return c.getTime();
    }

    public static boolean isBetween(Date begin, Date curr, Date end) {
        return begin.compareTo(curr) <= 0 && curr.compareTo(end) <= 0;
    }

    public static boolean isBeforeSomeHours(Date now, Date when, Double someHours) {
        Double someHoursMs = 3600000.0D * someHours;
        Long aftMs = when.getTime();
        Long befMs = now.getTime();
        return (double)(aftMs - befMs) > someHoursMs;
    }

    public static boolean isBeforeSomeMinutes(Date now, Date when, Long someMinutes) {
        Long someHoursMs = 60000L * someMinutes;
        Long aftMs = when.getTime();
        Long befMs = now.getTime();
        return aftMs - befMs > someHoursMs;
    }

    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int minuteBetween(Date smdate, Date bdate) {
        long time1 = smdate.getTime();
        long time2 = bdate.getTime();
        long between_days = (time2 - time1) / 60000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String addMinuteForTime(Timestamp time, int minute) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = null;
        date = sdf.parse(sdf.format(time));
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(12, minute);
        return sdf.format(ca.getTime()).toString();
    }

    public static String dayAddMinuteForTime(Date time, int minute) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        date = sdf.parse(sdf.format(time));
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(12, minute);
        return sdf.format(ca.getTime()).toString();
    }

    public static String MinuteForTime(Timestamp time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = null;
        date = sdf.parse(sdf.format(time));
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return sdf.format(ca.getTime()).toString();
    }

    public static Date addHourForTime(Date time, int hour) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(time);
        ca.add(11, hour);
        return ca.getTime();
    }

    public static Date addDayForTime(Date time, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(time);
        calendar.add(5, day);
        time = calendar.getTime();
        return time;
    }

    public static double dateDiff(Date start, Date end) throws ParseException {
        long diff = end.getTime() - start.getTime();
        BigDecimal a = new BigDecimal(diff);
        BigDecimal hours = a.divide(new BigDecimal(3600000), 3, 4);
        return hours.doubleValue();
    }

    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(1) == cal2.get(1);
        boolean isSameMonth = isSameYear && cal1.get(2) == cal2.get(2);
        boolean isSameDate = isSameMonth && cal1.get(5) == cal2.get(5);
        return isSameDate;
    }

    public static boolean isAcceptTime(String time) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        now = sd.parse(sd.format(now));
        long nowT = now.getTime();
        long nowL = sd.parse(time).getTime();
        return nowT < nowL;
    }

    public static long getMillisecond(String time) {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");

        try {
            return sd.parse(time).getTime();
        } catch (ParseException var3) {
            var3.printStackTrace();
            return 0L;
        }
    }

    public static long getMillisecond(String time, String formatter) {
        SimpleDateFormat sd = new SimpleDateFormat(formatter);

        try {
            return sd.parse(time).getTime();
        } catch (ParseException var4) {
            var4.printStackTrace();
            return 0L;
        }
    }

    public static String getMillisecondToStr(long milliSecond) {
        Date dattimeDate = new Date(milliSecond);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dattimeDate);
        SimpleDateFormat formattwo = new SimpleDateFormat("HH:mm");
        String nowtime = formattwo.format(calendar.getTime());
        return nowtime;
    }

    public static int dayForWeek(Date pTime) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek;
        if (c.get(7) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(7) - 1;
        }

        return dayForWeek;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        return cl;
    }

    public static boolean duringDatePeriod(Date startTime, Date endTime, Date descTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String _startTime = sdf.format(startTime);
        String _endTime = sdf.format(endTime);
        String _descTime = sdf.format(descTime);
        return duringDatePeriod(_startTime, _endTime, _descTime);
    }

    public static boolean duringDatePeriod(String startTime, String endTime, String descTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date _descTime = sdf.parse(descTime);
            Date _startTime = sdf.parse(startTime);
            Date _endTime = sdf.parse(endTime);
            return _descTime.getTime() <= _endTime.getTime() && _descTime.getTime() >= _startTime.getTime();
        } catch (ParseException var8) {
            var8.printStackTrace();
            return false;
        }
    }

    public static boolean duringDatePeriod(String startTime, String endTime, Date descTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String _descTime = sdf.format(descTime);
        return duringDatePeriod(startTime, endTime, _descTime);
    }

    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + (long)minute * 60L * 1000L);
        return c.getTime();
    }

    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    public static String dealDateFormat(String oldDateStr) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDateStr);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            Date date1 = df1.parse(date.toString());
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df2.format(date1);
        } catch (Exception var6) {
            return null;
        }
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7) - 1;
        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }
}
