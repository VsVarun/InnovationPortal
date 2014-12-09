package com.iri.ip.zpoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.iri.ip.domain.CategoryDAO;

public class CategoryJsonGenerator {

	public static void main(String[] args) {

		List<CategoryDAO> categoryList = new ArrayList<CategoryDAO>();
		categoryList.add(new CategoryDAO("New Features"));
		categoryList.add(new CategoryDAO("Ideation"));
		categoryList.add(new CategoryDAO("Process Improvement"));
		categoryList.add(new CategoryDAO("Technology N Trends"));
		categoryList.add(new CategoryDAO("Productivity"));
		categoryList.add(new CategoryDAO("Cost of Ownership"));
		categoryList.add(new CategoryDAO("Operational Efficiency"));
		
		String json = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			json =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(categoryList);
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
