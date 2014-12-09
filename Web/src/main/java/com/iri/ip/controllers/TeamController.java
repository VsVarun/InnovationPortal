package com.iri.ip.controllers;

import java.util.List;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.config.AppContext;
import com.iri.ip.domain.TeamDAO;
import com.iri.ip.repository.TeamRepository;


/**
 * @author		: Varun Chandresekar 
 * @user		: [ schand07 ]
 * @citrixID	: [ prsch ]
 * @desc		: 
 * @fileName	: TeamController.java
 * @packageName	: com.iri.ip.controllers
 * @projectName	: Web
 * @Date_Time	: Dec 9, 2014_11:52:16 PM
 */
@RestController
@RequestMapping("/Team")
public class TeamController {
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=(MimeTypeUtils.APPLICATION_JSON_VALUE))
    public @ResponseBody List<TeamDAO> getAll() throws Exception {
		TeamRepository teamRepo = AppContext.getRepositoryBean(TeamRepository.class);
		return (List<TeamDAO>) teamRepo.getAll();
    }
	
	@RequestMapping(value = "/getAllAsDropDown", method = RequestMethod.GET, produces=(MimeTypeUtils.TEXT_HTML_VALUE))
    public @ResponseBody String getAllAsDropDown() throws Exception {
		TeamRepository teamRepo = AppContext.getRepositoryBean(TeamRepository.class);
		return teamRepo.getAllAsDropDown();
    }
}
