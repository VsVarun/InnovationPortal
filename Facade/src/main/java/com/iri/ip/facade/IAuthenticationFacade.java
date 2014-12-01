/**
 * 
 */
package com.iri.ip.facade;

import com.iri.ip.objectModel.UserInfo;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: IAuthenticationFacade.java
 * @packageName	: com.iri.ip.facade
 * @projectName	: Facade
 * @Date_Time	: Nov 23, 2014_11:48:23 PM
 */
public interface IAuthenticationFacade {
	
	public UserInfo signIn(String userID, String password);
	public UserInfo signOut(String userID);
	
}
