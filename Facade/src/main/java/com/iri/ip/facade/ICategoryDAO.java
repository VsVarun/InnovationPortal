/**
 * 
 */
package com.iri.ip.facade;

import java.util.List;

import com.iri.ip.domain.CategoryDAO;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: ICategoryDAO.java
 * @packageName	: com.iri.ip.facade
 * @projectName	: Facade
 * @Date_Time	: Dec 2, 2014_2:36:15 PM
 */
public interface ICategoryDAO {
	
	List<CategoryDAO> getAllCategories();
	
}
