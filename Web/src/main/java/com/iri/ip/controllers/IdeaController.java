package com.iri.ip.controllers;

import java.util.List;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iri.ip.config.AppContext;
import com.iri.ip.domain.IdeaDAO;
import com.iri.ip.repository.IdeaRepository;

@RestController
@RequestMapping("/Idea")
public class IdeaController {
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=(MimeTypeUtils.APPLICATION_JSON_VALUE))
    public @ResponseBody List<IdeaDAO> getAll() throws Exception {
		return (List<IdeaDAO>) AppContext.getRepositoryBean(IdeaRepository.class).getAll();
    }
	
	@RequestMapping(value = "/getAllAsTable", method = RequestMethod.GET, produces=(MimeTypeUtils.TEXT_HTML_VALUE))
    public @ResponseBody String getAllAsTable() throws Exception {
		return AppContext.getRepositoryBean(IdeaRepository.class).getAllAsTable();
    }
	
	@RequestMapping(value = "/getUserIdeasAsTable/{userName}", method = RequestMethod.GET, produces=(MimeTypeUtils.TEXT_HTML_VALUE))
    public @ResponseBody String getUserIdeasAsTable(@PathVariable String userName) throws Exception {
		return AppContext.getRepositoryBean(IdeaRepository.class).getUserIdeasAsTable(userName);
    }
	
	@RequestMapping(value = "/Submit", method = RequestMethod.POST, consumes=(MimeTypeUtils.APPLICATION_JSON_VALUE))
    public void submit(@RequestBody IdeaDAO idea) throws Exception {
		AppContext.getRepositoryBean(IdeaRepository.class).submitIdea(idea);
    }
}
