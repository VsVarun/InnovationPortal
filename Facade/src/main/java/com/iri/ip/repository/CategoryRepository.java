/**
 * 
 */
package com.iri.ip.repository;

import static com.iri.ip.constants.VMConstants.CATEGORY_LIST_VM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, List<CategoryDAO>> finalList = getCategoryHierarchy(categoryList);
		String innerHTML = "";
		VelocityContext context = null;
		try {
			if( finalList!=null ){
				context = new VelocityContext();
				context.put("CategoryMap", finalList);
				innerHTML = TemplateUtils.parseTemplate(context, CATEGORY_LIST_VM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerHTML;
	}
	
	private Map<String, List<CategoryDAO>> getCategoryHierarchy(
			List<CategoryDAO> categoryList) {
		Map<String, List<CategoryDAO>> retVal = new HashMap<String, List<CategoryDAO>>();
		for(CategoryDAO category : categoryList){
			List<CategoryDAO> catList = new ArrayList<CategoryDAO>();
			if(retVal.get(category.getCategoryName()) != null){
				catList = retVal.get(category.getCategoryName());
			}
			catList.add(category);
			retVal.put(category.getCategoryName(), catList);
		}
		return retVal;
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
