/**
 * 
 */
package com.iri.ip.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: This Class Contains various Application Context Instantiation and Initialization
 * @fileName	: ContextInitializer.java
 * @packageName	: com.iri.ip.config
 * @projectName	: Web
 * @Date_Time	: Nov 24, 2014_2:12:21 AM
 */
public class AppContext {
	
	/*
	 * This API would return the Service Bean for the provided ClassType
	 * This API uses AnnotationConfigApplicationContext rather than Application Context
	 * @param BeanType
	 * @return
	 */
	@SuppressWarnings("resource")
	public static <T> T getServiceBean(Class<T> BeanType) throws Exception{
		T retVal = null;
		ApplicationContext ctx = null;
	    try{
			ctx = new AnnotationConfigApplicationContext(ServiceConfig.class);
			retVal = ctx.getBean(BeanType);
		}catch(Exception e){
			throw new Exception("Class Type : "+BeanType+" - Service Not Wired");
		}
	    return retVal;
	}
	
	/*
	 * This API would return the DAO Bean for the provided ClassType
	 * This API uses AnnotationConfigApplicationContext rather than Application Context
	 * @param BeanType
	 * @return
	 */
	@SuppressWarnings("resource")
	public static <T> T getDaoBean(Class<T> BeanType) throws Exception{
		T retVal = null;
		ApplicationContext ctx = null;
		try{
			ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
			retVal = ctx.getBean(BeanType);
		}catch(Exception e){
			throw new Exception("Class Type : "+BeanType+" - Not Wired | Not an Component");
		}
		return retVal;
	}
	
	/*
	 * This API would return the Mongo DB Repository Bean for the provided ClassType
	 * This API uses AnnotationConfigApplicationContext rather than Application Context
	 * @param BeanType
	 * @return
	 */
	@SuppressWarnings("resource")
	public static <T> T getRepositoryBean(Class<T> BeanType) throws Exception{
		T retVal = null;
		ApplicationContext ctx = null;
		try{
			ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
			retVal = ctx.getBean(BeanType);
		}catch(Exception e){
			throw new Exception("Class Type : "+BeanType+" - Not Wired | Not an Component");
		}
		return retVal;
	}
}
