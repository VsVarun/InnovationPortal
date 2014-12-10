package com.iri.ip.zpoc;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.iri.ip.domain.IdeaDAO;

public class IdeaJsonGenerator {

	public static void main(String[] args) {

		IdeaDAO idea = new IdeaDAO();
		idea.setBenefits("Sample Benefit");
		idea.setCategoryName("Ideation");
		idea.setChallenges("Sample Challenges");
		idea.setCreatedDate(new Date().toString());
		idea.setDescription("Sample Desc");
		idea.setLastModifiedDate(new Date().toString());
		idea.setStatus("Submitted");
		idea.setSummary("Sample Summary");
		idea.setTeamName("Analytics");
		idea.setUserName("prsch");
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			json =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(idea);
			System.out.println(json);
		} catch (JsonGenerationException e)
		{
		   e.printStackTrace();
		} catch (JsonMappingException e)
		{
		   e.printStackTrace();
		} catch (IOException e)
		{
		   e.printStackTrace();
		}
		
	}

}
