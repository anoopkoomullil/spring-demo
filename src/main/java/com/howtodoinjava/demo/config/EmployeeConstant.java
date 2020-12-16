package com.howtodoinjava.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeConstant {
	
	
	private static final Logger logger = LogManager.getLogger(EmployeeConstant.class);

	public EmployeeConstant() {
		logger.info("AuditMappingConstant Constructor");
	}
	
	public static final String SPL_CHR_UNDSCR = "_";
	public static final String SPL_CHR_FWDSLH = "/";
	public static final String SPL_CHR_LFTCBR = "{";
	public static final String SPL_CHR_RGTCBR = "}";
	public static final String SPL_CHR_COLUMN = ":";
	public static final String SPL_CHR_SEMI_COLUMN = ";";
	public static final String SPL_CHR_SPACE = " ";
	public static final String SPL_CHR_EMPTY = "";
	public static final String SPL_CHR_COMA = ",";
	public static final String CARRIER_ID="SQ";
	public static final String PLUS_SIGN="+";
	public static final String NEW_LINE="\n";
	
	public static final String DAT_FMT_DDMMMYY = "dd-MMM-yy";
	public static final String DAT_FMT_DDMMYY = "dd-MM-yy";
	public static final String DAT_FMT_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FULL_DATE_TIME2 = "yyyy-MM-dd hh:mm:ss";
	public static final String EEE_MMM_DD_HH_MM_SS_YYYY = "EEE MMM dd HH:mm:ss z yyyy";
	public static final String FULL_DATE_TIME = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_TIME_FMT_2 = "ddMMyy_HHmmss";

	public static final String STR_ALL =  "ALL";
	public static final String TELEX_SERVICE_EXCEPTION = "TelexServiceException";
	public static final String TELEX_DAO_EXCEPTION = "TelexDaoException";
	public static final String TELEX_EXCEPTION = "Exception";
	
	public static final String EMAIL_STATIC_CONTENT = "staticcontent";
	public static final String EMAIL_DYNAMIC_CONTENT = "dynamiccontent";
	public static final String EMAIL_DELIMITER = "::";
	public static final String DEFAULT_EMAIL_FROM="mwt_noreply@singaporeair.com.sg";
	
	public static final boolean EXC_TRUE = true;
	public static final boolean EXC_FALSE = false;
	public static final String EXCEPTION_CRITICAL="CRITICAL";
	public static final String EXCEPTION_IMPORTANT="IMPORTANT";
	public static final String EXCEPTION_NORMAL="NORMAL";
	public static final String SUMMARY = "Summary";
	
	public static final String REPORT_TARGET ="target";
	public static final String FILE_SEPRATOR="/";
	public static final String RESOURCES_PATH = "src/main/resources/";
	public static final String UPLIFTVVIP = "UpliftVVIP";
	public static final String UPLIFTDETAILS = "UplifDetails";
	public static final String UPLIFTSCHEDULE = "UpliftSchedule";
	public static final String AMINITIES = "Amenities";
	public static final String IFSS_APPLICATION_REPORT = "Inflight Scheduling System (IFSS)";
	public static final String REPORTS = "reports";
	public static final String FILE_FORMAT_XLSX=".xlsx";
	
	public static final String MW_TELEX_LIST_CACHE2K="mwTelexListCache2k";
	public static final String MW_TELEX_LIST_JCACHE="mwTelexListJCache";
	
	public static final String FETCHALL_ROUTERULE="fetchAllRouteRule";
	public static final String FETCHALL_COPYRULE="fetchAllCopyRule";
	public static final String TELEXROUTERULE="TelexRouteRule";
	public static final String FETCHALL_TELEXQUEUE="fetchAllTelexQueue";
	public static final String FETCHALL_GROUPRULE="fetchAllGroupRule";
}
