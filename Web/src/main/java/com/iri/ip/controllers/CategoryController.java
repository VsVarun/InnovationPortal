package com.iri.ip.controllers;

import java.util.List;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.config.AppContext;
import com.iri.ip.domain.CategoryDAO;
import com.iri.ip.repository.CategoryRepository;

/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: Rest Controller for Authentication
 * @fileName	: InnovationPortalController.java
 * @packageName	: com.iri.ip.controllers
 * @projectName	: InnovationPortal.Web
 * @Date_Time	: Nov 23, 2014_2:30:15 AM
 */
@RestController
@RequestMapping("/Category")
public class CategoryController {
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=(MimeTypeUtils.APPLICATION_JSON_VALUE))
    public @ResponseBody List<CategoryDAO> getAll() throws Exception {
		CategoryRepository cr = AppContext.getRepositoryBean(CategoryRepository.class);
		return (List<CategoryDAO>) cr.getAll();
    }
	
	@RequestMapping(value = "/getAllAsDropDown", method = RequestMethod.GET, produces=(MimeTypeUtils.TEXT_HTML_VALUE))
    public @ResponseBody String getAllAsDropDown() throws Exception {
		CategoryRepository cr = AppContext.getRepositoryBean(CategoryRepository.class);
		return cr.getAllAsDropDown();
    }
}
