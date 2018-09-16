package com.frudence.talentdemo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.frudence.talentdemo.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {
    private String host = "localhost";

    private Integer port = 27017;

    private String dbName = "myRetail";

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(host, port);
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }
}