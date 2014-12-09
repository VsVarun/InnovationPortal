/**
 * 
 */
package com.iri.ip.utils;

import java.io.StringWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.google.common.io.Resources;

/**
 * @author		: Varun Chandresekar [ schand07 ]
 * @date 		: Aug 12, 2014 10:37:56 AM
 * @fileName	: TemplateUtils.java
 * @packageName	: com.iri.monitor.utils
 * @projectName	: ILDMonitor
 */
public class TemplateUtils {
	
	public static URL VM_FILE_PATH = Resources.getResource("com/iri/ip/domain/templates");

	/**This API is responsible for manipulating the provided values to the template and generates the required string 
	 * @param context
	 * @param vmName
	 * @return
	 */
	public static String parseTemplate(VelocityContext context, String vmName){
		StringWriter retVal = new StringWriter();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		final String templatePath = "com/iri/ip/domain/templates/" + vmName;
		Template template = ve.getTemplate(templatePath);
        template.merge(context, retVal);
        return retVal.toString();
	}
	
	/**This is an Simple Method which returns the current system Date
	 * This will be moved to Utils soon.
	 * @return
	 */
	public static String getSysDate(){
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
