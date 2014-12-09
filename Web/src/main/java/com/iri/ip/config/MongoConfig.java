package com.iri.ip.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = "com.iri.ip.repository")
public class MongoConfig{
	
	@Bean
    public MongoDbFactory getMongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(getMongoClient(), "InnovPort");
    }
 
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
        return mongoTemplate;
    }

	private MongoClient getMongoClient() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		mongoClient.setWriteConcern(WriteConcern.SAFE);
		return mongoClient;
	}
	
}
