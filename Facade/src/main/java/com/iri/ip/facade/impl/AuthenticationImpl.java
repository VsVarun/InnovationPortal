/**
 * 
 */
package com.iri.ip.facade.impl;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.iri.ip.facade.IAuthenticationFacade;
import com.iri.ip.ldap.ActiveDirectoryLdapAuthenticationProvider;
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
	
	private ActiveDirectoryLdapAuthenticationProvider ldapProvider;

	public AuthenticationImpl(ActiveDirectoryLdapAuthenticationProvider ldapProvider) {
		this.ldapProvider = ldapProvider;
	}

	@Override
	public UserInfo signIn(String userID, String password) {
		UserInfo userInfo = null;
		try {
			DirContextOperations userData = ldapProvider
					.doAuthentication(new UsernamePasswordAuthenticationToken(
							userID, password));
			userInfo = doMapFromContext(userData);
			userInfo.setLoginID(userID);
		} catch (Exception e) {
			// Eating the LDAP exception mainly caused by invalid user name and
			// password
		}
		return userInfo;
	}
	
	/**
	 * Method to map from authenticated context to Object UserInfo
	 * @param context
	 * @return
	 */
	private UserInfo doMapFromContext(DirContextOperations context) {
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName(context.getStringAttribute("givenName"));
		userInfo.setLastName(context.getStringAttribute("sn"));
		userInfo.setEmail(context.getStringAttribute("mail"));
        return userInfo;
     }

	@Override
	public UserInfo signOut(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
