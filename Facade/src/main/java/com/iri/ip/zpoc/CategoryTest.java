package com.iri.ip.zpoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.iri.ip.domain.CategoryDAO;

public class CategoryTest {

	public static void main(String[] args) {

		List<CategoryDAO> categoryList = new ArrayList<CategoryDAO>();
		categoryList.add(new CategoryDAO("Category 1", "Sub Category 1"));
		categoryList.add(new CategoryDAO("Category 1", "Sub Category 2"));
		categoryList.add(new CategoryDAO("Category 1", "Sub Category 3"));
		categoryList.add(new CategoryDAO("Category 2", "Sub Category 1"));
		categoryList.add(new CategoryDAO("Category 2", "Sub Category 2"));
		categoryList.add(new CategoryDAO("Category 2", "Sub Category 3"));
		categoryList.add(new CategoryDAO("Category 2", "Sub Category 4"));
		categoryList.add(new CategoryDAO("Category 2", "Sub Category 5"));
		categoryList.add(new CategoryDAO("Category 3", "Sub Category 1"));
		categoryList.add(new CategoryDAO("Category 3", "Sub Category 2"));
		categoryList.add(new CategoryDAO("Category 3", "Sub Category 3"));
		categoryList.add(new CategoryDAO("Category 4", "Sub Category 1"));
		categoryList.add(new CategoryDAO("Category 4", "Sub Category 2"));
		
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
