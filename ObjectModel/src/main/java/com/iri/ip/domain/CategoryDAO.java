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
	private String subCategoryName;

	/**
	 * 
	 */
	public CategoryDAO() {
	}

	/**
	 * @param categoryID
	 * @param categoryName
	 * @param subCategoryName
	 */
	public CategoryDAO(String categoryName,
			String subCategoryName) {
		super();
		this.categoryName = categoryName;
		this.subCategoryName = subCategoryName;
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

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryDAO [categoryID=" + categoryID + ", categoryName="
				+ categoryName + ", subCategoryName=" + subCategoryName + "]";
	}

}
