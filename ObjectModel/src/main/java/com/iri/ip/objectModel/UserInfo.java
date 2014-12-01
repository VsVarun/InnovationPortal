/**
 * 
 */
package com.iri.ip.objectModel;

import java.io.Serializable;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: This POJO class contains the information of an user
 * @fileName	: UserInfo.java
 * @packageName	: com.iri.ip.objectModel
 * @projectName	: InnovationPortal.ObjectModel
 * @Date_Time	: Nov 23, 2014_2:51:23 AM
 */
public class UserInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long userID;
	private String firstName;
	private String lastName;
	private String loginID;
	/**
	 * 
	 */
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param loginID
	 */
	public UserInfo(long userID, String firstName, String lastName,
			String loginID) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginID = loginID;
	}
	
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the loginID
	 */
	public String getLoginID() {
		return loginID;
	}
	/**
	 * @param loginID the loginID to set
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", "
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (loginID != null ? "loginID=" + loginID : "") + "]";
	}

}
