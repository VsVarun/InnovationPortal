/**
 * 
 */
package com.iri.ip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iri.ip.facade.IAuthenticationFacade;
import com.iri.ip.facade.impl.AuthenticationImpl;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: This Configuration contains the Services Bean Definitions alone
 * @fileName	: ServiceConfig.java
 * @packageName	: com.iri.ip.config
 * @projectName	: Web
 * @Date_Time	: Nov 24, 2014_2:16:51 AM
 */
@Configuration
public class ServiceConfig {

	/**
	 * @return
	 */
	@Bean
	public IAuthenticationFacade authenticate(){
		return new AuthenticationImpl();
	}
	
}
