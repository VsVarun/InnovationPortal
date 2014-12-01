/**
 * 
 */
package com.iri.ip.facade.impl;

import com.iri.ip.facade.IAuthenticationFacade;
import com.iri.ip.objectModel.UserInfo;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: AuthenticationImpl.java
 * @packageName	: com.iri.ip.facade.impl
 * @projectName	: Facade
 * @Date_Time	: Nov 23, 2014_11:48:30 PM
 */
public class AuthenticationImpl implements IAuthenticationFacade {

	@Override
	public UserInfo signIn(String userID, String password) {
		UserInfo ui = new UserInfo();
		ui.setUserID(10599);
		ui.setFirstName(userID);
		ui.setLastName(password);
		ui.setLoginID("prsch");
		return ui;
	}

	@Override
	public UserInfo signOut(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
