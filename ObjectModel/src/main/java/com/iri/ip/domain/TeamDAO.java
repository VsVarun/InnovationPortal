/**
 * 
 */
package com.iri.ip.domain;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: TeamDAO.java
 * @packageName	: com.iri.ip.domain
 * @projectName	: ObjectModel
 * @Date_Time	: Dec 9, 2014_11:34:27 PM
 */
@Document( collection = "Team" )
public class TeamDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger teamID;
	private String teamName;

	/**
	 * 
	 */
	public TeamDAO() {
	}

	/**
	 * @param teamName
	 */
	public TeamDAO(String teamName) {
		super();
		this.teamName = teamName;
	}

	/**
	 * @return the teamID
	 */
	public BigInteger getTeamID() {
		return teamID;
	}

	/**
	 * @param teamID the teamID to set
	 */
	public void setTeamID(BigInteger teamID) {
		this.teamID = teamID;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeamDAO [teamID=" + teamID + ", teamName=" + teamName + "]";
	}


}
