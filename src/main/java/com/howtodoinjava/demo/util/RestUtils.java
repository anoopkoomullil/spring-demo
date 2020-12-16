package com.howtodoinjava.demo.util;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class RestUtils {
	
	private static final Logger logger = LogManager.getLogger(RestUtils.class);

	private static RestTemplate restTemplate = new RestTemplate();
	
	
	private RestUtils() {

	}
	
	public static <T> List<T> fetchMultiple(String url, T object,String type)  {
		logger.info("[RestUtils][fetchMultiple][begin]");
		List<T> objectLists = new ArrayList<>();
		ResponseEntity<List<T>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		try {
			HttpEntity<T> entity = new HttpEntity<>(object,headers);
			responseEntity = restTemplate.exchange(url,HttpMethod.POST, entity, new ParameterizedTypeReference<List<T>>(){});
			objectLists = responseEntity.getBody();
			
		}catch(Exception e) {
			logger.info("[RestUtils][getRestGetForList][exception]"+e);
		}
		logger.info("[RestUtils][fetchMultiple][end]");
		return convert(objectLists,type);
	}
	
	public static <T> Object fetchOne(String url, T objects, String type) {
		Object object = new Object();
		logger.info("[RestUtils][fetchOne][begin]");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> requestEntity = new HttpEntity<>(objects,headers);
			ResponseEntity<T> responseEntity = null;
				responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<T>(){});
				object = responseEntity.getBody();
			
		}catch(Exception e) {
			logger.info("[RestUtils][getRestGetForList][exception]"+e);
		}
		logger.info("[RestUtils][fetchOne][end]");
		return convert(object,type);
	}
	
	public static <T> int createorUpdateorDelete(String uri, T object) {
		logger.info("[RestUtils][createorUpdateorDelete][begin]");
		int statusValue = 0;
		ResponseEntity<Boolean> responseEntity=null;
		HttpHeaders headers = new HttpHeaders();
		try {
			HttpEntity<T> entity = new HttpEntity<>(object,headers);
				responseEntity = restTemplate.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<Boolean>() {
				});
			
			HttpStatus status = responseEntity.getStatusCode();
			statusValue = status.value();
		} catch (Exception e) {
			logger.info("Exception:putRestObject" + e);
		}
		logger.info("[RestUtils][createorUpdateorDelete][end]");
		return statusValue;

	}
	//This method is for fetchAll, without passing any parameter object
	public static <T> List<T> fetchAll(String url, String type) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException{
		logger.info("[RestUtils][fetchAll][begin]");
		List<T> objectLists = new ArrayList<>();
		ResponseEntity<List<T>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<T> entity = new HttpEntity<>(headers);
			int count = 0;
			int statusValue=0;
			String statusName="";
			while(count<3 && objectLists.isEmpty()) {				
					responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
							new ParameterizedTypeReference<List<T>>() {	});
				
				objectLists = responseEntity.getBody();
				HttpStatus status = responseEntity.getStatusCode();
				statusValue = status.value();
				statusName = status.name();
				count++;
			}
			if(count==3 || statusValue!=200||!statusName.equals("OK")) {
				logger.info("[RestUtils][fetchAll][empty list]");
			}
			logger.info("[RestUtils][fetchAll][end]");
		return convert(objectLists,type);
	}
	
	public static <T> List<T> convert(List<T> input,String type){
		logger.info("[RestUtils][convert][begin]");
		ObjectMapper mapper = new ObjectMapper();
		List<T> pojos = new ArrayList<T>();
		/*switch(type) {
		case IfssConfig.REST_AUDIT_LOG:pojos = mapper.convertValue(input, new TypeReference<List<AuditLog>>(){});
						break;
		case IfssConfig.REST_SYSTEM_PARAMETER: pojos = mapper.convertValue(input, new TypeReference<List<SystemParameter>>(){});
						break;
		case IfssConfig.REST_STATION: pojos = mapper.convertValue(input, new TypeReference<List<Station>>(){});
						break;
		case IfssConfig.REST_ITEM:	pojos = mapper.convertValue(input, new TypeReference<List<Item>>(){});
						break;
				default:break;
		}*/
		logger.info("[RestUtils][convert][end]");
		return pojos;
	}
	
	public static <T> Object convert(T input,String type){
		logger.info("[RestUtils][convert][begin]");
		ObjectMapper mapper = new ObjectMapper();
		Object pojo = new Object();
		/*switch(type) {
		case IfssConfig.REST_AUDIT_LOG:pojo = mapper.convertValue(input, new TypeReference<AuditLog>(){});
						break;
		case IfssConfig.REST_SYSTEM_PARAMETER: pojo = mapper.convertValue(input, new TypeReference<SystemParameter>(){});
						break;
		case IfssConfig.REST_STATION: pojo = mapper.convertValue(input, new TypeReference<Station>(){});
						break;
		case IfssConfig.REST_ITEM:pojo = mapper.convertValue(input, new TypeReference<Item>(){});
				  		break;
				default:break;
		}*/
		logger.info("[RestUtils][convert][end]");
		return pojo;
	}

}
