/**
 * 
 */
package com.iri.ip.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: This Configuration contains the Rest Controllers and WebMVC Configuration
 * @fileName	: DaoConfig.java
 * @packageName	: com.iri.ip.config
 * @projectName	: Web
 * @Date_Time	: Nov 24, 2014_2:17:34 AM
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.iri.ip.controllers")
public class ControllerConfig extends WebMvcConfigurerAdapter {

}
