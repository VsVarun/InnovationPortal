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
 * @fileName	: IdeaDAO.java
 * @packageName	: com.iri.ip.domain
 * @projectName	: ObjectModel
 * @Date_Time	: Dec 10, 2014_12:43:11 AM
 */
@Document( collection = "Idea" )
public class IdeaDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger ideaID;
	private String categoryName;
	private String userName;
	private String teamName;
	private String summary;
	private String description;
	private String benefits;
	private String challenges;
	private String status;
	private String createdDate;
	private String lastModifiedDate;

	/**
	 * 
	 */
	public IdeaDAO() {
		super();
	}

	/**
	 * @param ideaID
	 * @param categoryName
	 * @param userName
	 * @param teamName
	 * @param summary
	 * @param description
	 * @param benefits
	 * @param challenges
	 * @param status
	 * @param createdDate
	 * @param lastModifiedDate
	 */
	public IdeaDAO(BigInteger ideaID, String categoryName, String userName,
			String teamName, String summary, String description,
			String benefits, String challenges, String status,
			String createdDate, String lastModifiedDate) {
		super();
		this.ideaID = ideaID;
		this.categoryName = categoryName;
		this.userName = userName;
		this.teamName = teamName;
		this.summary = summary;
		this.description = description;
		this.benefits = benefits;
		this.challenges = challenges;
		this.status = status;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the ideaID
	 */
	public BigInteger getIdeaID() {
		return ideaID;
	}

	/**
	 * @param ideaID the ideaID to set
	 */
	public void setIdeaID(BigInteger ideaID) {
		this.ideaID = ideaID;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the benefits
	 */
	public String getBenefits() {
		return benefits;
	}

	/**
	 * @param benefits the benefits to set
	 */
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	/**
	 * @return the challenges
	 */
	public String getChallenges() {
		return challenges;
	}

	/**
	 * @param challenges the challenges to set
	 */
	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IdeaDAO [ideaID=" + ideaID + ", categoryName=" + categoryName
				+ ", userName=" + userName + ", teamName=" + teamName
				+ ", summary=" + summary + ", description=" + description
				+ ", benefits=" + benefits + ", challenges=" + challenges
				+ ", status=" + status + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
