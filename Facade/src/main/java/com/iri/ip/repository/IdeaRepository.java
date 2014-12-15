/**
 * 
 */
package com.iri.ip.repository;

import static com.iri.ip.constants.VMConstants.IDEAS_TABLE_VM;

import java.util.List;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.iri.ip.domain.IdeaDAO;
import com.iri.ip.utils.TemplateUtils;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: IdeaRepository.java
 * @packageName	: com.iri.ip.repository
 * @projectName	: Facade
 * @Date_Time	: Dec 10, 2014_12:46:47 AM
 */
@Repository
public class IdeaRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * API to get the list of Ideas Submitted
	 * @return
	 */
	public List<IdeaDAO> getAll(){
		List<IdeaDAO> retVal = null;
		if(this.mongoTemplate.collectionExists(IdeaDAO.class)){
			retVal = this.mongoTemplate.findAll(IdeaDAO.class);
		}else{
			createCollection();
		}
		return retVal;
	}
	
	public String getAllAsTable(){
		List<IdeaDAO> ideas = getAll();
		String innerHTML = "";
		VelocityContext context = null;
		try {
			if( ideas!=null ){
				context = new VelocityContext();
				context.put("IdeaList", ideas);
				innerHTML = TemplateUtils.parseTemplate(context, IDEAS_TABLE_VM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerHTML;
	}
	
	public void submitIdea(IdeaDAO idea){
		if(!this.mongoTemplate.collectionExists(IdeaDAO.class)){
			createCollection();
		}
		this.mongoTemplate.insert(idea);
	}
	
	public void createCollection(){
		if(!this.mongoTemplate.collectionExists(IdeaDAO.class)){
			this.mongoTemplate.createCollection(IdeaDAO.class);
		}
	}
	
	public void dropCollection(){
		if(this.mongoTemplate.collectionExists(IdeaDAO.class)){
			this.mongoTemplate.dropCollection(IdeaDAO.class);
		}
	}
	
}
