/**
 * 
 */
package com.iri.ip.repository;

import static com.iri.ip.constants.VMConstants.CATEGORY_LIST_VM;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.iri.ip.domain.CategoryDAO;
import com.iri.ip.utils.TemplateUtils;
import com.mongodb.util.JSON;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: CategoryRepository.java
 * @packageName	: com.iri.ip.repository
 * @projectName	: Facade
 * @Date_Time	: Dec 2, 2014_3:08:59 PM
 */
@Repository
public class CategoryRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * API 
	 * @return
	 */
	public List<CategoryDAO> getAll(){
		List<CategoryDAO> retVal = null;
		if(this.mongoTemplate.collectionExists(CategoryDAO.class)){
			retVal = this.mongoTemplate.findAll(CategoryDAO.class);
			if(retVal.size() < 1){
				initializeCollection();
				getAll();
			}
		}else{
			createCollection();
			getAll();
		}
		return retVal;
	}
	
	public String getAllAsDropDown(){
		List<CategoryDAO> categoryList = getAll();
		String innerHTML = "";
		VelocityContext context = null;
		try {
			if( categoryList!=null ){
				context = new VelocityContext();
				context.put("CategoryList", categoryList);
				innerHTML = TemplateUtils.parseTemplate(context, CATEGORY_LIST_VM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerHTML;
	}
	
	public void createCollection(){
		if(!this.mongoTemplate.collectionExists(CategoryDAO.class)){
			this.mongoTemplate.createCollection(CategoryDAO.class);
		}
		initializeCollection();
	}
	
	@SuppressWarnings("unchecked")
	public void initializeCollection(){
		try {
			if(this.mongoTemplate.collectionExists(CategoryDAO.class)){
				if(this.mongoTemplate.findAll(CategoryDAO.class).size() < 1){
					URL url = Resources.getResource("com/iri/ip/domain/data/seed/Category.JSON");
					String json = Resources.toString(url, Charsets.UTF_8);
					List<CategoryDAO> categoryDaoList = (List<CategoryDAO>) JSON.parse(json);
					this.mongoTemplate.insert(categoryDaoList,CategoryDAO.class);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dropCollection(){
		if(this.mongoTemplate.collectionExists(CategoryDAO.class)){
			this.mongoTemplate.dropCollection(CategoryDAO.class);
		}
	}
	
	

}
