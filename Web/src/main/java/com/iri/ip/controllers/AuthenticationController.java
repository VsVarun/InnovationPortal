package com.iri.ip.controllers;

import java.util.Base64;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.config.AppContext;
import com.iri.ip.ldap.ActiveDirectoryLdapAuthenticationProvider;
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

		String username = "prsaq";
		String password = new String(Base64.getDecoder().decode("aXJpQDU0Mw=="));

		ActiveDirectoryLdapAuthenticationProvider ldapProvider = AppContext
				.getAuthBean(ActiveDirectoryLdapAuthenticationProvider.class);

		UserInfo ui = new UserInfo();
		try {
			Authentication authResult = ldapProvider
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			UserDetails userDetails = (UserDetails) authResult.getPrincipal();
			ui.setLoginID(userDetails.getUsername());
		} catch (Exception e) {
			// Eating the LDAP exception mainly caused by invalid user name and
			// password
		}
		return ui;
	}
}
