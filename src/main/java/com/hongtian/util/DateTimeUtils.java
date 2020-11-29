package com.hongtian.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间日期工具类.
 * <p>
 * Created by cyetstar on 14-6-17.
 */
public class DateTimeUtils {

    public static final String DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN = "yyyyMMdd";
    public static final String MONTH_PATTERN = "yyyyMM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String DATE = "dd";
    public static final String MONTH = "MM";

    public static String now() {
        return now(DATETIME_PATTERN);
    }

    public static String now(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String today() {
        return today(DATE_PATTERN);
    }

    public static String today(String pattern) {
        return now(pattern);
    }

    public static String yesterday() {
        return DateFormatUtils.format(DateUtils.addDays(new Date(), -1), DATE_PATTERN);
    }

    public static String tomorrow() {
        return DateFormatUtils.format(DateUtils.addDays(new Date(), 1), DATE_PATTERN);
    }

    public static String getCurrentYear() {
        return now(YEAR_PATTERN);
    }

    public static String getCurrentMonth() {
        return now(MONTH_PATTERN);
    }

    public static String getCurrentGAMonth() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_MONTH) > 20) {
            return DateFormatUtils.format(DateUtils.addMonths(cal.getTime(), 1), MONTH_PATTERN);
        } else {
            return getCurrentMonth();
        }
    }

    public static String addSeconds(int n) {
        return add(DateTimeUtils.now(), Calendar.SECOND, n);
    }

    public static String addSeconds(String value, int n) {
        return add(value, Calendar.SECOND, n);
    }

    public static String addMinutes(int n) {
        return add(DateTimeUtils.now(), Calendar.MINUTE, n);
    }

    public static String addMinutes(String value, int n) {
        return add(value, Calendar.MINUTE, n);
    }

    public static String addHours(int n) {
        return add(DateTimeUtils.now(), Calendar.HOUR, n);
    }

    public static String addHours(String value, int n) {
        return add(value, Calendar.HOUR, n);
    }

    public static String addDays(int n) {
        return add(DateTimeUtils.today(), Calendar.DAY_OF_MONTH, n);
    }

    public static String addDays(String value, int n) {
        return add(value, Calendar.DAY_OF_MONTH, n);
    }

    public static String addWeeks(int n) {
        return add(DateTimeUtils.today(), Calendar.WEEK_OF_MONTH, n);
    }

    public static String addWeeks(String value, int n) {
        return add(value, Calendar.WEEK_OF_MONTH, n);
    }

    public static String addMonths(int n) {
        return add(DateTimeUtils.today(), Calendar.MONTH, n);
    }

    public static String addMonths(String value, int n) {
        return add(value, Calendar.MONTH, n);
    }

    public static String addYears(int n) {
        return add(DateTimeUtils.today(), Calendar.YEAR, n);
    }

    public static String addYears(String value, int n) {
        return add(value, Calendar.YEAR, n);
    }

    private static String add(String value, int type, int n) {
        Date date;
        String pattern = DATE_PATTERN;
        try {
            if (StringUtils.length(value) > 8) {
                pattern = DATETIME_PATTERN;
            }
            date = DateUtils.parseDate(value, pattern);
        } catch (ParseException e) {
            return null;
        }
        switch (type) {
            case Calendar.SECOND: {
                date = DateUtils.addSeconds(date, n);
                break;
            }
            case Calendar.MINUTE: {
                date = DateUtils.addMinutes(date, n);
                break;
            }
            case Calendar.HOUR: {
                date = DateUtils.addHours(date, n);
                break;
            }
            case Calendar.DAY_OF_MONTH: {
                date = DateUtils.addDays(date, n);
                break;
            }
            case Calendar.WEEK_OF_MONTH: {
                date = DateUtils.addWeeks(date, n);
                break;
            }
            case Calendar.MONTH: {
                date = DateUtils.addMonths(date, n);
                break;
            }
            case Calendar.YEAR: {
                date = DateUtils.addYears(date, n);
                break;
            }
        }
        return DateFormatUtils.format(date, pattern);
    }

    public static String formatDate(String value, String destPattern) {
        return formatDateTime(value, DATE_PATTERN, destPattern);
    }

    public static String formatDateTime(String value, String destPattern) {
        return formatDateTime(value, DATETIME_PATTERN, destPattern);
    }

    public static String formatDateTime(String value, String origPattern, String destPattern) {
        try {
            Date date = DateUtils.parseDate(value, origPattern);
            return DateFormatUtils.format(date, destPattern);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp parseTimestamp(String value) {
        return parseTimestamp(value, DATETIME_PATTERN);
    }

    public static Timestamp parseTimestamp(String value, String pattern) {
        try {
            Date date = DateUtils.parseDate(value, pattern);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    //20200920 计算结束时间 和 开始时间 的间隔毫秒数
    public static Long calcTimeSpan(String sBegin,String sEnd){
        Timestamp tsBegin=parseTimestamp(sBegin);
        Timestamp tsEnd=parseTimestamp(sEnd);
        if (tsBegin!=null && tsEnd!=null){
            return tsEnd.getTime()  -tsBegin.getTime();
        }else{
            return null;
        }
    }


    // 第一天，最后一天系列
    public static String getFirstDayOfThisWeek() {
        return getFirstDayOfThisWeek(new Date());
    }

    public static String getFirstDayOfThisWeek(Date date) {
        date = getFirstDayOfWeek(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfThisWeek() {
        return getLastDayOfThisWeek(new Date());
    }

    public static String getLastDayOfThisWeek(Date date) {
        date = getLastDayOfWeek(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfLastWeek() {
        return getFirstDayOfLastWeek(new Date());
    }

    public static String getFirstDayOfLastWeek(Date date) {
        date = getFirstDayOfWeek(DateUtils.addWeeks(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfLastWeek() {
        return getLastDayOfLastWeek(new Date());
    }

    public static String getLastDayOfLastWeek(Date date) {
        date = getLastDayOfWeek(DateUtils.addWeeks(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfNextWeek() {
        return getFirstDayOfNextWeek(new Date());
    }

    public static String getFirstDayOfNextWeek(Date date) {
        date = getFirstDayOfWeek(DateUtils.addWeeks(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfNextWeek() {
        return getLastDayOfNextWeek(new Date());
    }

    public static String getLastDayOfNextWeek(Date date) {
        date = getLastDayOfWeek(DateUtils.addWeeks(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfThisMonth() {
        return getFirstDayOfThisMonth(new Date());
    }

    public static String getFirstDayOfThisMonth(Date date) {
        date = getFirstDayOfMonth(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfThisMonth() {
        return getLastDayOfThisMonth(new Date());
    }

    public static String getLastDayOfThisMonth(Date date) {
        date = getLastDayOfMonth(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfLastMonth() {
        return getFirstDayOfLastMonth(new Date());
    }

    public static String getFirstDayOfLastMonth(Date date) {
        date = getFirstDayOfMonth(DateUtils.addMonths(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfLastMonth() {
        return getLastDayOfLastMonth(new Date());
    }

    public static String getLastDayOfLastMonth(Date date) {
        date = getLastDayOfMonth(DateUtils.addMonths(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfNextMonth() {
        return getFirstDayOfNextMonth(new Date());
    }

    public static String getFirstDayOfNextMonth(Date date) {
        date = getFirstDayOfMonth(DateUtils.addMonths(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfNextMonth() {
        return getLastDayOfNextMonth(new Date());
    }

    public static String getLastDayOfNextMonth(Date date) {
        date = getLastDayOfMonth(DateUtils.addMonths(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfThisQuarter() {
        return getFirstDayOfThisQuarter(new Date());
    }

    public static String getFirstDayOfThisQuarter(Date date) {
        date = getFirstDayOfQuarter(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfThisQuarter() {
        return getLastDayOfThisQuarter(new Date());
    }

    public static String getLastDayOfThisQuarter(Date date) {
        date = getLastDayOfQuarter(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfLastQuarter() {
        return getFirstDayOfLastQuarter(new Date());
    }

    public static String getFirstDayOfLastQuarter(Date date) {
        date = getFirstDayOfQuarter(DateUtils.addMonths(date, -3));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfLastQuarter() {
        return getLastDayOfLastQuarter(new Date());
    }

    public static String getLastDayOfLastQuarter(Date date) {
        date = getLastDayOfQuarter(DateUtils.addMonths(date, -3));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfNextQuarter() {
        return getFirstDayOfNextQuarter(new Date());
    }

    public static String getFirstDayOfNextQuarter(Date date) {
        date = getFirstDayOfQuarter(DateUtils.addMonths(date, 3));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfNextQuarter() {
        return getLastDayOfNextQuarter(new Date());
    }

    public static String getLastDayOfNextQuarter(Date date) {
        date = getLastDayOfQuarter(DateUtils.addMonths(date, 3));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfThisYear() {
        return getFirstDayOfThisYear(new Date());
    }

    public static String getFirstDayOfThisYear(Date date) {
        date = getFirstDayOfYear(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfThisYear() {
        return getLastDayOfThisYear(new Date());
    }

    public static String getLastDayOfThisYear(Date date) {
        return DateFormatUtils.format(getLastDayOfYear(date), DATE_PATTERN);
    }

    public static String getFirstDayOfLastYear() {
        return getFirstDayOfLastYear(new Date());
    }

    public static String getFirstDayOfLastYear(Date date) {
        date = getFirstDayOfYear(DateUtils.addYears(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfLastYear() {
        return getLastDayOfLastYear(new Date());
    }

    public static String getLastDayOfLastYear(Date date) {
        date = getLastDayOfYear(DateUtils.addYears(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfNextYear() {
        return getFirstDayOfNextYear(new Date());
    }

    public static String getFirstDayOfNextYear(Date date) {
        date = getFirstDayOfYear(DateUtils.addYears(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfNextYear() {
        return getLastDayOfNextYear(new Date());
    }

    public static String getLastDayOfNextYear(Date date) {
        date = getLastDayOfYear(DateUtils.addYears(date, 1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfThisGAYear() {
        return getFirstDayOfThisGAYear(new Date());
    }

    public static String getFirstDayOfThisGAYear(Date date) {
        date = getFirstDayOfGAYear(date);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfThisGAYear() {
        return getLastDayOfThisGAYear(new Date());
    }

    public static String getLastDayOfThisGAYear(Date date) {
        return DateFormatUtils.format(getLastDayOfGAYear(date), DATE_PATTERN);
    }

    public static String getFirstDayOfLastGAYear() {
        return getFirstDayOfLastGAYear(new Date());
    }

    public static String getFirstDayOfLastGAYear(Date date) {
        date = getFirstDayOfGAYear(DateUtils.addYears(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getLastDayOfLastGAYear() {
        return getLastDayOfLastGAYear(new Date());
    }

    public static String getLastDayOfLastGAYear(Date date) {
        date = getLastDayOfGAYear(DateUtils.addYears(date, -1));
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getFirstDayOfLastGAMonth() {
        return getFirstDayOfLastGAMonth(DATE_PATTERN);
    }

    public static String getFirstDayOfLastGAMonth(String datePattern) {
        return DateFormatUtils.format(getFirstDayOfLastGAMonth(new Date()), datePattern);
    }

    public static String getLastDayOfLastGAMonth() {
        return getLastDayOfLastGAMonth(DATE_PATTERN);
    }

    public static String getLastDayOfLastGAMonth(String datePattern) {
        return DateFormatUtils.format(getLastDayOfLastGAMonth(new Date()), datePattern);
    }

    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        // 默认时，每周第一天为星期日，需要更改一下
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// Monday
        return c.getTime();
    }

    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        // 默认时，每周第一天为星期日，需要更改一下
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // Sunday
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getFirstDayOfQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        if (month <= Calendar.MARCH) {
            c.set(Calendar.MONTH, Calendar.JANUARY);
        } else if (month <= Calendar.JUNE) {
            c.set(Calendar.MONTH, Calendar.APRIL);
        } else if (month <= Calendar.SEPTEMBER) {
            c.set(Calendar.MONTH, Calendar.JULY);
        } else {
            c.set(Calendar.MONTH, Calendar.OCTOBER);
        }
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getLastDayOfQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        if (month <= Calendar.MARCH) {
            c.set(Calendar.MONTH, Calendar.MARCH);
        } else if (month <= Calendar.JUNE) {
            c.set(Calendar.MONTH, Calendar.JUNE);
        } else if (month <= Calendar.SEPTEMBER) {
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        } else {
            c.set(Calendar.MONTH, Calendar.DECEMBER);
        }
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getLastDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getFirstDayOfGAYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.MONTH) <= Calendar.DECEMBER || c.get(Calendar.DATE) <= 20) {
            c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
        }
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        c.set(Calendar.DAY_OF_MONTH, 21);
        return c.getTime();
    }

    public static Date getLastDayOfGAYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(getFirstDayOfGAYear(date));
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
        c.set(Calendar.DAY_OF_MONTH, 20);
        return c.getTime();
    }

    public static Date getFirstDayOfLastGAMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DATE) <= 20) {
            c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        }
        c.set(Calendar.DAY_OF_MONTH, 21);
        return c.getTime();
    }

    public static Date getLastDayOfLastGAMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DATE) > 20) {
            c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
        }
        c.set(Calendar.DAY_OF_MONTH, 20);
        return c.getTime();
    }

    /**
     * 通过月份返回季度
     *
     * @param month 月份
     * @return 返回季度
     */
    public static int getQuarter(int month) {
        int season = 1;//季度
        if (month >= 1 && month <= 3) {
            season = 1;
        } else if (month >= 4 && month <= 6) {
            season = 2;
        } else if (month >= 7 && month <= 9) {
            season = 3;
        } else if (month >= 10 && month <= 12) {
            season = 4;
        }
        return season;
    }

    public static String getWeekOfYear() {
        return getWeekOfYear(today());
    }

    public static String getWeekOfYear(String dateString) {
        try {
            Date date = DateUtils.parseDate(dateString, DATE_PATTERN);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int week = c.get(Calendar.WEEK_OF_YEAR);
            c.add(Calendar.DAY_OF_MONTH, -7);
            int year = c.get(Calendar.YEAR);
            if (week < c.get(Calendar.WEEK_OF_YEAR)) {
                year += 1;
            }
            return String.valueOf(year) + StringUtils.leftPad(String.valueOf(week), 2, '0');
        } catch (ParseException e) {
            return null;
        }
    }

    public static int getDayOfWeek(String dateString) {
        try {
            Date date = DateUtils.parseDate(dateString, DATE_PATTERN);
            Calendar c = Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(date);
            return c.get(Calendar.DAY_OF_WEEK) - 1;
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     * 获取半天所在的区域，1-14
     *
     * @param dateString
     * @return
     */
    public static int getHalfDayOfWeek(String dateString) {
        int n = getDayOfWeek(dateString.substring(0, 8));
        String time = dateString.substring(8, 14);
        if (time.compareTo("115959") < 1) {
            return n * 2 - 1;
        } else {
            return n * 2;
        }
    }

    public static int getWeekOfMonth(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置星期一为一周的第一天。
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public static int getWeekOfThisMonth() throws ParseException {
        return getWeekOfMonth(DateTimeUtils.now(), DATETIME_PATTERN);
    }

    /**
     * 将字符串日期转换为日期.
     *
     * @param value   字符串日期
     * @param pattern 字符串日期格式匹配符
     * @return 返回日期.
     * @throws NullPointerException 如果参数为空.
     * @see DateUtils#parseDate(String, Locale, String...)
     */
    @Deprecated
    public static Date toDate(String value, String pattern) throws NullPointerException {
        if (StringUtils.isBlank(value) || StringUtils.isBlank(pattern)) {
            throw new NullPointerException("将字符串转换为 Date 时, 参数 value 和 pattern 不能为空.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * lenient 是否为不严格时间，true：不严格 false 严格
     * 如果需要严格按照日期计算lenient = false 传入
     */
    public static Date toDate(String value, String pattern, boolean lenient) throws NullPointerException {
        if (StringUtils.isBlank(value) || StringUtils.isBlank(pattern)) {
            throw new NullPointerException("将字符串转换为 Date 时, 参数 value 和 pattern 不能为空.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(lenient);
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 输入1-7，获取汉字周一到周日
     *
     * @param weekday
     * @return
     */
    public static String getChineseWeekDay(int weekday) {
        switch (weekday) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
        }
        return null;
    }

    public static String getSpecialMonth(Calendar date, Integer nMonth) {
        if (date == null) {
            date = Calendar.getInstance();
        }
        date.add(Calendar.MONTH, nMonth);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    public static String getSpecialYear(Calendar date, Integer nYear) {
        if (date == null) {
            date = Calendar.getInstance();
        }
        date.add(Calendar.YEAR, nYear);
        return DateFormatUtils.format(date, DATE_PATTERN);
    }

    /**
     * 计算两个日期相差几天
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int getWeek(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return g.get(Calendar.WEEK_OF_YEAR);//获得周数
    }

    public static void main(String[] args) {
        System.out.println("当前是第几周" + getWeek(new Date()));
        System.out.println("本周一：" + getFirstDayOfThisWeek());
        System.out.println("本周日：" + getLastDayOfThisWeek());
        System.out.println("上周一：" + getFirstDayOfLastWeek());
        System.out.println("上周日：" + getLastDayOfLastWeek());
        System.out.println("下周一：" + getFirstDayOfNextWeek());
        System.out.println("下周日：" + getLastDayOfNextWeek());

        System.out.println("本月第一天：" + getFirstDayOfThisMonth());
        System.out.println("本月最后天：" + getLastDayOfThisMonth());
        System.out.println("上月第一天：" + getFirstDayOfLastMonth());
        System.out.println("上月最后天：" + getLastDayOfLastMonth());
        System.out.println("下月第一天：" + getFirstDayOfNextMonth());
        System.out.println("下月最后天：" + getLastDayOfNextMonth());

        System.out.println("本季第一天：" + getFirstDayOfThisQuarter());
        System.out.println("本季最后天：" + getLastDayOfThisQuarter());
        System.out.println("上季第一天：" + getFirstDayOfLastQuarter());
        System.out.println("上季最后天：" + getLastDayOfLastQuarter());
        System.out.println("下季第一天：" + getFirstDayOfNextQuarter());
        System.out.println("下季最后天：" + getLastDayOfNextQuarter());

        System.out.println("本年第一天：" + getFirstDayOfThisYear());
        System.out.println("明年第一天：" + getFirstDayOfNextYear());

        String rq = "20180131";
        int year = Integer.parseInt(rq.substring(0, 4));
        int month = Integer.parseInt(rq.substring(4, 6)) - 1;
        int date = Integer.parseInt(rq.substring(6, 8));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        calendar.add(Calendar.MONTH, -2);
        String validDateBefore2Moth = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
        System.out.println(validDateBefore2Moth);
    }

}
