/**
 * 
 */
package com.iri.ip.utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: JacksonParser.java
 * @packageName	: com.iri.ip.utils
 * @projectName	: Facade
 * @Date_Time	: Dec 4, 2014_8:29:08 AM
 */
public class JacksonParser {
	
	/**
	 * 
	 */
	public JacksonParser() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static <T> String writeObjectToString(T obj) throws Exception{
		try {
			return getObjectWriter().writeValueAsString(obj);
		} catch (IOException e) {
			throw new Exception("Error While Serializing an Object to String. Cause: "+e.getCause());
		}
	}
	
	/**
	 * 
	 * @param json
	 * @param classType
	 * @return
	 * @throws Exception
	 */
	public static <T> T readStringAsObject(String json, Class<T> classType) throws Exception{
		T retVal = null;
		try {
			retVal = getObjectMapper().readValue(json, classType);
		} catch (IOException e) {
			throw new Exception("Error While Serializing a String to an Object. Cause: "+e.getCause());
		}
		return retVal;
	}
	
	/**
	 * 
	 * @return
	 */
	private static ObjectMapper getObjectMapper(){
		return new ObjectMapper().enableDefaultTyping();
	}
	
	/**
	 * 
	 * @return
	 */
	private static ObjectWriter getObjectWriter(){
		return new ObjectMapper().writerWithDefaultPrettyPrinter();
	}

}
