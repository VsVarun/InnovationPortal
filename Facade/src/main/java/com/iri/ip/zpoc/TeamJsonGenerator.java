package com.iri.ip.zpoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.iri.ip.domain.TeamDAO;

public class TeamJsonGenerator {

	public static void main(String[] args) {

		List<TeamDAO> teamList = new ArrayList<TeamDAO>();
		teamList.add(new TeamDAO("Analytics"));
		teamList.add(new TeamDAO("Support/SCM"));
		teamList.add(new TeamDAO("Problog/Delivery"));
		teamList.add(new TeamDAO("ETL Engineering"));
		teamList.add(new TeamDAO("TSG"));
		teamList.add(new TeamDAO("ILD Modeling"));
		teamList.add(new TeamDAO("AS Engineering"));
		teamList.add(new TeamDAO("AP/AE"));
		teamList.add(new TeamDAO("Plus suite/Portal"));
		teamList.add(new TeamDAO("MDM"));
		teamList.add(new TeamDAO("QA"));
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			json =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(teamList);
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
