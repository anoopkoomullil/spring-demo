package com.howtodoinjava.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.howtodoinjava.demo.config.EmployeeConstant;




public class DateUtils {
	
	private static final Logger logger = LogManager.getLogger(DateUtils.class);
	
	private DateUtils() {
		logger.info("DateUtils");
	}
	
	public static Calendar getCalendar(String date, String format) {
		if (date == null || format == null) {
			return null;
		}

		SimpleDateFormat fd = new SimpleDateFormat(format);
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(fd.parse(date));
			return c;
		} catch (ParseException ex) {
			return null;
		}
	}
	
	public static Calendar getCalendar(java.util.Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	
	public static synchronized String getDate(Calendar c) {
		String format = null;
		if (c == null) {
			return null;
		}
		format = System.getProperty("dateformat");
		if (format == null) {
			format ="dd-MM-yyyy HH:mm:ss";
		}
		return getDate(c, format);
	}
	
	public static synchronized String getDate(Calendar c, String format) {
		if (c == null || format == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		df.setTimeZone(c.getTimeZone());
		return df.format(c.getTime());
	}
	
	/*
	 * First Day = Monday(Num: 1) Last day = Sunday(Num: 7)
	 */
	public static int getDaysofWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(day==1){
			day = 7;
		} else {
			day = day-1;
		}
		return day;
	}
	
	public static int compareTo(Calendar c1, Calendar c2) {
		int compare = compare(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
		if (compare != 0) {
			return compare;
		}
		compare = compare(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
		if (compare != 0) {
			return compare;
		}
		compare = compare(c1.get(Calendar.DATE), c2.get(Calendar.DATE));
		return compare;
	}
	
	private static int compare(int x, int y) {
		if (x == y) {
			return 0;
		}
		if (x > y) {
			return 1;
		}
		return -1;
	}
	
	public static Date addDay(Date date,int noOfDays) {
		Calendar c=Calendar.getInstance();
		if(date != null) {
			c.setTime(date);
		}
		c.add(Calendar.DATE, noOfDays);
		return c.getTime();
	}
	
	public static Date addMinutes(Date date,int minutes) {
		Calendar c=Calendar.getInstance();
		if(date != null) {
			c.setTime(date);
		}
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}
	
	public static boolean checkDateBetweenDates(Date from,Date to,Date check) {
		boolean result=false;
		if(from != null && to != null && check != null) {
			boolean fromCheck=(from.compareTo(check) < 0 ) || (from.compareTo(check) == 0 );
			boolean toCheck=(to.compareTo(check) > 0 ) || (to.compareTo(check) == 0 );
			result=fromCheck && toCheck;
		}
		return result;
	}
	
	public static int getDiffBetweenDates(Date from,Date to) throws ParseException {
		String format="MM/dd/yyyy";
		Date tmpFromDate=convertStringtoDateTime(getDatetoString(from,format),format);
		Date tmpToDate=convertStringtoDateTime(getDatetoString(to,format),format);
		int dayDiff=0;
		if(tmpFromDate != null && tmpToDate != null ) {
			long diffInMillies = tmpToDate.getTime() - tmpFromDate.getTime();
			dayDiff= (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		}
		return dayDiff;
	}
	public static String getDatetoString(Date date,String format) {
		String dateStirng="";
		if(date != null && format != null ) {
			DateFormat dateFormat = new SimpleDateFormat(format);  
			dateStirng = dateFormat.format(date); 
		}
		return dateStirng;
	}
	public static Date convertStringtoDateTime(String dateWithTime,String format) throws ParseException {
		Date dateTime = null;
		if(dateWithTime != null && format != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateTime = sdf.parse(dateWithTime);
		}
		return dateTime;
	}
	
	 public static String getDayOfOperation(Date date)
	 {
		LocalDate localdate=	date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		java.time.DayOfWeek dayOfWeek = localdate.getDayOfWeek();
		 String i=""; 
		 switch (dayOfWeek ) {
	      case MONDAY:i="MON";
	        break;
	      case TUESDAY:i="TUE";
	        break;
	      case WEDNESDAY:i="WED";
	        break;
	      case THURSDAY:i="THU";
	        break;
	      case FRIDAY:i="FRI";
	        break;
	        
	      case SATURDAY:i="SAT";
	        break;
	        
	      case SUNDAY:i="SUN";
	        break;

	    }
		 return i;		 
	 }
	 
	 
	 public static Date addOrMinusHHMMtoDate(Date date, String hours,String minutes,String operation) {
			 if(date != null) {
				 Calendar cal=Calendar.getInstance();
				 cal.setTime(date);
				 if(EmployeeConstant.PLUS_SIGN.equals(operation)) {
					 int positiveHours=Integer.parseInt(hours);
					 int positiveMinutes=Integer.parseInt(minutes);
					 cal.add(Calendar.HOUR_OF_DAY, positiveHours);
					 cal.add(Calendar.MINUTE, positiveMinutes);
					 date=cal.getTime();
				 }else{
					 int negativeHours=Integer.parseInt(operation+hours);
					 int negativeMinutes=Integer.parseInt(operation+minutes);
					 cal.add(Calendar.HOUR_OF_DAY, negativeHours);
					 cal.add(Calendar.MINUTE, negativeMinutes);
					 date=cal.getTime();
				 }
			 }
			 return date;
	}
		 
}

