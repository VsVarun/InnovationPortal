package com.iri.ip.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: Web Application Initializer
 * @fileName	: WebAppInitializer.java
 * @packageName	: com.iri.ip.config
 * @projectName	: Web
 * @Date_Time	: Nov 25, 2014_11:19:59 AM
 */
public class WebAppInitializer implements WebApplicationInitializer {
 
    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ServiceConfig.class, DaoConfig.class);
 
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
 
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(ControllerConfig.class);
             
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/Services/*");
         
    }

 }