package com.iri.ip.controllers;

import java.util.Base64;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.config.AppContext;
import com.iri.ip.facade.IAuthenticationFacade;
import com.iri.ip.objectModel.UserInfo;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: Rest Controller for Authentication
 * @fileName	: InnovationPortalController.java
 * @packageName	: com.iri.ip.controllers
 * @projectName	: InnovationPortal.Web
 * @Date_Time	: Nov 23, 2014_2:30:15 AM
 */
@RestController
@RequestMapping("/Authenticate")
public class AuthenticationController {
	
	@RequestMapping(value = "/SignIn", method = RequestMethod.GET, produces = (MimeTypeUtils.APPLICATION_JSON_VALUE))
	public @ResponseBody UserInfo signIn() throws Exception {

		String userID = "prsaq";
		String password = new String(Base64.getDecoder().decode("aXJpQDU0Mw=="));

		IAuthenticationFacade facade = AppContext
				.getAuthBean(IAuthenticationFacade.class);

		UserInfo ui = null;
		try {
			ui = facade.signIn(userID, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ui;
	}	
	
}
