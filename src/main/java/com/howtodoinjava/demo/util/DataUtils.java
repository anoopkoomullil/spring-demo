package com.howtodoinjava.demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.howtodoinjava.demo.config.EmployeeConstant;
import com.howtodoinjava.demo.exception.ExceptionResponse;


public class DataUtils {

	private static final Logger logger = LogManager.getLogger(DataUtils.class);
	
	
	private DataUtils() {
		logger.info("DataUtils");
	}

	public static String getFileName(String inputDir, final String filePattern) {
		File folder = new File(inputDir);
		if (!folder.exists()) {
			return null;
		}
		long lastModified = 0;
		String lastModifiedFile = null;
		for (final File fileEntry : folder.listFiles((FilenameFilter) new WildcardFileFilter(filePattern))) {
			// it will return the latest and matched file
			if(!fileEntry.isDirectory() && (fileEntry.lastModified() > lastModified)) {
					lastModified = fileEntry.lastModified();
					lastModifiedFile = fileEntry.getName();
			}
		}
		return lastModifiedFile;
	}

	/**
	 * This Method will convert File to String
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static StringBuilder convertFiletoString(final File file) throws IOException {
		StringBuilder strInputString;
		strInputString = null;
		String strReadData = null;
		try(BufferedReader bfrMessageReader = new BufferedReader(new FileReader(file))){
			strInputString = new StringBuilder();
			while ((strReadData = bfrMessageReader.readLine()) != null) {
				strInputString.append(strReadData).append("\n");
			}
		}
		return strInputString;
	}

	/**
	 * Returns true if the given String is null or the empty string.
	 * 
	 * @param s    String to test
	 * @param trim true to trim before checking if empty
	 * @return boolean
	 */
	public static boolean isEmpty(String s, boolean trim) {
		if (s == null)
			return true;
		if (trim)
			s = s.trim();
		return "".equals(s);
	}

	/**
	 * Returns true if the given list is null or size is zero.
	 * 
	 * @param list List
	 * @return boolean
	 */
	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * Returns true if the given set is null or size is zero.
	 * 
	 * @param list List
	 * @return boolean
	 */
	public static boolean isEmpty(Set<?> set) {
		return set == null || set.isEmpty();
	}

	/**
	 * Returns true if the given object array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given array is null or length is zero.
	 * 
	 * @param array Object[]
	 * @return boolean
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * Returns true if the given map is null or size is zero.
	 * 
	 * @param map Map
	 * @return boolean
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}

	/**
	 * Returns true if the given String is null or the empty string.
	 * 
	 * @param s String to test
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
	
	/***
	 * Method to convert String to Int
	 * @param value
	 * @return
	 */
	public static int getInt(String value){
		if(value==null || value.trim().length()==0){
			return 0;
		}
		try{
			return Integer.parseInt(value.trim());
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	
	
	public static <T> List<List<T>> splitList(int eachListSize,List<T> list){
		List<List<T>> result=null;
		if(list != null && list.size() > eachListSize && eachListSize > 0) {
			List<Integer> endpoints = new ArrayList<>();
			for(int i=0;i<list.size();i=i+eachListSize) {
				endpoints.add(i);
			}
			endpoints.add(list.size());
			result = IntStream.rangeClosed(0, (endpoints.size()-2)).mapToObj(i -> list.subList(endpoints.get(i), endpoints.get(i+1))).collect(Collectors.toList());
		}
		return result;
	}
	
	public static <T> List<T> clone(List<T> originalList){
		List<T> result = null;
		if (null!= originalList) {
			 result = originalList.stream().collect(Collectors.toList());
		}
		return result;
	}
	
	public static void setExceptionResponse(String error,String description,boolean status,String code,String severityFlag,ExceptionResponse exceptionResponse) {
		exceptionResponse.setError(error);
		exceptionResponse.setErrorMessage(description);
		exceptionResponse.setExceptionFound(status);
		exceptionResponse.getExceptionList().add(code);
		exceptionResponse.setSeverityFlag(severityFlag);
	}
	
	public static void setExceptionTrace(Exception e,ExceptionResponse exceptionResponse) {
		logger.error("[IFSS] [CRITICALITY] ["+exceptionResponse.getSeverityFlag()+"]");
		exceptionResponse.setExceptionDesc("Cause==="+e.getCause()+"Message==="+e.getMessage()+"Formated trase===="+ExceptionUtils.getStackTrace(e));
		logger.error(exceptionResponse.getExceptionDesc());
	}
	
	/**
	 * Method to trim leadig zero's from string..
	 * 
	 */
	
	public static String removeLeadingZeros(String str) 
    { 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
        StringBuffer sb = new StringBuffer(str); 
        sb.replace(0, i, ""); 
        return sb.toString();  // return 
    }

	
	
	public static String replaceNotifyBraceses(String input) {
		String output=input;
		if(!isEmpty(input)) {
			output=output.replace("}", "").replace("{", "");
		}
		return output;
	}

	public static boolean isValidRouteInfo(int sectorCount, String string) {
		boolean valiRouteInfo=false;
		if(sectorCount == StringUtils.countMatches(string,'/')) {
			valiRouteInfo=true;
		}
		return valiRouteInfo;
	}
	/**
	 * Method  to return List Size
	 * @param list
	 * @return
	 */
	
	public static int getSize(List<?> list) {
		if(!DataUtils.isEmpty(list))
		{
			return list.size();
		}	
		return 0;
	}
	
	public static int getSize(Map<?, ?> objMap) {
		if(!DataUtils.isEmpty(objMap))
		{
			return objMap.size();
		}	
		return 0;
	}
	
	public static <T extends Comparable<T>> T greatsest(T a, T b) {
	    return a == null ? b : (b == null ? a : (a.compareTo(b) > 0 ? a : b));
	
	}
	public static boolean isDateOverlapping(Date start1,Date end1,Date start2,Date end2) {
		return start1.compareTo(end2) <= 0 && end1.compareTo(start2) >= 0;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	public static String getDeckValue(String deck) {
		if(isEmpty(deck))
		{
			deck= "-";
		}
		return deck;
	}
	
	
	public static <T> Stream<T> getStream(Iterable<T> iterable){
		return StreamSupport.stream(iterable.spliterator(), false);
	}
	public static java.util.function.Supplier<Stream<Integer>> cellIteratorSupplier(int end){
		return ()->numberStream(end);
	}
	
	public static Stream<Integer> numberStream(int end){
		return IntStream.range(0, end).boxed();
	}
	
	public static String getRandomNumber(){
		String dateTime=DateUtils.getDatetoString(new Date(), EmployeeConstant.DATE_TIME_FMT_2); 
	    double x = Math.random();
	    return dateTime+String.valueOf(x);
	}
	
}