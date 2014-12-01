package com.iri.ip.controllers;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.component.UserInfoCMP;
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
	
	@RequestMapping(value = "/SignIn", method = RequestMethod.GET, produces=(MimeTypeUtils.APPLICATION_JSON_VALUE))
    public @ResponseBody UserInfo signIn() throws Exception {
		UserInfo ui = new UserInfo();
		IAuthenticationFacade authenticate = AppContext.getServiceBean(IAuthenticationFacade.class);
		ui = authenticate.signIn("Varun", "Chandresekar");
		
		UserInfoCMP uiCmp = AppContext.getDaoBean(UserInfoCMP.class);
		System.out.println(uiCmp.toString());
        return ui;
    }
}
