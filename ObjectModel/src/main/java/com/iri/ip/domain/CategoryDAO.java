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
 * @fileName	: CategoryDAO.java
 * @packageName	: com.iri.ip.document
 * @projectName	: ObjectModel
 * @Date_Time	: Dec 2, 2014_2:46:19 PM
 */
@Document( collection = "Category" )
public class CategoryDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger categoryID;
	private String categoryName;

	/**
	 * 
	 */
	public CategoryDAO() {
	}

	/**
	 * @param categoryID
	 * @param categoryName
	 */
	public CategoryDAO(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryID
	 */
	public BigInteger getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(BigInteger categoryID) {
		this.categoryID = categoryID;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryDAO [categoryID=" + categoryID + ", categoryName="
				+ categoryName + "]";
	}

}
