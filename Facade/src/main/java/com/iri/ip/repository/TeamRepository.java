/**
 * 
 */
package com.iri.ip.repository;

import static com.iri.ip.constants.VMConstants.TEAM_LIST_VM;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.iri.ip.domain.TeamDAO;
import com.iri.ip.utils.TemplateUtils;
import com.mongodb.util.JSON;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: TeamRepository.java
 * @packageName	: com.iri.ip.repository
 * @projectName	: Facade
 * @Date_Time	: Dec 9, 2014_11:40:23 PM
 */
@Repository
public class TeamRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * API 
	 * @return
	 */
	public List<TeamDAO> getAll(){
		List<TeamDAO> retVal = null;
		if(this.mongoTemplate.collectionExists(TeamDAO.class)){
			retVal = this.mongoTemplate.findAll(TeamDAO.class);
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
		List<TeamDAO> teamList = getAll();
		String innerHTML = "";
		VelocityContext context = null;
		try {
			if( teamList!=null ){
				context = new VelocityContext();
				context.put("TeamList", teamList);
				innerHTML = TemplateUtils.parseTemplate(context, TEAM_LIST_VM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerHTML;
	}
	
	public void createCollection(){
		if(!this.mongoTemplate.collectionExists(TeamDAO.class)){
			this.mongoTemplate.createCollection(TeamDAO.class);
		}
		initializeCollection();
	}
	
	@SuppressWarnings("unchecked")
	public void initializeCollection(){
		try {
			if(this.mongoTemplate.collectionExists(TeamDAO.class)){
				if(this.mongoTemplate.findAll(TeamDAO.class).size() < 1){
					URL url = Resources.getResource("com/iri/ip/domain/data/seed/Team.JSON");
					String json = Resources.toString(url, Charsets.UTF_8);
					List<TeamDAO> teamDaoList = (List<TeamDAO>) JSON.parse(json);
					this.mongoTemplate.insert(teamDaoList,TeamDAO.class);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dropCollection(){
		if(this.mongoTemplate.collectionExists(TeamDAO.class)){
			this.mongoTemplate.dropCollection(TeamDAO.class);
		}
	}
	
}
